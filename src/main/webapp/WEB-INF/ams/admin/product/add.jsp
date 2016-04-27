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

</script>
<form action="${basePath}/product/add.do" method="post" id="product" name="product">
    <input type="hidden" name="type" value="${type}"/>
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
      <li><a href="#">业务管理</a></li>
      <li><a href="#">成果、专利维护</a></li>
      <li><a href="#">新增${typeName}</a></li>
    </ul>
  </div>
  <div class="formbody">
    <div class="formtitle"><span>${typeName}信息</span></div>
    <ul class="forminfo">
      <li><label>${typeName}名称<b>*</b></label><input name="name" id="name" type="text" class="dfinput" /><i style="color: red;"></i></li>
      <li><label>中文名称<b>*</b></label><input name="chineseName" id="chineseName" type="text" class="dfinput" /><i style="color: red;"></i></li>
      <li><label>单位名称</label><input name="organization" id="organization" type="text" value="" class="dfinput" /><i style="color: red;"></i></li>
      <li><label>研究开始时间</label><input name="startDate" id="startDate" type="text" value="" class="dfinput" onClick="WdatePicker()" /><i style="color: red;"></i></li>
      <li><label>研究结束时间</label><input name="endDate" id="endDate" type="text" value="" class="dfinput" onClick="WdatePicker()" /><i style="color: red;"></i></li>
      <li><label>通讯地址</label><input name="addr" id="addr" type="text" value="" class="dfinput" /><i style="color: red;"></i></li>
      <li><label>联系人</label><input name="linkman" id="linkman" type="text" value="" class="dfinput" /><i style="color: red;"></i></li>
      <li><label>联系电话</label><input name="telephone" id="telephone" type="text" value="" class="dfinput" /><i style="color: red;"></i></li>
      <li><label>所在区域</label><input name="area" id="area" type="text" value="" class="dfinput" /><i style="color: red;"></i></li>
      <li><label>邮政编码</label><input name="zipCode" id="zipCode" type="text" value="" class="dfinput" /><i style="color: red;"></i></li>
      <li><label>任务来源</label>
          <div class="vocation">
              <select class="select1" name="taskSource">
                  <option>-- 请选择 --</option>
                  <option>国家计划</option>
                  <option>省市计划</option>
                  <option>市级计划</option>
                  <option>基金</option>
                  <option>计划内</option>
                  <option>计划外</option>
              </select>
          </div>
      </li>

      <li><label>有无密级</label><cite>
          <input name="isSecret" type="radio" value="N" checked="checked" />无&nbsp;&nbsp;&nbsp;&nbsp;
          <input name="isSecret" type="radio" value="A" />有</cite>
      </li>
      <li><label>密级<b>*</b></label>
          <div class="vocation">
              <select class="select1" name="secretLevel">
                    <option>-- 请选择 --</option>
                    <option>秘密</option>
                    <option>机密</option>
                    <option>绝密</option>
              </select>
          </div>
      </li>
      <li><label>内容简介<b>*</b></label>
          <textarea id="content" name="content" cols="" rows="" class="textinput"></textarea><i style="color: red;"></i>
      </li>
      <li><label>技术资料</label>
          <textarea id="technologyDirectory" name="technologyDirectory" cols="" rows="" class="textinput"></textarea><i style="color: red;"></i>
      </li>

      <li><label>&nbsp;</label><input onclick="saveProduct();" type="button" class="btn" value="提交"/></li>
    </ul>
  </div>
</form>
