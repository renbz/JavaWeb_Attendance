<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" import="java.util.*" %>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="css/skin_/nav.css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/global.js"></script>
    <title>底部内容页</title>
</head>
<body>
<div id="rounded-corner">
    <div id="bd">
        <div class="sidebar">
            <div class="sidebar-bg"></div>
            <i class="sidebar-hide"></i>
            <ul class="nav">
                <li class="nav-li current">
                    <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">用户管理</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" href="index.jsp" data-id="1"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">首页</span></a></li>
                        <li class="subnav-li" href=/R08_FindUserByPageServlet?currentPage=1&rows=5" data-id="2"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">用户管理</span></a></li>
                    </ul>
                </li>
                <li class="nav-li last-nav-li">
                    <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">部门管理</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" data-id="10"  href="R01_FindDepartmentByPageServlet?currentPage=1&rows=5" ><a href="javascript:;" class="ue-clear" ><i class="subnav-icon"></i><span class="subnav-text">部门管理</span></a></li>
                    </ul>
                </li>

                <li class="nav-li last-nav-li">
                    <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">日报管理</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" data-id="12"  href="R01_FindReportByPageServlet?currentPage=1&rows=5" ><a href="javascript:;" class="ue-clear" ><i class="subnav-icon"></i><span class="subnav-text">日报管理</span></a></li>
                    </ul>
                </li>
                <li class="nav-li last-nav-li">
                    <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">加班管理</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" data-id="13"  href="/R01_FindWorkReByPageServlet?currentPage=1&rows=5" ><a href="javascript:;" class="ue-clear" ><i class="subnav-icon"></i><span class="subnav-text">加班申请</span></a></li>
                    </ul>
                </li>
                <li class="nav-li last-nav-li">
                    <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">休假管理</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" data-id="14"  href="/R01_FindRestReByPageServlet?currentPage=1&rows=5" ><a href="javascript:;" class="ue-clear" ><i class="subnav-icon"></i><span class="subnav-text">休假申请</span></a></li>
                    </ul>
                </li>
                <li class="nav-li last-nav-li">
                    <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">审批管理</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" data-id="15"  href="/R01_FindWorkByPageServlet?currentPage=1&rows=5" ><a href="javascript:;" class="ue-clear" ><i class="subnav-icon"></i><span class="subnav-text">加班审批</span></a></li>

                        <li class="subnav-li" data-id="16"  href="/R01_FindRestByPageServlet?currentPage=1&rows=5" ><a href="javascript:;" class="ue-clear" ><i class="subnav-icon"></i><span class="subnav-text">休假审批</span></a></li>
                    </ul>
                </li>
                <li class="nav-li last-nav-li">
                    <a  href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">个人信息修改</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" data-id="17"  href="${pageContext.request.contextPath}/R01_MyInfoEchoServlet" ><a href="javascript:;" class="ue-clear" ><i class="subnav-icon"></i><span class="subnav-text">个人信息修改</span></a></li>
                    </ul>
                </li>
                <li class="nav-li last-nav-li">
                    <a  href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">我的桌面</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" data-id="18"  href="${pageContext.request.contextPath}/R01_MyDeskTopServlet" ><a href="javascript:;" class="ue-clear" ><i class="subnav-icon"></i><span class="subnav-text">我的桌面</span></a></li>
                    </ul>
                </li>
            </ul>
            <div class="tree-list outwindow">
                <div class="tree ztree"></div>
            </div>
        </div>
        <div class="main">
            <div class="title">
                <i class="sidebar-show"></i>
                <ul class="tab ue-clear">

                </ul>
                <i class="tab-more"></i>
                <i class="tab-close"></i>
            </div>
            <div class="content">
            </div>
        </div>
    </div>
</div>

<div class="more-bab-list">
    <ul></ul>
    <div class="opt-panel-ml"></div>
    <div class="opt-panel-mr"></div>
    <div class="opt-panel-bc"></div>
    <div class="opt-panel-br"></div>
    <div class="opt-panel-bl"></div>
</div>

</body>
<script type="text/javascript" src="js/nav.js"></script>
<script type="text/javascript" src="js/Menu.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
    var menu = new Menu({
        defaultSelect: $('.nav').find('li[data-id="1"]')
    });


    $.fn.zTree.init($(".tree"), setting, zNodes);


    $('.sidebar h2').click(function(e) {
        $('.tree-list').toggleClass('outwindow');
        $('.nav').toggleClass('outwindow');
    });

    $(document).click(function(e) {
        if(!$(e.target).is('.tab-more')){
            $('.tab-more').removeClass('active');
            $('.more-bab-list').hide();
        }
    });
</script>
</html>
