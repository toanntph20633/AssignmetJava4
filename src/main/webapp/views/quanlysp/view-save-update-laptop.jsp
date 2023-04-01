<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/30/2023
  Time: 11:17 PM
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
<div class="container row">
    <div class="col">
        <form action="/quan-ly/quan-ly-san-pham/laptop/add-or-update?uid=${laptop.id}" method="post"
              enctype="multipart/form-data">
            <div class="mb-3">
                <label class="form-label">Mã sản phẩm</label>
                <input type="text" class="form-control" name="laptopCode" value="${laptop.laptopCode}">
            </div>
            <div class="mb-3">
                <label class="form-label">Tên sản phẩm</label>
                <input type="text" class="form-control" name="laptopName" value="${laptop.laptopName}">
            </div>
            <div class="mb-3">
                <label class="form-label">Mô tả</label>
                <input type="text" class="form-control" name="description" value="${laptop.description}">
            </div>
            <div class="mb-3">
                <label class="form-label">Giá bán</label>
                <input type="text" class="form-control" name="price" value="${laptop.price}">
            </div>
            <div class="mb-3">
                <label class="form-label">Hãng</label>
                <select class="form-select" aria-label="Default select example" name="brandId">
                    <c:forEach var="b" items="${listBrand}">
                        <option value="${b.id}" ${b.id == laptop.brandId.id ?"selected":""} >${b.brandName}</option>
                    </c:forEach>
                </select>
            </div>
            <c:if test="${laptop.id == null}">
                <div class="mb-3">
                    <label class="form-label">Số lượng</label>
                    <input type="text" class="form-control" name="soLuong">
                </div>
            </c:if>
            <div class="mb-3">
                <label class="form-label">Ảnh</label>
                <input type="file" class="form-control" name="image">
            </div>
            <button type="submit" class="btn btn-primary">${laptop.id != null?"Update":"Add"}</button>
        </form>
    </div>
    <div class="col">
        <div class="text-center m-2 mt-5">
            <c:if test="${laptop.images != null}">
                <img src="${laptop.images}" width="600">
            </c:if>
        </div>
    </div>
</div>
<c:if test="${laptop.id != null}">
    <div>
        <div class="h5 my-3">Danh sách các sản phẩm</div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Tên máy</th>
                <th scope="col">Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listDetail}" var="ld">
                <tr>
                    <th scope="row">${ld.laptopDetailCode}</th>
                    <td>${ld.laptopId.laptopName}</td>
                    <td>
                        <a type="button" class="btn btn-danger"
                           href="/quan-ly/quan-ly-san-pham/laptop-detail/delete?id=${ld.id}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="d-flex justify-content-center my-3">
            <c:if test="${page != 1}"><a href="/quan-ly/quan-ly-san-pham/laptop/view-update?id=${laptop.id}&page=${page-1}"
                                         class=" h5 text-primary"><<</a></c:if>
            <div class="fs-5 mx-3">${page}/${sizePage}</div>
            <c:if test="${page != sizePage}"><a
                    href="/quan-ly/quan-ly-san-pham/laptop/view-update?id=${laptop.id}&page=${page+1}"
                    class="h5 text-primary">>></a></c:if>
        </div>
    </div>
</c:if>

</body>
</html>
