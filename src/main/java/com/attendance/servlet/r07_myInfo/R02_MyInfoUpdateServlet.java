package com.attendance.servlet.r07_myInfo;

import com.attendance.bean.Users;
import com.attendance.dao.R07_MyInfoUpdaterDao;
import com.attendance.dao.impl.R07_MyInfoUpdateDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ren
 * 2020/12/15
 */

@WebServlet("/R02_MyInfoUpdateServlet")
public class R02_MyInfoUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端传入的数据
        int id = (Integer) request.getSession().getAttribute("myId");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String department_id = request.getParameter("department_id");
        String sex = request.getParameter("sex");
        String mobile = request.getParameter("mobile");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");

        //创建Users对象 并对其赋值
        Users us  = new Users();
        us.setId(id);
        us.setAccount(account);
        us.setPassword(password);
        us.setName(name);
        us.setDepartment_id(department_id);
        us.setSex(sex);
        us.setMobile(mobile);
        us.setBirthday(birthday);
        us.setEmail(email);

        //调用dao层查询数据库
        R07_MyInfoUpdaterDao dao = new R07_MyInfoUpdateDaoImpl();
        dao.updateMyInfo(us);

        //修改成功返回登录页面
        response.sendRedirect(request.getContextPath()+"/login.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
