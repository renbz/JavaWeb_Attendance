package com.attendance.servlet.r02_department;

import com.attendance.bean.Department;
import com.attendance.bean.PageBean;
import com.attendance.dao.R02_DepartmentDao;
import com.attendance.dao.impl.R02_DepartmentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Ren
 * 2020/12/13
 */
@WebServlet("/R01_FindDepartmentByPageServlet")
public class R01_FindDepartmentByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        R02_DepartmentDao userDao = new R02_DepartmentDaoImpl();
        //1. 获取参数
        String currentPage = request.getParameter("currentPage");  //当前页码
        if(currentPage==null){
            currentPage = "1";
        }
        String rows = request.getParameter("rows");   //每页显示条数
        if(rows==null){
            rows = "5";
        }
        String deptname = request.getParameter("search_name");   // 获得模糊查询的name值
        //2. 调用dao查询
        R02_DepartmentDao dao  = new R02_DepartmentDaoImpl();

        int currentPage_ = Integer.parseInt(currentPage);
        int rows_ = Integer.parseInt(rows);
        //1. 创建空的pageBean对象
        PageBean<Department> pb = new PageBean<Department>();
        //2. 设置参数
        pb.setCurrentPage(currentPage_);
        pb.setRows(rows_);
        //3. 调用dao查询总记录数
        int totalCount = dao.findTotalCount(deptname);
        pb.setTotalCount(totalCount);
        //4. 调用dao查询List集合
        // 计算开始的索引
        int start = (currentPage_ - 1) * rows_ +1;
        List<Department> list = dao.findByPage(start,rows_,deptname);
        pb.setList(list);
        //5. 计算总页码
        int totalPage = totalCount % rows_ == 0 ? totalCount/rows_ : totalCount/rows_ + 1;
        pb.setTotalPage(totalPage);
        //6. 将pageBean存入request中
        request.setAttribute("pb",pb);
        //转发到数据显示页面
        request.getRequestDispatcher("/dept/deptSearch.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
