package com.servlet;

import com.beans.User;
import com.dao.BalanceDao;
import com.dao.BillDao;
import com.vo.BillVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/zf")
public class ZFServlet  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));
        Float mone = Float.valueOf(request.getParameter("money"));
        String type = request.getParameter("type");
        try {
            BillDao.update(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        User user = (User) request.getSession().getAttribute("user");

        if (type.equals("电费")){
            try {
                BalanceDao.updateElectric(user.getId(),mone);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if (type.equals("水费")){
            try {
                BalanceDao.updateWater(user.getId(),mone);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        ArrayList<BillVo> byId = BillDao.getByIdANDState(user.getId());

        ResultSet money = null;
        try {
            money = BalanceDao.getMoney(user.getId());
            if (money.next()) {

                request.getServletContext().setAttribute("water", money.getFloat(1));
                request.getServletContext().setAttribute("electric",  money.getFloat(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getServletContext().setAttribute("BillList", byId);
        request.getRequestDispatcher("/UserBillManage.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
