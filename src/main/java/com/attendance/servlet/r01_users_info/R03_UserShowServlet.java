package com.attendance.servlet.r01_users_info;

import com.attendance.dao.impl.R01_UsersInfoDaoImpl;
import com.attendance.bean.UserShow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Ren
 * 2020/12/12
 */
@WebServlet("/R03_UserShowServlet")
public class R03_UserShowServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //封装查询出来的用户信息
        List<UserShow> userShows = (new R01_UsersInfoDaoImpl()).userInfoSearchAll();
        request.setAttribute("userShows",userShows);
        request.getRequestDispatcher("/user/userSearch.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
