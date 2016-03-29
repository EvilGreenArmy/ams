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

</script>
<form action="${basePath}/message/list.do" method="post" id="categoryList" name="categoryList">
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">业务管理</a></li>
        <li><a href="#">消息管理</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <li class="click" onclick="getData('${basePath}/message/add.do','','workspace');"><span><img src="${basePath}/img/admin/login/t01.png" /></span>添加</li>
            <li onclick="delCategory();"><span><img src="${basePath}/img/admin/login/t03.png" /></span>删除</li>
        </ul>

        <ul class="toolbar1">
            <li><span><img src="${basePath}/img/admin/login/t05.png" /></span>设置</li>
        </ul>

    </div>


    <table class="tablelist">
        <thead>
        <tr>
            <th><input name="" type="checkbox" id="chk_all" /></th>
            <th>标题</th>
            <th>发信人</th>
            <th>内容</th>
            <th>状态</th>
            <th>发信时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="obj" items="${page.resultList}">
            <tr>
                <td><input name="id" type="checkbox" value="${obj.id}" /></td>
                <td>${obj.title}</td>
                <td>${obj.fromUser.name}</td>
                <td>${obj.content}</td>
                <td>
                    <c:if test="${'A' eq obj.status}">
                        激活
                    </c:if>
                    <c:if test="${'A' ne obj.status}">
                        禁用
                    </c:if>
                </td>
                <td>${obj.sendDate}</td>
                <td>
                    <a href="#" class="tablelink" onclick="getData('${basePath}/category/edit.do?id=${obj.id}','','workspace');">回复</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <div class="pagin">
        <div class="message">共<i class="blue"><c:out value="${page.totalResult}"/></i>条记录，当前显示第&nbsp;<i class="blue"><c:out value="${page.currentPage + 1}"/>&nbsp;</i>页</div>
        <ul class="paginList">
            <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
            <li class="paginItem"><a href="javascript:;">1</a></li>
            <li class="paginItem current"><a href="javascript:;">2</a></li>
            <li class="paginItem"><a href="javascript:;">3</a></li>
            <li class="paginItem"><a href="javascript:;">4</a></li>
            <li class="paginItem"><a href="javascript:;">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="javascript:;">10</a></li>
            <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>

</div>
</form>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
