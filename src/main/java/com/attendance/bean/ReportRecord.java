package com.attendance.bean;

/**
 * @author Ren
 *
 *日志记录实体
 */

public class ReportRecord {


    /*
    report_id     number(9) primary key ,
    account       varchar2(255) not null,
    report_date   varchar2(10)  not null,
    work_process  varchar2(255) not null,
    work_content  varchar2(255) not null,
    tomorrow_plan varchar2(255) not null,
    problem       varchar2(255),
    other         varchar2(255)
     */

    private int report_id;
    private String account;
    private String report_date;
    private String work_process;
    private String work_content;
    private String tomorrow_plan;
    private String problem;
    private String other;

    public int getReport_id() {
        return report_id;
    }

    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getReport_date() {
        return report_date;
    }

    public void setReport_date(String report_date) {
        this.report_date = report_date;
    }

    public String getWork_process() {
        return work_process;
    }

    public void setWork_process(String work_process) {
        this.work_process = work_process;
    }

    public String getWork_content() {
        return work_content;
    }

    public void setWork_content(String work_content) {
        this.work_content = work_content;
    }

    public String getTomorrow_plan() {
        return tomorrow_plan;
    }

    public void setTomorrow_plan(String tomorrow_plan) {
        this.tomorrow_plan = tomorrow_plan;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
