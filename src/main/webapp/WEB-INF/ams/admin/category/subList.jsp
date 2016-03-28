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
            $("#categoryList").attr("action","${basePath}/category/del.do?parentId=${parentId}")
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

</script>
<form action="${basePath}/category/list.do" method="post" id="categoryList" name="categoryList">
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">系统管理</a></li>
        <li><a href="#">数据字典管理</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <li class="click" onclick="getData('${basePath}/category/add.do?parentId=${parentId}','','workspace');"><span><img src="${basePath}/img/admin/login/t01.png" /></span>添加</li>
            <li onclick="delCategory();"><span><img src="${basePath}/img/admin/login/t03.png" /></span>删除</li>
        </ul>
    </div>

    <table class="tablelist">
        <thead>
        <tr>
            <th><input name="" type="checkbox" value="" /></th>
            <th>名称</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="obj" items="${list}">
            <tr>
                <td><input name="id" type="checkbox" value="${obj.id}" /></td>
                <td>${obj.name}</td>
                <td>
                    <c:if test="${'A' eq obj.status}">
                        激活
                    </c:if>
                    <c:if test="${'A' ne obj.status}">
                        禁用
                    </c:if>
                </td>
                <td>
                    <a href="#" class="tablelink" onclick="getData('${basePath}/category/edit.do?id=${obj.id}','','workspace');">修改</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="${basePath}/img/admin/login/ticon.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>

    </div>
</div>
</form>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
