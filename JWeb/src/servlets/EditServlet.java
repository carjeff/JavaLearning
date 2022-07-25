package servlets;

import fruit.bean.Fruit;
import fruit.dao.FruitDAO;
import fruit.dao.impl.FruitDAOImpl;
import myssm.myspringmvc.ViewBaseServlet;
import myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jason
 * @date 2022/7/25 17:01
 * @Description
 */
@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {

    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidStr = req.getParameter("fid");
        if (StringUtil.isNotEmpty(fidStr)){
            int fid = Integer.parseInt(fidStr);
            Fruit fruit = fruitDAO.getFruitByFid(fid);
            req.setAttribute("fruit",fruit);
            super.processTemplate("edit",req,resp);
        }
    }
}
