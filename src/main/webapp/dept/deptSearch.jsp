<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>部门管理</title>
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
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">部门管理</a></li>
    </ul>
    </div>

	<!--查询条件-->
    <br />
    <br />
    <ul class="seachform">
        <form action="${pageContext.request.contextPath}/R01_FindDepartmentByPageServlet" method="post">
    <li>
      <label> 部门名称</label><input name="search_name" type="text" class="scinput" /></li>

    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"/></li>
        </form>
    </ul>
    </div>

    <div class="tools">
    	<ul class="toolbar">
        <li class="click"><span><img src="../images/t01.png" /></span><a href="/dept/deptInsert.jsp" target="_self">添加</a></li>
        <li class="click"><img src="../images/trash.png" /></span><a href="" target="rightFrame">删除</a></li>
        </ul>
    </div>


    <table class="tablelist"><tbody><tr><td><table class="tablelist"><tbody><tr><td><table class="tablelist">
      <tbody>
        <tr>
          <td><table class="tablelist">
              <thead>
                <tr>
                <th width="5%" height="83"><input name="" type="checkbox" value="" checked="checked"/></th>
                  <th width="12%">部门编号<i class="sort"><img src="../images/px.gif" /></i></th>
                  <th width="16%">部门名称</th>
                  <th width="15%">负责人</th>
                  <th width="13%">人数</th>
                  <th width="21%">注册时间</th>
                  <th width="18%">操作</th>
                </tr>
              </thead>
              <tbody>

              <c:forEach items="${pb.list}" var="ds" varStatus="s">
                  <tr>
                      <td><input name="did" type="checkbox" value="${ds.department_id}" /></td>
                      <td>${ds.department_id}</td>
                      <td>${ds.department_name}</td>
                      <td>${ds.manager}</td>
                      <td>${ds.total_user}</td>
                      <td>${ds.create_time}</td>
                      <td><span><a href="${pageContext.request.contextPath}/R04_DeptEchoDataServlet?id=${ds.department_id}" class="tablelink"><img src="../images/user_edit.png" />修改</a>
                          <a href="${pageContext.request.contextPath}/R03_DepartmentDelServlet?id=${ds.department_id}" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                  </tr>
              </c:forEach>


              <%--
                <tr>
                 <td><input name="" type="checkbox" value="" /></td>
                  <td>10001</td>
                  <td>研发一部</td>
                  <td>张楠</td>
                  <td>20</td>
                  <td>2013-09-09 15:05</td>
                  <td><span><a href="deptUpdate.html" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                </tr>
                <tr>
                 <td><input name="" type="checkbox" value="" /></td>
                  <td>10002</td>
                  <td>研发二部</td>
                  <td>张婧研</td>
                  <td>10</td>
                  <td>2013-09-09 15:05</td>
                  <td><span><a href="deptUpdate.html" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                </tr>
                <tr>
                  <td><input name="" type="checkbox" value="" /></td>
                  <td>10003</td>
                  <td>研发三部</td>
                  <td>张东</td>
                  <td>30</td>
                  <td>2013-09-09 15:05</td>
                  <td><span><a href="deptUpdate.html" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                </tr>
                <tr>
                  <td><input name="" type="checkbox" value="" /></td>
                  <td>10004</td>
                  <td>测试部</td>
                  <td>王丽丽</td>
                  <td>40</td>
                  <td>2013-09-09 15:05</td>
                   <td><span><a href="deptUpdate.html" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                </tr>
                <tr>
                  <td><input name="" type="checkbox" value="" /></td>
                  <td>10005</td>
                  <td>质量保证部</td>
                  <td>余力</td>
                  <td>20</td>
                  <td>2013-09-09 15:05</td>
                  <td><span><a href="deptUpdate.html" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                </tr>
               --%>

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
                <li class="paginItem current"><a href="${pageContext.request.contextPath}/R01_FindDepartmentByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
            </c:if>
            <c:if test="${pb.currentPage!=i && ( i <=5 || i >=pb.totalPage-4)}">
                <li class="paginItem"><a href="${pageContext.request.contextPath}/R01_FindDepartmentByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
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
