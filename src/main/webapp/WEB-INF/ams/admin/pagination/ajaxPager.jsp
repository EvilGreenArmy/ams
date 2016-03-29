<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pagin">
    <div class="message">共<i class="blue"><c:out value="${page.totalResult}"/></i>条记录，当前显示第&nbsp;<i class="blue"><c:out
            value="${page.currentPage}"/>&nbsp;</i>页
    </div>
    <ul class="paginList">
        <c:if test="${page.currentPage > 1}">
            <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        </c:if>
        <c:if test="${page.currentPage <= 1}">
            <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        </c:if>
        <c:if test="${page.totalPage <= 8}">
            <c:forEach var="i" begin="1" end="${page.totalPage}">
                <c:if test="${page.currentPage == i}">
                    <li class="paginItem current"><a href="javascript:;">${i}</a></li>
                </c:if>
                <c:if test="${page.currentPage != i}">
                    <li class="paginItem"><a href="javascript:;">${i}</a></li>
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
                        <li class="paginItem"><a href="javascript:;">${i}</a></li>
                    </c:if>
                </c:forEach>
            </c:if>
            <c:if test="${page.currentPage > 5}">
                <!-- 默认显示第一页、第二页 -->
                <li class="paginItem"><a href="javascript:;">1</a></li>
                <li class="paginItem"><a href="javascript:;">2</a></li>
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
                        <li class="paginItem current"><a href="javascript:;">${i}</a></li>
                    </c:if>
                    <c:if test="${page.currentPage != i}">
                        <li class="paginItem"><a href="javascript:;">${i}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${end != page.totalPage}">
                    <li class="paginItem more"><a href="javascript:;">...</a></li>
                </c:if>
            </c:if>
        </c:if>
        <c:if test="${page.currentPage < page.totalPage}">
            <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </c:if>
        <c:if test="${page.currentPage >= page.totalPage}">
            <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </c:if>
    </ul>
    <span>到<input type="text" name="go" />页<input type="button" onclick="goPage();" value="确定"></span>
    <input name="currentPage" type="hidden" value="${page.currentPage}" readonly />
    <input name="pageSize" type="hidden" value="${page.showCount}" readonly />
</div>