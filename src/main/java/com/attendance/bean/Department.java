package com.attendance.bean;

/**
 * @author Ren
 *
 * 部门
 */

public class Department {

    private int department_id;       //部门id
    private String department_name;  //部门名称
    private String manager;          //部门负责人
    private int total_user;          //管理人数
    private String create_time;      //创建时间

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getTotal_user() {
        return total_user;
    }

    public void setTotal_user(int total_user) {
        this.total_user = total_user;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                ", manager='" + manager + '\'' +
                ", total_user=" + total_user +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
