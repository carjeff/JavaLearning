package servlets;

import fruit.bean.Fruit;
import fruit.dao.FruitDAO;
import fruit.dao.impl.FruitDAOImpl;
import myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jason
 * @date 2022/7/25 22:12
 * @Description
 */

@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet {

    private FruitDAO fruitDAO = new FruitDAOImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");

        String fname = req.getParameter("fname");
        String priceStr = req.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = req.getParameter("fcount");
        int fcount = Integer.parseInt(fcountStr);
        String remark = req.getParameter("remark");

        Fruit fruit = new Fruit(0,fname,price,fcount,remark);
        fruitDAO.addFruit(fruit);

        resp.sendRedirect("index");
    }
}
