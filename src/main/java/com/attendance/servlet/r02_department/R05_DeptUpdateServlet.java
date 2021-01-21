package com.attendance.servlet.r02_department;

import com.attendance.bean.Department;
import com.attendance.dao.R02_DepartmentDao;
import com.attendance.dao.impl.R02_DepartmentDaoImpl;

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
@WebServlet("/R05_DeptUpdateServlet")
public class R05_DeptUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        R02_DepartmentDao dao = new R02_DepartmentDaoImpl();
        // 获取前端提交的信息
        String deptId = request.getParameter("department_id");
        String deptName = request.getParameter("department_name");
        String manager = request.getParameter("manager");
        // 将信息存入dept对象中
        Department dept = new Department();
        dept.setDepartment_id(Integer.parseInt(deptId));
        dept.setDepartment_name(deptName);
        dept.setManager(manager);
        //调用dao层 将信息插入进数据库
        dao.insertDepartment(dept);

        //信息插入成功，跳转到数据显示页面
        response.sendRedirect(request.getContextPath()+"/R01_FindDepartmentByPageServlet");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
