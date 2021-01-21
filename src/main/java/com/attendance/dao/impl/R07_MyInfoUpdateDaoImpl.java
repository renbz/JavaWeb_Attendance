package com.attendance.dao.impl;

import com.attendance.bean.Users;
import com.attendance.dao.R07_MyInfoUpdaterDao;
import com.attendance.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ren
 */

public class R07_MyInfoUpdateDaoImpl implements R07_MyInfoUpdaterDao {
    Connection conn = null;
    PreparedStatement ps  = null;
    ResultSet rs = null;
    DbUtil du = new DbUtil();


    @Override
    public Users echoMyInfo(int myId) {

        Users users = new Users();
        String sql = "select * from T_USER_INFO where id = ?";
        conn = du.getConn();
        ps = du.getPs(conn,sql);
        try {
            ps.setInt(1,myId);
            rs = ps.executeQuery();

            while (rs.next()){
                users.setId(rs.getInt("id"));
                users.setAccount(rs.getString("account"));
                users.setPassword(rs.getString("password"));
                users.setName(rs.getString("name"));
                users.setDepartment_id(rs.getString("department_id"));
                users.setSex(rs.getString("sex"));
                users.setMobile(rs.getString("mobile"));
                users.setBirthday(rs.getString("birthday"));
                users.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            du.closeAll(rs,ps,conn);
        }
        return users;

    }

    /**
     * 修改个人信息
     * @param u
     */
    @Override
    public void updateMyInfo(Users u) {
        String sql = "update T_USER_INFO set account=? , password = ? , name=? , department_id=? , " +
                "sex=? , birthday=? , mobile=? , email = ? where id=?";
        conn = du.getConn();
        ps = du.getPs(conn, sql);

        try {
            ps.setString(1, u.getAccount());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getName());
            ps.setString(4, u.getDepartment_id());
            ps.setString(5, u.getSex());
            ps.setString(6, u.getBirthday());
            ps.setString(7, u.getMobile());
            ps.setString(8, u.getEmail());
            ps.setInt(9, u.getId());  //这里需要获得当前用户的id

            int c = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
    }
}
