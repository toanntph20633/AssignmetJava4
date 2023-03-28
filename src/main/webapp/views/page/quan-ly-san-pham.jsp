<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/28/2023
  Time: 11:28 PM
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
<table class="table">

    <thead>
    <tr>
        <th scope="col">Mã sản phẩm</th>
        <th scope="col">Tên sản phẩm</th>
        <th scope="col">Hãng</th>
        <th scope="col">Giá bán</th>
        <th scope="col">Số lượng tồn</th>
        <th scope="col">Trạng thái</th>
        <th scope="col">Ảnh minh họa</th>
        <th scope="col">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${listLaptop}">
        <tr>
            <th scope="row">${item.laptopCode}</th>
            <td>${item.laptopName}</td>
            <td>${item.brandId.brandName}</td>
            <td>${item.price}</td>
            <td>${item.quantity}</td>
            <td>${item.status}</td>
            <td><img src="${item.images}" width="100"></td>
            <td><a type="button" class="btn btn-success">Sửa</a>
                <a type="button" class="btn btn-danger" href="/quan-ly-san-pham/delete">Xóa</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="../layout/back.jsp"></jsp:include>

</body>
</html>
