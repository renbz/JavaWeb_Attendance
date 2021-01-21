package com.attendance.servlet.r06_workRecord_manager;

import com.attendance.dao.R06_WorkApplyDao;
import com.attendance.dao.impl.R06_WorkApplyDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Ren
 * 2020/12/17
 */
@WebServlet("/R02_PassWorkServlet")
public class R02_PassWorkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        R06_WorkApplyDao dao = new R06_WorkApplyDaoImpl();
        //获取前端传入的id号，调用dao中的方法
        String id = request.getParameter("id");
        //System.out.println(id);
        dao.passWorkApply(Integer.parseInt(id));
        //获取当前处理的时间并传入mydeskTop表中
        String handleDate = new Date().toLocaleString();
        dao.setHandleDate(handleDate,Integer.parseInt(id));

        //跳转回页面信息显示的页面
        response.sendRedirect("R01_FindWorkByPageServlet");

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
