package com.attendance.servlet.r04_work_record;

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
 * 2020/12/20
 */
@WebServlet("/R03_DealWorkReServlet")
public class R03_DealWorkReServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取前端传入的id值
        String id = request.getParameter("id");
        //根据id删除
        R04_WorkRecordDao dao = new R04_WorkRecordDaoImpl();
        dao.delWorkRecord(Integer.parseInt(id));

        //删除完成，返回信息显示页面
        response.sendRedirect("/R01_FindWorkReByPageServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
