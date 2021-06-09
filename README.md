# JavaWeb_Attendance

1.	软件开发流程(可说明软件的开发流程包括几个阶段，每个阶段做什么任务，出什么文档)z
1）	分析理解前端页面，将前端的html页面改成Jsp页面，JSP页面加入page标签
2）	将JSP页面中的静态数据 修改为从数据库查询到的动态数据，通过JSTL的ForEach进行循环遍历数据，并通过EL表达式取出数据。
3）	修改JSP代码中的分页查询部分代码,  并将（总记录条数，总页码数，每页要显示的数据List<T>  当前页码，每页显示的记录条数(默认为5) 封装到PageBean类中）
4）	通过JSP中的<a>标签的href属性 或 form的action属性 或 js代码的自定义提交方法进行跳转到Servlet层
5）	Servlet层调用Dao层的操作数据库的方法，包括: 数据库的增删改查。添加、删除、查询、多表查询、模糊搜索。
6）	面向接口编程，先写dao接口 再写dao的实现类。
7）	操作完数据库，如果是查询数据 将结果集返回到servlet页面，通过setAttribute(key,value)将数据存入request作用域，跳转回JSP页面，再通过JSP页面的EL表达式获取存入的数据。
8）	如果是修改数据，修改完成后直接跳转页面就可

2.	项目整体功能概要（大体说明整个项目的功能）
所有功能全部实现
-	登录、注册(用户添加)
-	登录后的首页，显示的是本地时间
-	用户管理
 *  分页查询用户信息
 *  修改用户用户信息(数据回显,修改)
 *  删除用户信息
 *  添加用户信息
 *  模糊搜索用户信息
 *  批量删除用户信息
-  部门管理
 *  分页查询部门信息
 *  修改部门信息(数据回显,修改)
 *  删除部门信息(部门下人数为0才可删除，不为0就不能是删除)
 *  添加部门信息
 *  模糊搜索部门信息
 *  批量删除部门信息
- 日报管理
 *  分页查询日报信息
 *  修改日报信息(数据回显,修改)
 *  删除日报信息
 *  添加日报信息
 *  模糊搜索日报信息
 *  批量删除日报信息
- 加班管理
 *  加班申请分页查询
 *  修改加班申请(数据回显,修改)
 *  删除加班申请
 *  添加
 *  模糊搜索
 *  批量删除加班信息
- 休假管理
 *  休假申请分页查询
 *  修改休假申请(数据回显,修改)
 *  删除加休假申请
 *  添加休假申请
 *  模糊搜索休假信息
 *  批量删除休假信息
- 审批管理(审批加班申请 和 审批休假申请)
 *  待处理的加班申请 的 分页查询
 *  通过加班申请
 *  驳回加班申请
 *  待处理的休假申请 的 分页查询
 *  通过休假申请
 *  驳回休假申请
 *  模糊搜索 待处理的 加班申请和休假申请
- 个人信息修改
*  根据登录的id查询数据库进行 数据的回显，保存后完成信息修改  
- 我的桌面
*  当审批信息后，该页面就会显示通过还是驳回的信息及审批时间

4.	个人承担的开发任务说明（标明个人模块的完成情况，所开发的每个模块功能详细说明及界面）

-	登录、注册(用户添加)
从输入框输入数据，在servlet层通过request.getParameter()获取form表单提交的参数，将获得的用户名、密码作为参数调用dao层的方法进行查询数据库，select * from t_user_info where username=? andpassword =?  如果数据库查询结果集不为空，则说明数据库中有该用户名和密码，可以登录成功。登录成功返回main.jsp页面，登录失败则提示账号或密码错误的信息。
 

