package com.attendance.servlet.r01_users_info;

import com.attendance.dao.impl.R01_UsersInfoDaoImpl;
import com.attendance.bean.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ren
 * 2020/12/12
 */
@WebServlet("/R05_UserEchoDataServlet")
public class R05_UserEchoDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id = request.getParameter("id");
        //调用dao层 查询数据库的方法
        Users users = (new R01_UsersInfoDaoImpl()).queryEchoData(Integer.parseInt(id));
        //将数据存储到request域中
        request.setAttribute("user",users);
        //请求转发到修改用户信息的jsp页面
        request.getRequestDispatcher("/user/userUpdate.jsp").forward(request,response);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
