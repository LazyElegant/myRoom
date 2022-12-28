package com.servlet;

import com.beans.User;
import com.dao.BalanceDao;
import com.dao.BillDao;
import com.dao.UserDao;
import com.vo.BillVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/getMyBill")
public class getMyBillServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mouth = request.getParameter("name") ;
        User user = (User) request.getSession().getAttribute("user");

        ArrayList<BillVo> byId = BillDao.getByIdANDMonth(user.getId(),mouth);
        Float money = 0F;
        Float wmoney = 0F;
        System.out.println(mouth);
        for (BillVo billVo : byId) {
            System.out.println(billVo);
            if (billVo.getType().equals("“—Ω·«Â")){
                money += billVo.getMoney();
            }else {
                wmoney+=billVo.getMoney();
            }

        }
        request.getServletContext().setAttribute("BillList", byId);
        request.getServletContext().setAttribute("sum", money);
        request.getServletContext().setAttribute("wum", wmoney);
        request.getRequestDispatcher("/UserMain.jsp")
                    .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
