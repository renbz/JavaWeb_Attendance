package com.attendance.dao;

import com.attendance.bean.Department;
import com.attendance.bean.ReportShow;

import java.util.List;

/**
 * @author Ren
 */

public interface R03_ReportRecordDao {

    /**
     * 封装查询用户记录总条数的方法
     * @return 返回用户总记录条数
     */
    int findTotalCount(String anme);



    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @return
     */
    List<ReportShow> findByPage(int start, int rows, String name);


    /**
     * 根据id删除用户
     */
    void deleteReport(int id);

    /**
     * 根据id回显数据
     */
    ReportShow echodata(int id);


    /**
     * 根据res对象  修改信息
     */
    void updateReport(ReportShow res);


    /**
     * 插入语句
     */
    void insertReport(ReportShow res);






}
