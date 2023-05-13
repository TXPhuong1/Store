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
<h3 class="card-title mt-3 text-center">Sửa cửa hàng</h3>
<br>
<form action="/cua-hang/update?id=${ch.id}" method="post">
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">
                <i class="fas fa-id-card" style="font-size: 30px"></i>
                <p style="margin-top: 17px; margin-left: 14px; margin-right: 10px">Mã cửa hàng</p>
            </span>
        </div>
        <input id="ma" name="ma" class="form-control" type="text" value="${ch.ma}" style="padding-top: 10px">
    </div><!-- form-group// -->
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">
                <i class="fas fa-language" style="font-size: 30px"></i>
                <p style="margin-top: 17px; margin-left: 10px">Tên cửa hàng</p>
            </span>
        </div>
        <input id="ten" name="ten" class="form-control" type="text" value="${ch.ten}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 63px">
                <i class="fas fa-map-marker-alt" style="font-size: 30px"></i>
                <p style="margin-top: 17px; margin-left: 25px">Địa chỉ</p>
            </span>
        </div>
        <input id="diaChi" name="diaChi" class="form-control" type="text" value="${ch.diaChi}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 35px">
                <i class="fa fa-building" style="font-size: 30px"></i>
                <p style="margin-top: 17px; margin-left: 22px">Thành phố</p>
            </span>
        </div>
        <input id="thanhPho" name="thanhPho" class="form-control" type="text" value="${ch.thanhPho}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 46px">
                <i class="fas fa-globe" style="font-size: 30px"></i>
                <p style="margin-top: 17px; margin-left: 20px">Quốc gia</p>
            </span>
        </div>
        <input id="quocGia" name="quocGia" class="form-control" type="text" value="${ch.quocGia}" style="padding-top: 10px">
    </div>
    <br>
    <div class="row">
        <button id="send" type="submit" class="btn btn-primary btn-block">Sửa</button>
    </div>
</form>
<script src="../js/js.js"></script>
</body>
</html>