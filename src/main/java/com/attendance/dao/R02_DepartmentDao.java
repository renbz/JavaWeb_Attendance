package com.attendance.dao;

import com.attendance.bean.Department;

import java.util.List;

/**
 * @author Ren
 */

public interface R02_DepartmentDao {

    /**
     * 封装查询用户记录总条数的方法
     * @return 返回用户总记录条数
     */
    int findTotalCount(String name);


    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @return
     */
    List<Department> findByPage(int start, int rows, String deptname);


    /**
     * 添加部门信息的方法
     * @param dept
     */
    void deptAdd(Department dept);


    /**
     *根据部门查询人数
     */
    int findUserCountByDeptId(int deptId);


    /**
     * 根据部门id删除部门
     * @param deptId
     */
    void deleteDeptById(int deptId);


    /**
     * 根据部门id查询数据库
     */
    Department findDeptById(int deptId);


    /**
     * 添加部门
     * @param dept
     */
    void insertDepartment(Department dept);

}
