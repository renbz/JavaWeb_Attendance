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
import java.util.Date;

/**
 * @author Ren
 * 2020/12/13
 */
@WebServlet("/R02_DepartmentAddServlet")
public class R02_DepartmentAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取要添加的部门信息
        Department dp = new Department();
        int deptId = Integer.parseInt(request.getParameter("dept_id"));
        String deptName = request.getParameter("dept_name");
        String manager = request.getParameter("manager");
        String createTime = new Date().toLocaleString();

        R02_DepartmentDao dao = new R02_DepartmentDaoImpl();
        int total_user = dao.findUserCountByDeptId(deptId);
        dp.setDepartment_id(deptId);
        dp.setDepartment_name(deptName);
        dp.setTotal_user(total_user);
        dp.setManager(manager);
        dp.setCreate_time(createTime);
        //调用dao层的添加部门的方法
        (new R02_DepartmentDaoImpl()).deptAdd(dp);
        //返回部门显示页面
        response.sendRedirect(request.getContextPath()+"/R01_FindDepartmentByPageServlet");



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}