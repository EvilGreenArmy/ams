<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>欢迎登录延安科技成果转换系统</title>
  <link href="${pageContext.request.contextPath}/css/admin/login/style.css" rel="stylesheet" type="text/css" />
  <script language="JavaScript" src="${pageContext.request.contextPath}/js/admin/jquery.js"></script>
  <script src="${pageContext.request.contextPath}/js/admin/cloud.js" type="text/javascript"></script>

  <script language="javascript">
    $(function(){
        $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
        $(window).resize(function(){
          $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
        })
    });
    function doLogin() {
      $("#loginForm").submit();
    }
  </script>

</head>

<body style="background-color:#1c77ac; background-image:url(${pageContext.request.contextPath}/img/admin/login/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



<div id="mainBody">
  <div id="cloud1" class="cloud"></div>
  <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
  <span>欢迎登录后台管理界面平台</span>
  <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
  </ul>
</div>

<div class="loginbody">

  <span class="systemlogo"></span>
  <form action="login.do" method="post" id="loginForm">
    <div class="loginbox">
      <ul>
        <li><input name="" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
        <li><input name="" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/></li>
        <li><input name="" type="button" class="loginbtn" value="登录"  onclick="doLogin();"  /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
      </ul>
    </div>
  </form>

</div>



<div class="loginbm">Copyright &copy; 2016 延安科技局版权所有</div>
</body>
</html>

