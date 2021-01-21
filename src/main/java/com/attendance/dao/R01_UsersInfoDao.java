package com.attendance.dao;

import com.attendance.bean.UserShow;
import com.attendance.bean.Users;

import java.util.List;

/**
 * @author Ren
 */

public interface R01_UsersInfoDao {




    /**
     * R01_UserLoginServlet
     * 封装登录验证
     * @param u  封装了用户信息(账号和密码)的users对象
     * @return 返回查询结果 boolean类型，查询到结果返回true  登录成功
     */
    boolean loginCheck(Users u);





    /**
     * 封装添加用户信息的方法
     * @param u 封装用户信息
     * @return 返回更新数据库的行数
     */
    Integer userInfoAdd(Users u);







    /**
     * 封装查询用户信息的方法
     * @return  返回存储用户信息的集合
     */
    List userInfoSearchAll();






    /**
     * 封装删除用户的功能
     * @param id  要删除用户的id
     */
    void deleteUser(int id);




    /**
     * 封装查询用户信息并回显到修改页面的功能
     * @param id  要修改的用户id ， 根据id从数据库中查询数据，回显到前端页面
     * @return   返回Users类的对象
     */
    Users queryEchoData(int id);




    /**
     * 封装修改用户信息的方法
     * @param u  将修改后的信息封装到users对象中，传参至此页面，进行数据库信息的修改
     */
    void userInfoUpdate(Users u);





    /**
     * 封装查询用户记录总条数的方法
     * @return 返回用户总记录条数
     */
    int findTotalCount(String name, int department_id);




    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @return
     */
    List<UserShow> findByPage(int start, int rows, String name, int department_id);




    /**
     * 根据用户命名 密码 获取用户id
     * @param u
     * @return
     */
    int searchId(Users u);








}
