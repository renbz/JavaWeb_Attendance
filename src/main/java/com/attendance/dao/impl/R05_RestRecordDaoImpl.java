package com.attendance.dao.impl;

import com.attendance.bean.RestRecordShow;
import com.attendance.bean.WorkRecordShow;
import com.attendance.dao.R05_RestRecordDao;
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

public class R05_RestRecordDaoImpl implements R05_RestRecordDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DbUtil du = new DbUtil();



    /**
     * 查询加班记录总条数
     * @return
     */
    @Override
    public int findTotalCount() {
        List<WorkRecordShow> list = new ArrayList<WorkRecordShow>();
        String sql = "select count(*) from t_rest_record";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        int count = 0;
        try {
            rs = ps.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
        return count;
    }


    /**
     * 分页查询休假信息
     * @param start
     * @param rows
     * @return
     */
    @Override
    public List<RestRecordShow> findByPage(int start, int rows) {
        List<RestRecordShow> list = new ArrayList<RestRecordShow>();
        String sql = "select * from (select distinct tw.* , ROWNUM as r , tu.name  from t_user_info tu, t_rest_record tw  where tu.account = tw.account order by tw.rest_id) where r between ? and ? ";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {

            ps.setInt(1, start);
            ps.setInt(2, start + rows - 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                RestRecordShow rrs = new RestRecordShow();
                rrs.setRest_id(rs.getInt("rest_id"));
                rrs.setRest_time(rs.getString("rest_time"));
                rrs.setAccount(rs.getString("account"));
                rrs.setRest_start_date(rs.getString("rest_start_date"));
                rrs.setStart_time(rs.getString("start_time"));
                rrs.setEnd_time(rs.getString("end_time"));
                rrs.setRest_end_date(rs.getString("rest_end_date"));
                rrs.setBeikao(rs.getString("beikao"));
                rrs.setName(rs.getString("name"));
                rrs.setRest_cause(rs.getString("rest_cause"));
                rrs.setState(rs.getString("state"));
                list.add(rrs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
        return list;
    }




    @Override
    public void insertRestRecord(RestRecordShow rrs) {
        String sql = "insert into t_rest_record (account,rest_start_date,start_time,rest_end_date,end_time,rest_time,rest_cause,state) values(?,?,?,?,?,?,?,'0')";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {
            ps.setString(1,rrs.getAccount());
            ps.setString(2,rrs.getRest_start_date());
            ps.setString(3,rrs.getStart_time());
            ps.setString(4,rrs.getRest_start_date());
            ps.setString(5,rrs.getEnd_time());
            ps.setString(6,rrs.getRest_time());
            ps.setString(7,rrs.getRest_cause());
            ps.executeUpdate();
            du.commit(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }


    }


    /**
     * 根据id删除休假记录
     * @param id
     */
    @Override
    public void delRestRecord(int id) {
        String sql = "delete t_rest_record where rest_id = ?";
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
