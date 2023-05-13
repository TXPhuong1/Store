<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@include file="layout/header.jsp" %>
<body class="container">
<main>
    <div class="py-5 text-center">
        <h2>Checkout form</h2>
    </div>
    <div class="row g-5">
        <div class="col-md-5 col-lg-5 order-md-last">
            <h4 class="d-flex justify-content-between align-items-center mb-3">
                <span class="text-primary">Your cart</span>
            </h4>
            <table id="myTable" class="table table-bordered">
                <thead>
                <tr>
                    <th>Mã hóa đơn</th>
                    <th>Mã sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Đơn giá</th>
                    <th>Thành tiền</th>
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
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <form class="card p-2">
                <h1 id="total" class="input-group">
                </h1>
            </form>
        </div>
        <div class="col-7">
            <form action="/hoa-don/update?id=${hd.id}" method="post">
                <div class="mb-3 row">
                    <label class="col-sm-3 col-form-label">Mã khách hàng</label>
                    <div class="col-sm-9">
                        <select class="form-select" aria-label="Default select example" name="khachHang">
                            <c:forEach items="${listKH}" var="kh">
                                <option value="${kh.id}" ${hd.idKH.id == kh.id ? "selected":""}>${kh.ma}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-3 col-form-label">Mã nhân viên</label>
                    <div class="col-sm-9">
                        <select class="form-select" aria-label="Default select example" name="nhanVien">
                            <c:forEach items="${listNV}" var="nv">
                                <option value="${nv.id}" ${hd.idNV.id == kh.id ? "selected":""}>${nv.ma}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-3 col-form-label">Mã hóa đơn</label>
                    <div class="col-sm-9">
                        <select class="form-select" aria-label="Default select example" name="hoaDon">
                            <c:forEach items="${listHDCT}" var="hdct">
                                <option value="${hdct.idHoaDon.id}" ${hdct.idHoaDon.id == hd.id ? "selected":""}>${hd.ma}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
<%--                <div class="mb-3 row">--%>
<%--                    <label class="col-sm-3 col-form-label">Mã hóa đơn</label>--%>
<%--                    <div class="col-sm-9">--%>
<%--                        <input type="text" name="ma" class="form-control" value="${hd.ma}">--%>
<%--                    </div>--%>
<%--                </div>--%>
                <div class="mb-3 row">
                    <label class="col-sm-3 col-form-label">Ngày tạo</label>
                    <div class="col-sm-9">
                        <input id="ngayTao" type="date" name="ngayTao" class="form-control" value="${ngayTao}">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-3 col-form-label">Ngày thanh toán</label>
                    <div class="col-sm-9">
                        <input id="ngayThanhToan" type="date" name="ngayThanhToan" class="form-control" value="${ngayThanhToan}">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-3 col-form-label">Ngày ship</label>
                    <div class="col-sm-9">
                        <input id="ngayShip" type="date" name="ngayShip" class="form-control" value="${ngayShip}">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-3 col-form-label">Ngày nhận</label>
                    <div class="col-sm-9">
                        <input id="ngayNhan" type="date" name="ngayNhan" class="form-control" value="${ngayNhan}">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-3 col-form-label">Tên người nhận</label>
                    <div class="col-sm-9">
                        <input id="tenNguoiNhan" type="text" name="tenNguoiNhan" class="form-control" value="${hd.tenNguoiNhan}">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-3 col-form-label">Địa chỉ</label>
                    <div class="col-sm-9">
                        <input id="diaChi" type="text" name="diaChi" class="form-control" value="${hd.diaChi}">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-3 col-form-label">Số điện thoại</label>
                    <div class="col-sm-9">
                        <input id="sdt" type="text" name="sdt" class="form-control" value="${hd.sdt}">
                    </div>
                </div>
                <button id="send" type="submit" class="btn btn-success">Thanh toán</button>
            </form>
        </div>
    </div>
</main>
<script>
    function calculateSum() {
        let sum = 0;
        const tableRows = document.getElementsByTagName("tr");

        for (let i = 1; i < tableRows.length; i++) {
            const tableCells = tableRows[i].getElementsByTagName("td");
            const cellValue = parseFloat(tableCells[4].textContent);
            sum += cellValue;
        }
        return sum;
    }
    const totalInner = document.getElementById('total');
    totalInner.innerText = "Tổng tiền: " + calculateSum();
</script>
<script src="../js/js.js"></script>
</body>
</html>



