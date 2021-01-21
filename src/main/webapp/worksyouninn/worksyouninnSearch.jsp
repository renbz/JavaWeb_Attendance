<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>加班审批</title>
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
    <li><a href="#">审批</a></li>
    <li><a href="#">加班审批</a></li>
    </ul>
    </div>
   
	<!--查询条件-->
    <br />
    <br />
    <ul class="seachform">
    <li>
      <label> 加班日期:</label><input name="" type="text" class="scinput"  value="请选择开始日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></li>
     <li>  <label> 到</label><input name="" type="text" class="scinput" value="请选择结束日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></li>
    <li>
    <label>姓名：</label>  
    <input name="" type="text" class="scinput" />
    </li>
    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询"/></li>
    </ul>
    </div>
    <table class="tablelist"><tbody><tr><td><table class="tablelist"><tbody><tr><td><table class="tablelist"><tbody><tr><td><table class="tablelist">
      <tbody>
        <tr>
          <td><table class="tablelist">
            <tbody>
              <tr>
                <td><table class="tablelist">
                      <tbody>
                        <tr>
                          <td><table class="tablelist">
                              <thead>
                                <tr>
                                  <th width="3%" height="45"><input name="input" type="checkbox" value="" checked="checked"/></th>
                                  <th width="7%">工号<i class="sort"><img src="../images/px.gif" /></i></th>
                                  <th width="11%">姓名</th>
                                  <th width="10%">加班日期</th>
                                  <th width="9%">开始时间</th>
                                  <th width="11%">终了时间</th>
                                  <th width="7%">加班原因</th>
                                  <th width="13%">操作</th>
                                </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${pb.list}" var="wrs" varStatus="s">
                                  <tr>
                                      <td><input name="uid" type="checkbox" value="${wrs.record_id}"/></td>
                                      <td>${wrs.account}</td>
                                      <td>${wrs.name}</td>
                                      <td>${wrs.work_date}</td>
                                      <td>${wrs.start_time}</td>
                                      <td>${wrs.end_time}</td>
                                      <td>${wrs.work_cause}</td>
                                      <td><span><a href="${pageContext.request.contextPath}/R02_PassWorkServlet?id=${wrs.record_id}" class="tablelink"><img src="../images/valid.png" onclick="confirm('确定审核通过吗？')"/></a>
                                          <a href="${pageContext.request.contextPath}/R03_RefuseWorkServlet?id=${wrs.record_id}" class="tablelink" onclick="confirm('确定要驳回？')"> <img src="../images/error.png" /></a></span></td>
                              </c:forEach>
                                <%--<tr>
                                  <td><input name="input" type="checkbox" value="" /></td>
                                  <td>20130901</td>
                                  <td>admin</td>
                                  <td>2013-09-09 </td>
                                  <td>08:30</td>
                                  <td>17:30</td>
                                  <td>参加讲座</td>
                                  <td><span><a href="#" class="tablelink"><img src="../images/valid.png" onclick="confirm('确定审核通过吗？')"/></a><a href="#" class="tablelink" onclick="confirm('确定要驳回？')"> <img src="../images/error.png" /></a></span></td>
                                </tr>
                                <tr>
                                  <td><input name="input" type="checkbox" value="" /></td>
                                  <td>20130902</td>
                                  <td>wanglin</td>
                                  <td>2018-09-09 </td>
                                  <td>08:30</td>
                                  <td>17:30</td>
                                  <td>参加讲座</td>
                                  <td><span><a href="#" class="tablelink"><img src="../images/valid.png" /></a><a href="#" class="tablelink"  onclick="confirm('确定通过当前消息？')" /> <a href="#" class="tablelink" onclick="confirm('确定要驳回当前消息？')"> <img src="../images/error.png" alt="驳回"/></a></span></td>
                                </tr>
                                <tr>
                                  <td><input name="input" type="checkbox" value="" /></td>
                                  <td>20130903</td>
                                  <td>wangli</td>
                                  <td>2015-09-10 </td>
                                  <td>08:30</td>
                                  <td>17:30</td>
                                  <td>参加培训</td>
                                  <td><span><a href="#" class="tablelink"><img src="../images/valid.png" /> </a><a href="#" class="tablelink"  onclick="confirm('确定通过当前消息？')" /><a href="#" class="tablelink" onclick="confirm('确定要驳回当前消息？')"> <img src="../images/error.png" /></a></span></td>
                                </tr>
                                <tr>
                                  <td><input name="input" type="checkbox" value="" /></td>
                                  <td>20130904</td>
                                  <td>zhangli</td>
                                  <td>2015-09-09 </td>
                                  <td>08:30</td>
                                  <td>17:30</td>
                                  <td>讨论技术问题</td>
                                  <td><span><a href="#" class="tablelink"><img src="../images/valid.png" /> </a><a href="#" class="tablelink"  onclick="confirm('确定通过当前消息？')" /><a href="#" class="tablelink" onclick="confirm('确定要驳回当前消息？')"> <img src="../images/error.png" /></a></span></td>
                                </tr>
                                <tr>
                                  <td><input name="input" type="checkbox" value="" /></td>
                                  <td>20130905</td>
                                  <td>zhang_lin</td>
                                  <td>2015-09-09 </td>
                                  <td>08:30</td>
                                  <td>17:30</td>
                                  <td>讨论技术问题</td>
                                  <td><span><a href="#" class="tablelink"><img src="../images/valid.png" /></a><a href="#" class="tablelink" onclick="confirm('确定要驳回当前消息？')"> <img src="../images/error.png" /></a></span></td>
                                </tr>--%>
                              </tbody>
                          </table></td>
                        </tr>
                      </tbody>
                  </table></td>
              </tr>
              </tbody>
          </table></td>
        </tr>
      </tbody>
    </table>
    </td>
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


<%--<div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
</div>--%>
    <div class="pagin">
        <div class="message">共<i class="blue">${pb.totalCount}</i>条记录，共 ${pb.totalPage} 页, 当前显示第&nbsp;<i class="blue">${pb.currentPage}&nbsp;</i>页</div>
        <ul class="paginList">
            <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
            <c:forEach begin="1" end="${pb.totalPage}" var="i">
                <c:if test="${pb.currentPage==i && (i <=5 || i >=pb.totalPage-4)}">
                    <li class="paginItem current"><a href="${pageContext.request.contextPath}/R01_FindWorkByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                </c:if>
                <c:if test="${pb.currentPage!=i && (i <=5 || i >=pb.totalPage-4)}">
                    <li class="paginItem"><a href="${pageContext.request.contextPath}/R01_FindWorkByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
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
