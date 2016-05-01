<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
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
    function delSource(){
        layer.confirm('确定要删除数据吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            trimForm('userList');
            $("#userList").attr("action","${basePath}/user/delete.do")
            layer.closeAll();
            postDataByFormName('userList','workspace');
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
    function singleDelete(id) {
        layer.confirm('确定要删除数据吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            postDataByURL('${basePath}/source/delete.do',{id:id},'workspace');
            layer.closeAll();
        }, function(){
        });
    }
    function querySource(){
        postDataByFormName('sourceList','workspace');
    }
</script>
<form action="${basePath}/source/list.do" method="post" id="sourceList" name="sourceList">
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">系统管理</a></li>
        <li><a href="#">菜单管理</a></li>
    </ul>
</div>

<div class="rightinfo">
    <div class="seach_box">

        <fieldset>
            <legend>菜单查询</legend>
            <table>
                <tbody>
                <tr>
                    <td class="tabel_title">菜单名称</td>
                    <td class="table_cont">
                        <input type="text" name="name" placeholder="菜单名称" value="${paramMap.name}" class="search_input"/>
                    </td>
                    <td  class="tabel_title">对应URL</td>
                    <td  class="table_cont">
                        <input type="text" name="code" placeholder="对应URL" value="${paramMap.code}" class="search_input"/>
                    </td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="3"></td>
                    <td>
                        <button type="button" class="search_btn" onclick="querySource();">查询</button>
                    </td>
                </tr>
                </tfoot>
            </table>
        </fieldset>


    </div>
    <div class="tools">

       <%-- <ul class="toolbar">
            <li class="click" onclick="getData('${basePath}/source/add.do','','workspace');"><span><img src="${basePath}/img/admin/login/t01.png" /></span>添加</li>
            &lt;%&ndash;<li class="click"><span><img src="${basePath}/img/admin/login/t02.png" /></span>激活</li>&ndash;%&gt;
            <li onclick="delSource();"><span><img src="${basePath}/img/admin/login/t03.png" /></span>删除</li>
        </ul>--%>


        <ul class="toolbar1">
            <%--<li><span><img src="${basePath}/img/admin/login/t05.png" /></span>设置</li>--%>
        </ul>

    </div>


    <table class="tablelist">
        <thead>
        <tr>
            <th>菜单名称</th>
            <th>对应URL</th>
            <th>上级菜单名称</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="obj" items="${page.resultList}">
            <tr>
                <td>${obj.name}</td>
                <td>${obj.code}</td>
                <td>${obj.parentInfo.name}</td>
                <%--<td><fmt:formatDate value="${obj.birthday}" pattern="yyyy-MM-dd"/></td>--%>
                <td>${obj.description}</td>
                <td>
                    <a href="javascript:;" class="tablelink" onclick="getData('${basePath}/source/edit.do?id=${obj.id}','','workspace');">修改</a>
                    <%--<a href="javascript:;" onclick="singleDelete(${obj.id})" class="tablelink"> 删除</a>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <jsp:include page="../pagination/ajaxPager.jsp" flush="true" >
        <jsp:param name="formName" value="sourceList" />
    </jsp:include>
    </div>
    </form>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
