package com.attendance.servlet.r06_restRecord_manager;

import com.attendance.dao.R06_RestApplyDao;
import com.attendance.dao.impl.R06_RestApplyDaoImpl;

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
@WebServlet("/R02_PassRestServlet")
public class R02_PassRestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        R06_RestApplyDao dao = new R06_RestApplyDaoImpl();
        //获取前端传入的id
        String id = request.getParameter("id");
        dao.passRestApply(Integer.parseInt(id));
        //返回信息展示页面
        response.sendRedirect("R01_FindRestByPageServlet");


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
