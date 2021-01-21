package com.attendance.servlet.r03_report_record;

import com.attendance.bean.ReportShow;
import com.attendance.dao.R03_ReportRecordDao;
import com.attendance.dao.impl.R03_ReportRecordDaoImpl;

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
@WebServlet("/R05_ReportInsertServlet")
public class R05_ReportInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取前端初入的数据
        String name = request.getParameter("name");
        String report_date = request.getParameter("report_date");
        String work_process = request.getParameter("work_process");
        String work_content = request.getParameter("work_content");
        String tomorrow = request.getParameter("tomorrow");
        String problem = request.getParameter("problem");
        String other = request.getParameter("other");

        ReportShow res = new ReportShow();
        //res.setName(name);
        res.setAccount(name);
        res.setReport_date(report_date);
        res.setWork_process(work_process);
        res.setWork_content(work_content);
        res.setProblem(problem);
        res.setTomorrow(tomorrow);
        res.setOther(other);
        //调用dao插入数据库语句
        R03_ReportRecordDao dao = new R03_ReportRecordDaoImpl();
        dao.insertReport(res);
        //跳转到显示页面
        response.sendRedirect("R01_FindReportByPageServlet");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
