package com.attendance.dao;

import com.attendance.bean.RestRecordShow;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Ren
 */

public interface R05_RestRecordDao {

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
     * 插入数据
     * @param rrs
     */
    void insertRestRecord(RestRecordShow rrs) ;


    /**
     * 根据id删除数据
     * @param id
     */
    void delRestRecord(int id);
}
