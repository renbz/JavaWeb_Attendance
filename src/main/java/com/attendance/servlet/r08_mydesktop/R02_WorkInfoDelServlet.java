package com.attendance.servlet.r08_mydesktop;

import com.attendance.dao.R08_MyDeskTopDao;
import com.attendance.dao.impl.R08_MyDeskTopDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ren
 * 2020/12/19
 */
@WebServlet("/R02_WorkInfoDelServlet")
public class R02_WorkInfoDelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        R08_MyDeskTopDao dao = new R08_MyDeskTopDaoImpl();
        dao.delWorkInfo(Integer.parseInt(id));
        //跳转回信息显示页面
        response.sendRedirect(request.getContextPath()+"/R01_MyDeskTopServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
