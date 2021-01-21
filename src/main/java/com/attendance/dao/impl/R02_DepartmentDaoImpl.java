package com.attendance.dao.impl;

import com.attendance.bean.Department;
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

public class R02_DepartmentDaoImpl implements com.attendance.dao.R02_DepartmentDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DbUtil du = new DbUtil();

    /**
     * 封装查询部门记录总条数的方法
     *
     * @return 返回部门总记录条数
     */

    @Override
    public int findTotalCount(String name ) {
        int count = 0;
        String sql = "select count(*) from t_department ";
        if(name != null){
            sql = "select count(*) from t_department where department_name like ? ";
        }
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {
            if(name!= null){
                String name1 = "%"+name+"%";
                ps.setString(1, name1);
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
     * 分页查询部门信息
     *
     * @param start
     * @param rows
     * @return
     */
    @Override
    public List<Department> findByPage(int start, int rows, String name) {

        List<Department> list = new ArrayList<Department>();
        String sql1 = "select * from (select td.DEPARTMENT_ID,td.CREATE_TIME,td.TOTAL_USER,td.DEPARTMENT_NAME,td.MANAGER,ROWNUM as r  from T_DEPARTMENT td  order by DEPARTMENT_ID) where r between ? and ?";
        String sql2 = "select * from (select td.DEPARTMENT_ID,td.MANAGER,td.DEPARTMENT_NAME,td.TOTAL_USER,td.CREATE_TIME ,ROWNUM as r  from T_DEPARTMENT td   where DEPARTMENT_NAME like ?) where r between ? and ?";

        String sql = sql1;
        if (name != null && !"".equals(name)) {   //如果有查询条件有值 则执行sql语句2
            sql = sql2;
        }

        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {

            if (name != null && !"".equals(name)) {   //如果查询条件有值 则对后两个参数赋值
                String  name1 = "%" + name + "%";
                System.out.println(name1);
                ps.setString(1, name1);
                ps.setInt(2, start );
                ps.setInt(3, start + rows - 1 );
            } else {
                ps.setInt(1, start );
                ps.setInt(2, start + rows - 1 );
            }

            rs = ps.executeQuery();
            //System.out.println("------------------------");
            while (rs.next()) {
                Department ds = new Department();
                ds.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
                ds.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
                ds.setManager(rs.getString("manager"));
                ds.setTotal_user(rs.getInt("TOTAL_USER"));
                ds.setCreate_time(rs.getString("CREATE_TIME"));

                list.add(ds);
                //System.out.println(ds.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
        return list;

    }


    /**
     *根据部门查询人数
     */
    @Override
    public int findUserCountByDeptId(int deptId) {
        String sql = "select count(*) from t_user_info where department_id = ? ";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        int count = 0;
        try {
            ps.setInt(1, deptId);
            rs = ps.executeQuery();
            if (rs.next()) {
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
     * 向部门表中插入数据库
     *
     * @param dept 封装了部门信息的对象
     */
    @Override
    public void deptAdd(Department dept) {

        String sql = "insert into t_department values (?,?,?,?,?)";
        conn = du.getConn();
        ps = du.getPs(conn, sql);
        try {
            ps.setInt(1, dept.getDepartment_id());
            ps.setString(2, dept.getDepartment_name());
            ps.setString(3, dept.getManager());
            ps.setInt(4, dept.getTotal_user());
            ps.setString(5, dept.getCreate_time());
            int i = ps.executeUpdate();
            System.out.println("执行了添加用户语句");
            System.out.println(dept);
            du.commit(conn);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
    }


    /**
     * 根据部门的id删除部门
     * @param deptId
     */
    @Override
    public void deleteDeptById(int deptId) {

        String sql = "delete from t_department where department_id = ?";
        conn = du.getConn();
        ps = du.getPs(conn,sql);
        try {
            ps.setInt(1,deptId);
            ps.executeUpdate();
            du.commit(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
    }




    /**
     * 根据部门id查询数据库
     */
    @Override
    public Department findDeptById(int deptId){

        Department dept = new Department();

        String sql = "select * from t_department where department_id = ?";
        conn = du.getConn();
        ps = du.getPs(conn,sql);
        try {
            ps.setInt(1,deptId);
            rs = ps.executeQuery();

            if(rs.next()){
                dept.setDepartment_id(rs.getInt(1));
                dept.setDepartment_name(rs.getString(2));
                dept.setManager(rs.getString(3));
                dept.setTotal_user(rs.getInt(4));
                dept.setCreate_time(rs.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
        return dept;
    }


    /**
     * 根据部门id修改部门信息
     * @param dept
     */
    @Override
    public void insertDepartment(Department dept) {

        String sql = "update t_department set department_name = ? and manager= ? where department_id = ?";
        conn = du.getConn();
        ps = du.getPs(conn,sql);
        try{
            ps.setString(1,dept.getDepartment_name());
            ps.setString(2,dept.getManager());
            ps.setInt(3,dept.getDepartment_id());
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            du.closeAll(rs, ps, conn);
        }
    }
}
