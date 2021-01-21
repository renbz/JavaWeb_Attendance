package com.attendance.servlet.r08_mydesktop;

import com.attendance.bean.MyDeskTop;
import com.attendance.dao.R08_MyDeskTopDao;
import com.attendance.dao.impl.R08_MyDeskTopDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ren
 * 2020/12/19
 */
@WebServlet("/R01_MyDeskTopServlet")
public class R01_MyDeskTopServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //根据登录的id在加班表中，查找个人的加班信息并显示
        int id = (int) request.getSession().getAttribute("myId");
        //System.out.println(id);
        R08_MyDeskTopDao dao = new R08_MyDeskTopDaoImpl();
        List<MyDeskTop> list;
        list = dao.findMywork(id);
        //将list值存入request域中

        //System.out.println(list.size());
        request.setAttribute("list",list);
        //跳转到显示页面
        request.getRequestDispatcher("/mydesktop/mydesktop.jsp").forward(request,response);

    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

