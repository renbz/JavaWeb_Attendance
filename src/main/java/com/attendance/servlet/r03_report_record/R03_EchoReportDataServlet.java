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
@WebServlet("/R03_EchoReportDataServlet")
public class R03_EchoReportDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        R03_ReportRecordDao dao = new R03_ReportRecordDaoImpl();
        //获取前端传入的id，进行数据查询
        String id = request.getParameter("id");
        ReportShow res =dao.echodata(Integer.parseInt(id));
        //将获取的值存入attribute
        request.setAttribute("res",res);
        request.getRequestDispatcher("/report/reportUpdate.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
