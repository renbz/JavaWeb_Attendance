package com.attendance.bean;

/**
 * @author Ren
 */

public class Account {

    /*
     Id      number(9) primary key,
    Account varchar2(20) not null
     */

    private int id;
    private String account;

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
}
