package com.servlet;

import com.beans.Classify;
import com.beans.User;
import com.dao.ClassifyDao;
import com.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateClassify")
public class UpdateClassifyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ClassifyDao.update(new Classify(Integer.parseInt(request.getParameter("id")),request.getParameter("name")));
            request.getServletContext().setAttribute("ClassifyList",  ClassifyDao.list());
            request.getRequestDispatcher("/ClassifyManage.jsp")
                    .forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
