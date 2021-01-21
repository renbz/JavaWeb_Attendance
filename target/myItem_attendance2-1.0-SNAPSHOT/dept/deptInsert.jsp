
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户添加</title>
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
 document.forms[0].action="${pageContext.request.contextPath}/R02_DepartmentAddServlet";
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
    <li><a href="#">添加部门</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <li>
      <label>部门编号 <font color="red">*</font></label>
      </label><input name="dept_id" type="text" class="dfinput" /></li>
    <li>
      <label>部门名称 <font color="red">*</font></label>
      <input name="dept_name" type="text" class="dfinput" />
    </li>
    <li>
      <label>负责人</label>
       <div class="vocation">
    <select class="select3"  name="manager">
    <option value="">--请选择--</option>
    <option value="任兵长" selected >任兵长</option>
    <option value="王皓" >王皓</option>
    <option value="陈福海" >陈福海</option>
    <option value="官文莹" >官文莹</option>
    <option value="周雅宁" >周雅宁</option>
    </select>
    </div>
    </li> 
    <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存" onclick="saveButton()"/></li>
    </ul>
    </div>
</form>
</body>
</html>
