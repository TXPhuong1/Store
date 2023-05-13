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
    <div class="col-3">
        <h3 class="card-title mt-1 text-center">Thêm hóa đơn</h3>
        <form action="/hoa-don/add" method="post">
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px">
                            <i class="fas fa-id-card" style="font-size: 30px"></i>
                        </span>
                </div>
                <select id="nhanVien" class="form-control" name="nhanVien">
                    <option selected value="">Chọn nhân viên</option>
                    <c:forEach items="${listNV}" var="nv">
                        <option value="${nv.id}">${nv.ho} ${nv.tenDem} ${nv.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <br>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px">
                            <i class="fas fa-person-booth" style="font-size: 30px"></i>
                        </span>
                </div>
                <select id="khachHang" class="form-control" name="khachHang">
                    <option selected value="">Chọn khách hàng</option>
                    <c:forEach items="${listKH}" var="kh">
                        <option value="${kh.id}">${kh.ho} ${kh.tenDem} ${kh.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <br>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px">
                            <i class="fas fa-language" style="font-size: 30px"></i>
                        </span>
                </div>
                <input id="ma" name="ma" class="form-control" placeholder="Mã hóa đơn" type="text">
            </div> <!-- form-group// -->
            <br>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text">
                            <i class="fas fa-file-signature" style="font-size: 30px"></i>
                        </span>
                </div>
                <input id="ngayTao" name="ngayTao" class="form-control" placeholder="Ngày tạo" type="date"
                       style="padding-top: 10px">
            </div>
            <br>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 16px">
                            <i class="fas fa-file-invoice-dollar" style="font-size: 30px"></i>
                        </span>
                </div>
                <input id="ngayThanhToan" name="ngayThanhToan" class="form-control" placeholder="Ngày thanh toán" type="date"
                       style="padding-top: 10px">
            </div>
            <br>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text">
                            <i class="fas fa-truck" style="font-size: 30px"></i>
                        </span>
                </div>
                <input id="ngayShip" name="ngayShip" class="form-control" placeholder="Ngày ship" type="date"
                       style="padding-top: 10px">
            </div>
            <br>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 16px">
                            <i class="fa-solid fa-hand-holding-hand" style="font-size: 30px"></i>
                        </span>
                </div>
                <input id="ngayNhan" name="ngayNhan" class="form-control" placeholder="Ngày nhận" type="date"
                       style="padding-top: 10px">
            </div>
            <br>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 24px">
                            <i class="fas fa-signature" style="font-size: 30px"></i>
                        </span>
                </div>
                <input id="tenNguoiNhan" name="tenNguoiNhan" class="form-control" placeholder="Tên người nhận" type="text"
                       style="padding-top: 10px">
            </div>
            <br>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 28px">
                            <i style="font-size: 30px" class="fas fa-map-marker-alt"></i>
                        </span>
                </div>
                <input id="diaChi" name="diaChi" class="form-control" placeholder="Địa chỉ" type="text"
                       style="padding-top: 10px">
            </div>
            <br>
            <div class="form-group input-group">
                <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 21px">
                            <i style="font-size: 30px" class="fa fa-phone"></i>
                        </span>
                </div>
                <input id="sdt" name="sdt" class="form-control" placeholder="Số điện thoại" type="text"
                       style="padding-top: 10px">
            </div>
            <br>
            <button id="send" class="btn btn-primary btn-block" type="submit">Thêm</button>
        </form>
    </div>
    <div class="col-9">
        <h3 class="card-title mt-1 text-center">Danh sách hóa đơn</h3>
        <table class="table table-bordered">
            <thead class="table-dark">
            <tr>
                <th>Mã hóa đơn</th>
                <th>Khách hàng</th>
                <th>Nhân viên</th>
                <th>Ngày tạo</th>
                <th>Ngày thanh toán</th>
                <th>Ngày ship</th>
                <th>Ngày nhận</th>
                <th>Tên người nhận</th>
                <th>Địa chỉ</th>
                <th>Sđt</th>
                <th>Tình trạng</th>
                <th colspan="3">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHD}" var="hd">
                <tr>
                    <td>${hd.ma}</td>
                    <td>${hd.idKH.ho} ${hd.idKH.tenDem} ${hd.idKH.ten}</td>
                    <td>${hd.idNV.ho} ${hd.idNV.tenDem} ${hd.idNV.ten}</td>
                    <td>${hd.ngayTao}</td>
                    <td>${hd.ngayThanhToan}</td>
                    <td>${hd.ngayShip}</td>
                    <td>${hd.ngayNhan}</td>
                    <td>${hd.tenNguoiNhan}</td>
                    <td>${hd.diaChi}</td>
                    <td>${hd.sdt}</td>
                    <td>${hd.tinhTrang == 1 ? "Đã thanh toán" : "Chưa thanh toán"}</td>
                    <div>

                        <td>
                            <a href="/hoa-don/chon-san-pham?id=${hd.id}">
                                <button ${hd.tinhTrang == 1 ? "disabled" : ""} type="submit" class="btn btn-info">Chọn
                                    sản phẩm
                                </button>
                            </a>
                        </td>
                        <td>
                            <a href="/hoa-don/thanh-toan?id=${hd.id}">
                                <button ${hd.tinhTrang == 1 ? "disabled" : ""} type="submit" class="btn btn-info">Thanh
                                    toán
                                </button>
                            </a>
                        </td>
                        <td>
                            <a href="/hoa-don/delete?id=${hd.id}">
                                <button ${hd.tinhTrang == 1 ? "disabled" : ""} type="submit" class="btn btn-info">Xóa
                                </button>
                            </a>
                        </td>
                    </div>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="../js/js.js"></script>
</body>
</html>
