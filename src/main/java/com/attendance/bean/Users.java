package com.attendance.bean;

/**
 * @author Ren
 * 用户表
 */

public class Users {

    private int id;

    private String account;

    private String password;

    private String name;

    private String department_id;

    private String sex;

    private String birthday;

    private String mobile;

    private String email;

    private String User_type;

    private String mylevel;

    private String create_time;

    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_type() {
        return User_type;
    }

    public void setUser_type(String user_type) {
        User_type = user_type;
    }

    public String getMylevel() {
        return mylevel;
    }

    public void setMylevel(String mylevel) {
        this.mylevel = mylevel;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", department_id='" + department_id + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", User_type='" + User_type + '\'' +
                ", mylevel='" + mylevel + '\'' +
                ", create_time=" + create_time +
                ", state='" + state + '\'' +
                '}';
    }
}
