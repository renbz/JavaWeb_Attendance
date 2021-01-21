package com.attendance.servlet.r07_myInfo;

import com.attendance.bean.Users;
import com.attendance.dao.impl.R07_MyInfoUpdateDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ren
 * 2020/12/14
 */
@WebServlet("/R01_MyInfoEchoServlet")
public class R01_MyInfoEchoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取通过 用户名，密码 查询到的id
        int id = (int) request.getSession().getAttribute("myId");

        // 调用dao层 查询数据库   获取当前用户信息
        Users us = new R07_MyInfoUpdateDaoImpl().echoMyInfo(id);
        System.out.println(us.toString());
        // 将当前用户信息 存入attribute
        request.setAttribute("us",us);
        //request.setAttribute("myId",id);
        // 转发到修改用户信息的界面
        request.getRequestDispatcher(request.getContextPath()+"/user/userPasswordUpdate.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
