<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户管理</title>
    <link href="../css/style2.css" rel="stylesheet" type="text/css"/>
    <link href="../css/select.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="../js/select-ui.min.js"></script>
    <script type="text/javascript">
        KE.show({
            id: 'content7',
            cssPath: './index.css'
        });
    </script>

    <script type="text/javascript">
        $(document).ready(function (e) {
            $(".select1").uedSelect({
                width: 345
            });
            $(".select2").uedSelect({
                width: 167
            });
            $(".select3").uedSelect({
                width: 100
            });
        });


        /*自己写的 提交表格的js代码*/
        window.onload = function () {

            //给删除选中按钮 添加单击事件
            document.getElementById("delSelected").onclick = function () {
                document.getElementById("myForm").submit();
            }

        }
    </script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">用户管理</a></li>
    </ul>
</div>

<!--查询条件-->
<br/>
<br/>
<ul class="seachform">
    <form action="${pageContext.request.contextPath}/R08_FindUserByPageServlet" method="post">
    <li><label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名</label><input name="search_name" type="text" class="scinput"/></li>
    <li><label>部门</label>
        <div class="vocation">
            <select class="select3" name="department_id">
                <option value="10001" selected >研发一部</option>
                <option value="10002">研发二部</option>
                <option value="10003">研发三部</option>
                <option value="10004">测试部</option>
                <option value="10005">质量保证部</option>
            </select>
        </div>
    </li>

    <li><label>&nbsp;</label><input type="submit" class="scbtn" value="查询"/></li>
    </form>
</ul>
</div>

<div class="tools">

    <ul class="toolbar">
        <li class="click"><span><img src="../images/t01.png"/></span><a href="/user/userInsert.jsp"
                                                                        target="rightFrame">添加</a></li>
        <%-- id="delSelected"  为自己加上的 ，在js代码中调用  --%>
        <%-- href="javascript:void(0);"   不要添加此代码，否则会跳转到空白网址 --%>
        <li class="click"><img src="../images/trash.png"/></span><a id="delSelected" target="rightFrame">删除</a></li>
    </ul>
</div>

<form id="myForm" action="${pageContext.request.contextPath}/R07_SelectUserDelServlet" method="post">
<table class="tablelist">
    <tbody>
    <tr>
        <td>
        <table class="tablelist">
            <tbody><tr><td><table class="tablelist">
                 <tbody><tr><td>
                        <table class="tablelist">
                        <thead>
                        <tr>
                            <th><input name="" type="checkbox" value="" checked="checked"/></th>
                            <th width="7%">工号<i class="sort"><img src="../images/px.gif"/></i></th>
                            <th width="11%">姓名</th>
                            <th width="10%">部门</th>
                            <th width="9%">职务</th>
                            <th width="11%">注册时间</th>
                            <th width="5%">性别</th>
                            <th width="10%">手机</th>
                            <th width="9%">出生日期</th>
                            <th width="12%">邮箱</th>
                            <th width="13%">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%--通过前端传入的pageBean对象（pb），中含有list集合，list结合中封装了users要显示的信息，用jstl循环和EL表达式获取显示出来--%>
                        <c:forEach items="${pb.list}" var="us" varStatus="s">
                            <tr>
                                <td><input name="uid" type="checkbox" value="${us.id}"/></td>
                                <td>${us.account}</td>
                                <td>${us.name}</td>
                                <td>${us.department_name}</td>

                                <%--逻辑判断 如果查询出的数据为0 显示管理员 --%>
                                <c:if test="${us.user_type==0}">
                                    <td>管理员</td>
                                </c:if>
                                <c:if test="${us.user_type==1}">
                                    <td>主管</td>
                                </c:if>
                                <c:if test="${us.user_type==2}">
                                    <td>员工</td>
                                </c:if>
                                <td>${us.create_time}</td>
                                <%--如果查询出的数据是1 显示男 其余显示女--%>
                                <td>${us.sex==1?"男":"女"}</td>
                                <td>${us.mobile}</td>
                                <td>${us.birthday}</td>
                                <td>${us.email}</td>
                                <%--修改按钮   点击后 跳转到R05_UserEchoDataServlet   ? id =${us.id}  是一种传参的方式 类似于form表单提交--%>
                                <td><span><a href="${pageContext.request.contextPath}/R05_UserEchoDataServlet?id=${us.id}"
                                             class="tablelink"><img src="../images/user_edit.png"/>修改</a>
                                    <%--删除按钮同理 --%>
                                    <a href="${pageContext.request.contextPath}/R04_UserDeleteServlet?id=${us.id}" class="tablelink" onclick="confirm('确定要删除吗？')"> <img
                                        src="../images/trash.png"/>删除</a></span></td>
                            </tr>
                        </c:forEach>


                                </tbody>
                            </table>

                        </td>
                    </tr>
                    </tbody>
                </table>
                    </td>
                </tr>
                </tbody>
            </table>
        </td>
    </tr>
    </tbody>
</table>
</form>

<div class="pagin">
    <div class="message">共<i class="blue">${pb.totalCount}</i>条记录，共 ${pb.totalPage} 页, 当前显示第&nbsp;<i class="blue">${pb.currentPage}&nbsp;</i>页</div>
    <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <c:forEach begin="1" end="${pb.totalPage}" var="i">
            <c:if test="${pb.currentPage==i && (i <=5 || i >=pb.totalPage-4)}">
                <li class="paginItem current"><a href="${pageContext.request.contextPath}/R08_FindUserByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
            </c:if>
            <c:if test="${pb.currentPage!=i && (i <=5 || i >=pb.totalPage-4)}">
                <li class="paginItem"><a href="${pageContext.request.contextPath}/R08_FindUserByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
            </c:if>
            <c:if test="${i == 6 }">
                <li class="paginItem more"><a href="javascript:;">...</a></li>
            </c:if>
        </c:forEach>

        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
    </ul>
</div>


<div class="tip">
    <div class="tiptop"><span>提示信息</span><a></a></div>

    <div class="tipinfo">
        <span><img src="images/ticon.png"/></span>
        <div class="tipright">
            <p>是否确认对信息的修改 ？</p>
            <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
    </div>

    <div class="tipbtn">
        <input name="" type="button" class="sure" value="确定"/>&nbsp;
        <input name="" type="button" class="cancel" value="取消"/>
    </div>

</div>


</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
