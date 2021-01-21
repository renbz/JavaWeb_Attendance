<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>考勤管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/style1.css" />
    <link rel="stylesheet" type="text/css" href="css/body.css"/>
</head>
<body>
<div class="container">
    <section id="content">
        <form action="/R01_UserLoginServlet">
            <%--补充form表单内容--%>
            <h1>考勤管理系统</h1>
            <div>
                <input type="text" placeholder="用户名" required="" name="username" value="renbz" />
            </div>
            <div>
                <input type="password" placeholder="密码" required="" name="password"  value="ren372930"/>
            </div>
            <div class="">
                <span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>			</div>
            <div>
                <!-- <input type="submit" value="Log in" /> -->
                <input type="submit" value="登录" class="btn btn-primary" id="js-btn-login"/>
                <label> <input name="" type="checkbox" value="" checked="checked" />记住密码</label>
                <label> <input name="" type="checkbox" value="" />自动登录</label>
            </div>
        </form><!-- form -->
        <c:if test="${message==0}">
            <div>用户名或密码错误</div>
            <% session.removeAttribute("message"); %>
        </c:if>
        <div style="color:red"> ${message} </div>

    </section>
</div>
<br><br><br><br>

</body>
</html>