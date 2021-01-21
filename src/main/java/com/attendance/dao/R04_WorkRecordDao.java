package com.attendance.dao;

import com.attendance.bean.WorkRecordShow;

import java.util.List;

/**
 * @author Ren
 */

public interface R04_WorkRecordDao {

    /**
     * 查询总记录条数
     * @return
     */
    int findTotalCount();


    /**
     * 分页查询信息
     */
    List<WorkRecordShow> findByPage(int start, int rows);


    /**
     * 插入信息
     */
    void insertWorkRecord(WorkRecordShow wrs);


    /**
     * 根据id删除信息
     * @param id
     */
    void delWorkRecord(int id);

}
