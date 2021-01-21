package com.attendance.bean;

/**
 * @author Ren
 * <p>
 * 休假记录
 */

public class RestRecordShow {

    /*
    rest_id         number(9) primary key,
    account         varchar2(255) not null,
    rest_start_date varchar2(10)  not null,
    start_time      varchar2(8)   not null,
    rest_end_date   varchar2(10)  not null,
    end_time        varchar2(8)   not null,
    rest_time       varchar2(8)   not null,
    rest_cause      varchar2(255) not null,
    beikao          varchar2(255),
    state           char(1) default '0'
     */


    private int rest_id;
    private String account;
    private String name;
    private String rest_start_date;
    private String start_time;
    private String rest_end_date;
    private String end_time;
    private String rest_cause;
    private String rest_time;
    private String beikao;
    private String state;

    public String getRest_time() {
        return rest_time;
    }

    public void setRest_time(String rest_time) {
        this.rest_time = rest_time;
    }

    public int getRest_id() {
        return rest_id;
    }

    public void setRest_id(int rest_id) {
        this.rest_id = rest_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRest_start_date() {
        return rest_start_date;
    }

    public void setRest_start_date(String rest_start_date) {
        this.rest_start_date = rest_start_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getRest_end_date() {
        return rest_end_date;
    }

    public void setRest_end_date(String rest_end_date) {
        this.rest_end_date = rest_end_date;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getRest_cause() {
        return rest_cause;
    }

    public void setRest_cause(String rest_cause) {
        this.rest_cause = rest_cause;
    }

    public String getBeikao() {
        return beikao;
    }

    public void setBeikao(String beikao) {
        this.beikao = beikao;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RestRecordShow{" +
                "rest_id=" + rest_id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", rest_start_date='" + rest_start_date + '\'' +
                ", start_time='" + start_time + '\'' +
                ", rest_end_date='" + rest_end_date + '\'' +
                ", end_time='" + end_time + '\'' +
                ", rest_cause='" + rest_cause + '\'' +
                ", rest_time='" + rest_time + '\'' +
                ", beikao='" + beikao + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
