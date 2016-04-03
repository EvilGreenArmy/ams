<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="topleft">
  <img src="${pageContext.request.contextPath}/img/admin/login/pic_logo_kjjh.png" title="系统首页" />
</div>

<ul class="nav">
  <%--<li><a href="javascript:;" class="selected"><img src="${pageContext.request.contextPath}/img/admin/login/icon01.png" title="工作台" /><h2>工作台</h2></a></li>
  <li><a href="javascript:;" ><img src="${pageContext.request.contextPath}/img/admin/login/icon02.png" title="模型管理" /><h2>模型管理</h2></a></li>
  <li><a href="javascript:;" ><img src="${pageContext.request.contextPath}/img/admin/login/icon03.png" title="模块设计" /><h2>模块设计</h2></a></li>
  <li><a href="javascript:;" ><img src="${pageContext.request.contextPath}/img/admin/login/icon04.png" title="常用工具" /><h2>常用工具</h2></a></li>
  <li><a href="javascript:;" ><img src="${pageContext.request.contextPath}/img/admin/login/icon05.png" title="文件管理" /><h2>文件管理</h2></a></li>
  <li><a href="javascript:;" ><img src="${pageContext.request.contextPath}/img/admin/login/icon06.png" title="系统设置" /><h2>系统设置</h2></a></li>--%>
</ul>

<div class="topright">
  <ul>
    <li><span><img src="${pageContext.request.contextPath}/img/admin/login/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="${pageContext.request.contextPath}/member/logout.do">退出</a></li>
  </ul>

  <div class="user">
    <span>admin</span>
    <i>消息</i>
    <b>5</b>
  </div>
</div>
<script type="text/javascript">
  $(function(){
    //顶部导航切换
    $(".nav li a").click(function(){
      $(".nav li a.selected").removeClass("selected")
      $(this).addClass("selected");
    })
  })
</script>