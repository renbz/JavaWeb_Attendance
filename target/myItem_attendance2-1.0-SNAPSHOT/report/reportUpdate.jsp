
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户添加</title>
<link href="../css/style2.css" rel="stylesheet" type="text/css" />
<link href="../css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../js/select-ui.min.js"></script>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
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
 document.forms[0].action="${pageContext.request.contextPath}/R04_ReportUpdateServlet?report_id=${res.report_id}";
 document.forms[0].submit();
}
</script>
</head>

<body>
<form action="${pageContext.request.contextPath}/R04_ReportUpdateServlet?report_id=${res.report_id}">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">日报管理</a></li>
    <li><a href="#">修改日报</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <li>
        <input hidden name="report_id" value="${res.report_id}">
      <label>姓名</label>
      </label><input name="name" type="text" class="dfinput" value="${res.name}"  />
    </li>
    <li>
      <label>日期 <font color="red">*</font></label>
      <input name="report_date" type="text" class="dfinput" value="${res.report_date}" onClick="WdatePicker({work_date:'',dateFmt:'yyyy-MM-dd'})"/>
    </li>
     <li>
      <label>作业进度 <font color="red">*</font></label><input name="work_process" type="text" class="dfinput" value="${res.work_process}" />
    </li>
    <li>
      <label>作业内容<font color="red">*</font></label>
      </label>
      <textarea rows="5" cols="10" id="tomorrow_plan2" required="required"  name="work_content" style="width: 500px; height: 30px; padding-left:5px; border: 1px solid #eaeff2; margin-top: 20px;ime-mode:disabled;" maxlength="255">${res.work_content}</textarea>
    </li>
    
    <li>
      <label>明日计划 <font color="red">*</font></label>
      <textarea rows="5" cols="10" id="tomorrow_plan" required="required"  name="tomorrow" style="width: 500px; height: 30px; padding-left:5px; border: 1px solid #eaeff2; margin-top: 20px;ime-mode:disabled;" maxlength="255">${res.tomorrow}</textarea></li>
    <li>
      <label>问题点</label>
      <textarea rows="5" cols="10" id="tomorrow_plan4" required="required"  name="problem" style="width: 500px; height: 30px; padding-left:5px; border: 1px solid #eaeff2; margin-top: 20px;ime-mode:disabled;" maxlength="255">${res.problem}</textarea>
    </li>
    <li>
      <label>需联络事项</label>
     <textarea rows="5" cols="10" id="tomorrow_plan3" required="required"  name="other" style="width: 500px; height: 30px; padding-left:5px; border: 1px solid #eaeff2; margin-top: 20px;ime-mode:disabled;" maxlength="255">${res.other}</textarea>
    </li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" onclick="saveButton()"/></li>
    </ul>
  </div>
</form>
</body>
</html>
