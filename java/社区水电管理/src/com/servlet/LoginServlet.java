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
import com.dao.BalanceDao;
import com.dao.BillDao;
import com.dao.UserDao;
import com.vo.BillVo;

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
				user.setState(rs.getInt(4));
				session.setAttribute("user",user);
				request.getServletContext().setAttribute("msg", "");

				if(user.getState()==0){
					request.getServletContext().setAttribute("BalanceList", BalanceDao.list());
					request.getRequestDispatcher("/AdminMain.jsp")
							.forward(request, response);
					return;
				}else {
					ArrayList<BillVo> byId = BillDao.getById(rs.getInt(1));
					Float money = 0F;
					Float wmoney = 0F;
					for (BillVo billVo : byId) {
						if (billVo.getType().equals("ÒÑ½áÇå")){
							money += billVo.getMoney();
						}else {
							wmoney+=billVo.getMoney();
						}

					}
					request.getServletContext().setAttribute("sum", money);
					request.getServletContext().setAttribute("wum", wmoney);
					request.getServletContext().setAttribute("BillList", byId);
					request.getRequestDispatcher("/UserMain.jsp")
							.forward(request, response);
					return;

				}
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
