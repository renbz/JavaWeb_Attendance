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
@WebServlet("/R04_DeptEchoDataServlet")
public class R04_DeptEchoDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        R02_DepartmentDao dao = new R02_DepartmentDaoImpl();
        //获取部门id
        String id = request.getParameter("id");
        int deptId = Integer.parseInt(id);
        //根据id查询数据库，获取部门信息
        Department dept = dao.findDeptById(deptId);
        request.setAttribute("dept",dept);
        //跳转到数据修改页面
        request.getRequestDispatcher(request.getContextPath()+"/dept/deptUpdate.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
