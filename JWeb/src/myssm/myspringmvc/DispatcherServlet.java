package myssm.myspringmvc;

import myssm.util.StringUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jason
 * @date 2022/7/26 16:23
 * @Description
 */

@WebServlet("*.do")
public class DispatcherServlet extends ViewBaseServlet {
    //核心分配器，通过operate去定位不同的controller
    private Map<String, Object> beanMap = new HashMap<>();

    public DispatcherServlet() {
    }

    @Override
    public void init() throws ServletException {
        //初始化
        super.init();
        //解析配置文件
        try {
            //首先在xml上定义bean的对应关系，接收到xml的输入流
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("applicationContext.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //创建document对象
            Document document = documentBuilder.parse(inputStream);
            //得到bean标签的所有节点
            NodeList beanNodeList = document.getElementsByTagName("bean");

            for (int i = 0; i < beanNodeList.getLength(); i++) {
                Node beanNode = beanNodeList.item(i);
                //判断该节点是否是元素节点
                if (beanNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) beanNode;
                    //如果是的话，取到对应属性的值
                    String beanId = element.getAttribute("id");
                    String beanClassName = element.getAttribute("class"); // String类型的fruit.controllers.FruitController
                    //将String类型的直接转换成对应的实例object
                    Object beanObj = Class.forName(beanClassName).getConstructor().newInstance();
                    //将id 和 实例的对象 存到beanMap中
                    beanMap.put(beanId, beanObj);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 该方法是做统一事务处理
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码
        req.setCharacterEncoding("UTF-8");
        //得到request请求的路径  /fruit.do
        String servletPath = req.getServletPath();
        servletPath = servletPath.substring(1);
        int lastDoIndex = servletPath.lastIndexOf(".do");
        servletPath = servletPath.substring(0, lastDoIndex);
        //根据路径从beanMap中取出对应对象
        Object controllerBeanObj = beanMap.get(servletPath);
        //从请求中取出operate值
        String operate = req.getParameter("operate");
        if (StringUtil.isEmpty(operate)) {
            //默认是index
            operate = "index";
        }

        try {
            //取出该实例的所有方法
            Method[] declaredMethods = controllerBeanObj.getClass().getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (operate.equals(method.getName())) {
                    //统一获取请求参数
                    Parameter[] parameters = method.getParameters();
                    //parameterValues 用来承载参数的值
                    Object[] parameterValues = new Object[parameters.length];
                    for (int i =0; i<parameters.length; i++){
                        Parameter parameter = parameters[i];
                        String parameterName = parameter.getName();
                        if ("req".equals(parameterName)){
                            parameterValues[i] = req;
                        }else if ("resp".equals(parameterName)){
                            parameterValues[i] = resp;
                        }else if ("session".equals(parameterName)){
                            parameterValues[i] = req.getSession();
                        }else {
                            String parameterValue = req.getParameter(parameterName);

                            Object parameterObj = parameterValue;
                            String parameterTypeName = parameter.getType().getName();
                            if (parameterObj!=null){
                                if ("java.lang.Integer".equals(parameterTypeName)){
                                    parameterObj = Integer.parseInt(parameterValue);
                                }
                            }
                            parameterValues[i] = parameterObj;
                        }
                    }

                    method.setAccessible(true);
                    Object invoke = method.invoke(controllerBeanObj, parameterValues);
                    String returnValue = (String) invoke;
                    //视图处理
                    if (returnValue.startsWith("redirect:")) {
                        String redirectStr = returnValue.substring("redirect:".length());
                        resp.sendRedirect(redirectStr);
                    } else {
                        super.processTemplate(returnValue, req, resp);
                    }
                }
            }
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
