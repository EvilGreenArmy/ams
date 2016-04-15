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

    function queryMessage(){
        postDataByFormName('messageList','workspace');
    }


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
            postDataByFormName('messageList','workspace');
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
<style>

</style>
<form action="${basePath}/message/list.do" method="post" id="messageList" name="messageList">
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">业务管理</a></li>
        <li><a href="#">消息管理</a></li>
    </ul>
</div>

<div class="rightinfo">


  <div class="seach_box">

      <fieldset>
          <legend>消息查询</legend>
          <table>
              <tbody>
              <tr>
                  <td class="tabel_title">标题</td>
                  <td class="table_cont">
                      <input type="text" name="title" placeholder="Search" value="${paramMap.title}" class="search_input"/>
                  </td>
                  <td  class="tabel_title">内容</td>
                  <td  class="table_cont">
                      <input type="text" name="content" placeholder="Search" value="${paramMap.content}" class="search_input"/>
                  </td>
              </tr>
              </tbody>
              <tfoot>
              <tr>
                  <td colspan="3"></td>
                  <td>
                      <button type="button" class="search_btn" onclick="queryMessage();">查询</button>
                  </td>
              </tr>
              </tfoot>
          </table>
      </fieldset>


  </div>

    <div class="tools">

        <ul class="toolbar">
            <li class="click" onclick="getData('${basePath}/message/add.do','','workspace');"><span><img src="${basePath}/img/admin/login/t01.png" /></span>发送通知</li>
            <li onclick="delCategory();"><span><img src="${basePath}/img/admin/login/t03.png" /></span>删除</li>
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
                <td>${obj.fromUser.userName}</td>
                <td>${obj.content}</td>
                <td>
                    <c:if test="${'A' eq obj.status}">
                        正常
                    </c:if>
                    <c:if test="${'D' eq obj.status}">
                        删除
                    </c:if>
                </td>
                <td><fmt:formatDate value="${obj.sendDate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                <td>
                    <a href="#" class="tablelink" onclick="getData('${basePath}/message/add.do?toUserId=${obj.fromUser.id}','','workspace');">回复</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <jsp:include page="../pagination/ajaxPager.jsp" flush="true" >
        <jsp:param name="formName" value="messageList" />
    </jsp:include>

</div>
</form>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
