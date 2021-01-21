package com.attendance.dao.impl;

import com.attendance.bean.WorkRecordShow;
import com.attendance.dao.R04_WorkRecordDao;
import com.attendance.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ren
 */

public class R04_WorkRecordDaoImpl implements R04_WorkRecordDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DbUtil du = new DbUtil();

    /**
     * 查询加班记录总条数
     *
     * @return
     */
    @Override
    public int findTotalCount() {
        List<WorkRecordShow> list = new ArrayList<WorkRecordShow>();
        String sql = "select count(*) from t_work_record tw";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        int count = 0;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    /**
     * 分页查询加班信息
     *
     * @param start
     * @param rows
     * @return
     */
    @Override
    public List<WorkRecordShow> findByPage(int start, int rows) {
        List<WorkRecordShow> list = new ArrayList<WorkRecordShow>();
        String sql = " select *  from (select distinct tw.* ,ROWNUM  as r, tu.name  from t_user_info tu, t_work_record tw  where tu.account = tw.account order by tw.RECORD_ID) where r between ? and ? ";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {
            ps.setInt(1, start);
            ps.setInt(2, start + rows - 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                WorkRecordShow wrs = new WorkRecordShow();
                wrs.setRecord_id(rs.getInt("record_id"));
                wrs.setAccount(rs.getString("account"));
                wrs.setWork_date(rs.getString("work_date"));
                wrs.setStart_time(rs.getString("start_time"));
                wrs.setEnd_time(rs.getString("end_time"));
                wrs.setWork_cause(rs.getString("work_cause"));
                wrs.setBeikao(rs.getString("beikao"));
                wrs.setName(rs.getString("name"));
                wrs.setState(rs.getString("state"));
                //System.out.println(wrs.toString());
                list.add(wrs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
        return list;
    }

    /**
     * 插入加班信息
     *
     * @param wrs
     * @return
     */
    @Override
    public void insertWorkRecord(WorkRecordShow wrs) {
        String sql = "insert into t_work_record values(NULL,?,?,?,?,?,?,'无','0') ";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {
            ps.setString(1, wrs.getAccount());
            ps.setString(2, wrs.getWork_date());
            ps.setString(3, wrs.getStart_time());
            ps.setString(4, wrs.getEnd_time());
            ps.setString(5, wrs.getWork_time());
            ps.setString(6, wrs.getWork_cause());
            ps.executeUpdate();
            du.commit(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
    }

    @Override
    public void delWorkRecord(int id) {
        String sql = "delete from t_work_record where record_id = ?";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {
            ps.setInt(1,id);
            ps.executeUpdate();
            du.commit(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
    }

}
