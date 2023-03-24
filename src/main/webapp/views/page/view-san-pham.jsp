<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/24/2023
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../layout/header.jsp">
    <jsp:param name="username" value="${acc.userName}"/>
    <jsp:param name="password" value="${acc.password}"/>
    <jsp:param name="customerId" value="${acc.customerId.id}"/>
</jsp:include>
<jsp:include page="../layout/back.jsp"></jsp:include>
</body>
</html>
