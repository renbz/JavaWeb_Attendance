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
@WebServlet("/R04_ReportUpdateServlet")
public class R04_ReportUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取前端初入的数据
        String id = request.getParameter("report_id");
        System.out.println(id);
        String name = request.getParameter("name");
        String report_date = request.getParameter("report_date");
        String work_process = request.getParameter("work_process");
        String work_content = request.getParameter("work_content");
        String tomorrow = request.getParameter("tomorrow");
        String problem = request.getParameter("problem");
        String other = request.getParameter("other");

        ReportShow res = new ReportShow();
        res.setReport_id(Integer.parseInt(id));
        res.setName(name);
        res.setReport_date(report_date);
        res.setWork_process(work_process);
        res.setWork_content(work_content);
        res.setProblem(problem);
        res.setTomorrow(tomorrow);
        res.setOther(other);

        //调用dao层进行修改
        R03_ReportRecordDao dao = new R03_ReportRecordDaoImpl();
        dao.updateReport(res);

        //跳转回数据显示页面
        response.sendRedirect("R01_FindReportByPageServlet");



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
