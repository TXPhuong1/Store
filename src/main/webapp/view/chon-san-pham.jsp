<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
    <title>TXP SHOP</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.4.0/css/all.css">
    <style>
        .input-group-prepend {
            width: 80px;
        }
    </style>
</head>
<body>
<%@include file="layout/header.jsp" %>
<br>
<div class="row">
    <div class="col-4">
        <h3 class="card-title mt-1 text-center">Thêm hóa đơn</h3>
        <form action="/hoa-don-chi-tiet/add" method="post">
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text">
                            <i class="fas fa-file-signature" style="font-size: 30px"></i>
                        </span>
                </div>
                <select id="hoaDon" class="form-control" name="hoaDon">
                    <c:forEach items="${listHD}" var="hd">
                        <option value="${hd.id}" ${idHD.id == hd.id ? "selected" :""}>${hd.ma}</option>
                    </c:forEach>
                </select>
            </div>
            <br>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px">
                            <i class="fas fa-tshirt" style="font-size: 30px"></i>
                        </span>
                </div>
                <select id="chiTietSP" class="form-control" name="chiTietSP">
                    <option selected value="">Chọn sản phẩm</option>
                    <c:forEach items="${listCTSP}" var="ctsp">
                        <option value="${ctsp.id}">${ctsp.idSP.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <br>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 24px">
                            <i class="fas fa-sort-numeric-up-alt" style="font-size: 30px"></i>
                        </span>
                </div>
                <input id="soLuong" name="soLuong" class="form-control" placeholder="Số lượng" type="text"
                       style="padding-top: 10px">
            </div>
            <br>
            <button id="send" class="btn btn-primary btn-block" type="submit">Thêm</button>
        </form>
    </div>
    <div class="col-8">
        <h3 class="card-title mt-1 text-center">Hóa đơn</h3>
        <table class="table table-bordered">
            <thead class="table-dark">
            <tr>
                <th>Mã hóa đơn</th>
                <th>Mã sản phẩm</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
                <th>Thành tiền</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHDCT}" var="hdct">
                <tr>
                    <td>${hdct.idHoaDon.ma}</td>
                    <td>${hdct.idChiTietSP.idSP.ten}</td>
                    <td>${hdct.soLuong}</td>
                    <td>${hdct.donGia}</td>
                    <td>${hdct.donGia *  hdct.soLuong}</td>
                    <td>
                        <a href="/hoa-don-chi-tiet/delete?idHD=${hdct.idHoaDon.id}&idSP=${hdct.idChiTietSP.id}">
                            <button type="submit" class="btn btn-info">Xóa</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="../js/js.js"></script>
</body>
</html>
