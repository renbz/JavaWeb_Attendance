package com.attendance.dao.impl;
import com.attendance.dao.R01_UsersInfoDao;
import com.attendance.bean.UserShow;
import com.attendance.bean.Users;
import com.attendance.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ren
 * 2020-12-12
 */

public class R01_UsersInfoDaoImpl implements R01_UsersInfoDao {
    Connection conn = null;
    PreparedStatement ps  = null;
    ResultSet rs = null;
    DbUtil du = new DbUtil();




    /**
     * R01_UserLoginServlet
     * 封装登录验证
     * @param u  封装了用户信息(账号和密码)的users对象
     * @return 返回查询结果 boolean类型，查询到结果返回true  登录成功
     */
    @Override
    public boolean loginCheck(Users u){
        String sql = "select * from t_user_info where name = ? and password = ? ";
        conn = du.getConn();
        ps = du.getPs(conn,sql);
        try {
            ps.setString(1,u.getName());
            ps.setString(2,u.getPassword());
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            du.closeAll(rs,ps,conn);
        }
        return false;
    }



    /**
     * 封装添加用户信息的方法
     * @param u 封装用户信息
     * @return 返回更新数据库的行数
     * @throws SQLException
     */
    @Override
    public Integer userInfoAdd(Users u) {
        String sql = "insert into t_user_info(account,password,name,department_id,sex,birthday,mobile,email) " +
                "values(?,?,?,?,?,?,?,?)";
        conn = du.getConn();
        ps = du.getPs(conn,sql);
        int c = 0;
        try {
            ps.setString(1,u.getAccount());
            ps.setString(2,u.getPassword());
            ps.setString(3,u.getName());
            ps.setString(4,u.getDepartment_id());
            ps.setString(5,u.getSex());
            ps.setString(6,u.getBirthday());
            ps.setString(7,u.getMobile());
            ps.setString(8,u.getEmail());

            c = ps.executeUpdate();
            System.out.println(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            du.closeAll(rs,ps,conn);
        }
        return c;
    }




    /**
     * 封装查询用户信息的方法
     * @return  返回存储用户信息的集合
     */
    @Override
    public List userInfoSearchAll() {
        List<UserShow> list = new ArrayList<UserShow>();

        String sql = "select  tu.ID, tu.ACCOUNT, tu.NAME, tu.DEPARTMENT_ID,td.DEPARTMENT_NAME, tu.SEX, tu.BIRTHDAY, tu.MOBILE, tu.EMAIL, " +
                " tu.USER_TYPE, tu.CREATE_TIME from T_USER_INFO tu,T_DEPARTMENT td where tu.DEPARTMENT_ID = td.DEPARTMENT_ID";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {
            rs =  ps.executeQuery();
            while(rs.next()){
                UserShow us = new UserShow();
                us.setId(rs.getInt(1));
                us.setAccount(rs.getString(2));
                us.setName(rs.getString(3));
                us.setDeparment_id(rs.getInt(4));
                us.setDepartment_name(rs.getString(5));
                us.setSex(rs.getString(6));
                us.setBirthday(rs.getString(7));
                us.setMobile(rs.getString(8));
                us.setEmail(rs.getString(9));
                us.setUser_type(rs.getString(10));
                us.setCreate_time(rs.getString(11));
                //System.out.println(us.toString());
                list.add(us);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }

        return list;
    }




    /**
     * 封装删除用户的功能
     * @param id  要删除用户的id
     */
    @Override
    public void deleteUser(int id){

        int i = 0;
        String sql = "delete from T_USER_INFO where id = ?";
        conn = du.getConn();
        ps = du.getPs(conn,sql);
        try {
            ps.setInt(1,id);
            i = ps.executeUpdate();
            du.commit(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            du.closeAll(rs,ps,conn);
        }
    }


    /**
     * 封装查询用户信息并回显到修改页面的功能
     * @param id  要修改的用户id ， 根据id从数据库中查询数据，回显到前端页面
     * @return   返回Users类的对象
     */
    @Override
    public Users queryEchoData(int id){

        Users users = new Users();
        String sql = "select * from T_USER_INFO where id = ?";
        conn = du.getConn();
        ps = du.getPs(conn,sql);
        try {
            ps.setInt(1,id);
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
     * 封装修改用户信息的方法
     * @param u  将修改后的信息封装到users对象中，传参至此页面，进行数据库信息的修改
     */
    @Override
    public void userInfoUpdate(Users u) {

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
            /*System.out.println(c);*/
            du.commit(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
    }



    /**
     * 封装查询用户记录总条数的方法
     * @return 返回用户总记录条数
     */
    public int findTotalCount(){
        int count = 0;
        DbUtil du = new DbUtil();
        String sql = "select count(*) from t_user_info ";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {
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



    /**
     * 封装查询用户记录总条数的方法-----模糊查询
     * @return 返回用户总记录条数
     */

    @Override
    public int findTotalCount(String name , int id){
        int count = 0;
        DbUtil du = new DbUtil();
        String sql1 = "select count(*) from t_user_info";
        String sql2 = "select count(*) from t_user_info where name like ? and department_id = ?";
        conn = du.getConn();
        String sql = sql1;

        try {
            if(name != null && !"".equals(name)){
                sql = sql2;
                ps = du.getPs(conn, sql);
                name = "%"+name+"%";
                ps.setString(1,name);
                ps.setInt(2,id);
            }else{
                ps = du.getPs(conn, sql);
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



    /**
     *  分页查询用户信息
     * @param start
     * @param rows
     * @return
     */
    @Override
    public List<UserShow> findByPage(int start, int rows , String name ,int department_id) {

        List<UserShow> list = new ArrayList<UserShow>();
        String sql1 ="select * from ((select  tu.ID, tu.ACCOUNT, tu.NAME, tu.DEPARTMENT_ID,td.DEPARTMENT_NAME, tu.SEX, tu.BIRTHDAY, tu.MOBILE, tu.EMAIL," +
                "   tu.USER_TYPE, tu.CREATE_TIME , ROWNUM as r from T_USER_INFO tu,T_DEPARTMENT td where tu.DEPARTMENT_ID = td.DEPARTMENT_ID order by tu.ID )) where r between ? and ?";

        String sql2 = " select * from (select * from (select tu.ID, tu.ACCOUNT, tu.NAME, tu.DEPARTMENT_ID, td.DEPARTMENT_NAME, tu.SEX," +
                "       tu.BIRTHDAY, tu.MOBILE, tu.EMAIL, tu.USER_TYPE, tu.CREATE_TIME, rownum as r from T_USER_INFO tu, T_DEPARTMENT td " +
                "where tu.DEPARTMENT_ID = td.DEPARTMENT_ID and tu.name like ? and tu.DEPARTMENT_ID = ? order by tu.ID ) temp) where r between ? and ? ";

        String sql = sql1;
        if(name!=null && !"".equals(name)){   //如果有查询条件有值 则执行sql语句2
            sql = sql2;
        }

        conn = du.getConn();
        ps = du.getPs(conn,sql);
        try {
            if(name!=null && !"".equals(name)){   //如果查询条件有值 则对后两个参数赋值
                name = "%"+name+"%";
                ps.setString(1,name);
                ps.setInt(2,department_id);
                ps.setInt(3,start);
                ps.setInt(4,start+rows-1);
            }else{
                ps.setInt(1,start);
                ps.setInt(2,start+rows-1);
            }

            rs = ps.executeQuery();

            while (rs.next()){
                UserShow us = new UserShow();
                us.setId(rs.getInt(1));
                us.setAccount(rs.getString(2));
                us.setName(rs.getString(3));
                us.setDeparment_id(rs.getInt(4));
                us.setDepartment_name(rs.getString(5));
                us.setSex(rs.getString(6));
                us.setBirthday(rs.getString(7));
                us.setMobile(rs.getString(8));
                us.setEmail(rs.getString(9));
                us.setUser_type(rs.getString(10));
                us.setCreate_time(rs.getString(11));

                list.add(us);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }


    /**
     * 根据登录的用户名 密码获取id
     * @param u
     * @return
     */
    @Override
    public int searchId(Users u) {
        String sql = "select id from t_user_info where name = ? and password = ? ";
        conn = du.getConn();
        ps = du.getPs(conn,sql);
        int myId = 0;
        try {
            ps.setString(1,u.getName());
            ps.setString(2,u.getPassword());
            rs = ps.executeQuery();
            if(rs.next()){
                myId = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            du.closeAll(rs,ps,conn);
        }
        return myId;
    }
}