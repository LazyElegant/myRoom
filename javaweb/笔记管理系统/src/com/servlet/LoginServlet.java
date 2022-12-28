package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.User;
import com.dao.NoteDao;
import com.dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username") ;
		String password = request.getParameter("password") ;

		try {
			ResultSet rs = UserDao.getUser(userName, password);
			if (rs.next()) {
				HttpSession session = request.getSession();
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				session.setAttribute("user",user);
				request.getServletContext().setAttribute("msg", "");

				request.getServletContext().setAttribute("NoteList",  NoteDao.list(user.getId()));
				request.getRequestDispatcher("/main.jsp")
						.forward(request, response);
				return;
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		request.getServletContext().setAttribute("msg", "µÇÂ½Ê§°Ü£¡£¡£¡");
		request.getRequestDispatcher("/index.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
