<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/24/2023
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
<jsp:include page="../layout/back.jsp"></jsp:include>
<div class="h3 mx-2 mt-5">Danh sách các laptop bán chạy nhất</div>
<div class="row  row-cols-4 my-5">
    <c:forEach items="${listLaptop}" var="item">
        <div class="col mt-5">
          <jsp:include page="../layout/item.jsp">
            <jsp:param name="name" value="${item.laptopName}"/>
            <jsp:param name="img" value="${item.images}"/>
            <jsp:param name="price" value="${item.price}"/>
            <jsp:param name="id" value="${item.id}"/>
        </jsp:include>
        </div>
    </c:forEach>
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>
