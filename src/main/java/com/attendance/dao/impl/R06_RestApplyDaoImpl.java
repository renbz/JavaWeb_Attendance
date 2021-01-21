package com.attendance.dao.impl;

import com.attendance.bean.RestRecordShow;
import com.attendance.bean.WorkRecordShow;
import com.attendance.dao.R06_RestApplyDao;
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

public class R06_RestApplyDaoImpl implements R06_RestApplyDao {
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
        String sql = "select count(*) from t_rest_record where STATE='0'";
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
        String sql = "select * from (select distinct tr.* , ROWNUM as r , tu.name  from t_user_info tu, t_rest_record tr  where tu.account = tr.account and tr.STATE='0' order by tr.rest_id) where r between ? and ? ";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {

            ps.setInt(1, start);
            ps.setInt(2, start + rows - 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                RestRecordShow rrs = new RestRecordShow();
                rrs.setRest_time(rs.getString("rest_time"));
                rrs.setRest_id(rs.getInt("rest_id"));
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
    public void passRestApply(int id) {
        String sql = "update t_rest_record set state= '1' where rest_id = ? ";
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


    @Override
    public void refuseRestApply(int id) {
        String sql = "update t_rest_record set state= '2' where rest_id = ? ";
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
