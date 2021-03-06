<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<script type="text/javascript">
    function delFavorites(){
        layer.confirm('确定要删除数据吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            trimForm('competitionList');
            $("#competitionList").attr("action","${basePath}/competition/delete.do")
            layer.closeAll();
            postDataByFormName('competitionList','workspace');
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
    function deal(id, productId) {
        layer.confirm('确定要成交吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            postDataByURL('${basePath}/product/deal.do',{id:id, productId:productId},'workspace');
            layer.closeAll();
        }, function(){
        });
    }
</script>
<form action="${basePath}/competition/list.do" method="post" id="competitionList" name="competitionList">
<input type="hidden" name="productId" value="${productId}" readonly/>
<div class="rightinfo">
    <table class="tablelist" style="table-layout:fixed; ">
        <thead>
        <tr>
            <th width="5%"><input id="chk_all" type="checkbox" value="" /></th>
            <c:if test="${isAdmin eq '1'}">
                <th width="10%">竞价人</th>
            </c:if>
            <th width="20%">名称</th>
            <th width="10%">类型</th>
            <th width="10%">出价金额</th>
            <th>评价</th>
            <th width="15%">时间</th>
          <%--  <th>是否最高价</th>--%>
            <c:if test="${product.status eq '3' || product.status eq '1'}">
                <th width="5%">操作</th>
            </c:if>
            <c:if test="${product.status ne '3' && product.status ne '1'}">
                <th width="10%">是否成交价</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="obj" items="${page.resultList}">
            <tr>
                <td><input name="id" type="checkbox" value="${obj.id}" /></td>
                <c:if test="${isAdmin eq '1'}">
                    <td>${obj.userInfo.userName}</td>
                </c:if>
                <td style="text-overflow:ellipsis; white-space:nowrap; width:16em; overflow:hidden;" title="${obj.productInfo.name}">${obj.productInfo.name}</td>
                <c:if test="${obj.productInfo.type eq '1'}">
                    <td>成果</td>
                </c:if>
                <c:if test="${obj.productInfo.type eq '2'}">
                    <td>专利</td>
                </c:if>
                <td style="width:150px;white-space:nowrap; overflow:hidden;"><fmt:formatNumber value="${obj.comValue}" pattern="#,#00.0#"/>*${obj.productInfo.priceUnit}</td>
                <td style="text-overflow:ellipsis; white-space:nowrap; width:16em; overflow:hidden;" title="${obj.content}">${obj.content}</td>
                <td><fmt:formatDate value="${obj.createTime}"  pattern="yyyy-MM-dd HH:mm:ss"/></td>
              <%--  <c:if test="${obj.status eq '1'}">
                    <td>是</td>
                </c:if>
                <c:if test="${obj.status eq '0'}">
                    <td>否</td>
                </c:if>--%>
                <c:if test="${product.status eq '3' || product.status eq '1'}">
                <td>
                    <a href="javascript:;" onclick="deal(${obj.id}, ${productId})" class="tablelink"> 成交</a>
                </td>
                </c:if>
                <c:if test="${product.status ne '3' && product.status ne '1'}">
                    <c:if test="${'1' eq obj.dealStatus}">
                       <td> 是</td>
                    </c:if>
                    <c:if test="${'1' ne obj.dealStatus}">
                        <td> 否</td>
                    </c:if>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <jsp:include page="../pagination/ajaxPager.jsp" flush="true" >
        <jsp:param name="formName" value="competitionList" />
    </jsp:include>
    </div>
    </form>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
