<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
    <title>TXP SHOP</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
</head>
<body>
<%@include file="layout/header.jsp" %>
<div class="container">
    <br>
    <div class="row">
        <div class="col-4">
            <h3 class="card-title mt-1 text-center">Thêm nhân viên</h3>
            <form action="/nhan-vien/add" method="post">
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px">
                            <i class="fas fa-id-card" style="font-size: 30px"></i>
                        </span>
                    </div>
                    <input id="ma" name="ma" class="form-control" placeholder="Mã nhân viên" type="text">
                </div> <!-- form-group// -->
                <br>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            <i class="fas fa-language" style="font-size: 30px"></i>
                        </span>
                    </div>
                    <input id="ho" name="ho" class="form-control" placeholder="Họ nhân viên" type="text"
                           style="padding-top: 10px">
                </div>
                <br>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 16px">
                            <i class="fas fa-file-signature" style="font-size: 30px"></i>
                        </span>
                    </div>
                    <input id="tenDem" name="tenDem" class="form-control" placeholder="Tên đệm" type="text"
                           style="padding-top: 10px">
                </div>
                <br>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            <i class="fas fa-signature" style="font-size: 30px"></i>
                        </span>
                    </div>
                    <input id="ten" name="ten" class="form-control" placeholder="Tên nhân viên" type="text"
                           style="padding-top: 10px">
                </div>
                <br>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 16px">
                            <i class="fas fa-venus-mars" style="font-size: 30px"></i>
                        </span>
                    </div>
                    <input id="gioiTinh" name="gioiTinh" class="form-control" placeholder="Giới tính" type="text"
                           style="padding-top: 10px">
                </div>
                <br>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 24px">
                            <i class="fas fa-birthday-cake" style="font-size: 30px"></i>
                        </span>
                    </div>
                    <input id="ngaySinh" name="ngaySinh" class="form-control" placeholder="Ngày sinh" type="date"
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
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 15px">
                            <i class="fas fa-user-tag" style="font-size: 30px"></i>
                        </span>
                    </div>
                    <select id="nhanVien" class="form-control" name="nhanVien">
                        <option selected value="">Chọn người gửi báo cáo</option>
                        <c:forEach items="${listNV}" var="nv">
                            <option value="${nv.id}">${nv.ho} ${nv.tenDem} ${nv.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right:17px">
                            <i class="fas fa-store" style="font-size: 30px"></i>
                        </span>
                    </div>
                    <select class="form-control" name="cuaHang">
                        <option selected value="">Chọn cửa hàng</option>
                        <c:forEach items="${listCH}" var="ch">
                            <option value="${ch.id}">${ch.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 23px">
                            <i class="fas fa-fingerprint" style="font-size: 30px"></i>
                        </span>
                    </div>
                    <select id="chucVu" class="form-control" name="chucVu">
                        <option selected value="">Chọn chức vụ</option>
                        <c:forEach items="${listCV}" var="cv">
                            <option value="${cv.id}">${cv.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 16px">
                            <i class="fas fa-signal" style="font-size: 30px"></i>
                        </span>
                    </div>
                    <select id="trangThai" class="form-control" name="trangThai">
                        <option selected value="=">Chọn trạng thái</option>
                        <option value="1">Hoạt động</option>
                        <option value="2">Không hoạt động</option>
                    </select>
                </div>
                <br>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="padding-right: 27px">
                            <i style="font-size: 30px" class="fa fa-lock"></i>
                        </span>
                    </div>
                    <input id="matKhau" name="matKhau" class="form-control" placeholder="Mật khẩu" type="text"
                           style="padding-top: 10px">
                </div>
                <br>
                <button id="send" class="btn btn-primary btn-block" type="submit">Thêm</button>
            </form>
        </div>
        <div class="col-8">
            <h3 class="card-title mt-1 text-center">Danh sách nhân viên</h3>
            <table class="table table-bordered">
                <thead class="table-dark">
                <tr>
                    <td>Mã</td>
                    <td colspan="3">Họ và tên</td>
                    <td>Giới tính</td>
                    <td>Sđt</td>
                    <td>Ngày sinh</td>
                    <td>Địa chỉ</td>
                    <td>Gửi báo cáo</td>
                    <td>Cửa hàng</td>
                    <td>Chức vụ</td>
                    <td>Trạng thái</td>
                    <td>Mật khẩu</td>
                    <td>Action</td>
                </tr>
                </thead>
                <tbody class="table-hover">
                <c:forEach items="${listNV}" var="nv">
                    <tr>
                        <td>${nv.ma}</td>
                        <td colspan="3">${nv.ho} ${nv.tenDem} ${nv.ten}</td>
                        <td>${nv.gioiTinh}</td>
                        <td>${nv.sdt}</td>
                        <td>${nv.ngaySinh}</td>
                        <td>${nv.diaChi}</td>
                        <td>${nv.idGBC.ten}</td>
                        <td>${nv.idCH.ten}</td>
                        <td>${nv.idCV.ten}</td>
                        <td>${nv.trangThai == 1 ? "Hoạt động" : "Không hoạt động"}</td>
                        <td>${nv.matKhau}</td>
                        <td><a href="/nhan-vien/detail?id=${nv.id}">
                            <button type="submit" class="btn btn-info">Sửa</button>
                        </a>
                            <a href="/nhan-vien/delete?id=${nv.id}">
                                <button type="submit" class="btn btn-info">Xóa</button>
                            </a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="../js/js.js"></script>
</body>
</html>
