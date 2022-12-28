package com.servlet;

import com.beans.User;
import com.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/registered")
public class RegisteredServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("username") ;
        String password = request.getParameter("password") ;

        try {
            User user = new User();
            user.setUsername(userName);
            user.setPassword(password);
            UserDao.insertUser(user);
            request.getRequestDispatcher("/index.jsp")
                    .forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
