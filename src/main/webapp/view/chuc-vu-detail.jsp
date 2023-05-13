<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
    <title>TXP SHOP</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
<%@include file="layout/header.jsp" %>
<style>
    .divider-text span {
        padding: 7px;
        font-size: 12px;
        position: relative;
        z-index: 2;
    }

    .container {
        margin-top: 100px;
    }
</style>
<div class="container">
    <h3 class="card-title mt-3 text-center">Sửa chức vụ</h3>
    <br>
    <div class="row">
        <div class="col-12">
            <form action="/chuc-vu/update?id=${cv.id}" method="post">
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            <i class="fas fa-id-card" style="font-size: 30px"></i>
                            <p style="margin-top: 17px; margin-left: 10px; margin-right: 12px">Mã chức vụ</p>
                        </span>
                    </div>
                    <input id="ma" name="ma" class="form-control" type="text" value="${cv.ma}" style="padding-top: 10px">
                </div> <!-- form-group// -->
                <br>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            <i class="fas fa-language" style="font-size: 30px"></i>
                            <p style="margin-top: 17px; margin-left: 10px">Tên chức vụ</p>
                        </span>
                    </div>
                    <input id="ten" name="ten" class="form-control" type="text" value="${cv.ten}" style="padding-top: 10px">
                </div> <!-- form-group// -->
                <%--                <div class="form-group input-group">--%>
                <%--                    <div class="input-group-prepend">--%>
                <%--                        <span class="input-group-text"> <i class="fa fa-phone"></i> </span>--%>
                <%--                    </div>--%>
                <%--                    <select class="custom-select" style="max-width: 120px;">--%>
                <%--                        <option selected="">+971</option>--%>
                <%--                        <option value="1">+972</option>--%>
                <%--                        <option value="2">+198</option>--%>
                <%--                        <option value="3">+701</option>--%>
                <%--                    </select>--%>
                <%--                    <input name="" class="form-control" placeholder="Phone number" type="text">--%>
                <%--                </div> <!-- form-group// -->--%>
                <%--                <div class="form-group input-group">--%>
                <%--                    <div class="input-group-prepend">--%>
                <%--                        <span class="input-group-text"> <i class="fa fa-building"></i> </span>--%>
                <%--                    </div>--%>
                <%--                    <select class="form-control">--%>
                <%--                        <option selected=""> Select job type</option>--%>
                <%--                        <option>Designer</option>--%>
                <%--                        <option>Manager</option>--%>
                <%--                        <option>Accaunting</option>--%>
                <%--                    </select>--%>
                <%--                </div> <!-- form-group end.// -->--%>
                <%--                <div class="form-group input-group">--%>
                <%--                    <div class="input-group-prepend">--%>
                <%--                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>--%>
                <%--                    </div>--%>
                <%--                    <input class="form-control" placeholder="Create password" type="password">--%>
                <%--                </div> <!-- form-group// -->--%>
                <%--                <div class="form-group input-group">--%>
                <%--                    <div class="input-group-prepend">--%>
                <%--                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>--%>
                <%--                    </div>--%>
                <%--                    <input class="form-control" placeholder="Repeat password" type="password">--%>
                <%--                </div> <!-- form-group// -->--%>
                <%--                <div class="form-group">--%>
                <br>
                <button id="send" type="submit" class="btn btn-primary btn-block">Sửa</button>
        </div> <!-- form-group// -->
        </form>
    </div>
</div>
<script src="../js/js.js"></script>
</body>
</html>
