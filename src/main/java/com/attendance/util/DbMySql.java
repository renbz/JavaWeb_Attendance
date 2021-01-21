package com.attendance.util;

import java.sql.*;

/**
 * @author Ren
 */
public class DbMySql {
	/**
	 * 封装连接数据库的基本操作
	 */

	/*
	 * 定义属性
	 */

	Connection conn = null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//声明参数信息：字符串常量
	static String driverName="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jspitem";
	String user="root";
	String password="ren372930";

	/*
	 * 定义方法
	 */
	//加载驱动
	static{
		try {
			Class.forName(driverName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//获取jdbc的连接对象
	public Connection getConn(){
		try {
			conn=DriverManager.getConnection(url, user, password);
			if(conn!=null){
				//设置自动提交为否
				conn.setAutoCommit(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//获取sql状态对象
	public PreparedStatement getPs(Connection conn,String sql){
		try {
			ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	//关闭流对象
	public void closeAll(ResultSet rs,PreparedStatement ps,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//封装手动提交操作
	public void commit(Connection conn){
		try {
			if(conn!=null){
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//封装回退操作
	public void rollback(Connection conn){
		try {
			if(conn!=null){
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
