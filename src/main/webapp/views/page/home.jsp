<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/24/2023
  Time: 12:22 AM
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
<div class="row text-center mt-4">
    <div class="h1">CÁC SẢN PHẨM CỦA CHÚNG TÔI</div>
    <div class="col ">
        <a href="/san-pham">
            <div class="card" style="width: 18rem; border: none">
                <img src="https://synnexfpt.com/wp-content/uploads/2022/11/D42661C1-859E-44D0-924A-51A7978B12E0.png"
                     alt="...">
                <div class="card-body">
                    <div class="h5">Laptop ROG</div>
                </div>
            </div>
        </a>

    </div>
    <div class="col ">
        <a href="/san-pham">
            <div class="card" style="width: 18rem; border: none">
                <img src="https://synnexfpt.com/wp-content/uploads/2022/11/D42661C1-859E-44D0-924A-51A7978B12E0.png"
                     alt="...">
                <div class="card-body">
                    <div class="h5">Laptop ROG</div>
                </div>
            </div>
        </a>

    </div>
    <div class="col ">
        <a href="/san-pham">
            <div class="card" style="width: 18rem; border: none">
                <img src="https://synnexfpt.com/wp-content/uploads/2022/11/D42661C1-859E-44D0-924A-51A7978B12E0.png"
                     alt="...">
                <div class="card-body">
                    <div class="h5">Laptop ROG</div>
                </div>
            </div>
        </a>

    </div>
    <div class="col ">
        <a href="/san-pham">
            <div class="card" style="width: 18rem; border: none">
                <img src="https://synnexfpt.com/wp-content/uploads/2022/11/D42661C1-859E-44D0-924A-51A7978B12E0.png"
                     alt="...">
                <div class="card-body">
                    <div class="h5">Laptop ROG</div>
                </div>
            </div>
        </a>

    </div>
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>
