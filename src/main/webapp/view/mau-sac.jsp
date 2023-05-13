<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
    <title>TXP SHOP</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
<%@include file="layout/header.jsp" %>
<br>
<div class="row">
    <div class="col-6">
        <h3 class="card-title mt-1 text-center">Thêm màu sắc</h3>
        <form action="/mau-sac/add" method="post">
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 20px">
                            <i class="fas fa-id-card" style="font-size: 30px"></i>
                        </span>
                </div>
                <input id="ma" name="ma" class="form-control" placeholder="Mã màu sắc" type="text">
            </div> <!-- form-group// -->
            <br>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text">
                            <i class="fas fa-language" style="font-size: 30px"></i>
                        </span>
                </div>
                <input id="ten" name="ten" class="form-control" placeholder="Tên màu sắc" type="text"
                       style="padding-top: 10px">
            </div>
            <br>
            <button type="submit" id="send" class="btn btn-primary btn-block">Thêm</button>
        </form>
    </div>
    <div class="col-6">
        <h3 class="card-title mt-1 text-center">Danh sách màu sắc</h3>
        <table class="table table-bordered">
            <thead class="table-dark">
            <tr>
                <td>Mã</td>
                <td colspan="2">Tên</td>
                <td>Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listMS}" var="ms">
                <tr>
                    <td>${ms.ma}</td>
                    <td>
                        <div style="width: 200px; height: 30px; background-color: ${ms.ten}; border: #303030 solid 1px">
                        </div>
                    </td>
                    <td>${ms.ten}</td>
                    <td><a href="/mau-sac/detail?id=${ms.id}">
                        <button type="submit" class="btn btn-info">Sửa</button>
                    </a>
                        <a href="/mau-sac/delete?id=${ms.id}">
                            <button type="submit" class="btn btn-info">Xóa</button>
                        </a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="../js/js.js"></script>
</body>
</html>
