<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    function pagework(){
        var num=parseInt($("#input_page").val());
        if(isNaN(num)) {
            $("#input_page").val("");
        }
        var totalPage = '${page.totalPage}';
        if(num <= 0 || num > totalPage){
            $("#input_page").val("");
        }

    }
</script>
<style>
    .page_commit{padding:3px 5px; border-radius:3px; border:1px solid #ccc; margin-left:10px; cursor:pointer;}
    .page_commit:hover{ background:rgb(61,128,218); color:#fff;}
</style>
<div class="pagin">
    <div class="message" style="float:left; line-height:30px;">共<i class="blue"><c:out value="${page.totalResult}"/></i>条记录，当前显示第&nbsp;<i class="blue"><c:out
            value="${page.currentPage}"/>&nbsp;</i>页
    </div>
    <ul class="paginList">
        <c:if test="${page.currentPage > 1}">
            <li class="paginItem"><a href="javascript:;" onclick="changePage(${page.currentPage - 1}, ${page.showCount}, '${param.formName}')">
                <span class="pagepre"></span></a></li>
        </c:if>
        <!-- 禁用状态 -->
        <c:if test="${page.currentPage <= 1}">
            <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        </c:if>
        <c:if test="${page.totalPage <= 8}">
            <c:forEach var="i" begin="1" end="${page.totalPage}">
                <c:if test="${page.currentPage == i}">
                    <li class="paginItem current"><a href="javascript:;">${i}</a></li>
                </c:if>
                <c:if test="${page.currentPage != i}">
                    <li class="paginItem"><a href="javascript:;" onclick="changePage(${i}, ${page.showCount}, '${param.formName}')">${i}</a></li>
                </c:if>
            </c:forEach>
        </c:if>
        <c:if test="${page.totalPage > 8}">
            <c:if test="${page.currentPage <= 5}">
                <c:forEach var="i" begin="1" end="7">
                    <c:if test="${page.currentPage == i}">
                        <li class="paginItem current"><a href="javascript:;">${i}</a></li>
                    </c:if>
                    <c:if test="${page.currentPage != i}">
                        <li class="paginItem"><a href="javascript:;" onclick="changePage(${i}, ${page.showCount}, '${param.formName}')">${i}</a></li>
                    </c:if>
                </c:forEach>
            </c:if>
            <c:if test="${page.currentPage > 5}">
                <!-- 默认显示第一页、第二页 -->
                <li class="paginItem"><a href="javascript:;" onclick="changePage(1, ${page.showCount}, '${param.formName}')">1</a></li>
                <li class="paginItem"><a href="javascript:;" onclick="changePage(2, ${page.showCount}, '${param.formName}')">2</a></li>
                <li class="paginItem more"><a href="javascript:;">...</a></li>
                <c:set var="begin" value="${page.currentPage - 2 }"/>
                <c:set var="end" value="${page.currentPage + 2 }"/>
                <!-- end大于最后一页 -->
                <c:choose>
                    <c:when test="${end > page.totalPage}">
                        <c:set var="end" value="${page.totalPage }"/>
                        <c:set var="begin" value="${page.currentPage - 4 }"/>
                        <c:if test="${page.currentPage - begin < 2}">
                            <c:set var="begin" value="${begin - 4 }"/>
                        </c:if>
                    </c:when>
                    <c:when test="${end + 1 == page.totalPage}">
                        <c:set var="end" value="${page.totalPage }"/>
                    </c:when>
                </c:choose>
                <c:forEach var="i" begin="${begin}" end="${end}">
                    <c:if test="${page.currentPage == i}">
                        <li class="paginItem current"><a href="javascript:;" >${i}</a></li>
                    </c:if>
                    <c:if test="${page.currentPage != i}">
                        <li class="paginItem"><a href="javascript:;" onclick="changePage(${i}, ${page.showCount}, '${param.formName}')">${i}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${end != page.totalPage}">
                    <li class="paginItem more"><a href="javascript:;">...</a></li>
                </c:if>
            </c:if>
        </c:if>
        <c:if test="${page.currentPage < page.totalPage}">
            <li class="paginItem"><a href="javascript:;" onclick="changePage(${page.currentPage + 1}, ${page.showCount}, '${param.formName}')"><span class="pagenxt"></span></a></li>
        </c:if>
        <c:if test="${page.currentPage >= page.totalPage}">
            <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </c:if>
    </ul>
    <span>到<input type="text" id="input_page" name="input_page" onkeyup="pagework();" style="border:1px solid #ccc; width:30px; height:20px;padding-left:5px; line-height:30px; margin:5px 10px;" />页<input type="button" class="page_commit" onclick="goPage(${page.showCount},'${param.formName}');" value="确定"></span>
    <input id="currentPage" name="currentPage" type="hidden" value="${page.currentPage}" readonly />
    <input id="pageSize" name="pageSize" type="hidden" value="${page.showCount}" readonly />
</div>