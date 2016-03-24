<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Test</title>
</head>
<body>
<table>
    <tr><td><c:out value="${test}" /></td></tr>
    <c:forEach items="${page.resultList}" var="obj">
    <tr>
      <td><c:out value="${obj.userName}" /></td>
      <td><c:out value="${obj.age}" /></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
