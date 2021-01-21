<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>我的桌面</title>
    <link href="../css/style2.css" rel="stylesheet" type="text/css"/>

</head>

<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">我的桌面</a></li>
    </ul>
</div>
<br/>
<br/>
<div class="mainindex">

    <div class="welinfo">
        <span><img src="../images/sun.png" alt="天气"/></span>
        <b>Admin早上好，您有新消息</b>
    </div>


    <c:forEach items="${list}" var="mdt" varStatus="s">
        <div class="welinfo">
            <h4>
                您的${mdt.applyDate}的加班申请已于${mdt.handleDate}${mdt.state} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                &nbsp;<a href="${pageContext.request.contextPath}/R02_WorkInfoDelServlet?id=${mdt.id}" onclick="confirm('确定删除该信息吗？')">删除</a>
            </h4>
        </div>
    </c:forEach>


    <%--<div class="welinfo">
        <h4>
            您的2016-09-09的加班申请已于2016-09-09 12:00:00已通过 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a
                href="#" onclick="confirm('确定删除该信息吗？')">删除</a>
        </h4>
    </div>

    <div class="welinfo">
        <h4>
            您的2016-09-10的加班申请已于2016-09-09 12:00:00已驳回 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a
                href="#" onclick="confirm('确定删除该信息吗？')">删除</a></h4>
        </h4>
    </div>--%>

</div>
</body>
</html>
