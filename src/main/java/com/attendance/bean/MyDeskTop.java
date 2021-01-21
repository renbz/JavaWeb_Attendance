package com.attendance.bean;

/**
 * @author Ren
 */

public class MyDeskTop {

    private int id;
    private String applyDate;
    private String state;
    private String handleDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(String handleDate) {
        this.handleDate = handleDate;
    }

    @Override
    public String toString() {
        return "MyDeskTop{" +
                "applyDate='" + applyDate + '\'' +
                ", state='" + state + '\'' +
                ", handleDate='" + handleDate + '\'' +
                '}';
    }
}
