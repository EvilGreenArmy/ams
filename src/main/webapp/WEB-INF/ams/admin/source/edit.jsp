<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript">
  function saveSource() {

    if($("#name").val() == '') {
      $("#name").next("i").text('菜单名称不能为空');
      return;
    } else {
      $("#name").next("i").text('')
    }
    //保存
    //询问框
    layer.confirm('确定要保存数据吗？', {
      btn: ['确定','取消'] //按钮
    }, function(){
      trimForm('source');
      layer.closeAll();
      postDataByFormName('source','workspace');
    }, function(){
    });
  }
</script>
<form action="${basePath}/source/edit.do" method="post" id="source" name="source">
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
      <li><a href="#">系统管理</a></li>
      <li><a href="#">菜单管理</a></li>
      <li><a href="#">修改菜单</a></li>
    </ul>
  </div>

  <div class="formbody">
    <input type="hidden" id="id" name="id" value="${source.id}" readonly />
    <div class="formtitle"><span>菜单信息</span></div>

    <ul class="forminfo">
      <li><label>菜单名称</label><input name="name" value="${source.name}" readonly id="name" type="text" class="dfinput"  /><i></i></li>
      <li><label>描述</label><textarea name="description" id="description"  cols="" rows="" class="textinput">${source.description}</textarea></li>
      <li><label>&nbsp;</label><input onclick="saveSource();" type="button" class="btn" value="确认保存"/></li>
    </ul>
  </div>
</form>
