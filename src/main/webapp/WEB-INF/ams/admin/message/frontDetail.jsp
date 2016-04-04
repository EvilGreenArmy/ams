<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<form action="${basePath}/message/add.do" method="post" id="message" name="message">
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
      <li><a href="#">业务管理</a></li>
      <li><a href="#">我的消息</a></li>
      <li><a href="#">消息详情</a></li>
    </ul>
  </div>
  <div class="formbody">
    <div class="formtitle"><span>消息信息</span></div>
    <ul class="forminfo">
      <li><label>消息标题<b>*</b></label><input name="title" id="title" type="text" value="${message.title}" class="dfinput" readonly />
      <li><label>发信人</label><input name="name" id="name" type="text"  value="${message.fromUser.userName}" class="dfinput" readonly />
      <li><label>消息内容<b>*</b></label>
          <textarea id="content" name="content" cols="" rows="" class="textinput" readonly >${message.content}</textarea>
      </li>
      <li><label>&nbsp;</label><input onclick="getData('${basePath}/message/add.do?toUserId=${message.fromUser.id}','','workspace');" type="button" class="btn" value="回复"/></li>
    </ul>
  </div>
</form>
