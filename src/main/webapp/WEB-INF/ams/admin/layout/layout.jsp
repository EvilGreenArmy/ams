<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<!-- saved from url=(0047)http://layout.jquery-dev.com/demos/example.html -->
<html style="overflow: hidden; height: 100%; border: none; padding: 0px; margin: 0px;">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <title><tiles:getAsString name="title" /></title>
    <style>
        *{ margin: 0;padding:0;}
        .content_body .top_head{ width:100%; height: 88px;}
        .sidebar_box{ overflow: hidden;}
        .pull_left{ float:left;}
        .clear{ clear:both;}
        .left_side{background:#f0f9fd;}
        /** list search css **/
        fieldset {
            display: block;
            -webkit-margin-start: 2px;
            -webkit-margin-end: 2px;
            -webkit-padding-before: 0.35em;
            -webkit-padding-start: 0.75em;
            -webkit-padding-end: 0.75em;
            -webkit-padding-after: 0.625em;
            min-width: -webkit-min-content;
            border: 1px solid #ccc;
            padding:20px;
            margin-bottom: 20px;
        }
        fieldset legend{ padding:0 10px;}
        .seach_box{ margin-bottom: 10px;}
        .seach_box legend{ font-weight: bold;}
        .seach_box table{ width:100%;table-layout: fixed}
        .seach_box table .tabel_title{width:25%;; text-overflow: ellipsis; white-space: nowrap; overflow: hidden;}
        .seach_box table .table_cont{ width:45%;}
        .seach_box table td{ height:40px; border:1px solid #ccc; border-collapse: collapse; padding:0 10px;}
        .search_input{border:1px solid #ccc; border-radius: 3px; width: 90%; padding-left:10px; height:26px; line-height:16px; margin-right:10px; display:block; float:left;}
        .search_btn{  border:1px solid #ccc; border-radius: 3px;line-height:26px; color:#333; padding:0 20px;}
        .search_btn:hover{ background:rgb(61,128,218); color:#fff;}
        .right_side{ overflow: auto;}

    </style>
    <link href="${basePath}/css/admin/login/style.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/css/admin/login/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${basePath}/js/admin/layout/jquery.min.js"></script>
    <script type="text/javascript" src="${basePath}/js/admin/layout/common.js"></script>
    <script type="text/javascript" src="${basePath}/js/admin/select-ui.min.js"></script>
    <style type="text/css"></style>
    <script type="text/javascript"
            src="${basePath}/js/admin/layout/jquery.layout-latest.js"></script>
    <script type="text/javascript"
            src="${basePath}/js/admin/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript"
            src="${basePath}/js/admin/layer/layer.js"></script>
    <script type="text/javascript">
        function goIndex() {
            window.location.href = "${basePath}/admin/index.do";
        }
        $(function(){
            right_side();
        })
        $(window).resize(function(){
            right_side();
        })
        function right_side(){
            var win_width = $(window).width();
            var win_height = $(window).height();
            var sidebar_height = win_height-88;
            var left_min_width =186;
            var left_width = $(".left_side").width();
            var right_width = $(".right_side").width();
            /*left_width < left_min_width ？ $(".left_side").css("width",left_min_width) :$(".left_side").css("width",left_width);*/
            $(".left_side").css("width",left_min_width);
            $(".right_side").css("width",win_width-left_min_width);
            $(".left_side").css("height",sidebar_height);
            $(".right_side").css("height",sidebar_height);
        }
    </script>
</head>
<body>
<div class="content_body">
    <div class="top_head" style="background:url(${pageContext.request.contextPath}/img/admin/login/topbg.gif) repeat-x;">
        <tiles:insertAttribute name="header" />
    </div>
    <div class="sidebar_box">
        <div class="pull_left left_side">
            <tiles:insertAttribute name="navigation" />
        </div>
        <div class="pull_left right_side" id="workspace">
        </div>
    </div>
</div>

</body>
</html>