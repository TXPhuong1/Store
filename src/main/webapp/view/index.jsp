<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="layout/header.jsp" %>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <style>
        .product-grid2 {
            font-family: 'Open Sans', sans-serif;
            position: relative
        }

        .product-grid2 .product-image2 {
            overflow: hidden;
            position: relative
        }

        .product-grid2 .product-image2 a {
            display: block
        }

        .product-grid2 .product-image2 img {
            width: 100%;
            height: auto
        }

        .product-image2 .pic-1 {
            opacity: 1;
            transition: all .5s
        }

        .product-grid2:hover .product-image2 .pic-1 {
            opacity: 0
        }

        .product-image2 .pic-2 {
            width: 100%;
            height: 100%;
            opacity: 0;
            position: absolute;
            top: 0;
            left: 0;
            transition: all .5s
        }

        .product-grid2:hover .product-image2 .pic-2 {
            opacity: 1
        }

        .product-grid2 .social {
            padding: 0;
            margin: 0;
            position: absolute;
            bottom: 50px;
            right: 25px;
            z-index: 1
        }

        .product-grid2 .social li {
            margin: 0 0 10px;
            display: block;
            transform: translateX(100px);
            transition: all .5s
        }

        .product-grid2:hover .social li {
            transform: translateX(0)
        }

        .product-grid2:hover .social li:nth-child(2) {
            transition-delay: .15s
        }

        .product-grid2:hover .social li:nth-child(3) {
            transition-delay: .25s
        }

        .product-grid2 .social li a {
            color: #505050;
            background-color: #fff;
            font-size: 17px;
            line-height: 45px;
            text-align: center;
            height: 45px;
            width: 45px;
            border-radius: 50%;
            display: block;
            transition: all .3s ease 0s
        }

        .product-grid2 .social li a i {
            margin-top: 15px;
        }

        .product-grid2 .social li a:hover {
            color: #fff;
            background-color: #3498db;
            box-shadow: 0 0 10px rgba(0, 0, 0, .5)
        }

        .product-grid2 .social li a:after, .product-grid2 .social li a:before {
            content: attr(data-tip);
            color: #fff;
            background-color: #000;
            font-size: 12px;
            line-height: 22px;
            border-radius: 3px;
            padding: 0 5px;
            white-space: nowrap;
            opacity: 0;
            transform: translateX(-50%);
            position: absolute;
            left: 50%;
            top: -30px
        }

        .product-grid2 .social li a:after {
            content: '';
            height: 15px;
            width: 15px;
            border-radius: 0;
            transform: translateX(-50%) rotate(45deg);
            top: -22px;
            z-index: -1
        }

        .product-grid2 .social li a:hover:after, .product-grid2 .social li a:hover:before {
            opacity: 1
        }

        .product-grid2 .add-to-cart {
            color: #fff;
            background-color: #404040;
            font-size: 15px;
            text-align: center;
            width: 100%;
            padding: 10px 0;
            display: block;
            position: absolute;
            left: 0;
            bottom: -100%;
            transition: all .3s
        }

        .product-grid2 .add-to-cart:hover {
            background-color: #3498db;
            text-decoration: none
        }

        .product-grid2:hover .add-to-cart {
            bottom: 0
        }

        .product-grid2 .product-content {
            padding: 20px 10px;
            text-align: center
        }

        .product-grid2 .title {
            font-size: 17px;
            margin: 0 0 7px
        }

        .product-grid2 .title a {
            color: #303030
        }

        .product-grid2 .title a:hover {
            color: #3498db
        }

        .product-grid2 .price {
            color: #303030;
            font-size: 15px
        }

        @media screen and (max-width: 990px) {
            .product-grid2 {
                margin-bottom: 30px
            }
        }
    </style>
</head>
<body>
<br>
<div class="row">
    <h3 class="card-title mt-1 text-center" style="margin-bottom: 50px">Danh sách sản phẩm</h3>
    <c:forEach items="${listCTSP}" var="ctsp">
        <div class="col-md-3 col-sm-6">
            <div class="product-grid2">
                <div class="product-image2" style="height: 300px">
                    <a href="#">
                        <img class="pic-1" src="../image/${ctsp.idSP.ma}.jpg">
                        <img class="pic-2" src="../image/${ctsp.idSP.ma}A.jpg">
                    </a>
                    <ul class="social">
                        <li><a href="/chi-tiet-sp/detail?id=${ctsp.id}" data-tip="View detail"><i
                                class="fa fa-eye"></i></a></li>
                        <li><a href="/chi-tiet-sp/delete?id=${ctsp.id}" data-tip="Delete"><i
                                class="fas fa-minus-square"></i></a></li>
                    </ul>
                    <a class="add-to-cart" href="">Add to cart</a>
                </div>
                <div class="product-content">
                    <h3 class="title"><a href="#">${ctsp.idSP.ten}</a></h3>
                    <span class="price">${ctsp.giaBan}</span>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
