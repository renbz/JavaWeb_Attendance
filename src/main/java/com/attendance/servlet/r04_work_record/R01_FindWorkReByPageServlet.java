package com.attendance.servlet.r04_work_record;

import com.attendance.bean.PageBean;
import com.attendance.bean.WorkRecordShow;
import com.attendance.dao.R04_WorkRecordDao;
import com.attendance.dao.R06_WorkApplyDao;
import com.attendance.dao.impl.R04_WorkRecordDaoImpl;
import com.attendance.dao.impl.R06_WorkApplyDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Ren
 * 2020/12/19
 */
@WebServlet("/R01_FindWorkReByPageServlet")
public class R01_FindWorkReByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        R04_WorkRecordDao dao = new R04_WorkRecordDaoImpl();

        //1. 获取参数
        String currentPage = request.getParameter("currentPage");   //当前页码
        if(currentPage==null){
            currentPage = "1";
        }

        String rows = request.getParameter("rows");   //每页显示条数
        if(rows==null){
            rows = "5";
        }

        //2. 调用dao查询
        int currentPage_ = Integer.parseInt(currentPage);
        int rows_ = Integer.parseInt(rows);
        //1. 创建空的pageBean对象
        PageBean<WorkRecordShow> pb = new PageBean<WorkRecordShow>();
        //2. 设置参数
        pb.setCurrentPage(currentPage_);
        pb.setRows(rows_);
        //3. 调用dao查询总记录数
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);
        //4. 调用dao查询List集合
        //   计算开始的索引
        int start = (currentPage_ - 1) * rows_ +1;
        List<WorkRecordShow> list = dao.findByPage(start,rows_);
        pb.setList(list);
        //5. 计算总页码
        int totalPage = totalCount % rows_ == 0 ? totalCount/rows_ : totalCount/rows_ + 1;
        pb.setTotalPage(totalPage);
        //6. 将pageBean存入request中
        request.setAttribute("pb",pb);
        //7. 转发到数据显示页面
        request.getRequestDispatcher("/workmanager/workSearch.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
