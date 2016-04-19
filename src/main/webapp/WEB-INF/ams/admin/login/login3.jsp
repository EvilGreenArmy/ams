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
      var userName = $("#userName").val();
      var password = $("#password").val();
      if(userName == '') {
        $("#errMsg").text('用户名不能为空');
        return;
      }
      if(password == '') {
        $("#errMsg").text('密码不能为空');
        return
      }
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
    <li><a href="${pageContext.request.contextPath}/index.jsp">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
  </ul>
</div>

<div class="loginbody">

  <!--<span class="systemlogo"></span>-->
  <div style="width: 100%; height: 200px;">
      <p style="height: 150px;"></p>
      <div style="text-align: center; font-size: 34px; line-height:30px; font-weight: bold; color: #ffffff; font-family: 宋体; ">
          <img width="60" height="60" src="${pageContext.request.contextPath}/img/admin/login/loginlogo1.png" alt="" style="position:relative; top:20px;"/> 大众创业和科技对接系统
      </div>
  </div>
  <form action="${pageContext.request.contextPath}/admin/login.do" method="post" id="loginForm">
    <div class="loginbox">
      <ul>
        <li><input id="userName" name="userName" type="text" class="loginuser" placeholder="用户名"   onclick="JavaScript:this.value=''"/></li>
        <li><input id="password" name="password" type="password" class="loginpwd" placeholder="密码"  onclick="JavaScript:this.value=''"/></li>
        <li style="width:100%;white-space:nowrap">
          <input name="" type="button" class="loginbtn" value="登录"  onclick="doLogin();"  />
          <label id="errMsg" style="color:red">
            <c:if test="${errMsg != null}">
                <c:out value="${errMsg}"/>
            </c:if>
          </label>
        </li>
      </ul>
    </div>
  </form>

</div>



<div class="loginbm">Copyright &copy; 2016 延安科技局版权所有</div>
</body>
</html>

