package com.servlet;

import com.beans.User;
import com.dao.BillDao;
import com.vo.BillVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Analysis")
public class AnalysisServlet  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<BillVo> byId = BillDao.list();
        Float water = 0F;
        Float dian = 0F;
        for (BillVo billVo : byId) {
            if (billVo.getType().equals("ˮ��")){
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
