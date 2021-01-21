package com.attendance.Service.impl;

import com.attendance.Service.R01_UsersInfoService;
import com.attendance.bean.PageBean;
import com.attendance.bean.UserShow;
import com.attendance.dao.R01_UsersInfoDao;
import com.attendance.dao.impl.R01_UsersInfoDaoImpl;

/**
 * @author Ren
 */

public class R01_UsersInfoServiceImpl  {

/*

    @Override
    public PageBean<UserShow> findUserByPage(String currentPage, String rows) {

        R01_UsersInfoDao dao  = new R01_UsersInfoDaoImpl();
        int currentPage_ = Integer.parseInt(currentPage);
        int rows_ = Integer.parseInt(rows);
        //1. 创建空的pageBean对象
        PageBean<UserShow> pb = new PageBean<UserShow>();
        //2. 设置参数
        pb.setCurrentPage(currentPage_);
        pb.setRows(rows_);
        //3. 调用dao查询总记录数
        //int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);
        //4. 调用dao查询List集合
        // 计算开始的索引
        int start = (currentPage_ - 1) * rows_ ;
        //List<UserShow> list = dao.findByPage(start,rows_ );
        //pb.setList(list);
        //5. 计算总页码
        int totalPage = totalCount % rows_ == 0 ? totalCount/rows_ : totalCount/rows_ + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }
    */

}
