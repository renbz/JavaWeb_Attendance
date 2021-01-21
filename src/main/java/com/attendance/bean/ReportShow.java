package com.attendance.bean;

/**
 * @author Ren
 */

public class ReportShow {

    private int report_id;
    private String account;
    private String name;
    private String report_date;
    private String work_process;
    private String work_content;
    private String problem;
    private String other;
    private String tomorrow;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getOther() {
        return other;
    }

    public String getTomorrow() {
        return tomorrow;
    }

    public void setTomorrow(String tomorrow) {
        this.tomorrow = tomorrow;
    }

    @Override
    public String toString() {
        return "ReportShow{" +
                "report_id=" + report_id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", report_date='" + report_date + '\'' +
                ", work_process='" + work_process + '\'' +
                ", work_content='" + work_content + '\'' +
                ", problem='" + problem + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
