package com.attendance.dao;

import com.attendance.bean.Users;

/**
 * @author Ren
 */

public interface R07_MyInfoUpdaterDao {


    /**
     * 根据id 获取用户信息
     */
    Users echoMyInfo(int myId);


    /**
     * 修改个人信息
     * @param users
     */
    void updateMyInfo(Users users);



}
