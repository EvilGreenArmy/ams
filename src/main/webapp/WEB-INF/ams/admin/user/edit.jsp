<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript">
  function saveUser() {

    if($("#userName").val() == '') {
      $("#userName").next("i").text('用户名不能为空');
      return;
    } else {
      $("#userName").next("i").text('')
    }
    if(!checkEmail()) {
        return;
    } else {
      $("#email").next("i").text('')
    }
    var phone = $("#phone").val();
    if(!checkPhone(phone) && phone != '') {
      return;
    } else {
      $("#phone").next("i").text('')
    }
    if($("#acctName").val() == '') {
      $("#acctName").next("i").text('账号不能为空');
      return;
    } else {
      $("#acctName").next("i").text('');
      checkAcctName($("#acctName").val());
    }
  }
  function checkEmail() {
    var email = $("#email").val();
    if (!isEmail(email) && email != '') {
      $("#email").next("i").text("您输入的邮箱有误,请重新核对后再输入");
      return false;
    }
    return true;
  }
  function isEmail(str){
    var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    return reg.test(str);
  }
  function checkPhone(mobile) {
    if(mobile.length > 0) {
      if (mobile.length != 11) {
        $("#phone").next("i").text('请输入有效的手机号码');
        return false;
      }
      var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
      if (!myreg.test(mobile)) {
        $("#phone").next("i").text('请输入有效的手机号码');
        return false;
      }
      return true;
    }
  }
  function checkAcctName(val) {
    var id = $("#id").val();
    $.ajax({
      type: "POST",
      url: '${basePath}/user/checkAcctName.do?t=' + Math.random(),
      data: {acctName:val, id :id},
      dataType: "json",
      success: function(data) {
        data = eval("(" + data +")");
        if(data.state != '0') {
          $("#acctName").next('i').text(val + '已经存在');
          return false;
        } else {
          //保存
          //询问框
          layer.confirm('确定要保存数据吗？', {
            btn: ['确定','取消'] //按钮
          }, function(){
            trimForm('user');
            layer.closeAll();
            postDataByFormName('user','workspace');
          }, function(){
          });
        }
      }
    });
  }
</script>
<form action="${basePath}/user/edit.do" method="post" id="user" name="user">
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
      <li><a href="#">系统管理</a></li>
      <li><a href="#">用户管理</a></li>
      <li><a href="#">修改用户</a></li>
    </ul>
  </div>

  <div class="formbody">
    <input type="hidden" id="id" name="id" value="${user.id}" readonly />
    <div class="formtitle"><span>用户信息</span></div>

    <ul class="forminfo">
      <li><label>账号</label><input name="acctName" value="${user.acctName}" readonly id="acctName" type="text" class="dfinput"  /><i></i></li>
      <li><label>用户名</label><input name="userName" value="${user.userName}" id="userName" type="text" class="dfinput" /><i style="color: red;"></i></li>
      <li><label>用户名全称</label><input name="fullName" value="${user.fullName}" id="fullName" type="text" class="dfinput" /></li>
      <li><label>状态</label><cite>
        <input name="status" type="radio" value="A" <c:if test="${'A' eq user.status}">checked="checked"</c:if> />启用&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="status" type="radio" value="D" <c:if test="${'D' eq user.status}">checked="checked"</c:if> />禁用</cite>
      </li>
      <%--<li><label>生日</label><input name="birthday" id="birthday" readonly type="text" class="dfinput" onClick="WdatePicker({el:'birthday',dateFmt:'yyyy-MM-dd'});"/><i></i></li>--%>
      <li><label>性别</label><cite>
        <input name="gender"  type="radio" value="1" <c:if test="${'1' eq user.gender}">checked="checked"</c:if> />男&nbsp;&nbsp;&nbsp;&nbsp;
        <input name="gender" type="radio" value="0" <c:if test="${'0' eq user.gender}">checked="checked"</c:if> />女</cite>
      </li>

      <li><label>电子邮件</label><input name="email" id="email" value="${user.email}" type="text" class="dfinput" /><i style="color: red;"></i></li>
      <li><label>手机</label><input name="phone" id="phone" value="${user.phone}" type="text" class="dfinput" /><i style="color: red;"></i></li>
      <li><label>&nbsp;</label><input onclick="saveUser();" type="button" class="btn" value="确认保存"/></li>
    </ul>
  </div>
</form>
