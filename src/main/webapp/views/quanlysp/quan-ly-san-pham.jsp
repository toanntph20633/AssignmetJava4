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
<jsp:include page="../layout/back-quan-ly.jsp"></jsp:include>
<div class="m-3 ">
    <a type="button" class="btn btn-primary" href="/quan-ly/quan-ly-san-pham/laptop/view-add">Thêm sản phẩm</a>
</div>
<div class="row container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã sản phẩm</th>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Hãng</th>
            <th scope="col">Giá bán</th>
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
                <td>${item.status}</td>
                <td><img src="${item.images}" width="100"></td>
                <td><a type="button" class="btn btn-success"
                       href="/quan-ly/quan-ly-san-pham/laptop/view-update?id=${item.id}&page=${1}">Sửa</a>
                    <a type="button" class="btn btn-danger"
                       href="/quan-ly/quan-ly-san-pham/laptop/delete?id=${item.id}">Xóa</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="d-flex justify-content-center my-3">
        <c:if test="${page != 1}"><a href="/quan-ly/quan-ly-san-pham/laptop/list?page=${page-1}"
                                     class=" h5 text-primary"><<</a></c:if>
        <div class="fs-5 mx-3">${page}/${pageSize}</div>
        <c:if test="${page != pageSize}"><a
                href="/quan-ly/quan-ly-san-pham/laptop/list?page=${page+1}"
                class="h5 text-primary">>></a></c:if>
    </div>
</div>

</body>
</html>
