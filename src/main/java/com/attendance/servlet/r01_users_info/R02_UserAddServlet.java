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
@WebServlet("/R02_UserAddServlet")
public class R02_UserAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        String account = request.getParameter("account");  //工号
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String department_id = request.getParameter("department_id"); //部门id
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");

        Users u = new Users();
        u.setAccount(account);
        u.setPassword(password);
        u.setName(name);
        u.setDepartment_id(department_id);
        u.setSex(sex);
        u.setBirthday(birthday);
        u.setMobile(mobile);
        u.setEmail(email);
        //调用Dao层的插入数据库的方法

        //int c = 0;
        try { int c  = (new R01_UsersInfoDaoImpl()).userInfoAdd(u);

            if(c>0){
                //数据插入成功，跳转至数据显示页面
                response.sendRedirect(request.getContextPath()+"/R08_FindUserByPageServlet");
                //System.out.println("添加用户成功");
            }else{
                //数据插入失败，保留当前页面
                response.sendRedirect("/user/userInsert.jsp");
                System.out.println("添加用户失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(c);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
