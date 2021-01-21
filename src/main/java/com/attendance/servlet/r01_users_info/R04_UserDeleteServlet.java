package com.attendance.servlet.r01_users_info;

import com.attendance.dao.impl.R01_UsersInfoDaoImpl;

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
@WebServlet("/R04_UserDeleteServlet")
public class R04_UserDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取id
        String id = request.getParameter("id");
        //调用dao的删除
        (new R01_UsersInfoDaoImpl()).deleteUser(Integer.parseInt(id));
        //执行完删除后 跳转到查询所有的servlet处理界面
        response.sendRedirect(request.getContextPath()+"/R08_FindUserByPageServlet");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
