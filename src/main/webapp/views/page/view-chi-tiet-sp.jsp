<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/25/2023
  Time: 2:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <!-- Favicon-->

    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
<div>
    <div class="container">
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="${laptop.images}" alt="..."/></div>
                    <div class="col-md-6">
                        <div class="small mb-1">Mã sản phẩm: ${laptop.laptopCode}</div>
                        <h1 class="display-5 fw-bolder">${laptop.laptopName}</h1>
                        <div class="fs-5 mb-5">
                            <span class="text-decoration-line-through text-secondary">${laptop.price} VNĐ</span>
                            <span class="fs-4">${laptop.price} VNĐ</span>
                        </div>
                        <p class="lead">Mô tả sản phẩm:</p>
                        <p class="">-${laptop.description}</p>
                        <form action="/them-gio-hang?id = ${laptop.id}" method="post">
                            <div class="d-flex">
                                <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1"
                                       style="max-width: 3rem" name="soLuong"/>
                                <div class="d-flex">
                                    <a class="btn btn-outline-dark flex-shrink-0" type="submit">
                                        <i class="bi-cart-fill me-1"></i>
                                        Thêm vào giỏ hàng
                                    </a>
                                    <a class="btn btn-outline-danger mx-2" type="submit">
                                        <i class="bi-cart-fill me-1"></i>
                                        Mua ngay
                                    </a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>


</body>
</html>
