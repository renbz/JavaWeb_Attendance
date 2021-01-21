<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户添加</title>
    <link href="../css/style2.css" rel="stylesheet" type="text/css"/>
    <link href="../css/select.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="../js/select-ui.min.js"></script>
    <script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
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
    </script>
    <script language="javascript">
        function saveButton() {
            document.forms[0].action = "${pageContext.request.contextPath}/R02_MyInfoUpdateServlet?id=${us.id}";
            document.forms[0].submit();
        }
    </script>

</head>

<body>
<form action="userFrom">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">个人信息修改</a></li>

        </ul>
    </div>

    <div class="formbody">

        <div class="formtitle"><span>基本信息</span></div>

        <ul class="forminfo">
            <li>
                <label>工号 </label>
                </label><input name="account" type="text" class="scinput" value="${us.account}" readonly="readonly"/>
            </li>
            <li>
                <label>密码 <font color="red">*</font></label>
                <input name="password" type="password" class="dfinput" value="${us.password}"/>
            </li>
            <li>
                <label>确认密码 <font color="red">*</font></label><input name="password" type="password" class="dfinput"/>
            </li>
            <li>
                <label>姓名 <font color="red">*</font></label>
                </label><input name="name" type="text" class="dfinput" value="${us.name}"/>
            </li>
            <li><label>部门</label>
                <div class="vocation">
                    <select class="select3" name="department_id">

                        <c:if test="${us.department_id==10001}">
                            <option>--请选择--</option>
                            <option name="departId" value="10001" selected="selected">研发一部</option>
                            <option name="departId" value="10002">研发二部</option>
                            <option name="departId" value="10003">研发三部</option>
                            <option name="departId" value="10004">测试部</option>
                            <option name="departId" value="10005">质量保证部</option>
                        </c:if>

                        <c:if test="${us.department_id==10002}">
                            <option>--请选择--</option>
                            <option name="departId" value="10001" selected="selected">研发一部</option>
                            <option name="departId" value="10002">研发二部</option>
                            <option name="departId" value="10003">研发三部</option>
                            <option name="departId" value="10004">测试部</option>
                            <option name="departId" value="10005">质量保证部</option>
                        </c:if>

                        <c:if test="${us.department_id==10003}">
                            <option>--请选择--</option>
                            <option name="departId" value="10001">研发一部</option>
                            <option name="departId" value="10002">研发二部</option>
                            <option name="departId" value="10003" selected="selected">研发三部</option>
                            <option name="departId" value="10004">测试部</option>
                            <option name="departId" value="10005">质量保证部</option>
                        </c:if>

                        <c:if test="${us.department_id==10004}">
                            <option>--请选择--</option>
                            <option name="departId" value="10001">研发一部</option>
                            <option name="departId" value="10002">研发二部</option>
                            <option name="departId" value="10003">研发三部</option>
                            <option name="departId" value="10004" selected="selected">测试部</option>
                            <option name="departId" value="10005">质量保证部</option>
                        </c:if>
                        <c:if test="${us.department_id==10005}">
                            <option>--请选择--</option>
                            <option name="departId" value="10001">研发一部</option>
                            <option name="departId" value="10002">研发二部</option>
                            <option name="departId" value="10003">研发三部</option>
                            <option name="departId" value="10004">测试部</option>
                            <option name="departId" value="10005" selected="selected">质量保证部</option>
                        </c:if>
                    </select>
                </div>
            </li>
            <li>
                <label>性别</label>
                <c:if test="${us.sex==1}">
                    <cite><input name="sex" type="radio" value="1" checked="checked"/>
                        男&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="sex" type="radio" value="2"/>
                        女 </cite>
                </c:if>
                <c:if test="${us.sex!=1}">
                    <cite><input name="sex" type="radio" value="1"/>
                        男&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="sex" type="radio" value="2" checked="checked"/>
                        女 </cite>
                </c:if>
            </li>
            <li><label>手机号码 <font color="red">*</font></label><input name="mobile" type="text" class="dfinput"
                                                                     value="${us.mobile}"/></li>
            <li><label>出生日期</label>
                <input name="birthday" type="text" class="dfinput" value="${us.birthday}"
                       onClick="WdatePicker({work_date:'',dateFmt:'yyyy-MM-dd'})"/></li>
            <li><label>邮箱 <font color="red">*</font></label><input name="email" type="text" class="dfinput"
                                                                   value="${us.email}"/></li>
            <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存" onclick="saveButton()"/></li>
        </ul>
    </div>
</form>
</body>
</html>
