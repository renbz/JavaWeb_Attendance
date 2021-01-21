<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>休假申请修改</title>
    <link href="../css/style2.css" rel="stylesheet" type="text/css"/>
    <link href="../css/select.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="../js/select-ui.min.js"></script>
    <script type="text/javascript" src="../js/global.js"></script>
    <script type="text/javascript" src="../js/jquery.select.js"></script>
    <script type="text/javascript" src="../js/WdatePicker.js"></script>
    <script type="text/javascript" src="../js/umeditor.config.js"></script>
    <script type="text/javascript" src="../js/editor_api.js"></script>
    <script type="text/javascript" src="../umeditor/lang/zh-cn/zh-cn.js"></script>
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
            document.forms[0].action = "/R01_FindRestReByPageServlet?currentPage=1&rows=5";
            document.forms[0].submit();
        }
    </script>

</head>

<body>
<form action="myForm">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">休假管理</a></li>
            <li><a href="#">修改休假申请</a></li>
        </ul>
    </div>

    <div class="formbody">

        <div class="formtitle"><span>休假申请</span></div>

        <ul class="forminfo">
            <li>
                <label>工号</label>
                </label><input type="text" class="dfinput" value="20180002" readonly="readonly"/>
            </li>
            <li>
                <label>姓名</label>
                </label><input type="text" class="dfinput" value="renbz" readonly="readonly"/>
            </li>
            <li>
                <label>休假开始日期 <font color="red">*</font></label>
                <input type="text" class="dfinput" name="work_date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
                       value="2020-12-12 "/>
            </li>
            <li>
                <label>开始时间 <font color="red">*</font></label>
                <input type="text" class="dfinput" name="" value="8:30"/> (HH:mm)
            </li>
            <li>
                <label>休假结束日期 <font color="red">*</font></label>
                <input type="text" class="dfinput" name="work_date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
                       value="2020-12-13 "/>
            </li>
            <li>
                <label>终了时间 <font color="red">*</font></label>
                <input type="text" class="dfinput" name="" value="8:30"/> (HH:mm)
            </li>
            <li>
                <label>休假时间小计 </label>
                <input type="text" class="dfinput" name="" value="1day" readonly/>
            </li>
            <li>
                <br/>
                <label>休假原因 <font color="red">*</font></label><textarea rows="5" cols="10" id="tomorrow_plan"
                                                                        required="required" name="tomorrow_plan"
                                                                        style="width: 500px; height: 30px; padding-left:5px; border: 1px solid #eaeff2; margin-top: 20px;ime-mode:disabled;"
                                                                        maxlength="255">结婚</textarea></li>
            <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存" onclick="saveButton()"/></li>
        </ul>
    </div>
</form>
</body>
</html>
