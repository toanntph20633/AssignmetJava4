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
          <script src="https://kit.fontawesome.com/6b6872c6dd.js" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/trang-chu">Xin chào ${acc.customerId.cusName}</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/trang-chu">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/gioi-thieu">Giới thiệu</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/san-pham?page=1">Laptop Gaming</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Tài khoản
                    </a>
                    <ul class="dropdown-menu">
                        <c:if test="${acc != null}">
                            <li><a class="dropdown-item" href="/thong-tin-tai-khoan">Thông tin tài khoản</a></li>
                            <li><a class="dropdown-item" href="/gio-hang">Giỏ hàng của tôi</a></li>
                            <c:if test="${role.roleName == 'admin'}">
                                <li><a class="dropdown-item" href="/quan-ly">Quản lý</a></li>
                            </c:if>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="/dang-xuat">Đăng xuất</a></li>
                        </c:if>

                        <c:if test="${acc == null}">
                            <li><a class="dropdown-item" href="/dang-nhap">Đăng nhập</a></li>
                        </c:if>

                    </ul>
                </li>
            </ul>
            <form class="d-flex" role="search" action="/trang-chu">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
