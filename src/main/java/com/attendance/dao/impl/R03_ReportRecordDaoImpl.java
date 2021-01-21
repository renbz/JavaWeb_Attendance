package com.attendance.dao.impl;

import com.attendance.bean.ReportShow;
import com.attendance.dao.R03_ReportRecordDao;
import com.attendance.util.DbUtil;

import javax.print.attribute.standard.RequestingUserName;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ren
 */

public class R03_ReportRecordDaoImpl implements R03_ReportRecordDao {


    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DbUtil du = new DbUtil();

    /**
     * 封装查询用户记录总条数的方法
     *
     * @return 返回用户总记录条数
     */

    @Override
    public int findTotalCount(String name) {
        int count = 0;
        String sql = "select count(*) from t_report_record ";
        if(name!=null){
            sql="select count(*) from t_report_record where name like ?";
        }
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {
            if(name!=null){
                name="%"+name+"%";
                ps.setString(1,name);
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
        return count;
    }


    @Override
    public List<ReportShow> findByPage(int start, int rows, String name) {
        List<ReportShow> list = new ArrayList<ReportShow>();
        String sql1 = "select * from (select tr.REPORT_ID , tu.ACCOUNT , tu.NAME , tr.REPORT_DATE , tr.WORK_PROCESS , tr.WORK_CONTENT , tr.PROBLEM , tr.OTHER , ROWNUM as r " +
                " from T_USER_INFO  tu , T_REPORT_RECORD tr where tu.ACCOUNT = tr.ACCOUNT  order by r)  where r between ? and ?";
        String sql2 = "select * from (select    tr.REPORT_ID , tu.ACCOUNT , tu.NAME , tr.REPORT_DATE , tr.WORK_PROCESS , tr.WORK_CONTENT , tr.PROBLEM , tr.OTHER , ROWNUM as r " +
                " from T_USER_INFO  tu , T_REPORT_RECORD tr where tu.ACCOUNT = tr.ACCOUNT  and tu.NAME like ? order by r)  where r between ? and ? ";

        String sql = sql1;
        if (name != null && !"".equals(name)) {   //如果有查询条件有值 则执行sql语句2
            sql = sql2;
        }

        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {

            if (name != null && !"".equals(name)) {   //如果查询条件有值 则对后两个参数赋值
                name = "%" + name + "%";
                ps.setString(1, name);
                ps.setInt(2, start);
                ps.setInt(3, start + rows - 1);
            } else {
                ps.setInt(1, start);
                ps.setInt(2, start + rows - 1);
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                ReportShow reportShow = new ReportShow();
                reportShow.setReport_id(rs.getInt("REPORT_ID"));
                reportShow.setAccount(rs.getString("ACCOUNT"));
                reportShow.setName(rs.getString("NAME"));
                reportShow.setReport_date(rs.getString("REPORT_DATE"));
                reportShow.setWork_process(rs.getString("WORK_PROCESS"));
                reportShow.setProblem(rs.getString("PROBLEM"));
                reportShow.setWork_content(rs.getString("WORK_CONTENT"));
                reportShow.setOther(rs.getString("OTHER"));
                list.add(reportShow);
                //System.out.println(reportShow.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 根据id删除用户
     *
     * @param id
     */
    @Override
    public void deleteReport(int id) {
        String sql = "delete from t_report_record where report_id = ?";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
    }

    @Override
    public ReportShow echodata(int id) {
        ReportShow res = new ReportShow();
        String sql = "select tr.REPORT_ID , tu.ACCOUNT , tu.NAME , tr.REPORT_DATE ,tr.TOMORROW_PLAN, tr.WORK_PROCESS , tr.WORK_CONTENT , tr.PROBLEM , tr.OTHER from T_USER_INFO  tu , T_REPORT_RECORD tr where tu.ACCOUNT = tr.ACCOUNT and report_id=?";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            du.commit(conn);
            if (rs.next()) {
                res.setReport_id(rs.getInt("REPORT_ID"));
                res.setAccount(rs.getString("ACCOUNT"));
                res.setName(rs.getString("NAME"));
                res.setReport_date(rs.getString("REPORT_DATE"));
                res.setWork_process(rs.getString("WORK_PROCESS"));
                res.setWork_content(rs.getString("WORK_CONTENT"));
                res.setProblem(rs.getString("PROBLEM"));
                res.setOther(rs.getString("OTHER"));
                res.setTomorrow(rs.getString("TOMORROW_PLAN"));
                //System.out.println(res.toString());


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
        return res;
    }


    /**
     * 修改report信息
     *
     * @param res
     */
    @Override
    public void updateReport(ReportShow res) {
        String sql = "update T_REPORT_RECORD set report_date=?,work_process=?," +
                "work_content=?,problem=?,tomorrow_plan=?,other=? where report_id = ?";

        //System.out.println(res.toString());
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {

            ps.setString(1,res.getReport_date());
            ps.setString(2,res.getWork_process());
            ps.setString(3,res.getWork_content());
            ps.setString(4,res.getProblem());
            ps.setString(5,res.getTomorrow());
            ps.setString(6,res.getOther());
            ps.setInt(7,res.getReport_id());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }

    }


    /**
     * 插入日报信息
     * @param res
     */
    @Override
    public void insertReport(ReportShow res) {
        String sql = "insert into T_REPORT_RECORD values(NULL,?,?,?,?,?,?,?)";

        System.out.println(res.toString());
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {

            ps.setString(1,res.getAccount());
            ps.setString(2,res.getReport_date());
            ps.setString(3,res.getWork_process());
            ps.setString(4,res.getWork_content());
            ps.setString(6,res.getProblem());
            ps.setString(5,res.getTomorrow());
            ps.setString(7,res.getOther());

            ps.executeUpdate();
            du.commit(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }

    }


}
