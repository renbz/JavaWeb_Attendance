<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.text.SimpleDateFormat,java.util.*" %>
<html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/style2.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>

</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
    </ul>
</div>
   <br/>


<div class="mainindex">


    <div class="welinfo">
        <span><img src="images/sun.png" alt="天气"/></span>
        <b>Admin早上好，欢迎使用考勤管理系统</b>
    </div>

    <div class="welinfo">
        <span><img src="images/time.png" alt="时间"/></span>

        <i><%= new SimpleDateFormat("YYYY-MM-dd HH:mm").format(new Date()) %>
        </i></div>

</body>
</html>
