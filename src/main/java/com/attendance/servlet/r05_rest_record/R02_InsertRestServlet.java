package com.attendance.servlet.r05_rest_record;

import com.attendance.bean.Account;
import com.attendance.bean.RestRecordShow;
import com.attendance.dao.R05_RestRecordDao;
import com.attendance.dao.impl.R05_RestRecordDaoImpl;

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
@WebServlet("/R02_InsertRestServlet")
public class R02_InsertRestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取前端的传值
        String account= request.getParameter("account");
        String name = request.getParameter("name");
        String rest_start_date = request.getParameter("rest_start_date");
        String start_time = request.getParameter("start_time");
        String rest_end_date = request.getParameter("rest_end_date");
        String end_time = request.getParameter("end_time");
        String rest_time = request.getParameter("rest_time");
        String rest_cause = request.getParameter("rest_cause");

        RestRecordShow rrs = new RestRecordShow();
        rrs.setAccount(account);
        rrs.setName(name);
        rrs.setRest_start_date(rest_start_date);
        rrs.setStart_time(start_time);
        rrs.setRest_end_date(rest_end_date);
        rrs.setEnd_time(end_time);
        rrs.setRest_time(rest_time);
        rrs.setRest_cause(rest_cause);


        R05_RestRecordDao dao = new R05_RestRecordDaoImpl();
        dao.insertRestRecord(rrs);

        // 返回显示页面
        response.sendRedirect("/R01_FindRestReByPageServlet");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