public int searchId(Users u) {
    String sql = "select id from t_user_info where name = ? and password = ? ";
    conn = du.getConn();
    ps = du.getPs(conn,sql);
    int myId = 0;
    try {
        ps.setString(1,u.getName());
        ps.setString(2,u.getPassword());
        rs = ps.executeQuery();
        if(rs.next()){
            myId = rs.getInt(1);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        du.closeAll(rs,ps,conn);
    }
    return myId;
}



-	登录后的首页，显示的是本地时间
该显示页面只需修改JSP页面中的数据显示即可，使用
<%= new SimpleDateFormat("YYYY-MM-dd HH:mm").format(new Date()) %>
 

-	用户管理

分页查询

在前台的JSP页面中，将固定的分页代码改为动态的代码，如果页数过多 则显示前5条和后4条中间用省略号代替。 点击用户管理后 进入后台servlet调用dao的层的数据库，将分页查询到的user存入list集合中，将其存入pageBean的list集合中。连同查出总记录条数返回到servlet层 , 存入request域中，并在前端页面通过EL表达式取出。

-	int totalCount   -->   总记录条数
-	int totalPage    -->   总页码数 = totalCount % 每页显示的数目 == 0 ? totalCount / 每页显示的数目 : totalCount / 每页显示的数目 +1
-	List list        -->   每页的数据   list集合
      前台传至后台的数据:
-	int currentPage  -->   当前页码
-	int rows         -->   每页显示的数据条数

-	将5条信息其封装成一个类，取名为pageBean
-	totalCount = select count(*) from users;
-	totalPage = 提供每页显示的数据条数； rows
-	list  = select * from user limit ? , ?   -->  第一个? 开始查询的索引，第二个 ? rows每页显示的条数
-	currentPage = 提供当前页码给服务器
-	开始查询的索引 = ( currentPage - 1 ）* rows
-	步骤: 接收请求参数currentPage,rows
-	//创建空的pageBean 对象
-	//设置currentPage   属性和rows属性
-	//调用dao完成查询 totalCount 总记录数  dao.findTotalCount()
-	// start索引: (currentPage-1)*rows
-	//调用dao去查询list集合  dao.findByPage(int start, int rows)
-	//计算总页码: 返回pageBean对象
-	
-	userDao层
-	// 查询总记录数
-	int findTotalCount(){}
-	//分页查询list
-	List findByPage(int start,int rows)



 
 
 
List<UserShow> list = new ArrayList<UserShow>();
String sql1 ="select * from ((select  tu.ID, tu.ACCOUNT, tu.NAME, tu.DEPARTMENT_ID,td.DEPARTMENT_NAME, tu.SEX, tu.BIRTHDAY, tu.MOBILE, tu.EMAIL,  tu.USER_TYPE, tu.CREATE_TIME , ROWNUM as r from T_USER_INFO tu,T_DEPARTMENT td where tu.DEPARTMENT_ID = td.DEPARTMENT_ID order by tu.ID )) where r between ? and ?";

String sql2 = " select * from (select * from (select tu.ID, tu.ACCOUNT, tu.NAME, tu.DEPARTMENT_ID, td.DEPARTMENT_NAME, tu.SEX,  tu.BIRTHDAY, tu.MOBILE, tu.EMAIL, tu.USER_TYPE, tu.CREATE_TIME, rownum as r from T_USER_INFO tu, T_DEPARTMENT td   where tu.DEPARTMENT_ID = td.DEPARTMENT_ID and tu.name like ? and tu.DEPARTMENT_ID = ? order by tu.ID ) temp) where r between ? and ? ";

String sql = sql1;
if(name!=null && !"".equals(name)){   //如果有查询条件有值 则执行sql语句2
    sql = sql2;
}

conn = du.getConn();
ps = du.getPs(conn,sql);
try {
    if(name!=null && !"".equals(name)){ //如果查询条件有值 则对后两个参数赋值
        name = "%"+name+"%";
        ps.setString(1,name);
        ps.setInt(2,department_id);
        ps.setInt(3,start);
        ps.setInt(4,start+rows-1);
    }else{
        ps.setInt(1,start);
        ps.setInt(2,start+rows-1);
    }

    rs = ps.executeQuery();

    while (rs.next()){
        UserShow us = new UserShow();
        us.setId(rs.getInt(1));
        us.setAccount(rs.getString(2));
        us.setName(rs.getString(3));
        us.setDeparment_id(rs.getInt(4));
        us.setDepartment_name(rs.getString(5));
        us.setSex(rs.getString(6));
        us.setBirthday(rs.getString(7));
        us.setMobile(rs.getString(8));
        us.setEmail(rs.getString(9));
        us.setUser_type(rs.getString(10));
        us.setCreate_time(rs.getString(11));

        list.add(us);

    }
} catch (SQLException e) {
    e.printStackTrace();
}



用户信息修改
要修改用户信息首先要进行数据回显，只有显示了要修改用户的信息才能进行修改。 
数据回显：点击修改按钮后 通过路径+?id=${user.id} 将id值传入servlet中，在servlet中通过request.getParameter()获取id值，并将id作为调用dao层查询用户信息方法的参数。查询到数据后 取出结果集的信息 存放如user对象中，将User对象返回到servlet层并存入request域中，在前端获取信息后展示出来。 
信息修改：当修改信息后，信息提交到servlet页面，在servlet中通过request.getParameter()方法获取，存入user对象中，将user对象作为参数传至dao层修改数据。servlet通过response.sendRedirectDispatch（）跳转到数据显示的servlet进而显示数据

String sql = "insert into t_user_info(account,password,name,department_id,sex,birthday,mobile,email)  values(?,?,?,?,?,?,?,?)";
conn = du.getConn();
ps = du.getPs(conn,sql);
int c = 0;
try {
    ps.setString(1,u.getAccount());
    ps.setString(2,u.getPassword());
    ps.setString(3,u.getName());
    ps.setString(4,u.getDepartment_id());
    ps.setString(5,u.getSex());
    ps.setString(6,u.getBirthday());
    ps.setString(7,u.getMobile());
    ps.setString(8,u.getEmail());

    c = ps.executeUpdate();
    System.out.println(u);
} catch (SQLException e) {
    e.printStackTrace();
}finally {
    du.closeAll(rs,ps,conn);
}

 
 
删除用户信息
点击删除按钮后，通过路径+?id=${user.id} 将id值传入servlet中，在servlet中通过request.getParameter()获取id值，并将id作为调用dao层查询删除用户的参数。通过id删除用户，servlet通过response.sendRedirectDispatch（）跳转到数据显示的servlet进而显示数据。
 
public void deleteUser(int id){

    int i = 0;
    String sql = "delete from T_USER_INFO where id = ?";
    conn = du.getConn();
    ps = du.getPs(conn,sql);
    try {
        ps.setInt(1,id);
        i = ps.executeUpdate();
        du.commit(conn);
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        du.closeAll(rs,ps,conn);
    }
}
添加用户信息
添加用户信息，点击添加按钮直接跳转到添加用户信息的JSP页面，在输入框中填写完要添加的信息后，信息提交到servlet页面，在servlet中通过request.getParameter()方法获取，存入user对象中，将user对象作为参数传至dao层进行添加数据。servlet通过response.sendRedirectDispatch() 跳转到数据显示的servlet进而显示数据。


 

     

public Integer userInfoAdd(Users u) {
    String sql = "insert into t_user_info(account,password,name,department_id,sex,birthday,mobile,email)  values(?,?,?,?,?,?,?,?)";
    conn = du.getConn();
    ps = du.getPs(conn,sql);
    int c = 0;
    try {
        ps.setString(1,u.getAccount());
        ps.setString(2,u.getPassword());
        ps.setString(3,u.getName());
        ps.setString(4,u.getDepartment_id());
        ps.setString(5,u.getSex());
        ps.setString(6,u.getBirthday());
        ps.setString(7,u.getMobile());
        ps.setString(8,u.getEmail());

        c = ps.executeUpdate();
        System.out.println(u);
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        du.closeAll(rs,ps,conn);
    }
    return c;
}


批量删除
通过前端页面的checkbox进行选择，并在script中设置提交表单的方法，在servlet层通过request.getParameterValues()进行获取存放要删除用户的id数组，循环遍历数组调用删除单个用户的方法。servlet通过response.sendRedirectDispatch（）跳转到数据显示的servlet进而显示数据。
 
 
模糊搜索功能
根据输入的内容，在servlet中获取参数，传至dao层操作数据库进行模糊搜索。
String sql2 = " select * from (select * from (select tu.ID, tu.ACCOUNT, tu.NAME, tu.DEPARTMENT_ID, td.DEPARTMENT_NAME, tu.SEX,  tu.BIRTHDAY, tu.MOBILE, tu.EMAIL, tu.USER_TYPE, tu.CREATE_TIME, rownum as r from T_USER_INFO tu, T_DEPARTMENT td   where tu.DEPARTMENT_ID = td.DEPARTMENT_ID and tu.name like ? and tu.DEPARTMENT_ID = ? order by tu.ID ) temp) where r between ? and ? ";

if(name!=null && !"".equals(name)){  //如果查询条件有值    
    name = "%"+name+"%";
    ps.setString(1,name);
    ps.setInt(2,department_id);
    ps.setInt(3,start);
    ps.setInt(4,start+rows-1);
}



 

-	部门管理
部门管理功能的实现与上述功能的实现同理 


 
-	日报管理
-	日报管理功能的实现与上述功能的实现同理
 


-	加班管理
-	日报管理功能的实现与上述功能的实现同理
 


-	休假管理
-	日报管理功能的实现与上述功能的实现同理 
 

-	审批管理
-	        加班审批
-	加班审批比上述功能增加了一个操作的功能，点击对号或错号后，会通过servlet层调用dao层操作数据库的方法，修改数据库的表的state列，当state=0时显示为需要操作的状态，当点击对号级审批通过，将数据库的state改为1，当点击错号级审批通过，将数据库的state改为2，并在加班管理中显示审批通过或审批被驳回。并在我的桌面上显示操作信息。
 
@Override
public void passWorkApply(int id) {
    String sql = "update t_work_record set state= '1' where record_id = ? ";
    conn = du.getConn();
    ps = du.getPs(conn, sql);
    try {
        ps.setInt(1,id);
        ps.executeUpdate();
        du.commit(conn);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        du.closeAll(rs, ps, conn);
    }

}

@Override
public void refuseWorkApply(int id) {
    String sql = "update t_work_record set state= '2' where record_id = ? ";
    conn = du.getConn();
    ps = du.getPs(conn, sql);
    try {
        ps.setInt(1,id);
        ps.executeUpdate();
        du.commit(conn);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        du.closeAll(rs, ps, conn);
    }
}



-	        休假审批
-	休假审批也比上述功能增加了一个操作的功能，点击对号或错号后，会通过servlet层调用dao层操作数据库的方法，修改数据库的表的state列，当state=0时显示为需要操作的状态，当点击对号级审批通过，将数据库的state改为1，当点击错号级审批通过，将数据库的state改为2，并在休假管理中显示审批通过或审批被驳回。并在我的桌面上显示操作信息。 
@Override
public void passRestApply(int id) {
    String sql = "update t_rest_record set state= '1' where rest_id = ? ";
    conn = du.getConn();
    ps = du.getPs(conn, sql);
    try {
        ps.setInt(1,id);
        ps.executeUpdate();
        du.commit(conn);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        du.closeAll(rs, ps, conn);
    }
}


@Override
public void refuseRestApply(int id) {
    String sql = "update t_rest_record set state= '2' where rest_id = ? ";
    conn = du.getConn();
    ps = du.getPs(conn, sql);
    try {
        ps.setInt(1,id);
        ps.executeUpdate();
        du.commit(conn);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        du.closeAll(rs, ps, conn);
    }
}




-	个人信息修改

要修改个人信息首先要进行数据回显，只有显示了要修改用户的信息才能进行修改。 
数据回显：点击修改个人信息按钮后，首先在登录完成后获取当前登录用户的id,并将其传入session作用域中， 通过路径+?id=${currentId} 将id值传入servlet中，在servlet中通过request.getParameter()获取id值，并将id作为调用dao层查询用户信息方法的参数。查询到数据后 取出结果集的信息 存放如user对象中，将User对象返回到servlet层并存入request域中，在前端获取信息后展示出来。 
信息修改：当修改信息后，信息提交到servlet页面，在servlet中通过request.getParameter()方法获取，存入user对象中，将user对象作为参数传至dao层修改数据。servlet通过response.sendRedirectDispatch（）跳转到数据显示的servlet进而显示数据


 

public Users echoMyInfo(int myId) {

    Users users = new Users();
    String sql = "select * from T_USER_INFO where id = ?";
    conn = du.getConn();
    ps = du.getPs(conn,sql);
    try {
        ps.setInt(1,myId);
        rs = ps.executeQuery();
        while (rs.next()){
            users.setId(rs.getInt("id"));
            users.setAccount(rs.getString("account"));
            users.setPassword(rs.getString("password"));
            users.setName(rs.getString("name"));
            users.setDepartment_id(rs.getString("department_id"));
            users.setSex(rs.getString("sex"));
            users.setMobile(rs.getString("mobile"));
            users.setBirthday(rs.getString("birthday"));
            users.setEmail(rs.getString("email"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        du.closeAll(rs,ps,conn);
    }
    return users;

}

/**
 * 修改个人信息
 * @param u
 */
@Override
public void updateMyInfo(Users u) {
    String sql = "update T_USER_INFO set account=? , password = ? , name=? , department_id=? , sex=? , birthday=? , mobile=? , email = ? where id=?";
    conn = du.getConn();
    ps = du.getPs(conn, sql);
    try {
        ps.setString(1, u.getAccount());
        ps.setString(2, u.getPassword());
        ps.setString(3, u.getName());
        ps.setString(4, u.getDepartment_id());
        ps.setString(5, u.getSex());
        ps.setString(6, u.getBirthday());
        ps.setString(7, u.getMobile());
        ps.setString(8, u.getEmail());
        ps.setInt(9, u.getId());  //这里需要获得当前用户的id
        int c = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        du.closeAll(rs, ps, conn);
    }
}


-	我的桌面

我的桌面功能的实现: 新加桌面显示审批信息的状态表，及当管理员审批用户的加班申请和休假申请时，就会调用数据库将该加班信息和休假信息存入 我的桌面数据库表中，并获取操作时的系统时间。 当点击我的桌面按钮时，就会从数据库中查询 显示在页面上。当触发了删除按钮，就会从数据库中删除。
 


5.	技术总结
5.1、说明对系统逻辑结构设计的理解（可参照软件公司员工考勤管理系统（ATT）-程序架构设计说明书.xls）。
     
    本项目使用了MVC三层架构, M：Model 模型，代表着业务逻辑代码与数据库代码，V：View 对数据的展示代码，比如JSP页面，就是专门用来展示数据，美化页面的 　C: Controller　　控制，Servlet来充当这一角色，连接着View和Model，从View中获得指令，在从model中通过业务逻辑代码获取需要的数据，然后在通过Servlet去交给View层去显示。也就是MVC三层结构的意义

 
5.2、个人所开发的模块涉及到的数据库表及对表中数据所进行的处理说明。

oracle不像mysql那样具有 auto_increment 主键自增的关键字，因此在oracle中要自己写 自增序列和触发器，例如用户表的自增序列。
---自增序列
CREATE SEQUENCE t_user_info_seq
    MINVALUE 1
    NOMAXVALUE
    INCREMENT BY 1
    START WITH 1 NOCACHE;

--创建触发器
create or replace trigger t_user_info_id_trigger
    before insert
    on t_user_info
    for each row
begin
    select t_user_info_seq.nextval into :new.id from dual;
end t_user_info_id_trigger;


使用ORACLE数据库，因为之前未学过ORACLE数据库，通过本次的项目是我对oracle数据库有了新的认识，尤其是在分页查询的语句上，因为mysql有limit关键字 可以直接实现分页查询。而对于oracle，则需要增加一列rownum，并将查询出的数据作为子表 通过between and 进行分页查询的语法书写。

数据库建表参考标准数据库文档创建，并新加桌面显示审批信息的状态表，及当管理员审批用户的加班申请和休假申请时，就会调用数据库将该加班信息和休假信息存入 我的桌面数据库表中，并获取操作时间。 当点击我的桌面按钮时，就会从数据库中查询 显示在页面上。当触发了删除按钮，就会从数据库中删除。



建表语法：
/*
1) 用户信息：员工号，密码，姓名，部门，性别，出生日期，手机号码，邮箱，用户类型，权限,是否在线
2) 加班记录：员工号，加班日期，开始时期，结束时间，加班时间，加班原因，备注，类型
3) 休假记录：员工号，休假开始日期，开始时间，休假结束日期，结束时间，休假时间，休假原因，备考，类型
4) 日报记录: 员工号,日报日期,作业进度,作业内容,明日作业计划,问题点,联络事项
5) 部门管理:部门名称,员工号，总人数，创建时间
6) 工号：工号
*/

/*---------------------------------用户信息表  T_USER_INFO --------------------------------------*/
/*创建用户信息表 T_USER_INFO 数据库*/
create table t_user_info
(
    id            number(9) primary key,
    account       varchar2(30)        not null,
    password      varchar2(255)       not null,
    name          varchar2(20)        not null,
    department_id varchar2(20)        not null,
    sex           char(1)             not null,
    birthday      varchar2(10),
    mobile        varchar2(11)        not null,
    email         varchar2(255),
    User_type     char(1) default '0' not null,
    mylevel       char(1) default '0' not null,
    create_time   varchar2(255),
    state         char(1) default '0' not null
);

---自增序列
CREATE SEQUENCE t_user_info_seq
    MINVALUE 1
    NOMAXVALUE
    INCREMENT BY 1
    START WITH 1 NOCACHE;

--创建触发器
create or replace trigger t_user_info_id_trigger
    before insert
    on t_user_info
    for each row
begin
    select t_user_info_seq.nextval into :new.id from dual;
end t_user_info_id_trigger;

/*查询数据表*/
select *
from t_user_info;

/*---------------------------------加班记录表  t_work_record --------------------------------------*/
/*创建加班记录表 t_work_record */
create table t_work_record
(
    record_id  number(9) primary key, /*自增主键*/
    account    varchar2(255) not null,
    work_date  varchar2(10)  not null,
    start_time varchar2(8)   not null,
    end_time   varchar2(8)   not null,
    work_time  varchar2(8)   not null,
    work_cause varchar2(255),
    beikao     varchar2(255),
    state      char default '0'
);
---自增序列
CREATE SEQUENCE t_work_record_seq
    MINVALUE 1
    NOMAXVALUE
    INCREMENT BY 1
    START WITH 1 NOCACHE;
--创建触发器
create or replace trigger t_work_record_seq_id_trigger
    before insert
    on t_work_record
    for each row
begin
    select t_work_record_seq.nextval into :new.record_id from dual;
end t_work_record_seq_id_trigger;


/* 向 T_WORK_RECORD 表中插入数据 */

/*查询数据表*/
select *
from T_WORK_RECORD;
/*---------------------------------休假记录表  t_rest_record --------------------------------------*/
/*创建休假记录表  t_rest_record */
create table t_rest_record
(
    rest_id         number(9) primary key,
    account         varchar2(255) not null,
    rest_start_date varchar2(10)  not null,
    start_time      varchar2(8)   not null,
    rest_end_date   varchar2(10)  not null,
    end_time        varchar2(8)   not null,
    rest_time       varchar2(8)   not null,
    rest_cause      varchar2(255) not null,
    beikao          varchar2(255),
    state           char(1) default '0'
);

---自增序列
CREATE SEQUENCE t_rest_record_seq
    MINVALUE 1
    NOMAXVALUE
    INCREMENT BY 1
    START WITH 1 NOCACHE;
--创建触发器
create or replace trigger t_rest_record_seq_id_trigger
    before insert
    on t_rest_record
    for each row
begin
    select t_rest_record_seq.nextval into :new.rest_id from dual;
end t_rest_record_seq_id_trigger;
/*查询数据表内容*/
select *
from t_rest_record;
/*--------------------------------- 创建日志记录表 t_report_record --------------------------------------*/
/* 创建日志记录表  t_report_record */
create table t_report_record
(
    report_id     number(9) primary key,
    account       varchar2(255) not null,
    report_date   varchar2(10)  not null,
    work_process  varchar2(255) not null,
    work_content  varchar2(255) not null,
    tomorrow_plan varchar2(255) not null,
    problem       varchar2(255),
    other         varchar2(255)
);
---自增序列
CREATE SEQUENCE t_report_record_seq
    MINVALUE 1
    NOMAXVALUE
    INCREMENT BY 1
    START WITH 1 NOCACHE;
--创建触发器
create or replace trigger t_report_record_seq_id_trigger
    before insert
    on t_report_record
    for each row
begin
    select t_report_record_seq.nextval into :new.report_id from dual;
end t_report_record_seq_id_trigger;


/*查询数据表内容*/
select *
from t_report_record;


/*----------------------- 创建部门管理表 t_department --------------------------*/
/* 创建部门管理表  t_department */
create table t_department
(
    department_id   number(9) primary key,
    department_name varchar2(255) not null,
    manager         varchar2(255),
    total_user      int default 0 not null,
    create_time     varchar2(255)
);

---自增序列
CREATE SEQUENCE t_department_seq
    MINVALUE 10001
    NOMAXVALUE
    INCREMENT BY 1
    START WITH 10001 NOCACHE;
--创建触发器
create or replace trigger t_department_seq_id_trigger
    before insert
    on t_department
    for each row
begin
    select t_department_seq.nextval into :new.department_id from dual;
end t_department_seq_id_trigger;
commit;
--查询数据
select *
from t_department;

/*-------------------------- 创建工号表 t_account ------------------------------*/
/* 创建日志记录表  t_account */
create table t_account
(
    Id      number(9) primary key,
    Account varchar2(20) not null
);


---自增序列
CREATE SEQUENCE t_account_seq
    MINVALUE 1
    NOMAXVALUE
    INCREMENT BY 1
    START WITH 1 NOCACHE;
--创建触发器
create or replace trigger t_account_seq_id_trigger
    before insert
    on t_account
    for each row
begin
    select t_account_seq.nextval into :new.id from dual;
end t_account_seq_id_trigger;

/*-------------------------- 我的桌面的加班处理记录表 ----------------------------*/
-- 创建我的桌面的加班处理记录  id,处理日期，外键id，
create table T_MYDESKTOP
(
    Id         number(9) primary key,
    handledate varchar2(20) not null,
    fid        number(9),
    state      varchar2(20) not null
    -- state  为0时 代表已删除不显示，为1代表显示
);
---自增序列
CREATE SEQUENCE t_mydesk_seq
    MINVALUE 1
    NOMAXVALUE
    INCREMENT BY 1
    START WITH 1 NOCACHE;
--创建触发器
create or replace trigger t_mydesk_seq_id_trigger
    before insert
    on T_MYDESKTOP
    for each row
begin
    select t_mydesk_seq.nextval into :new.id from dual;
end t_mydesk_seq_id_trigger;


/*-- 删除自增序列和触发器
drop sequence t_user_info_seq;
drop trigger t_user_info_id_trigger;
-- 删除自增序列和触发器
drop sequence t_work_record_seq;
drop trigger t_work_record_seq_id_trigger;
-- 删除自增序列和触发器
drop sequence t_rest_record_seq;
drop trigger t_rest_record_seq_id_trigger;
-- 删除自增序列和触发器
drop sequence t_report_record_seq;
drop trigger t_report_record_seq_id_trigger;
-- 删除自增序列和触发器
drop sequence t_department_seq;
drop trigger t_department_seq_id_trigger;
-- 删除自增序列和触发器
drop sequence t_account_seq;
drop trigger t_account_seq_id_trigger;*/

/*                                                                                               多表查询的连接*/
select tu.name, td.department_id, td.department_name
from t_user_info tu,
     t_department td
where tu.department_id = td.department_id;
select tw.*, tu.name
from t_user_info tu,
     t_work_record tw
where tu.account = tw.account;



因需要插入的表信息较多，故自己写了一个可以自动生成数据库插入信息语句的类。
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
            String z3 =ch.charAt((int)(26*Math.random()))+""+ch.charAt((int)
(26*Math.random()))+
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

 




5.3、个人所开发的模块中主要有哪些处理过程会发生异常？举例说明程序中是如何处理这些异常的？
异常一： 程序在正常运行的情况下，过了一天突然无法加载所有的CSS文件，也就是没有前端效果，项目页面乱成一团。
经过无数条百度，终于在凌晨两点找到一个靠谱的回答，并在第二天上午8点多进项尝试，发现可以成功。解决办法: 只需将下图中的黄色框中的html声明的代码去掉即可。 虽然之前在不删除这些信息的情况下可以正常运行，突然就加载不出css文件了，只有删了这些代码才可。
 

异常二：多表查询时，一个表中的信息在两一个表中没有，则就会出现查询不出信息的情况。
   例如当用户表和部门表联合(多表查询)进行查询需要展示的信息时。用户表中只有部门号，部门表中既有部门号，也有部门名。当要显示用户和用户所在部门的的信息时，就要涉及到多表查询。若用户表中的用户所对应的部门号在部门表中没有时，就会查询不到用户信息。故用户的每一个部门号都要是部门表中所存在的。

异常三： 服务器启动失败
原因： 在配置servlet时，用两个servlet同名，故在启动服务器将servlet加载进内存时出错。 本项目使用的是 annocation注解的方式配置servlet
解决办法: 只需将同名的servlet修改即可。


5.4、SVN工具的安装和使用(分为服务器端、客户端、eclipse中安装SVN插件及使用svn)？
本人在开发本项目时: 使用的是IDEA旗舰版集成开发工具
服务器使用Tomcat9.0.33
浏览器使用 Chrome浏览器
并整合Maven技术，便于开发jar的管理，并创建了本地仓库，下载jar包时，通过阿里巴巴的镜像进行下载，而非通过国外的中央仓库，这样大大增加了jar包的下载速度。
使用Git进行项目开发进度显示。
IDEA在配置本地的tomcat后，又使用了tomcat7的插件。



5.5、开发过程中遇到的技术难点及解决办法。
技术难点一: 无法通过input输入框提交的参数，该如何提交
- 通过?id=${ } 参数名和EL表达式提交
技术难点二: 数据库的多表查询
- 通过  …….. from 表1,表2  where 表1.字段 = 表2
技术难点三: 分页查询
- 后台传至前端的数据:
  int totalCount   -->   总记录条数
  int totalPage    -->   总页码数 = totalCount % 每页显示的数目 == 0 ? 	totalCount / 每页显示的数目 : totalCount / 每页显示的数目 +1
List list        -->   每页的数据   list集合
-	前台传至后台的数据:
     int currentPage  -->   当前页码
     int rows         -->   每页显示的数据条数

      将5条信息其封装成一个类，取名为pageBean
      totalCount = select count(*) from users;
      totalPage = 提供每页显示的数据条数； rows
      list  = select * from user limit ? , ?   -->  第一个? 开始查询的索引，   第二个 ? rows每页显示的条数
      currentPage = 提供当前页码给服务器
      开始查询的索引 = ( currentPage - 1 ）* rows
      步骤: 接收请求参数currentPage,rows
      //创建空的pageBean 对象
      //设置currentPage   属性和rows属性
      //调用dao完成查询 totalCount 总记录数  dao.findTotalCount()
      // start索引: (currentPage-1)*rows
      //调用dao去查询list集合  dao.findByPage(int start, int rows)
      //计算总页码: 返回pageBean对象

      userDao层
      // 查询总记录数
      int findTotalCount(){}
      //分页查询list
      List findByPage(int start,int rows)

技术难点四: 分页查询操作数据库的代码和模糊搜索的数据库代码
-	解决办法，通过询问老师oracle代码，尤其是查询表时，添加ROWNUM列 通过ROWNUM进行order by排序，并将查询出的表作为子表进行重新查询,并通过Between start and end 进行分页查询
List<UserShow> list = new ArrayList<UserShow>();
String sql1 ="select * from ((select  tu.ID, tu.ACCOUNT, tu.NAME, tu.DEPARTMENT_ID,td.DEPARTMENT_NAME, tu.SEX, tu.BIRTHDAY, tu.MOBILE, tu.EMAIL,  tu.USER_TYPE, tu.CREATE_TIME , ROWNUM as r from T_USER_INFO tu,T_DEPARTMENT td where tu.DEPARTMENT_ID = td.DEPARTMENT_ID order by tu.ID )) where r between ? and ?";

String sql2 = " select * from (select * from (select tu.ID, tu.ACCOUNT, tu.NAME, tu.DEPARTMENT_ID, td.DEPARTMENT_NAME, tu.SEX,     tu.BIRTHDAY, tu.MOBILE, tu.EMAIL, tu.USER_TYPE, tu.CREATE_TIME, rownum as r from T_USER_INFO tu, T_DEPARTMENT td   where tu.DEPARTMENT_ID = td.DEPARTMENT_ID and tu.name like ? and tu.DEPARTMENT_ID = ? order by tu.ID ) temp) where r between ? and ? ";

String sql = sql1;
if(name!=null && !"".equals(name)){   
//如果有查询条件有值 则执行sql语句2
    sql = sql2;
}
conn = du.getConn();
ps = du.getPs(conn,sql);
try {
    if(name!=null && !"".equals(name)){   
//如果查询条件有值 则对后两个参数赋值
        name = "%"+name+"%";
        ps.setString(1,name);
        ps.setInt(2,department_id);
        ps.setInt(3,start);
        ps.setInt(4,start+rows-1);
    }else{
        ps.setInt(1,start);
        ps.setInt(2,start+rows-1);
    }
    rs = ps.executeQuery();

5.6、系统开发过程中个人遵循了项目中规定的哪些开发规范？
1)  MVC 三层架构
2） 面向接口编程
3） 使用Bean封装
4） 提取公共方法，减少代码量
5） 使用数据库连接池 提取公共类
6)  数据库语法使用预编译的方式，防止SQL注入和提高执行效率


5.7、本项目主要是用什么办法监控项目进度的？列出你在其中的作业任务项。
1） 使用Git查看项目的提交
2） Excel表格的方式
3） 个人计划表
任务项: 全部模块的全部功能

5.8、本项目开发中获得的经验和不足。
本次项目是开发一个软件员工考勤管理的网站，并且在其中用到了oracle数据库连接的知识、大量后端和js、html代码知识。 虽然在现在的企业中JSP已属于过时的技术，但它仍是非常中的基础学科，属于原理性的知识，只有扎实掌握了JSP的知识，以及利用JSP开发项目的能力 才能应对不但发展的技术。例如JavaEE中的SpringMVC 就是对这些基础性知识的封装。此前虽然已经了解学习了许多相关的学科知识，积累了一定程度的开发经验，但此次依旧是一个非常宝贵的经历。我在项目的实践中不断进行尝试，继续积累宝贵的经验教训。纸上得来终觉浅，绝知此事要躬行。之前的jsp理论课为我们此次的实战课程积累的丰富的理论知识，不过当你真正开发一个项目的时候才会发现将知识正确运用到自己的项目里是一件多么不容易又多么有成就感的事情。学习敲代码是一件应该持续坚持的事情，在这个开发过程中我有许多新学习到的事情。这段时间以来，我得到的收获到的其实远不止刚刚提到的，所有的这些经验教训都会成为我以后工作生活的重要依据，而在这个过程中建立起来的与老师、团队成员的友谊也是我倍感珍惜的。


