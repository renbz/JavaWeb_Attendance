package com.attendance.dao.impl;

import com.attendance.bean.MyDeskTop;
import com.attendance.dao.R08_MyDeskTopDao;
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

public class R08_MyDeskTopDaoImpl implements R08_MyDeskTopDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DbUtil du = new DbUtil();


    @Override
    public List<MyDeskTop> findMywork(int id) {
        List<MyDeskTop> list = new ArrayList<MyDeskTop>();
        String sql = "select tm.id, tw.WORK_DATE,tw.STATE,tm.HANDLEDATE from T_MYDESKTOP tm , T_WORK_RECORD tw where  tm.FID=tw.RECORD_ID and tm.STATE='1' order by WORK_DATE ";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {

            rs = ps.executeQuery();
            while (rs.next()) {
                MyDeskTop mdt = new MyDeskTop();
                mdt.setId(rs.getInt("id"));
                mdt.setApplyDate(rs.getString("WORK_DATE"));
                mdt.setHandleDate(rs.getString("HANDLEDATE"));
                if (rs.getString("STATE").equals("1")) {
                    mdt.setState("已通过");
                } else if (rs.getString("STATE").equals("2")) {
                    mdt.setState("已驳回");
                }
                list.add(mdt);
                System.out.println(mdt.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
        return list;

    }


    /**
     * 根据id删除加班信息
     */
    @Override
    public void delWorkInfo(int id) {

        //
        String sql = "update T_MYDESKTOP set state='0' where  id = ?";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {
            ps.setInt(1, id);
            ps.executeUpdate();
            du.commit(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
    }

}
