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

@WebServlet("/main")
public class MainServlet  extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user.getState()==1){
            ArrayList<BillVo> byId = BillDao.getById(user.getId());
            Float money = 0F;
            Float wmoney = 0F;
            for (BillVo billVo : byId) {
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
            return;
        }else {

            request.getServletContext().setAttribute("BalanceList", BalanceDao.list());
            request.getRequestDispatcher("/AdminMain.jsp")
                    .forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
