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
@WebServlet("/R07_SelectUserDelServlet")
public class R07_SelectUserDelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取所有的id
        String[] ids = request.getParameterValues("uid");
        //遍历数组 调用dao删除
        for (String id : ids) {
            (new R01_UsersInfoDaoImpl()).deleteUser(Integer.parseInt(id));
        }
        //跳转回数据显示页面
        request.getRequestDispatcher(request.getContextPath()+"/R08_FindUserByPageServlet").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
