<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
  .apply-detail {
    display: block;
    clear: both;
    overflow: hidden;
    padding: 0.83333rem 0.66667rem;
    border-bottom: 0.08333rem dotted #e0e0e0;
    background-color: #fff;
  }
  .form-list li select, .form-list li input[type="text"], .form-list li input[type="password"] {
    height: 3.16667rem;
    line-height: 3.16667rem;
    width: 100%;
    -moz-border-radius: 0.25rem;
    -webkit-border-radius: 0.25rem;
    border-radius: 0.25rem;
    border: 0.08333rem solid #e0e0e0;
    font-size: 1.08333rem;
    background-color: #fff;
    color: #999999;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
  }
  .form-list li {
    display: block;
    clear: both;
    padding-bottom: 1.25rem;
    font-size: 1.08333rem;
    position: relative;
  }
  .btn {
    width: 137px;
    height: 35px;
    background: url('${basePath}/img/admin/login/btnbg.png') no-repeat;
    font-size: 14px;
    font-weight: bold;
    color: #fff;
    cursor: pointer;
    border-radius: 2px;
  }
</style>
<script type="text/javascript" src="${basePath}/js/admin/layout/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}/js/admin/layer/layer.js"></script>
<script type="text/javascript">
  function modify() {
    var oldPassword = $("#oldPassword").val();
    if(oldPassword== null || oldPassword == '') {
      layer.msg('原密码不能为空！');
      return;
    }
    var newPassword = $("#newPassword").val();
    if(newPassword== null || newPassword == '') {
      layer.msg('新密码不能为空！');
      return;
    }
    var newPasswordReply = $("#newPasswordReply").val();
    if(newPasswordReply== null || newPasswordReply == '') {
      layer.msg('两次密码不一致！');
      return;
    }
    if(newPasswordReply != newPassword) {
      layer.msg('两次密码不一致！');
      return;
    }
    $.ajax({
      type: "POST",
      url: '${basePath}/admin/modifyPassword.do',
      data: {oldPassword:oldPassword,newPassword:newPassword,newPasswordReply:newPasswordReply},
      dataType: "json",
      success: function(data) {
        data = JSON.parse(data);
        if(data.state != '1') {
          layer.msg(data.errMsg);
          return;
        } else {
          layer.msg('密码修改成功！');
          setTimeout(function() {
            parent.layer.closeAll();
          },1000);


        }
      }
    });
  }
</script>
<div class="apply-detail">
<form class="formBox" action="${basePath}/user/add.do" method="post" id="user" name="user">
  <ul class="form-list">
    <li>
      <input id="oldPassword" name="oldPassword" type="password" oncopy="return false" maxlength="20" autocomplete="off" onpaste="return false" placeholder="请输入原密码"/>
    </li>
    <li>
      <input id="newPassword" name="newPassword" type="password"  oncopy="return false" maxlength="20" autocomplete="off" onpaste="return false" placeholder="请输入6-20位密码"/>
    </li>
    <li>
      <input  id="newPasswordReply" name="newPasswordReply" type="password"  oncopy="return false" maxlength="20" autocomplete="off" onpaste="return false" placeholder="请输入6-20位新密码"/>
    </li>
  </ul>
  <div style="text-align: center">
    <input type="button" id="resubmit"  value="保存修改" class="btn" onclick="modify();" >
  </div>

</form>
</div>