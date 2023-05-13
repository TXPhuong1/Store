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
            width: 50px;
        }

        input {
            width: 200px;
        }

        .form-group {
            margin-bottom: 20px;
        }

    </style>
</head>
<body>
<%@include file="layout/header.jsp" %>
<br>
<div class="row">
    <div class="col-4">
        <h3 class="card-title mt-1 text-center">Thêm khách hàng</h3>
        <form class="form-group input-group" action="/khach-hang/add" method="post">
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px ; padding-bottom:10px">
                          <i class="fas fa-id-card" style="font-size: 20px"></i>
                        </span>
                </div>
                <input id="ma" name="ma" class="form-control" placeholder="Mã khách hàng" type="text">
            </div>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px ; padding-bottom:10px">
                            <i class="fas fa-language" style="font-size: 20px"></i>
                        </span>
                </div>
                <input id="ho" name="ho" class="form-control" placeholder="Họ khách hàng" type="text">
            </div>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px ; padding-bottom:10px">
                            <i class="fas fa-file-signature" style="font-size: 20px"></i>
                        </span>
                </div>
                <input id="tenDem" name="tenDem" class="form-control" placeholder="Tên đệm" type="text">
            </div>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px ; padding-bottom:10px">
                            <i class="fas fa-signature" style="font-size: 20px"></i>
                        </span>
                </div>
                <input id="ten" name="ten" class="form-control" placeholder="Tên khách hàng" type="text">
            </div>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px ; padding-bottom:10px">
                            <i class="fas fa-birthday-cake" style="font-size: 20px"></i>
                        </span>
                </div>
                <input id="ngaySinh" name="ngaySinh" class="form-control" placeholder="Ngày sinh" type="date">
            </div>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px ; padding-bottom:10px">
                            <i style="font-size: 20px" class="fa fa-phone"></i>
                        </span>
                </div>
                <input id="sdt" name="sdt" class="form-control" placeholder="Số điện thoại" type="text">
            </div>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px ; padding-bottom:10px">
                            <i style="font-size: 20px" class="fas fa-map-marker-alt"></i>
                        </span>
                </div>
                <input id="diaChi" name="diaChi" class="form-control" placeholder="Địa chỉ khách hàng" type="text">
            </div>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px ; padding-bottom:10px">
                            <i class="fa fa-building" style="font-size: 20px"></i>
                        </span>
                </div>
                <input id="thanhPho" name="thanhPho" class="form-control" placeholder="Thành phố" type="text">
            </div>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px ; padding-bottom:10px">
                            <i class="fas fa-globe" style="font-size: 20px"></i>
                        </span>
                </div>
                <input id="quocGia" name="quocGia" class="form-control" placeholder="Quốc gia" type="text">
            </div>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px ; padding-bottom:10px">
                            <i style="font-size: 20px" class="fa fa-lock"></i>
                        </span>
                </div>
                <input id="matKhau" name="matKhau" class="form-control" placeholder="Mật khẩu" type="password">
            </div>
            <button id="send" class="btn btn-success" type="submit">Thêm</button>
        </form>
    </div>
    <div class="col-8">
        <h3 class="card-title mt-1 text-center">Danh sách khách hàng</h3>
        <table class="table table-bordered">
            <thead class="table-dark">
            <tr>
                <td>Mã</td>
                <td>Họ và tên</td>
                <td>Sđt</td>
                <td>Ngày sinh</td>
                <td>Địa chỉ</td>
                <td>Thành phố</td>
                <td>Quốc gia</td>
                <td>Mật khẩu</td>
                <td colspan="2">Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listKH}" var="kh">
                <tr>
                    <td>${kh.ma}</td>
                    <td>${kh.ho} ${kh.tenDem} ${kh.ten}</td>
                    <td>${kh.sdt}</td>
                    <td>${kh.ngaySinh}</td>
                    <td>${kh.diaChi}</td>
                    <td>${kh.thanhPho}</td>
                    <td>${kh.quocGia}</td>
                    <td>${kh.matKhau}</td>
                    <td><a href="/khach-hang/detail?id=${kh.id}">
                        <button type="submit" class="btn btn-info">Sửa</button>
                    </a></td>
                    <td><a href="/khach-hang/delete?id=${kh.id}">
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