<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript">
  function saveProduct() {
    if($("#name").val() == '') {
      $("#name").next("i").text('名称不能为空');
      return;
    } else {
      $("#name").next("i").text('');
    }
      if($("#content").val() == '') {
          $("#content").next("i").text('内容简介不能为空');
          return;
      } else {
          $("#content").next("i").text('');
      }

      //询问框
      layer.confirm('确定要提交吗？', {
          btn: ['确定','取消'] //按钮
      }, function(){
          layer.closeAll();
          trimForm('product');
          postDataByFormName('product','workspace');
      }, function(){
      });


  }
  $(document).ready(function(e) {
      $(".select1").uedSelect({
          width: 345
      });
  });
</script>
<form action="${basePath}/product/edit.do" method="post" id="product" name="product">
    <input type="hidden" name="id" value="${product.id}"/>
    <input type="hidden" name="type" value="${type}"/>
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
      <li><a href="#">业务管理</a></li>
      <li><a href="#">成果、专利维护</a></li>
      <li><a href="#">修改${typeName}</a></li>
    </ul>
  </div>
  <div class="formbody">
    <div class="formtitle"><span>${typeName}信息</span></div>
    <ul class="forminfo">
        <li><label>${typeName}名称<b>*</b></label><input name="name" id="name" value="${product.name}" type="text" class="dfinput" /><i style="color: red;"></i></li>
        <li><label>中文名称</label><input name="chineseName" id="chineseName" value="${product.chineseName}" type="text" value="" class="dfinput" /><i style="color: red;"></i></li>
        <li><label>隶属省部</label><input name="province" id="province" value="${product.province}" type="text" class="dfinput" /><i style="color: red;"></i></li>
        <li><label>单位属性</label>
            <div class="vocation">
                <select class="select1" name="organsAttribute">
                    <option value="">-- 请选择 --</option>
                    <c:forEach items="${organsAttributes}" var="item">
                        <option value="${item.name}"
                                <c:if test="${product.organsAttribute eq item.name}">selected </c:if>
                                >${item.name}</option>
                    </c:forEach>
                </select>
            </div>
        </li>
        <li><label>单位名称</label><input name="organization" id="organization" value="${product.organization}" type="text" value="" class="dfinput" /><i style="color: red;"></i></li>
        <li><label>开始时间</label><input name="startDate" id="startDate" value="<fmt:formatDate value='${product.startDate}' pattern='yyyy-MM-dd'/>" type="text" class="dfinput"  onClick="WdatePicker()"/><i style="color: red;"></i></li>
        <li><label>结束时间</label><input name="endDate" id="endDate" value="<fmt:formatDate value='${product.endDate}' pattern='yyyy-MM-dd'/>" type="text" class="dfinput"  onClick="WdatePicker()"/><i style="color: red;"></i></li>
        <li><label>通讯地址</label><input name="addr" id="addr" value="${product.addr}" type="text" value="" class="dfinput" /><i style="color: red;"></i></li>
        <li><label>联系人</label><input name="linkman" id="linkman" value="${product.linkman}" type="text" value="" class="dfinput" /><i style="color: red;"></i></li>
        <li><label>联系电话</label><input name="telephone" id="telephone" value="${product.telephone}" type="text" value="" class="dfinput" /><i style="color: red;"></i></li>
        <li><label>所在区域</label><input name="area" id="area" value="${product.area}" type="text" value="" class="dfinput" /><i style="color: red;"></i></li>
        <li><label>邮政编码</label><input name="zipCode" id="zipCode" value="${product.zipCode}" type="text" value="" class="dfinput" /><i style="color: red;"></i></li>
        <li><label>任务来源</label>
            <div class="vocation">
                <select class="select1" name="taskSource">
                    <option value="">-- 请选择 --</option>
                    <c:forEach items="${taskSources}" var="item">
                        <option value="${item.name}"
                                <c:if test="${product.taskSource eq item.name}">selected </c:if>
                                >${item.name}</option>
                    </c:forEach>
                </select>
            </div>
        </li>

        <li><label>有无密级</label><cite>
            <input name="isSecret" type="radio" value="N" <c:if test="${product.isSecret eq 'N'}">checked </c:if>/>无&nbsp;&nbsp;&nbsp;&nbsp;
            <input name="isSecret" type="radio" value="A" <c:if test="${product.isSecret eq 'A'}">checked </c:if>/>有</cite>
        </li>
        <li><label>密级</label>
            <div class="vocation">
                <select class="select1" name="secretLevel">
                    <option value="">-- 请选择 --</option>
                    <c:forEach items="${secretLevels}" var="item">
                        <option value="${item.name}"
                                <c:if test="${product.secretLevel eq item.name}">selected </c:if>
                                >${item.name}</option>
                    </c:forEach>
                </select>
            </div>
        </li>
        <li><label>竞价单位</label>
            <div class="vocation">
                <select class="select1" name="priceUnit">
                    <option value="">-- 请选择 --</option>
                    <c:forEach items="${priceUnits}" var="item">
                        <option value="${item.name}"
                                <c:if test="${product.priceUnit eq item.name}">selected </c:if>
                                >${item.name}</option>
                    </c:forEach>
                </select>
            </div>
        </li>
        <li><label>内容简介</label>
            <textarea id="content" name="content" cols="" rows="" class="textinput">${product.content}</textarea><i style="color: red;"></i>
        </li>
        <li><label>技术资料<b>*</b></label>
            <textarea id="technologyDirectory" name="technologyDirectory" cols="" rows="" class="textinput">${product.technologyDirectory}</textarea><i style="color: red;"></i>
        </li>
      <li><label>&nbsp;</label><input onclick="saveProduct();" type="button" class="btn" value="提交"/></li>
    </ul>
  </div>
</form>
