package com.attendance.servlet.r01_users_info;
import com.attendance.dao.impl.R01_UsersInfoDaoImpl;
import com.attendance.bean.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

/**
 * @author Ren
 * 2020/12/12
 */

@WebServlet("/R01_UserLoginServlet")
public class R01_UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        request.getSession().setAttribute("username",username);

        Users u = new Users();
        u.setName(username);
        u.setPassword(password);
        Boolean ans = new R01_UsersInfoDaoImpl().loginCheck(u);

        //根据用户名和密码查询出用户id
        int myId = new R01_UsersInfoDaoImpl().searchId(u);
        request.getSession().setAttribute("myId",myId);

        if (ans) {//结果集不为空，即在数据库中查询到数据  登录成功

            response.sendRedirect("/main.jsp");
            //request.getRequestDispatcher("/main.jsp").forward(request, response);
        } else {
            //未查询到结果集   登录失败
            request.getSession().setAttribute("message", 0);
            //跳转至登录失败的页面,重定向
            response.sendRedirect("/main.jsp");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}