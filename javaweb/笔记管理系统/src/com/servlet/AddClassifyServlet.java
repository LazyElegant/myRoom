package com.servlet;

import com.beans.User;
import com.dao.ClassifyDao;
import com.dao.NoteDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addClassify")
public class AddClassifyServlet  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        try {
            ClassifyDao.insert(request.getParameter("name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getServletContext().setAttribute("NoteList",  NoteDao.list(user.getId()));
        request.getRequestDispatcher("/main.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
