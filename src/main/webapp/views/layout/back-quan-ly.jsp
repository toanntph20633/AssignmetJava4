<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/24/2023
  Time: 1:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<ul class="nav">
    <li class="nav-item">
        <a class="nav-link " aria-current="page" href="/quan-ly/quan-ly-san-pham/laptop/list?page=${1}">Quản lý sản
            phẩm</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/quan-ly/quan-ly-khach-hang/list?page=${1}">Quản lý khách hàng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/quan-ly/quan-ly-hoa-don/list?page=${1}">Quản lý hóa đơn</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " href="/quan-ly/quan-ly-doanh-thu/list?page=${1}">Quản lý doanh thu</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " href="/trang-chu">Trang chủ</a>
    </li>
    <li class="nav-item">
        <a class="nav-link " href="/dang-xuat">Đăng xuất</a>
    </li>

</ul>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
