<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript">
  function saveCategory() {
    if($("#name").val() == '') {
      $("#name").next("i").text('字典名称不能为空');
      return;
    } else {
      $("#name").next("i").text('');
      //checkName($("#name").val());
    }
      //询问框
      layer.confirm('确定要保存数据吗？', {
          btn: ['确定','取消'] //按钮
      }, function(){
          trimForm('category');
          layer.closeAll();
          postDataByFormName('category','workspace');
      }, function(){
      });
  }
  function checkName(val) {
    $.ajax({
      type: "GET",
      url: '${basePath}/category/checkCategoryName.do?t=' + Math.random(),
      data: {name:val},
      dataType: "json",
      success: function(data) {
        data = eval("(" + data +")");
        if(data.state != '0') {
          $("#name").next('i').text(val + '已经存在');
          return false;
        } else {
          //保存
          //询问框
          layer.confirm('确定要保存数据吗？', {
            btn: ['确定','取消'] //按钮
          }, function(){
            trimForm('category');
            layer.closeAll();
            postDataByFormName('category','workspace');
          }, function(){
          });
        }
      }
    });
  }
</script>
<form action="${basePath}/category/edit.do" method="post" id="category" name="category">
    <input type="hidden" name="parentId" value="${category.parent.id}"/>
    <input type="hidden" name="id" value="${category.id}"/>
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
      <li><a href="#">系统管理</a></li>
      <li><a href="#">字典管理</a></li>
      <li><a href="#">添加字典</a></li>
    </ul>
  </div>
  <div class="formbody">
    <div class="formtitle"><span>字典信息</span></div>
    <ul class="forminfo">
      <li><label>字典名称</label><input name="name" id="name" type="text" class="dfinput" value="${category.name}"/><i style="color: red;"></i></li>
        <li><label>状态</label><cite>
            <input name="status" type="radio" value="A" <c:if test="${'A' eq category.status}"> checked="checked" </c:if> />启用&nbsp;&nbsp;&nbsp;&nbsp;
            <input name="status" type="radio" value="D" <c:if test="${'A' ne category.status}"> checked="checked" </c:if> />禁用</cite>
        </li>
      <li><label>&nbsp;</label><input onclick="saveCategory();" type="button" class="btn" value="确认保存"/></li>
    </ul>
  </div>
</form>
