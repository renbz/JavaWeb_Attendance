
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>部门修改</title>
<link href="../css/style2.css" rel="stylesheet" type="text/css" />
<link href="../css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../js/select-ui.min.js"></script>
<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345
	});
	$(".select2").uedSelect({
		width : 167
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
<script language="javascript">
function saveButton(){
 document.forms[0].action="${pageContext.request.contextPath}/R05_DeptUpdateServlet";
 document.forms[0].submit();
}
</script>


</head>

<body>
<form action="userFrom">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">部门管理</a></li>
    <li><a href="#">修改部门</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <li>
      <label>部门编号</label>
      </label><input name="department_id" type="text" class="dfinput" readonly="readonly" value="${dept.department_id}"/></li>
    <li>
      <label>部门名称</label>
      <input name="department_name" type="text" class="dfinput" value="${dept.department_name}"/>
    </li>
     <li>
      <label>负责人 </label>
       <div class="vocation">
    <select name="manager" class="select3">
        <c:if test="${dept.manager=='任兵长'}">
            <option value="">--请选择--</option>
            <option value="任兵长" selected>任兵长</option>
            <option value="王皓"  >王皓</option>
            <option value="陈福海">陈福海</option>
            <option value="周雅宁">周雅宁</option>
            <option value="官文莹">官文莹</option>
        </c:if>
        <c:if test="${dept.manager=='王皓'}">
            <option value="">--请选择--</option>
            <option value="任兵长">任兵长</option>
            <option value="王皓"  selected>王皓</option>
            <option value="陈福海" >陈福海</option>
            <option value="周雅宁">周雅宁</option>
            <option value="官文莹">官文莹</option>
        </c:if>
        <c:if test="${dept.manager=='陈福海'}">
            <option value="">--请选择--</option>
            <option value="任兵长">任兵长</option>
            <option value="王皓" >王皓</option>
            <option value="陈福海" selected>陈福海</option>
            <option value="周雅宁">周雅宁</option>
            <option value="官文莹">官文莹</option>
        </c:if>
        <c:if test="${dept.manager=='周雅宁'}">
            <option value="">--请选择--</option>
            <option value="任兵长" >任兵长</option>
            <option value="王皓"  >王皓</option>
            <option value="陈福海"  >陈福海</option>
            <option value="周雅宁"  selected>周雅宁</option>
            <option value="官文莹" >官文莹</option>
        </c:if>
        <c:if test="${dept.manager=='官文莹'}">
            <option value="">--请选择--</option>
            <option value="任兵长">任兵长</option>
            <option value="王皓" >王皓</option>
            <option value="陈福海">陈福海</option>
            <option value="周雅宁">周雅宁</option>
            <option value="官文莹" selected>官文莹</option>
        </c:if>

    </select>
    </div>
    </li>
    <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存" onclick="saveButton()"/></li>
    </ul>
    </div>
</form>
</body>
</html>
