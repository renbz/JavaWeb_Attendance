<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html >
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/skin_/main.css" />
    <link rel="stylesheet" type="text/css" href="css/jquery.dialog.css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/global.js"></script>
    <title>考勤管理系统</title>
</head>
<body>
<div class="exitDialog">
    <div class="content">
        <div class="ui-dialog-icon"></div>
        <div class="ui-dialog-text">
            <p class="dialog-content">你确定要退出系统？</p>
            <p class="tips">如果是请点击“确定”，否则点“取消”</p>

            <div class="buttons">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="取消" />
            </div>
        </div>

    </div>
</div>


<div class="opt-panel skin-opt" style="top:36px;right:157px;">
    <ul class="ue-clear">
        <li attr-color="#0f8dc7"></li>
        <li attr-color="#1ea4a9"></li>
        <li attr-color="#eb7f00"></li>
        <li attr-color="#ed0f04"></li>
        <li attr-color="#f24b39"></li>
        <li attr-color="#ed0f04"></li>
        <li attr-color="#eb7f00"></li>
        <li attr-color="#ed0f04"></li>
        <li attr-color="#1ea4a9"></li>
    </ul>
    <div class="opt-panel-ml"></div>
    <div class="opt-panel-mr"></div>
    <div class="opt-panel-bl"></div>
    <div class="opt-panel-bc"></div>
    <div class="opt-panel-br"></div>
</div>
<div class="opt-panel-mr"></div>
<div class="opt-panel-bc"></div>
<div class="opt-panel-br"></div>
</div>

<div id="container">
    <div id="hd">
        <div class="hd-top">
            <div class="user-info"> <a href="javascript:;" class="user-avatar"><span><i class="info-num">2</i></span></a> <span class="user-name">${username}</span> <a href="javascript:;" class="more-info"></a> </div>
            <div class="setting ue-clear">
                <ul class="setting-main ue-clear">
                    <li><a href="javascript:;" class="close-btn exit"></a></li>
                </ul>
            </div>
        </div>

        <a>
            <div id="bd">
                <iframe width="100%" height="100%" id="mainIframe" src="nav.jsp" frameborder="0"></iframe>
            </div>
            <div id="ft" class="ue-clear">
                <div class="ft2 ue-clear"> <em>InspurUptec</em> <i class="ft-icon2"></i> </div>
            </div>
        </a></div>
</body>
<script type="text/javascript" src="js/core.js"></script>
<script type="text/javascript" src="js/jquery.dialog.js"></script>
<script type="text/javascript">
    $("#bd").height($(window).height()-$("#hd").outerHeight()-26);

    $(window).resize(function(e) {
        $("#bd").height($(window).height()-$("#hd").outerHeight()-26);

    });

    $('.exitDialog').Dialog({
        title:'提示信息',
        autoOpen: false,
        width:400,
        height:200
    });

    $('.exit').click(function(){
        $('.exitDialog').Dialog('open');
    });

    $('.exitDialog input[type=button]').click(function(e) {
        $('.exitDialog').Dialog('close');

        if($(this).hasClass('ok')){
            window.location.href = "login.jsp"	;
        }
    });

    (function(){
        var totalWidth = 0, current = 1;

        $.each($('.nav').find('li'), function(){
            totalWidth += $(this).outerWidth();
        });

        $('.nav').width(totalWidth);

        function currentLeft(){
            return -(current - 1) * 93;
        }

        $('.nav-btn a').click(function(e) {
            var tempWidth = totalWidth - ( Math.abs($('.nav').css('left').split('p')[0]) + $('.nav-wrap').width() );
            if($(this).hasClass('nav-prev-btn')){
                if( parseInt($('.nav').css('left').split('p')[0])  < 0){
                    current--;
                    Math.abs($('.nav').css('left').split('p')[0]) > 93 ? $('.nav').animate({'left': currentLeft()}, 200) : $('.nav').animate({'left': 0}, 200);
                }
            }else{

                if(tempWidth  > 0)	{

                    current++;
                    tempWidth > 93 ? $('.nav').animate({'left': currentLeft()}, 200) : $('.nav').animate({'left': $('.nav').css('left').split('p')[0]-tempWidth}, 200);
                }
            }
        });



        $.each($('.skin-opt li'),function(index, element){
            if((index + 1) % 3 == 0){
                $(this).addClass('third');
            }
            $(this).css('background',$(this).attr('attr-color'));
        });

        $('.setting-skin').click(function(e) {
            $('.skin-opt').show();
        });

        $('.skin-opt').click(function(e) {
            if($(e.target).is('li')){
                alert($(e.target).attr('attr-color'));
            }
        });

        $('.hd-top .user-info .more-info').click(function(e) {
            $(this).toggleClass('active');
            $('.user-opt').toggle();
        });

        $('.logo-icon').click(function(e) {
            $(this).toggleClass('active');
            $('.system-switch').toggle();
        });

        hideElement($('.user-opt'), $('.more-info'), function(current, target){

            $('.more-info').removeClass('active');
        });

        hideElement($('.skin-opt'), $('.switch-bar'));

        hideElement($('.system-switch'), $('.logo-icon'), function(current, target){

            $('.logo-icon').removeClass('active');
        });

    })();

</script>

</html>
