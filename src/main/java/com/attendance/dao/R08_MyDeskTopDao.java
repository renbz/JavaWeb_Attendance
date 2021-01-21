package com.attendance.dao;

import com.attendance.bean.MyDeskTop;

import java.util.List;

/**
 * @author Ren
 */

public interface R08_MyDeskTopDao {

    List<MyDeskTop> findMywork(int id);

    void delWorkInfo(int id);
}
