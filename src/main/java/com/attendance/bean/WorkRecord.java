package com.attendance.bean;


/**
 * @author Ren
 *
 * 工作记录
 */

public class WorkRecord {

    /**
     * record_id  number(9) primary key,
     * account    varchar2(255) not null,
     * work_date  varchar2(10)  not null,
     * start_time varchar2(8)   not null,
     * end_time   varchar2(8)   not null,
     * work_time  varchar2(8)   not null,
     * work_cause varchar2(255),
     * beikao     varchar2(255) default '0'
     */

    private int record_id;
    private String account;
    private String work_date;
    private String start_time;
    private String end_time;
    private String work_time;
    private String work_cause;
    private String beikao;

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getWork_date() {
        return work_date;
    }

    public void setWork_date(String work_date) {
        this.work_date = work_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getWork_cause() {
        return work_cause;
    }

    public void setWork_cause(String work_cause) {
        this.work_cause = work_cause;
    }

    public String getBeikao() {
        return beikao;
    }

    public void setBeikao(String beikao) {
        this.beikao = beikao;
    }
}