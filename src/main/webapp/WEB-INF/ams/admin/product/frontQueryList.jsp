<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript">
    /*$(document).ready(function(){
     $(".click").click(function(){
     $(".tip").fadeIn(200);
     });

     $(".tiptop a").click(function(){
     $(".tip").fadeOut(200);
     });

     $(".sure").click(function(){
     $(".tip").fadeOut(100);
     });

     $(".cancel").click(function(){
     $(".tip").fadeOut(100);
     });

     });*/


    function delCategory(){
        if(!checkSelect()){
            layer.alert('至少选择一个删除对象');
            return ;
        }
        layer.confirm('确定要删除数据吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            trimForm('categoryList');
            $("#categoryList").attr("action","${basePath}/category/del.do")
            layer.closeAll();
            postDataByFormName('categoryList','workspace');
        }, function(){
        });
    }

    function checkSelect(){
        var ids = $("input:checked");
        if(ids.size()>0){
            return true;
        }
        return false;
    }

    $(function(){
        $("#chk_all").click(function(){
            $("input[name='id']").prop("checked",$(this).prop("checked"));
        });
    })
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
<form action="${basePath}/product/frontList.do" method="post" id="productList" name="productList">
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">业务管理</a></li>
        <li><a href="#">成果专利维护</a></li>
    </ul>
</div>

<div class="rightinfo">
    <div class="seach_box">

        <fieldset>
            <legend>消息查询</legend>
            <table>
                <tbody>
                <tr>
                    <td class="tabel_title">类型：</td>
                    <td class="table_cont">
                        <select name="type" class="search_input">
                            <option value="">全部</option>
                            <option value="1" <c:if test="${'1'eq paramMap.type}">selected</c:if>>成果</option>
                            <option value="2" <c:if test="${'2'eq paramMap.type}">selected</c:if>>专利</option>
                        </select>
                    </td>
                    <td  class="tabel_title">名称：</td>
                    <td  class="table_cont">
                        <input type="text" name="name" value="${paramMap.name}" class="search_input"/>
                    </td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="3"></td>
                    <td>
                        <button type="button" onclick="postDataByFormName('productList','workspace');" class="search_btn">查询</button>
                    </td>
                </tr>
                </tfoot>
            </table>
        </fieldset>


    </div>
    <table class="tablelist">
        <thead>
        <tr>
            <th>名称</th>
            <th>单位</th>
            <th>联系人</th>
            <th>类型</th>
            <th>提交时间</th>
            <th>提交人</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="obj" items="${page.resultList}">
            <tr>
                <td><a href="#" onclick="getData('${basePath}/product/detail.do?t=f&id=${obj.id}','','workspace');">${obj.name}</a></td>
                <td>${obj.organization}</td>
                <td>${obj.linkman}</td>
                <td>
                    <c:if test="${'1' eq obj.type}">
                        成果
                    </c:if>
                    <c:if test="${'1' ne obj.type}">
                        专利
                    </c:if>
                </td>
                <td><fmt:formatDate value="${obj.editDate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                <td>${obj.addUser.userName}</td>
                <td>
                    <a href="#" class="tablelink" onclick="getData('${basePath}/message/add.do?toUserId=${obj.addUser.id}','','workspace');">回复</a>|
                    <a href="#" class="tablelink" onclick="favourite('${obj.id}');">收藏</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <jsp:include page="../pagination/ajaxPager.jsp" flush="true" >
        <jsp:param name="formName" value="productList" />
    </jsp:include>

</div>
</form>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
