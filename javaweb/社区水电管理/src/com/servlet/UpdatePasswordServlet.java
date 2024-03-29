package com.servlet;


import com.beans.User;
import com.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updatepaw")
public class UpdatePasswordServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String password = request.getParameter("newPassword") ;
        String oldPassword = request.getParameter("oldPassword") ;
        try {
            int i = UserDao.update(user.getId(), password, oldPassword);
            if (i>0){
                request.getServletContext().setAttribute("msg", "");
            }else{
                request.getServletContext().setAttribute("msg", "������󣡣�");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("/updatePassword.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
