<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="style.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <style><%@include file="style.css"%></style>
    <title>Bill Customer</title>


    <!-- Favicons -->
    <link href="/assets/img/favicon.png" rel="icon">
    <link href="/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="/assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="/assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
<%--    <link href="/assets/css/style.css" rel="stylesheet">--%>
</head>

<body>
    <div id="freeShip">
        <span>FREE SHIPPING with $20 Purchase </span>
        <a href="#">Details</a>
    </div>
    <div class="container">
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link" href="#">Help</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/signup/index.html">Sign Up</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login/index.html">Login</a>
            </li>
        </ul>
        <nav class="nav-search">
            <div class="row">
                <div class="col-md-2 col-4">
                    <a href="/home/index.html"><img src="../images/logo.png" class="logo" alt="logo" />
                    </a>
                </div>
                <div class="col-md-1 col-0"></div>
                <div class="col-md-6 col-4">
                    <div class="input-group mb-3" id="nav-search">
                        <input type="text" class="form-control" placeholder="What can we help you find?"
                            aria-label="Recipient's username" />
                        <button class="btn" type="button" id="button-addon2">
                            SEARCH
                        </button>
                    </div>
                </div>
                <div class="col-md-1 col-0"></div>
                <div class="col-md-2 col-4">
                    <ul class="list-unstyled" style="display: flex;">
                        <li>
                            <a href="/account/index.html">
                                <span class="fa fa-user"></span>
                            </a>
                        </li>
                        <li>
                            <a href="/wishlist/index.html">
                                <span class="fa fa-heart"></span>
                            </a>
                        </li>
                        <li>
                            <a href="/cart/index.html">
                                <span class="fa fa-shopping-cart"></span>
                            </a>
                        </li>
                        <li>
                            <a href="/bill/index.html">
                                <span class="fa fa-sticky-note"></span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="nav-shadow">
        <ul class="nav nav-underline nav-justified container">
            <li class="nav-item">
                <a class="nav-link" href="/home/index.html">home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/product/index.html">lips</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/aboutus/index.html">about us</a>
            </li>
        </ul>
    </div>
    <div id="nav-bottom"></div>
    <div class="main">
        <br>
        <div class="container">
<%--            <div class="content">--%>
<%--                <span class="text-content">Bill </span>--%>
<%--                <span class="available">(3)</span>--%>
<%--            </div>--%>
            <div class="card-body">
                <h5 class="card-title">Bill <span>| </span></h5>

                <table class="table table-hover datatable" >
                    <tr>
<%--                        <td>Id</td>--%>
                        <td>Price</td>
                        <td>Address</td>
<%--                        <td>Customer</td>--%>
<%--                        <td>Employee</td>--%>
                        <td>Status</td>
                        <td>Action</td>
                    </tr>
                    <c:forEach items="${listBill}" var="bill">
                        <tr onclick="goToPage('/bill_detail/index/${bill.id}')">
<%--                            <td>${bill.id}</td>--%>
                            <td>${bill.price}</td>
                            <td>${bill.address}</td>
<%--                            <td>${bill.employee.fullName}</td>--%>
<%--                            <td>${bill.customer.fullname}</td>--%>
                            <td>${bill.billStatus.name}</td>
                            <td>
                                <a href="/bill_detail/index/${bill.id}" class="btn btn-success">Detail</a>
                                    <%--                                            <a href="/bill/index/${bill.id}" class="btn btn-danger">Detail</a>--%>
