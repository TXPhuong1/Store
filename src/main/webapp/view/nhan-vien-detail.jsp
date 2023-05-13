<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
    <title>TXP SHOP</title>
    <!------ Include the above in your HEAD tag ---------->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
</head>
<body class="container">
<%@include file="layout/header.jsp" %>
<br>
<h3 class="card-title mt-3 text-center">Sửa nhân viên</h3>
<br>
<form action="/nhan-vien/update?id=${nhanVien.id}" method="post" class="container">
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">
                <i class="fas fa-id-card" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 10px">Mã nhân viên</p>
            </span>
        </div>
        <input id="ma" name="ma" class="form-control" type="text" value="${nhanVien.ma}" style="padding-top: 10px">
    </div> <!-- form-group// -->
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">
                <i class="fas fa-language" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 10px">Họ nhân viên</p>
            </span>
        </div>
        <input id="ho" name="ho" class="form-control" type="text" value="${nhanVien.ho}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 40px">
                <i class="fas fa-file-signature" style="font-size: 20px; margin-left: 5px"></i>
                <p style="margin-top: 17px; margin-left: 10px">Tên đệm</p>
            </span>
        </div>
        <input id="tenDem" name="tenDem" class="form-control" type="text" value="${nhanVien.tenDem}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">
                <i class="fas fa-signature" style="font-size: 14px"></i>
                <p style="margin-top: 17px; margin-left: 10px">Tên nhân viên</p>
            </span>
        </div>
        <input id="ten" name="ten" class="form-control" type="text" value="${nhanVien.ten}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 48px">
                <i class="fas fa-venus-mars" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 10px">Giới tính</p>
            </span>
        </div>
        <input id="gioiTinh" name="gioiTinh" class="form-control" type="text" value="${nhanVien.gioiTinh}" style="padding-top: 10px">
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
        <input name="sdt" class="form-control" type="text" value="${nhanVien.sdt}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 61px">
                <i class="fas fa-map-marker-alt" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 17px">Địa chỉ</p>
            </span>
        </div>
        <input id="diaChi" name="diaChi" class="form-control" type="text" value="${nhanVien.diaChi}" style="padding-top: 10px">
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 19px">
                <i class="fas fa-user-tag" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 10px">Gửi báo cáo</p>
            </span>
        </div>
        <select id="nhanVien" class="form-control" name="nhanVien">
            <c:forEach items="${listNhanVien}" var="nv">
                <option value="${nv.id}" ${nhanVien.idGBC == nv.id ? "selected":"" }>${nv.idGBC.ten}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 34px">
                <i class="fas fa-store" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 12px">Cửa hàng</p>
            </span>
        </div>
        <select id="cuaHang" class="form-control" name="cuaHang">
            <c:forEach items="${listCuaHang}" var="ch">
                <option value="${ch.id}" ${nhanVien.idCH.id == ch.id ? "selected":"" }>${ch.ten}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 42px">
                <i class="fas fa-fingerprint" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 18px">Chức vụ</p>
            </span>
        </div>
        <select id="chucVu" class="form-control" name="chucVu">
            <c:forEach items="${listChucVu}" var="cv">
                <option class="form-control"
                        value="${cv.id}" ${nhanVien.idCV.id == cv.id ? "selected":"" }>${cv.ten}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 29px">
                <i class="fas fa-signal" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 15px">Trạng thái</p>
            </span>
        </div>
        <select id="trangThai" class="form-control" name="trangThai">
            <option value="1" ${nhanVien.trangThai == 1 ? "selected":"" }>Hoạt động</option>
            <option value="2" ${nhanVien.trangThai == 2 ? "selected":"" }>Không hoạt động</option>
        </select>
    </div>
    <br>
    <div class="form-group input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" style="padding-right: 34px">
                <i class="fa fa-lock" style="font-size: 20px"></i>
                <p style="margin-top: 17px; margin-left: 23px">Mật khẩu</p>
            </span>
        </div>
        <input id="matKhau" name="matKhau" class="form-control" type="text" value="${nhanVien.matKhau}" style="padding-top: 10px">
    </div>
    <br>
    <div class="row">
        <button id="send" type="submit" class="btn btn-primary btn-block">Sửa</button>
    </div>
</form>
<script src="../js/js.js"></script>
</body>
</html>
