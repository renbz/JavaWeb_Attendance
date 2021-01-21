package com.attendance.dao;

import com.attendance.bean.RestRecordShow;

import java.util.List;

/**
 * @author Ren
 */

public interface R06_RestApplyDao {



    /**
     * 查询总记录条数
     * @return
     */
    public int findTotalCount();


    /**
     * 分页查询信息
     */
    public List<RestRecordShow> findByPage(int start, int rows);


    /**
     * 通过加班申请
     */
    public void passRestApply(int id);


    /**
     * 拒绝加班申请
     */
    public void refuseRestApply(int id);


}
