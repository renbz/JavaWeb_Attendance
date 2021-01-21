package com.attendance.servlet.r02_department;

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
@WebServlet("/R03_DepartmentDelServlet")
public class R03_DepartmentDelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        R02_DepartmentDao dao = new R02_DepartmentDaoImpl();

        //获取部门id
        String id = request.getParameter("id");
        int departmentId = Integer.parseInt(id);

        //查询数据库，部门中是否存在员工，若存在则删除失败
        int count = dao.findUserCountByDeptId(departmentId);
        System.out.println(count);
        if(count==0){  //如果部门中员工数等于0，则可以删除部门
            //执行删除部门的sql语句
            dao.deleteDeptById(departmentId);
            response.sendRedirect(request.getContextPath()+"/R01_FindDepartmentByPageServlet");
        }else{
            //部门存在员工，不能删除部门，返回到列表页面
            request.setAttribute("error","部门中仍包含员工，无法删除部门");
            request.getRequestDispatcher(request.getContextPath()+"/R01_FindDepartmentByPageServlet").forward(request,response);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
