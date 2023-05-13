<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@include file="layout/header.jsp" %>
<style>

    .card {
        border: none
    }

    .product {
        background-color: #eee
    }

    .brand {
        font-size: 13px
    }

    .act-price {
        color: red;
        font-weight: 700
    }

    .dis-price {
        text-decoration: line-through
    }

    .about {
        font-size: 14px
    }

    .color {
        margin-bottom: 10px
    }

    label.radio {
        cursor: pointer
    }

    label.radio input {
        position: absolute;
        top: 0;
        left: 0;
        visibility: hidden;
        pointer-events: none
    }

    label.radio span {
        padding: 2px 9px;
        border: 2px solid #ff0000;
        display: inline-block;
        color: #ff0000;
        border-radius: 3px;
        text-transform: uppercase
    }

    label.radio input:checked + span {
        border-color: #ff0000;
        background-color: #ff0000;
        color: #fff
    }

    .btn-danger {
        background-color: #ff0000 !important;
        border-color: #ff0000 !important
    }

    .btn-danger:hover {
        background-color: #da0606 !important;
        border-color: #da0606 !important
    }

    .btn-danger:focus {
        box-shadow: none
    }

    .cart i {
        margin-right: 10px
    }
</style>
<body>
<div class="container mt-5 mb-5">
    <div class="row d-flex justify-content-center">
        <div class="col-md-10">
            <div class="card">
                <div class="row">
                    <div class="col-md-6">
                        <div class="images p-3">
                            <div class="text-center p-4"><img id="main-image" src="../image/${ctsp.idSP.ma}.jpg"
                                                              width="470px" height="500px"/></div>
                            <div class="thumbnail text-center"><img onclick="change_image(this)"
                                                                    src="../image/${ctsp.idSP.ma}.jpg" width="100"
                                                                    height="130">
                                <img onclick="change_image(this)" src="../image/${ctsp.idSP.ma}A.jpg" width="100"
                                     height="130">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6" style="margin-top: 35px">
                        <h3 text-align: center>Cập Nhật Chi Tiết Sản Phẩm</h3>
                        <form action="/chi-tiet-sp/update?id=${ctsp.id}" method="post">
                            <div class="mb-3 row">
                                <label class="col-sm-3 col-form-label">Tên sản phẩm</label>
                                <div class="col-sm-8">
                                    <select class="form-select" aria-label="Default select example" name="sanPham">
                                        <c:forEach items="${listSP}" var="sp">
                                            <option value="${sp.id}" ${ctsp.idSP.id == sp.id ? "selected":"" }>${sp.ten}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <label class="col-sm-3 col-form-label">Tên màu</label>
                                <div class="col-sm-8">
                                    <select class="form-select" aria-label="Default select example" name="mauSac">
                                        <c:forEach items="${listMS}" var="ms">
                                            <option value="${ms.id}" ${ctsp.idMauSac.id == ms.id ? "selected":"" }>${ms.ten}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <label class="col-sm-3 col-form-label">Tên NSX</label>
                                <div class="col-sm-8">
                                    <select class="form-select" aria-label="Default select example" name="nhaSX">
                                        <c:forEach items="${listNSX}" var="nsx">
                                            <option value="${nsx.id}" ${ctsp.idNSX.id == nsx.id ? "selected":"" }>${nsx.ten}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <label class="col-sm-3 col-form-label">Tên dòng SP</label>
                                <div class="col-sm-8">
                                    <select class="form-select" aria-label="Default select example" name="dongSP">
                                        <c:forEach items="${listDSP}" var="dsp">
                                            <option value="${dsp.id}" ${ctsp.idDongSP.id == dsp.id ? "selected":"" }>${dsp.ten}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <label for="namBH" class="col-sm-3 col-form-label">Năm bảo hành</label>
                                <div class="col-sm-8">
                                    <input type="text" name="namBH" class="form-control" id="namBH" value="${ctsp.namBH}">
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <label for="mota" class="col-sm-3 col-form-label">Mô tả</label>
                                <div class="col-sm-8">
                                    <input type="text" name="moTa" class="form-control" id="mota" value="${ctsp.moTa}">
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <label for="soLuongTon" class="col-sm-3 col-form-label">Số lượng tồn</label>
                                <div class="col-sm-8">
                                    <input type="text" name="soLuongTon" class="form-control" id="soLuongTon"
                                           value="${ctsp.soLuongTon}">
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <label for="giaNhap" class="col-sm-3 col-form-label">Giá nhập</label>
                                <div class="col-sm-8">
                                    <input type="text" name="giaNhap" class="form-control" id="giaNhap" value="${ctsp.giaNhap}">
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <label for="giaBan" class="col-sm-3 col-form-label">Giá bán</label>
                                <div class="col-sm-8">
                                    <input type="text" name="giaBan" class="form-control" id="giaBan" value="${ctsp.giaBan}">
                                </div>
                            </div>
                            <div class="row">
                                <button id="send" type="submit" class="btn btn-primary">Sửa</button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function change_image(image) {
        var container = document.getElementById("main-image");
        container.src = image.src;
    }

    document.addEventListener("DOMContentLoaded", function (event) {
    });
</script>
<script src="../js/js.js"></script>
</body>
</html>
