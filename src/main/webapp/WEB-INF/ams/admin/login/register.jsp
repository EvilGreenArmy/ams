<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>延安市科技计划项目申报系统</title>

  <link href="${pageContext.request.contextPath}/css/admin/register/base.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/admin/register/sign_style_xmsb.css" rel="stylesheet" type="text/css">

  <meta http-equiv="Pragma" content="no-cache">
  <script type="text/javascript" src="${basePath}/js/admin/layout/jquery.min.js"></script>
  <script type="text/javascript"
          src="${basePath}/js/admin/layer/layer.js"></script>
  <script type="text/javascript">
    // 验证身份证
    function checkIdNo() {
      var card = $("#acctName").val();
      var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
      if(!pattern.test(card)) {
        layer.msg('身份证号不合法！');
        return false;
      } else {
        return true;
      }
    }
    function checkName() {
      var name=$("#userName").val();
      // 判断名称
      if ($.trim(name).length == 0) {
        layer.msg('请输入姓名！');
        return false;
      } else {
        if (isChinaName($.trim(name)) == false) {
          layer.msg('姓名不合法！');
          return false;
        } else {
          return true;
        }
      }
    }
    // 验证中文名称
    function isChinaName(name){
      var pattern = /^[\u4E00-\u9FA5]{1,6}$/;
      return pattern.test(name);
    }
    function checkPhone() {
      var phone = $("#phone").val();
      // 判断手机号码
      if ($.trim(phone).length == 0) {
        layer.msg('请输入手机号码！');
        return false;
      } else {
        if(isPhoneNo($.trim(phone) == false)) {
          layer.msg('手机号码不合法！');
          return false;
        } else {
          return true;
        }
      }
    }
    // 验证手机号
    function isPhoneNo(phone) {
      var pattern = /^1[34578]\d{9}$/;
      return pattern.test(phone);
    }
    function checkEmail() {
      var email = $("#email").val();
      // 判断手机号码
      if ($.trim(email).length == 0) {
        layer.msg('请输入电子邮箱！');
        return false;
      } else {
        if(isEmail($.trim(email) == false)) {
          layer.msg('电子邮箱不合法！');
          return false;
        } else {
          return true;
        }
      }
    }
    function isEmail(str){
      var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
      return reg.test(str);
    }
    function checkPasswdLength() {
      var pwd = $("#passwd1").val();
      if ($.trim(pwd).length == 0) {
        layer.msg('请输入登录密码！');
        return false;
      } else {
        return true;
      }
    }
    function checkPassword() {
      var password = $("#passwd1").val();
      var repeat = $("#passwd2").val();
      if($.trim(password) != $.trim(repeat)) {
        layer.msg('两次登录密码不一致！');
        return false;
      } else {
        return true;
      }
    }
    function button_onsubmit() {
      if(checkIdNo()) {
        if(checkName()) {
          if(checkPhone()) {
            if(checkEmail()) {
              if(checkPasswdLength()) {
                if(checkPassword()) {
                  $("#accountForm").submit();
                }
              }
            }
          }
        }
      }
    }
  </script>

</head>

<body>

<div class="header"> </div>

<div class="form-title" id="form_title2">
  <img src="${pageContext.request.contextPath}/img/admin/register/sign_form_title.png"><h2>用户注册</h2><span>（<font style="color:red;font-size:16px; font-weight:bold;margin:16px 6px 0 6px;padding-top:4px;">*</font>标示项目为必填项）&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">说明：注册时须填写项目负责人的身份证号，同时应录入其真实姓名，此姓名在填写申报信息时将自动显示且不可更改，请知悉。</font></span></div>


<div class="form-main" id="form_div2">
  <form name="accountForm" id="accountForm" method="post" action="${basePath}/admin/register.do">
    <input type="hidden" name="xmsbRegister.flag" value="0">
    <table class="sign-table">

      <tbody>
      <tr class="">
        <td width="30%" align="right">
          身份证号<font color="red">*</font>：
        </td>
        <td class="" width="70%">
          <input type="text" id="acctName" name="acctName" value="" class="input-sign" length="25" onblur="checkIdNo()">
        </td>
      </tr>

      <tr class="">
        <td width="30%" align="right">
          姓名<font color="red">*</font>：
        </td>
        <td class="" width="70%">
          <input type="text" id="userName" name="userName" value="" class="input-sign" length="25" onblur="checkName()">
        </td>
      </tr>

      <tr class="">
        <td width="30%" align="right">
          手机号码<font color="red">*</font>：
        </td>
        <td class="" width="70%">
          <input type="text" id="phone" name="phone" value="" class="input-sign" length="25" onblur="checkPhone()">
        </td>
      </tr>

      <tr class="">
        <td width="30%" align="right">
          电子邮箱<font color="red">*</font>：
        </td>
        <td class="" width="70%">
          <input type="text" id="email" name="email" value="" class="input-sign" length="25" onblur="checkEmail()">
        </td>
      </tr>

      <tr class="">
        <td width="30%" align="right">
          登录密码<font color="red">*</font>：
        </td>
        <td class="" width="70%">
          <input type="password" id="passwd1" name="password" value="" class="input-sign" length="25" onblur="checkPasswdLength()">
        </td>
      </tr>

      <tr class="">
        <td width="30%" align="right">
          确认密码<font color="red">*</font>：
        </td>
        <td class="" width="70%">
          <input type="password" id="passwd2" value="" class="input-sign" length="25" onblur="checkPassword()">
        </td>
      </tr>

      </tbody><tfoot>
    <tr>
      <td colspan="2">
        <input type="button" name="accountBtn" value="提交" class="btn-normal" onclick="button_onsubmit()">
        <input type="button" name="" value="取消" class="btn-normal" onclick="gotoBack()">
      </td>
    </tr>
    </tfoot>
    </table>
  </form>
</div>

</body>

</html>