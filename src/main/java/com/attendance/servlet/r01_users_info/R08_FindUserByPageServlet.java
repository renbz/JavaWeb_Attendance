package com.attendance.servlet.r01_users_info;

import com.attendance.bean.PageBean;
import com.attendance.bean.UserShow;
import com.attendance.dao.R01_UsersInfoDao;
import com.attendance.dao.impl.R01_UsersInfoDaoImpl;

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

@WebServlet("/R08_FindUserByPageServlet")
public class R08_FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        R01_UsersInfoDao userDao = new R01_UsersInfoDaoImpl();
        //1. 获取参数
        String currentPage = request.getParameter("currentPage");  //当前页码
        if(currentPage==null){
            currentPage = "1";
        }

        String rows = request.getParameter("rows");   //每页显示条数
        if(rows==null){
            rows = "5";
        }

        String name = request.getParameter("search_name");   // 获得模糊查询的name值
        String department_id = request.getParameter("department_id"); //获得查询需要的 部门id
        if(department_id == null){
            department_id = "10001";
        }

        int departmentId = Integer.parseInt(department_id);

        //2. 调用service查询
        //R01_UsersInfoService service = new R01_UsersInfoServiceImpl();
        //PageBean<UserShow> pb = service.findUserByPage(currentPage,rows);
        R01_UsersInfoDao dao  = new R01_UsersInfoDaoImpl();

        int currentPage_ = Integer.parseInt(currentPage);
        int rows_ = Integer.parseInt(rows);
        //1. 创建空的pageBean对象
        PageBean<UserShow> pb = new PageBean<UserShow>();
        //2. 设置参数
        pb.setCurrentPage(currentPage_);
        pb.setRows(rows_);
        //3. 调用dao查询总记录数
        int totalCount = dao.findTotalCount(name,departmentId);
        pb.setTotalCount(totalCount);
        //4. 调用dao查询List集合
        //   计算开始的索引
        int start = (currentPage_ - 1) * rows_ +1;
        List<UserShow> list = dao.findByPage(start,rows_,name, departmentId );
        pb.setList(list);
        //5. 计算总页码
        int totalPage = totalCount % rows_ == 0 ? totalCount/rows_ : totalCount/rows_ + 1;
        pb.setTotalPage(totalPage);
        //6. 将pageBean存入request中
        request.setAttribute("pb",pb);
        //转发到数据显示页面
        request.getRequestDispatcher("/user/userSearch.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
