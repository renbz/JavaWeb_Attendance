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
@WebServlet("/R02_ReportDeleteServlet")
public class R02_ReportDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        R03_ReportRecordDao dao  = new R03_ReportRecordDaoImpl();

        //获取前端传入的id
        String id = request.getParameter("id");
        //调用dao的删除方法
        dao.deleteReport(Integer.parseInt(id));
        //跳转到数据显示的页面
        response.sendRedirect("R01_FindReportByPageServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
