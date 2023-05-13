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
<div class="container">
    <br>
    <div class="row">
        <div class="col-6">
            <h3 class="card-title mt-1 text-center">Thêm cửa hàng</h3>
            <form action="/cua-hang/add" method="post">
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 20px">
                            <i class="fas fa-id-card" style="font-size: 30px"></i>
                        </span>
                    </div>
                    <input id="ma" name="ma" class="form-control" placeholder="Mã cửa hàng" type="text">
                </div> <!-- form-group// -->
                <br>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            <i class="fas fa-language" style="font-size: 30px"></i>
                        </span>
                    </div>
                    <input id="ten" name="ten" class="form-control" placeholder="Tên cửa hàng" type="text"
                           style="padding-top: 10px">
                </div>
                <br>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 26px">
                            <i style="font-size: 30px" class="fas fa-map-marker-alt"></i>
                        </span>
                    </div>
                    <input id="diaChi" name="diaChi" class="form-control" placeholder="Địa chỉ" type="text"
                           style="padding-top: 10px">
                </div>
                <br>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 22px">
                            <i style="font-size: 30px" class="fa fa-building"></i>
                        </span>
                    </div>
                    <input id="thanhPho" name="thanhPho" class="form-control" placeholder="Thành phố" type="text"
                           style="padding-top: 10px">
                </div>
                <br>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 19px">
                            <i style="font-size: 30px" class="fas fa-globe"></i>
                        </span>
                    </div>
                    <input id="quocGia" name="quocGia" class="form-control" placeholder="Quốc gia" type="text"
                           style="padding-top: 10px">
                </div>
                <br>
                <button id="send" class="btn btn-primary btn-block" type="submit">Thêm</button>
            </form>
        </div>
        <div class="col-6">
            <h3 class="card-title mt-1 text-center">Danh sách cửa hàng</h3>
            <table class="table table-bordered">
                <thead class="table-dark">
                <tr>
                    <td>Mã</td>
                    <td>Tên</td>
                    <td>Địa chỉ</td>
                    <td>Thành phố</td>
                    <td>Quốc gia</td>
                    <td>Action</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listCH}" var="ch">
                    <tr>
                        <td>${ch.ma}</td>
                        <td>${ch.ten}</td>
                        <td>${ch.diaChi}</td>
                        <td>${ch.thanhPho}</td>
                        <td>${ch.quocGia}</td>
                        <td><a href="/cua-hang/detail?id=${ch.id}">
                            <button type="submit" class="btn btn-info">Sửa</button>
                        </a>
                            <a href="/cua-hang/delete?id=${ch.id}">
                                <button type="submit" class="btn btn-info">Xóa</button>
                            </a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="../js/js.js">
</script>
</body>
</html>