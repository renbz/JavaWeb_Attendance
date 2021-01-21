package com.attendance.dao;

import com.attendance.bean.WorkRecordShow;

import java.util.List;

/**
 * @author Ren
 */

public interface R06_WorkApplyDao {

    /**
     * 查询总记录条数
     * @return
     */
    public int findTotalCount();


    /**
     * 分页查询信息
     */
    public List<WorkRecordShow> findByPage(int start, int rows);


    /**
     * 通过加班申请
     */
    public void passWorkApply(int id);


    /**
     * 拒绝加班申请
     */
    public void refuseWorkApply(int id);


    /**
     * set handleDate
     */
    public void setHandleDate(String handleDate,int id);



}
