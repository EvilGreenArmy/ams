<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript">
  function saveTimeliness() {


    //保存
    //询问框
    layer.confirm('确定要保存数据吗？', {
      btn: ['确定','取消'] //按钮
    }, function(){
      trimForm('timeliness');
      layer.closeAll();
      postDataByFormName('timeliness','workspace');
    }, function(){
    });
  }
  $(document).ready(function(e) {
      $(".select1").uedSelect({
          width: 345
      });
  });
</script>
<form action="${basePath}/timeliness/edit.do" method="post" id="timeliness" name="timeliness">
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
      <li><a href="#">系统管理</a></li>
      <li><a href="#">时效规则</a></li>
    </ul>
  </div>

  <div class="formbody">

    <div class="formtitle"><span>时效规则</span></div>
    <ul class="forminfo">
        <li><label>时效规则</label>
            <div class="vocation">
                <select class="select1" name="timeliness">
                    <option value="1" <c:if test="${timeliness eq 1}"> selected </c:if> >天</option>
                    <option value="7" <c:if test="${timeliness eq 7}"> selected </c:if> >周</option>
                    <option value="30" <c:if test="${timeliness eq 30}"> selected </c:if> >月</option>
                    <option value="90" <c:if test="${timeliness eq 90}"> selected </c:if> >季</option>
                    <option value="365" <c:if test="${timeliness eq 365}"> selected </c:if> >年</option>
                </select>
            </div>
        </li>
      <li><label>&nbsp;</label><input onclick="saveTimeliness();" type="button" class="btn" value="确认保存"/></li>
    </ul>
  </div>
</form>
