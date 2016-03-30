<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript">
  function saveRole() {

    if($("#name").val() == '') {
      $("#name").next("i").text('角色名称不能为空');
      return;
    } else {
      $("#name").next("i").text('')
    }
    //保存
    //询问框
    layer.confirm('确定要保存数据吗？', {
      btn: ['确定','取消'] //按钮
    }, function(){
      trimForm('role');
      layer.closeAll();
      postDataByFormName('role','workspace');
    }, function(){
    });
  }
</script>
<form action="${basePath}/role/add.do" method="post" id="role" name="role">
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
      <li><a href="#">系统管理</a></li>
      <li><a href="#">角色管理</a></li>
      <li><a href="#">新增角色</a></li>
    </ul>
  </div>

  <div class="formbody">

    <div class="formtitle"><span>角色信息</span></div>
    <ul class="forminfo">
      <li><label>角色</label><input name="name" id="name" type="text" class="dfinput"  /><i style="color: red;"></i></li>
      <li><label>描述</label><textarea name="description" id="description" cols="" rows="" class="textinput"></textarea></li>
      <li><label>&nbsp;</label><input onclick="saveRole();" type="button" class="btn" value="确认保存"/></li>
    </ul>
  </div>
</form>
