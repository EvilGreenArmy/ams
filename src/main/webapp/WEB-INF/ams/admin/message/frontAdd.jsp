<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript">
  function sendMessage() {
    if($("#title").val() == '') {
      $("#title").next("i").text('标题不能为空');
      return;
    } else {
      $("#title").next("i").text('');
    }
      if($("#content").val() == '') {
          $("#content").next("i").text('消息内容不能为空');
          return;
      } else {
          $("#content").next("i").text('');
      }

      //询问框
      layer.confirm('确定要发送消息吗？', {
          btn: ['确定','取消'] //按钮
      }, function(){
          layer.closeAll();
          trimForm('message');
          postDataByFormName('message','workspace');
      }, function(){
      });


  }

</script>
<form action="${basePath}/message/add.do" method="post" id="message" name="message">
    <input type="hidden" name="toUserId" value="${toUser.id}"/>
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
      <li><a href="#">业务管理</a></li>
      <li><a href="#">我的消息</a></li>
      <li><a href="#">发送消息</a></li>
    </ul>
  </div>
  <div class="formbody">
    <div class="formtitle"><span>消息信息</span></div>
    <ul class="forminfo">
      <li><label>消息标题<b>*</b></label><input name="title" id="title" type="text" class="dfinput" /><i style="color: red;"></i></li>
      <li><label>收信人</label><input name="name" id="name" type="text" value="${toUser.userName}" class="dfinput" /><i style="color: red;"></i></li>
      <li><label>消息内容<b>*</b></label>
          <textarea id="content" name="content" cols="" rows="" class="textinput"></textarea><i style="color: red;"></i>
      </li>
      <li><label>&nbsp;</label><input onclick="sendMessage();" type="button" class="btn" value="确认发送"/></li>
    </ul>
  </div>
</form>