<%--                                <form action="/bill/change_bill_status/${bill.id}" method="post">--%>
<%--                                    <button class=" ${bill.billStatus.id!=3?"btn btn-warning":"btn btn-dark"--%>
<%--                                                }" onclick="return confirm('You want to change this status?')"--%>
<%--                                        ${bill.billStatus.id==3?"disabled":""}>${bill.billStatus.id==3?"Done":"Change Status"}</button>--%>
<%--                                </form>--%>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <%--                            <form method="post" enctype="multipart/form-data" action="import">--%>
                <%--                                Thêm từ file excel: <input class="form-control" name="file" type="file">--%>
                <%--                                <button>Thêm</button>--%>
                <%--                            </form>--%>
            </div>
        </div>
        <br />
    </div>
    <footer class="bd-footer">
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-12">
                    <div class="row">
                        <div class="col-md-12 col-12">
                            <img src="../images/logo.png" class="logo" alt="logo" />
                            <p id="text_logo">We Have Everything For Lipstick Here!</p>
                        </div>
                        <div class="col-md-12 col-12">
                            <p id="text_subscribe">Subscribe To Our Newsletter</p>
                            <p id="text_blog">New blogs about lipsticks every week!</p>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="YOUR EMAIL ADDRESS"
                                    aria-label="Recipient's username" aria-describedby="button-addon2" />
                                <button class="btn" type="button" id="button-addon2">
                                    SUBSCRIBE
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-1 col-12"></div>
                <div class="col-md-7 col-12">
                    <div class="row">
                        <div class="col-md-4 col-6">
                            <p class="text_content_footer">Where's my order?</p>
                            <button class="btn" id="track_order" type="button">
                                TRACK ORDER
                            </button>
                            <p class="text_footer">
                                Please note, it may take longer than usual to fulfill orders
                                due to the impacts of COVID-19.
                            </p>
                        </div>
                        <div class="col-md-4 col-6">
                            <p class="text_content_footer">Shipping</p>
                            <p class="text_footer">About Free Shipping</p>
                            <p class="text_footer">Shipping Information</p>
                        </div>
                        <div class="col-md-4 col-6">
                            <p class="text_content_footer">Shopping App</p>
                            <p class="text_footer">
                                Try our View in Your Room feature, manage registries and save
                                payment info.
                            </p>
                            <img src="../images/logo_appstore.png" id="logo_appstore" />
                        </div>
                        <div class="col-md-4 col-6">
                            <p class="text_content_footer">Our Company</p>
                            <ul class="list-unstyled">
                                <li class="p-1">
                                    <a href="#" class="link_footer">About Us</a>
                                </li>
                                <li class="p-1">
                                    <a href="#" class="link_footer">Careers</a>
                                </li>
                                <li class="p-1">
                                    <a href="#" class="link_footer">Contact</a>
                                </li>
                                <li class="p-1">
                                    <a href="#" class="link_footer">Store locations</a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-md-4 col-6">
                            <p class="text_content_footer">Social Media</p>
                            <ul class="list-unstyled" style="display: flex;">
                                <li>
                                    <a href="#">
                                        <span class="fa fa-facebook-square"></span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="fa fa-instagram"></span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="fa fa-youtube-play"></span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="fa fa-twitter"></span>
                                    </a>
                                </li>
                            </ul>
                            <span class="text_footer">Show us your cat with:</span>
                            <span class="text_footer">#meowshop</span>
                            <br />
                            <span class="text_footer">#themeowshop</span>
                        </div>
                        <div class="col-md-4 col-6">
                            <p class="text_content_footer">Policies</p>
                            <ul class="list-unstyled">
                                <li class="p-1">
                                    <a href="#" class="link_footer">Shipping Policy</a>
                                </li>
                                <li class="p-1">
                                    <a href="#" class="link_footer">Refund Policy</a>
                                </li>
                                <li class="p-1">
                                    <a href="#" class="link_footer">Privacy Policy</a>
                                </li>
                                <li class="p-1">
                                    <a href="#" class="link_footer">Terms of Service</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <br />
            <hr />
            <div id="Copyright">
                Copyright © 2023 The Meow Shop. All rights reserved
            </div>
        </div>
    </footer>





    <!-- Vendor JS Files -->
    <script src="/assets/vendor/apexcharts/apexcharts.min.js"></script>
    <script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="/assets/vendor/chart.js/chart.umd.js"></script>
    <script src="/assets/vendor/echarts/echarts.min.js"></script>
    <script src="/assets/vendor/quill/quill.min.js"></script>
    <script src="/assets/vendor/simple-datatables/simple-datatables.js"></script>
    <script src="/assets/vendor/tinymce/tinymce.min.js"></script>
    <script src="/assets/vendor/php-email-form/validate.js"></script>

    <!-- Template Main JS File -->
    <script src="/assets/js/main.js"></script>
</body>

</html>