package com.servlet;

import com.beans.User;
import com.dao.BalanceDao;
import com.dao.BillDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/sf")
public class SFServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Float sf = Float.valueOf(request.getParameter("money"));

        User user = (User) request.getSession().getAttribute("user");
        BalanceDao.setSFMoney(user.getId(),sf);

        try {
            ResultSet money = BalanceDao.getMoney(user.getId());
            if (money.next()){
                request.getServletContext().setAttribute("water", money.getFloat(1));
                request.getServletContext().setAttribute("electric",  money.getFloat(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("/moneyManage.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
