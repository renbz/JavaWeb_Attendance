package com.attendance.util;

/**
 * @author Ren
 */

public class InsertDate {
    public static void main(String[] args) {

        String ch = "abcdefghijklmnopqrstuvwxyz";
        String s1 = "insert into t_user_info values (NULL , '";  //z1 工号
        String s2 = "' , '";                                     //z2 密码
        String s3 = "' , '";                                     //z3 用户名
        String s4 = "' , '";                                     //z4 部门编号
        String s5 = "' ,'";                                      //z5 性别 1 或 2
        String s6 = "' , '2005-11-17' , '";                      //z6 手机号
        String s7 = "' , '";                                     //z7 邮箱
        String s8 = "@qq.com' , '";                              //z8 用户类型  0-2
        String s9 = "' , '";                                     //z9 权限 0-2
        String s10 = "' , '2020-12-03' , '";                     //z10 是否在线 0 或 1

        String s11 = "' ) ; ";
        for(int i=0;i<100;i++){
            int z1 = 201801008+i;
            String z2 = ((int) (10000 * (Math.random()))+"0000").substring(0,4);
            String z3 =ch.charAt((int)(26*Math.random()))+""+ch.charAt((int)(26*Math.random()))+
                    ch.charAt((int)(26*Math.random()))+ch.charAt((int)(26*Math.random()))+ch.charAt((int)(26*Math.random()));
            int z4 = 10001+(int)(5*(Math.random()));
            int z5 = ((int)(99*(Math.random())))%2==0? 1:2;
            String z6 = "177777"+((int)(1000000*(Math.random()))+"000000").substring(0,5);
            String z7 = ((int)(100*((Math.random())))+"00").substring(0,2)+((int)(10000000*((Math.random())))+"00000000").substring(0,8);
            int z8 = ((int)(99*(Math.random())))%2==0? 1:2;
            int z9 = ((int)(99*(Math.random())))%2==0? 1:2;
            int z10 = ((int)(99*(Math.random())))%2==0? 0:1;
            String s = s1+z1+s2+z2+s3+z3+s4+z4+s5+z5+s6+z6+s7+z7+s8+z8+s9+z9+s10+z10+s11;
            System.out.println(s);
        }
    }
}