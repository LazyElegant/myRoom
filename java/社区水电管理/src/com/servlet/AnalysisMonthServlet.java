package com.servlet;

import com.dao.BillDao;
import com.vo.BillVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/AnalysisMonth")
public class AnalysisMonthServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        ArrayList<BillVo> byId = BillDao.getByMonth(name);
        Float water = 0F;
        Float dian = 0F;
        for (BillVo billVo : byId) {
            if (billVo.getType().equals("Ë®·Ñ")){
                water += billVo.getMoney();
            }else {
                dian+=billVo.getMoney();
            }

        }
        request.getServletContext().setAttribute("water", water);
        request.getServletContext().setAttribute("dian", dian);
        request.getServletContext().setAttribute("BillList",byId);
        request.getRequestDispatcher("/AnalysisManage.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
