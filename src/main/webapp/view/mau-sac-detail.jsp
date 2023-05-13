<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 07/03/2023
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
    <title>TXP SHOP</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <style>
        .container {
            margin-top: 100px;
        }
    </style>
</head>
<body class="container">
<%@include file="layout/header.jsp" %>
<h3 class="card-title mt-3 text-center">Sửa màu sắc</h3>
<br>
<form action="/mau-sac/update?id=${ms.id}" method="post">
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">
                <i class="fas fa-id-card" style="font-size: 30px"></i>
                <p style="margin-top: 17px; margin-left: 10px; margin-right: 12px">Mã màu sắc</p>
            </span>
        </div>
        <input id="ma" name="ma" class="form-control" type="text" value="${ms.ma}" style="padding-top: 10px">
    </div> <!-- form-group// -->
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">
                <i class="fas fa-language" style="font-size: 30px"></i>
                <p style="margin-top: 17px; margin-left: 10px">Tên màu sắc</p>
            </span>
        </div>
        <input id="ten" name="ten" class="form-control" type="text" value="${ms.ten}" style="padding-top: 10px">
    </div>
    <br>
    <div class="row">
        <button class="btn btn-primary" id="send" type="submit">Sửa</button>
    </div>
</form>
<script src="../js/js.js">
</script>
</body>
</html>
