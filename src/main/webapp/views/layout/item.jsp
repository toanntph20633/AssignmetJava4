<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/25/2023
  Time: 1:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="card" style="width: 18rem;">
    <img src="${param.img}" class="card-img-top" alt="...">
    <div class="card-body">
        <h5 class="card-title">${param.name}</h5>
        <p class="card-text">${param.price} VNĐ</p>
        <a href="/chi-tiet?id=${param.id}" class="btn btn-primary">Xem chi tiết</a>
    </div>
</div>
</body>
</html>
