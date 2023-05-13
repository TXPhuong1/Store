<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
    <link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
    <title>TXP SHOP</title>
    <style>
        .input-group-prepend {
            Width: 200px
        }
    </style>
</head>
<body class="container">
<%@include file="layout/header.jsp" %>
<br>
<h3 class="card-title mt-3 text-center">Sửa khách hàng</h3>
<br>
<form action="/khach-hang/update?id=${khachHang.id}" method="post" class="container">
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">
                <i class="fas fa-id-card" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 10px">Mã khách hàng</p>
            </span>
        </div>
        <input id="ma" name="ma" class="form-control" type="text" value="${khachHang.ma}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">
                <i class="fas fa-language" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 10px">Họ khách hàng</p>
            </span>
        </div>
        <input id="ho" name="ho" class="form-control" type="text" value="${khachHang.ho}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 40px">
                <i class="fas fa-file-signature" style="font-size: 20px; margin-left: 5px"></i>
                <p style="margin-top: 17px; margin-left: 10px">Tên đệm</p>
            </span>
        </div>
        <input id="tenDem" name="tenDem" class="form-control" type="text" value="${khachHang.tenDem}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">
                <i class="fas fa-signature" style="font-size: 14px"></i>
                <p style="margin-top: 17px; margin-left: 10px">Tên khách hàng</p>
            </span>
        </div>
        <input id="ten" name="ten" class="form-control" type="text" value="${khachHang.ten}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 36px">
                <i class="fas fa-birthday-cake" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 17px">Ngày sinh</p>
            </span>
        </div>
        <input id="ngaySinh" name="ngaySinh" class="form-control" type="date" value="${ngaySinh}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 18px">
                <i class="fa fa-phone" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 10px">Số điện thoại</p>
            </span>
        </div>
        <input id="sdt" name="sdt" class="form-control" type="text" value="${khachHang.sdt}" style="padding-top: 10px">
    </div>
    <br>

    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 61px">
                <i class="fas fa-map-marker-alt" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 17px">Địa chỉ</p>
            </span>
        </div>
        <input id="diaChi" name="diaChi" class="form-control" type="text" value="${khachHang.diaChi}" style="padding-top: 10px">
    </div>
    <br>

    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 61px">
                <i class="fa fa-building" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 17px">Thành phố</p>
            </span>
        </div>
        <input id="thanhPho" name="thanhPho" class="form-control" type="text" value="${khachHang.thanhPho}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 61px">
                <i class="fas fa-globe" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 17px">Quốc gia</p>
            </span>
        </div>
        <input id="quocGia" name="quocGia" class="form-control" type="text" value="${khachHang.quocGia}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 34px">
                <i class="fa fa-lock" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 23px">Mật khẩu</p>
            </span>
        </div>
        <input id="matKhau" name="matKhau" class="form-control" type="text" value="${khachHang.matKhau}" style="padding-top: 10px">
    </div>
    <br>
    <div class="row">
        <button id="send" type="submit" class="btn btn-primary">Sửa</button>
    </div>
</form>
<script src="../js/js.js"></script>
</body>
</html>

