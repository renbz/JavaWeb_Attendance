package com.attendance.servlet.r05_rest_record;

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
 * 2020/12/20
 */
@WebServlet("/R03_DelRestRecordServlet")
public class R03_DelRestRecordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取前端传入的id值
        String id = request.getParameter("id");
        //根据id删除
        R05_RestRecordDao dao = new R05_RestRecordDaoImpl();
        dao.delRestRecord(Integer.parseInt(id));
        //删除完成 返回信息展示页面
        response.sendRedirect("/R01_FindRestReByPageServlet");


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
