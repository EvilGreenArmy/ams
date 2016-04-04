<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0051)http://221.11.34.116:8081/yakj/xmsb/register.action -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>延安市科技计划项目申报系统</title>

  <link href="${pageContext.request.contextPath}/css/admin/register/base.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/admin/register/sign_style_xmsb.css" rel="stylesheet" type="text/css">

  <meta http-equiv="Pragma" content="no-cache">
 <%-- <script language="javascript" type="text/javascript" src="./延安市科技计划项目申报系统_files/WdatePicker.js"></script><style type="text/css"></style>
  <script src="./延安市科技计划项目申报系统_files/common.js"></script>
  <script type="text/javascript" src="./延安市科技计划项目申报系统_files/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="./延安市科技计划项目申报系统_files/jquery.form.js"></script>--%>
</head>

<body>

<div class="header"> </div>

<div class="form-title" id="form_title2">
  <img src="${pageContext.request.contextPath}/img/admin/register/sign_form_title.png"><h2>用户注册</h2><span>（<font style="color:red;font-size:16px; font-weight:bold;margin:16px 6px 0 6px;padding-top:4px;">*</font>标示项目为必填项）&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">说明：注册时须填写项目负责人的身份证号，同时应录入其真实姓名，此姓名在填写申报信息时将自动显示且不可更改，请知悉。</font></span></div>


<div class="form-main" id="form_div2">
  <form name="accountForm" id="accountForm" method="post" action="">
    <input type="hidden" name="xmsbRegister.flag" value="0">
    <table class="sign-table">

      <tbody><tr class="">
        <td width="30%" align="right">
          身份证号<font color="red">*</font>：
        </td>
        <td class="" width="70%">
          <input type="text" id="loginName" name="xmsbRegister.username" value="" class="input-sign" length="25&quot;" onblur="checkLoginName()">
          <div id="div1"></div>
        </td>
      </tr>

      <tr class="">
        <td width="30%" align="right">
          姓名<font color="red">*</font>：
        </td>
        <td class="" width="70%">
          <input type="text" id="realName" name="xmsbRegister.realName" value="" class="input-sign" length="25&quot;" onblur="checkName()">
          <div id="div6"><img src="${pageContext.request.contextPath}/img/admin/register/error.gif" width="15px" height="15px">&nbsp;<font color="red">姓名不能为空！</font></div>
        </td>
      </tr>

      <tr class="">
        <td width="30%" align="right">
          手机号码<font color="red">*</font>：
        </td>
        <td class="" width="70%">
          <input type="text" id="cellphone" name="xmsbRegister.cellphone" value="" class="input-sign" length="25&quot;" onblur="checkPhone()">
          <div id="div2"></div>
        </td>
      </tr>

      <tr class="">
        <td width="30%" align="right">
          电子邮箱<font color="red">*</font>：
        </td>
        <td class="" width="70%">
          <input type="text" id="email" name="xmsbRegister.email" value="" class="input-sign" length="25&quot;" onblur="checkEmail()">
          <div id="div3"></div>
        </td>
      </tr>

      <tr class="">
        <td width="30%" align="right">
          登录密码<font color="red">*</font>：
        </td>
        <td class="" width="70%">
          <input type="password" id="passwd1" name="xmsbRegister.password" value="" class="input-sign" length="25&quot;" onblur="checkPasswdLength()">
          <div id="div4"></div>
        </td>
      </tr>

      <tr class="">
        <td width="30%" align="right">
          确认密码<font color="red">*</font>：
        </td>
        <td class="" width="70%">
          <input type="password" id="passwd2" value="" class="input-sign" length="25&quot;" onblur="checkPassword()">
          <div id="div5"></div>
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

</body></html>