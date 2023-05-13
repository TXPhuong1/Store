<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.4.0/css/all.css">
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
<h3 class="card-title mt-3 text-center">Thêm sản phẩm mới</h3>
<br>
<form action="/chi-tiet-sp/add" method="post">
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 34px">
                <i class="fas fa-tshirt" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 12px">Tên sản phẩm</p>
            </span>
        </div>
        <select id="sanPham" class="form-control" name="sanPham">
            <c:forEach items="${listSP}" var="sp">
                <option value="${sp.id}">${sp.ten}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 34px">
                <i class="fas fa-palette" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 12px">Màu sắc</p>
            </span>
        </div>
        <select id="mauSac" class="form-control" name="mauSac">
            <c:forEach items="${listMS}" var="ms">
                <option value="${ms.id}">${ms.ten}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 34px">
                <i class="fas fa-store" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 12px">Nhà sản xuất</p>
            </span>
        </div>
        <select id="nhaSX" class="form-control" name="nhaSX">
            <c:forEach items="${listNSX}" var="nsx">
                <option value="${nsx.id}">${nsx.ten}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 34px">
                <i class="fas fa-bezier-curve" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 12px">Dòng sản phẩm</p>
            </span>
        </div>
        <select id="dongSP" class="form-control" name="dongSP">
            <c:forEach items="${listDSP}" var="dsp">
                <option value="${dsp.id}">${dsp.ten}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 61px">
                <i class="fas fa-calendar" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 17px">Năm bảo hành</p>
            </span>
        </div>
        <input id="namBH" name="namBH" class="form-control" type="text" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 61px">
                <i class="fas fa-sticky-note" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 17px">Mô tả</p>
            </span>
        </div>
        <input id="moTa" name="moTa" class="form-control" type="text" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 61px">
                <i class="fas fa-sort-numeric-up-alt" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 17px">Số lượng tồn</p>
            </span>
        </div>
        <input id="soLuongTon" name="soLuongTon" class="form-control" type="text" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 61px">
                <i class="fas fa-file-signature" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 17px">Giá nhập</p>
            </span>
        </div>
        <input id="giaNhap" name="giaNhap" class="form-control" type="text" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 61px">
                <i class="fa-solid fa-cash-register" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 17px">Giá bán</p>
            </span>
        </div>
        <input id="giaBan" name="giaBan" class="form-control" type="text" style="padding-top: 10px">
    </div>
    <br>
    <div class="row">
        <button id="send" type="submit" class="btn btn-primary">Thêm</button>
    </div>
</form>
<script src="../js/js.js"></script>
</body>
</html>
