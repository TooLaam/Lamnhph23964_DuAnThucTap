
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>ADMIN SITE</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="/assets/img/apple-touch-icon.png" rel="icon">
    <link href="/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,1500,1500i"
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
    <link href="/assets/css/style.css" rel="stylesheet">


</head>

<body>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
        <a href="index.html" class="logo d-flex align-items-center">
            <img src="/assets/img/logo.png" alt="LOGO">
            <%--<span class="d-none d-lg-block">LOGO</span>--%>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <div class="search-bar">
        <form class="search-form d-flex align-items-center" method="POST" action="#">
            <input type="text" name="query" placeholder="Search" title="Enter search keyword">
            <button type="submit" title="Search"><i class="bi bi-search"></i></button>
        </form>
    </div><!-- End Search Bar -->

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">

            <li class="nav-item d-block d-lg-none">
                <a class="nav-link nav-icon search-bar-toggle " href="#">
                    <i class="bi bi-search"></i>
                </a>
            </li><!-- End Search Icon-->



        </ul>
    </nav><!-- End Icons Navigation -->

</header><!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link" href="/statisticsResult">
                <i class="bi bi-grid"></i>
                <span>Overview</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>Product Management</span><i
                    class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/product/index">
                        <i class="bi bi-circle"></i><span>Product</span>
                    </a>
                </li>
                <li>
                    <a href="/category/index">
                        <i class="bi bi-circle"></i><span>Category</span>
                    </a>
                </li>
                <li>
                    <a href="/color/index">
                        <i class="bi bi-circle"></i><span>Color</span>
                    </a>
                </li>
                <li>
                    <a href="/brand/index">
                        <i class="bi bi-circle"></i><span>Brand</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Components Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>User Management</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/employee/index">
                        <i class="bi bi-circle"></i><span>Employee</span>
                    </a>
                </li>
                <li>
                    <a href="/customer/index">
                        <i class="bi bi-circle"></i><span>Customer</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Components Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-journal-text"></i><span>Bill</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="forms-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/bill/index">
                        <i class="bi bi-circle"></i><span>Bill Management</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Forms Nav -->


        <li class="nav-heading">Pages</li>

        <c:choose>
            <c:when test="${Name == null}">
                <li class="nav-item">
                    <a class="nav-link collapsed" href="/employee/index">
                        <i class="bi bi-person"></i>
                        <span>Log in</span>
                    </a>
                </li>
                <!-- End Profile Page Nav -->
            </c:when>
            <c:otherwise>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="/employee/detail/${empLogin.id}">
                        <i class="bi bi-person"></i>
                        <span>Profile</span>
                    </a>
                </li>
                <!-- End Profile Page Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="/employee/viewAdd">
                        <i class="bi bi-person"></i>
                        <span>Register</span>
                    </a>
                </li>
                <!-- End Register Page Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="/logout">
                            <%--<i class="bi bi-box-arrow-right"></i>--%>
                        <svg xmlns="http://www.w3.org/2000/svg" height="1em" style="margin-right: 10px;"
                             viewBox="0 0 512 512">
                            <path d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"/>
                        </svg>
                        <span>Sign Out</span>
                    </a>
                </li>
                <!-- End Sign Out Page Nav -->
            </c:otherwise>
        </c:choose>

    </ul>

</aside><!-- End Sidebar-->

<div style="float: right;margin-top: 70px; margin-right: 40px;width: 1150px">
    <form action="/employee/add" method="post">
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item active"><h1>Create Employee</h1></li>
                <li style="margin-top: 20px" class="breadcrumb-item"><a href="/employee/index">Home</a></li>
            </ol>
        </nav>
        <div class="border">
            <div class="row" style="margin-top: 50px;">
                <div class="col-md-6">
                    <b><label class="form-label">Full Name:</label></b>
                    <input type="text" class="form-control"  name="fullName" />

                    <b> <label class="form-label">Date Of Birth</label></b>
                    <input type="date" class="form-control"  name="dateOfBirth" />

                    <b><label class="form-label">Gender</label></b>
                    <select class="form-select" aria-label="Default select example" name="gender">

                        <option value=1>Male</option>
                        <option value=2>Female</option>

                    </select>


                    <b><label class="form-label">Phone Number</label></b>
                    <input type="number" class="form-control"  name="phoneNumber" />

                    <b><label class="form-label">Email</label></b>
                    <input type="email" class="form-control"  name="email" />
                </div>

                <div class="col-md-6">

                    <b> <label class="form-label">Address</label></b>
                    <input type="text" class="form-control"   name="address" />

                    <b><label class="form-label">Role</label></b>
                    <select class="form-select" aria-label="Default select example" name="idRole">

                        <c:forEach items="${role}" var="r">
                            <option value="${r.id}">${r.name}</option>
                        </c:forEach>
                    </select>

                    <b><label class="form-label">Username</label></b>
                    <input type="text" class="form-control"  name="username" />

                    <b><label class="form-label">Password</label></b>
                    <input type="password" class="form-control"  name="password" />



                </div>
            </div>
        </div>


        <button type="submit" class="btn btn-primary">ADD</button>
    </form>
</div>

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright <strong><span>MEOW</span></strong>. All Rights Reserved
    </div>
</footer><!-- End Footer -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

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