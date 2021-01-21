package com.attendance.servlet.r04_work_record;

import com.attendance.bean.WorkRecordShow;
import com.attendance.dao.R04_WorkRecordDao;
import com.attendance.dao.impl.R04_WorkRecordDaoImpl;

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
@WebServlet("/R02_InsertWorkServlet")
public class R02_InsertWorkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端的传值
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String work_date = request.getParameter("work_date");
        String start_time = request.getParameter("start_time");
        String end_time = request.getParameter("end_time");
        String work_time = request.getParameter("work_time");
        String work_cause = request.getParameter("work_cause");

        WorkRecordShow wrs = new WorkRecordShow();
        wrs.setAccount(account);
        wrs.setName(name);
        wrs.setWork_date(work_date);
        wrs.setStart_time(start_time);
        wrs.setEnd_time(end_time);
        wrs.setWork_time(work_time);
        wrs.setWork_cause(work_cause);

        R04_WorkRecordDao dao = new R04_WorkRecordDaoImpl();
        dao.insertWorkRecord(wrs);

        //返回显示页面
        response.sendRedirect("/R01_FindWorkReByPageServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
