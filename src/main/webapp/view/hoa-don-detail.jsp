<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@include file="layout/header.jsp" %>
<body>
<section class="container" style="padding: 20px">
    <h1 style=text-align:center">Cập nhật hóa đơn</h1>
    <form action="/hoa-don/update?id=${hd.id}" method="post">
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Mã khách hàng</label>
            <div class="col-sm-10">
                <select class="form-select" aria-label="Default select example" name="khachHang">
                    <c:forEach items="${listKH}" var="kh">
                        <option value="${kh.id}" ${hd.idKH.id == kh.id ? "selected":""}>${kh.ma}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Mã nhân viên</label>
            <div class="col-sm-10">
                <select class="form-select" aria-label="Default select example" name="nhanVien">
                    <c:forEach items="${listNV}" var="nv">
                        <option value="${nv.id}" ${hd.idNV.id == kh.id ? "selected":""}>${nv.ma}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Mã hóa đơn</label>
            <div class="col-sm-10">
                <input id="ma" type="text" name="ma" class="form-control" value="${hd.ma}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Ngày tạo</label>
            <div class="col-sm-10">
                <input id="ngayTao" type="date" name="ngayTao" class="form-control" value="${ngayTao}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Ngày thanh toán</label>
            <div class="col-sm-10">
                <input id="ngayThanhToan" type="date" name="ngayThanhToan" class="form-control" value="${ngayThanhToan}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Ngày ship</label>
            <div class="col-sm-10">
                <input id="ngayShip" type="date" name="ngayShip" class="form-control" value="${ngayShip}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Ngày nhận</label>
            <div class="col-sm-10">
                <input id="ngayNhan" type="date" name="ngayNhan" class="form-control" value="${ngayNhan}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Tên người nhận</label>
            <div class="col-sm-10">
                <input type="text" name="tenNguoiNhan" class="form-control" value="${hd.tenNguoiNhan}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Địa chỉ</label>
            <div class="col-sm-10">
                <input id="diaChi" type="text" name="diaChi" class="form-control" value="${hd.diaChi}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Số điện thoại</label>
            <div class="col-sm-10">
                <input id="sdt" type="text" name="sdt" class="form-control" value="${hd.sdt}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Tình trạng</label>
            <div class="col-sm-10">
                <input type="text" name="tinhTrang" class="form-control"
                       value="${hd.tinhTrang == 1 ? "Paid" : "Chưa thanh toán"}">
            </div>
        </div>
        <button id="send" type="submit" class="btn btn-success">Update</button>
    </form>
</section>
<script src="../js/js.js"></script>
</body>
</html>