<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script  type="text/javascript">

    function favourite(productId) {
        $.ajax({
            type: "POST",
            url: '${basePath}/favorites/add.do?t=' + Math.random(),
            data: {productId:productId},
            dataType: "json",
            success: function(data) {
                data = eval("(" + data +")");
                if(data.state != '0') {
                    layer.msg('收藏成功！');
                } else {
                    layer.msg('收藏失败！');
                }
            }
        });
    }
</script>
<form action="${basePath}/product/edit.do" method="post" id="product" name="product">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">业务管理</a></li>
            <li><a href="#">成果、专利详情</a></li>
        </ul>
    </div>
    <div class="formbody">
        <div class="formtitle"><span>${typeName}信息</span></div>
        <ul class="forminfo">
            <li><label>${typeName}名称</label><input name="name" id="name" value="${product.name}" type="text" class="dfinput" readonly /><i style="color: red;"></i></li>
            <li><label>中文名称</label><input name="chineseName" id="chineseName" value="${product.chineseName}" type="text"  class="dfinput" readonly/><i style="color: red;"></i></li>
            <li><label>隶属省部</label><input name="province" id="province" value="${product.province}" type="text"  class="dfinput" readonly/><i style="color: red;"></i></li>
            <li><label>单位属性</label><input name="organsAttribute" id="organsAttribute" value="${product.organsAttribute}" type="text"  class="dfinput" readonly/><i style="color: red;"></i></li>
            <li><label>单位名称</label><input name="organization" id="organization" value="${product.organization}" type="text"  class="dfinput" readonly/><i style="color: red;"></i></li>
            <li><label>研究开始时间</label><input name="startDate" id="startDate" value="<fmt:formatDate value='${product.startDate}' pattern='yyyy-MM-dd'/>" readonly type="text" class="dfinput"/><i style="color: red;"></i></li>
            <li><label>研究结束时间</label><input name="endDate" id="endDate" value="<fmt:formatDate value='${product.endDate}' pattern='yyyy-MM-dd'/>" readonly type="text" class="dfinput"/><i style="color: red;"></i></li>
            <li><label>通讯地址</label><input name="addr" id="addr" value="${product.addr}" type="text"  class="dfinput" readonly/><i style="color: red;"></i></li>
            <li><label>联系人</label><input name="linkman" id="linkman" value="${product.linkman}" type="text"  class="dfinput" readonly/><i style="color: red;"></i></li>
            <li><label>联系电话</label><input name="telephone" id="telephone" value="${product.telephone}" type="text"  class="dfinput" readonly/><i style="color: red;"></i></li>
            <li><label>所在区域</label><input name="area" id="area" value="${product.area}" type="text"  class="dfinput"readonly /><i style="color: red;"></i></li>
            <li><label>邮政编码</label><input name="zipCode" id="zipCode" value="${product.zipCode}" type="text"  class="dfinput"readonly/><i style="color: red;"></i></li>
            <li><label>任务来源</label><input name="taskSource" id="taskSource" value="${product.taskSource}" type="text"  class="dfinput"readonly/><i style="color: red;"></i></li>
            <li><label>有无密级</label><input name="isSecret" id="isSecret"
                                          <c:if test="${product.isSecret ne 'A'}">value="无" </c:if>
                                          <c:if test="${product.isSecret eq 'A'}">value="有" </c:if> type="text"  class="dfinput"readonly/><i style="color: red;"></i></li>
            <li><label>密级</label><input name="secretLevel" id="secretLevel" value="${product.secretLevel}" type="text"  class="dfinput"readonly/><i style="color: red;"></i></li>
            <li><label>内容简介</label>
                <textarea id="content" name="content" cols="" rows="" class="textinput" readonly>${product.content}</textarea><i style="color: red;"></i>
            </li>
            <li><label>技术资料</label>
                <textarea id="technologyDirectory" name="technologyDirectory" cols="" rows="" class="textinput" readonly>${product.technologyDirectory}</textarea><i style="color: red;"></i>
            </li>
            <li>
                <label>&nbsp;</label><input  onclick="getData('${basePath}/message/add.do?toUserId=${product.addUser.id}','','workspace');" type="button" class="btn" value="回复"/>
                <c:if test="${favorite ne 'Y'}">
                    <label>&nbsp;</label><input  onclick="favourite(${product.id});" type="button" class="btn" value="收藏"/>
                </c:if>
            </li>
        </ul>
    </div>
</form>
