package com.servlet;

import com.beans.Bill;
import com.dao.BalanceDao;
import com.dao.BillDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/insertBill")
public class InsertBillServlet  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Bill bill = new Bill();
        bill.setUserId(Integer.valueOf(request.getParameter("userId")));
        bill.setMonth(request.getParameter("mouth"));
        bill.setType(Integer.valueOf(request.getParameter("type")));
        bill.setMoney(Float.valueOf(request.getParameter("money")));
        try {
            BillDao.insertBill(bill);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getServletContext().setAttribute("BalanceList", BalanceDao.list());
        request.getRequestDispatcher("/AdminMain.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}