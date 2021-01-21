<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>加班管理</title>
<link href="../css/style2.css" rel="stylesheet" type="text/css" />
<link href="../css/select.css" rel="stylesheet" type="text/css" />
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
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">休假管理</a></li>
    </ul>
    </div>

	<!--查询条件-->
    <br />
    <br />
    <ul class="seachform">
    <li>
      <label> 休假日期:</label><input name="" type="text" class="scinput"  value="请选择开始日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></li>
     <li>  <label> 到</label><input name="" type="text" class="scinput" value="请选择结束日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></li>
    <li>
    <label>状态：</label>
    <div class="vocation">
    <select class="select3">
    <option>--请选择--</option>
    <option>审批中</option>
    <option>已批准</option>
    <option>已驳回</option>
    </select>
    </div>
    </li>
    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询"/></li>
    </ul>
    </div>

    <div class="tools">

    	<ul class="toolbar">
        <li class="click"><span><img src="../images/t01.png" /></span><a href="/restmanager/restInsert.jsp" target="_self">添加</a></li>
        <li class="click"><img src="../images/trash.png" /></span><a href="#" target="rightFrame">删除</a></li>
        </ul>
    </div>


    <table class="tablelist"><tbody><tr><td><table class="tablelist"><tbody><tr><td><table class="tablelist">
      <tbody>
        <tr>
          <td><table class="tablelist">
              <thead>
                <tr>
                <th width="3%"><input name="" type="checkbox" value="" checked="checked"/></th>
                  <th width="7%">工号<i class="sort"><img src="../images/px.gif" /></i></th>
                  <th width="11%">姓名</th>
                  <th width="10%">休假开始日期</th>
                  <th width="9%">休假开始时间</th>
                  <th width="10%">休假结束日期</th>
                  <th width="11%">休假终了时间</th>
                  <th width="7%">休假时间小计</th>
                  <th width="8%">状态</th>
                  <th width="13%">操作</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${pb.list}" var="rrs" varStatus="s">
              <tr>
                  <td><input name="uid" type="checkbox" value="${rrs.rest_id}"/></td>
                  <td>${rrs.account}</td>
                  <td>${rrs.name}</td>
                  <td>${rrs.rest_start_date}</td>
                  <td>${rrs.start_time}</td>
                  <td>${rrs.rest_end_date}</td>
                  <td>${rrs.end_time}</td>
                  <td>${rrs.rest_time}</td>
                  <c:if test="${rrs.state==0}">
                  <td>申请中</td>
                  </c:if>
                  <c:if test="${rrs.state==1}">
                  <td>已通过</td>
                  </c:if>
                  <c:if test="${rrs.state==2}">
                  <td>已驳回</td>
                  </c:if>

                  <td><span><a href="/restmanager/restUpdate.jsp" class="tablelink"><img src="../images/user_edit.png" />修改</a>
                      <a href="/R03_DelRestRecordServlet?id=${rrs.rest_id}" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                  </c:forEach>
                <%--<tr>
                 <td><input name="" type="checkbox" value="" /></td>
                  <td>20130901</td>
                  <td>admin</td>
                  <td>2013-09-09 </td>
                  <td>08:30</td>
                  <td>2013-09-09 </td>
                  <td>17:30</td>
                  <td>8.0</td>
                  <td>申请中</td>
                 <td><span><a href="restUpdate.html" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                </tr>
                <tr>
                 <td><input name="" type="checkbox" value="" /></td>
                  <td>20130902</td>
                  <td>wanglin</td>
                  <td>2018-09-09 </td>
                  <td>08:30</td>
                  <td>2018-09-10 </td>
                  <td>17:30</td>
                  <td>16.0</td>
                  <td>申请中</td>
                  <td><span><a href="restUpdate.html" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                </tr>
                <tr>
                  <td><input name="" type="checkbox" value="" /></td>
                  <td>20130903</td>
                  <td>wangli</td>
                  <td>2015-09-10 </td>
                  <td>08:30</td>
                  <td>2015-09-10 </td>
                  <td>17:30</td>
                  <td>8.0</td>
                  <td>已批准</td>
                  <td><span><a href="restUpdate.html" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                </tr>
                <tr>
                  <td><input name="" type="checkbox" value="" /></td>
                  <td>20130904</td>
                  <td>zhangli</td>
                  <td>2015-09-09 </td>
                  <td>08:30</td>
                  <td>2015-09-09 </td>
                  <td>17:30</td>
                  <td>8.0</td>
                  <td>已批准</td>
                   <td><span><a href="restUpdate.html" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                </tr>
                <tr>
                  <td><input name="" type="checkbox" value="" /></td>
                  <td>20130905</td>
                  <td>zhang_lin</td>
                  <td>2015-09-09 </td>
                  <td>08:30</td>
                  <td>2015-09-09 </td>
                  <td>17:30</td>
                  <td>8.0</td>
                  <td>已批准</td>
                  <td><a href="restUpdate.html" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></restUpdatespan></td>
                </tr>--%>
              </tbody>
          </table></td>
        </tr>
      </tbody>
    </table>
    </td>
          </tr>
    </tbody>
    </table></td>
        </tr>
    </tbody>
    </table>


<div class="pagin">
    <div class="message">共<i class="blue">${pb.totalCount}</i>条记录，共 ${pb.totalPage} 页, 当前显示第&nbsp;<i class="blue">${pb.currentPage}&nbsp;</i>页</div>

    <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <c:forEach begin="1" end="${pb.totalPage}" var="i">
            <c:if test="${pb.currentPage==i && (i <=5 || i >=pb.totalPage-4)}">
                <li class="paginItem current"><a href="${pageContext.request.contextPath}/R01_FindRestReByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
            </c:if>
            <c:if test="${pb.currentPage!=i && (i <=5 || i >=pb.totalPage-4)}">
                <li class="paginItem"><a href="${pageContext.request.contextPath}/R01_FindRestReByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
            </c:if>
            <c:if test="${i == 6 }">
                <li class="paginItem more"><a href="javascript:;">...</a></li>
            </c:if>
        </c:forEach>


        <%--<li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>--%>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
    </ul>
</div>


    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>

      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>

        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>

    </div>




    </div>

    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
