package com.attendance.bean;

/**
 * @author Ren
 */

public class UserShow {

    private int id;

    private String account;

    private String name;

    private int deparment_id;

    private String department_name;  //部门名称

    private String sex;

    private String birthday;

    private String mobile;

    private String email;

    private String user_type;//用户类型

    private String mylevel;

    private String create_time;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeparment_id() {
        return deparment_id;
    }

    public void setDeparment_id(int deparment_id) {
        this.deparment_id = deparment_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
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
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
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

    @Override
    public String toString() {
        return "UserShow{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", deparment_id=" + deparment_id +
                ", department_name='" + department_name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", user_type='" + user_type + '\'' +
                ", mylevel='" + mylevel + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }

    public UserShow() {
    }

}
