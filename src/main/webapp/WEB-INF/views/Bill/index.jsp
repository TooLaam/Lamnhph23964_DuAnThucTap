
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="pagetitle">
    <h1>Bill Management</h1>
    <nav>
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="index.html">Home</a></li>
            <li class="breadcrumb-item active">Overview</li>
            <li class="breadcrumb-item active">Product</li>
        </ol>
    </nav>
</div>
<!-- End Page Title -->

<section class="section dashboard">
    <div class="row">
        <!-- Left side columns -->
        <div class="col-lg-8">
            <div class="row">
                <!-- Recent Sales -->
                <div class="col-12">
                    <div class="card recent-sales overflow-auto">


                        <div class="card-body">
                            <h5 class="card-title">Bill <span>| </span></h5>

                            <table class="table table-borderless datatable">
                                <tr>
                                    <td>Id</td>
                                    <td>Price</td>
                                    <td>Address</td>
                                    <td>Customer</td>
                                    <td>Employee</td>
                                    <td>Status</td>
                                    <td>Action</td>
                                </tr>
                                <c:forEach items="${listBill}" var="bill">
                                    <tr>
                                        <td>${bill.id}</td>
                                        <td>${bill.price}</td>
                                        <td>${bill.address}</td>
                                        <td>${bill.employee.fullName}</td>
                                        <td>${bill.customer.fullname}</td>
                                        <td>${bill.billStatus.name}</td>
                                        <td>
                                            <a href="/bill/index/${bill.id}" class="btn btn-success">Detail</a>
                                            <a href="/bill/delete_bill/${bill.id}" class="btn btn-danger"
                                               onclick="return confirm('Bạn chắc chắn có muốn xóa??')">Remove</a>
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
                    <button class="btn btn-primary"><a href="/kich-thuoc/create"
                                                       style="text-decoration: none;color: white">Add New</a></button>

                </div><!-- End Recent Sales -->

            </div>

        </div><!-- End Left side columns -->

        <!-- Right side columns -->
        <div class="col-lg-4">

            <!-- Recent Activity -->
            <div class="card">

                <div class="card-body">
                    <h5 class="card-title">Sửa <span>| xx</span></h5>
                    <!-- Default Tabs -->
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item" role="presentation">
                            <button class="nav-link active" id="home-tab" data-bs-toggle="tab"
                                    data-bs-target="#home" type="button" role="tab" aria-controls="home"
                                    aria-selected="true">Edit
                            </button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" id="profile-tab" data-bs-toggle="tab"
                                    data-bs-target="#profile" type="button" role="tab" aria-controls="profile"
                                    aria-selected="false">Add new
                            </button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" id="contact-tab" data-bs-toggle="tab"
                                    data-bs-target="#contact" type="button" role="tab" aria-controls="contact"
                                    aria-selected="false">Detail
                            </button>
                        </li>
                    </ul>

<%--update--%>
                    <div class="tab-content pt-2" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel"
                             aria-labelledby="home-tab">
                            <form action="/bill/update-bill/${billId}" method="post">
                                <div class="form-group">
                                    Price: <input type="number" name="price" class="form-control" value="${billD.price}">
                                </div>


                                <div class="form-group">
                                    Address: <input type="text" name="address" class="form-control" value="${billD.address}">
                                </div>

                                <div>
                                    Customer:
                                    <select class="form-select" name="customerId" aria-label="Default select example">
                                        <c:forEach items="${listCustomer}" var="lc">
                                            <option value="${lc.id}" ${lc.id==billD.customer.id?"selected":""}>${lc.fullname}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div>
                                    Employee
                                    <select class="form-select" name="employeeId" aria-label="Default select example">
                                        <c:forEach items="${listEmployee}" var="lem">
                                            <option value="${lem.id}"${lem.id==billD.employee.id?"selected":""}>${lem.fullName}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <button class="btn btn-warning">Update</button>
                            </form>
                        </div>

<%--create--%>
                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                            <form action="/bill/create_bill" method="post">
                                <div class="form-group">
                                    Price: <input type="number" name="price" class="form-control">
                                </div>


                                <div class="form-group">
                                    Address: <input type="text" name="address" class="form-control">
                                </div>

                                <div>
                                    Customer:
                                    <select class="form-select" name="customerId" aria-label="Default select example">
                                        <c:forEach items="${listCustomer}" var="lc">
                                            <option value="${lc.id}">${lc.fullname}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div>
                                    Employee
                                    <select class="form-select" name="employeeId" aria-label="Default select example">
                                        <c:forEach items="${listEmployee}" var="lem">
                                            <option value="${lem.id}">${lem.fullName}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <button class="btn btn-success">Add new</button>
                            </form>
                        </div>
<%--detail--%>
                        <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                            <form class="row g-3" action="/bill/index/{billId}/${bill.id}" method="get">
                                <div class="form-group">
                                    Price: ${billD.price}
                                </div>
                                <div class="form-group">
                                    Address: ${billD.address}
                                </div>
                                <div class="form-group">
                                    Customer: ${billD.customer.fullname}
                                </div>
                                <div class="form-group">
                                    Employee: ${billD.employee.fullName}
                                </div>
                            </form><!-- End Multi Columns Form -->
                        </div>
                    </div><!-- End Default Tabs -->


                </div>

            </div>
        </div><!-- End Recent Activity -->


    </div><!-- End Right side columns -->

    </div>
</section>



