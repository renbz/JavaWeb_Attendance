package com.attendance.Service;

import com.attendance.bean.PageBean;
import com.attendance.bean.UserShow;

/**
 * @author Ren
 */

public interface R01_UsersInfoService {

    PageBean<UserShow> findUserByPage(String currentPage_, String rows_);

}
