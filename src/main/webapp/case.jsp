<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<%
    String hourParam = request.getParameter("degree");
    request.setAttribute("degreeVar", hourParam);
%>
<c:choose>
    <c:when test="${degreeVar<-25}">It is frost</c:when>
    <c:when test="${degreeVar <5}">It is cold</c:when>
    <c:when test="${degreeVar <25}">It is warm</c:when>
    <c:when test="${degreeVar >=25}">It is hot</c:when>
    <c:otherwise>Where is our temperature?</c:otherwise>

</c:choose>
</body>
</html>
