<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="pagetitle">
        <h1>Product</h1>
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
                            <h5 class="card-title">Product <span>| </span></h5>

                            <table class="table table-borderless datatable">
                                <tr>
                                    <th>Color</th>
                                    <th>Category</th>
                                    <th>Name</th>
                                    <th>Manufacturer</th>
                                    <th>Sold</th>
                                    <th>Price</th>
                                    <th>Status</th>
                                    <th>ImageUrl</th>
                                    <th>Action</th>

                                </tr>
                                <c:forEach items="${listProduct}" var="sp">
                                    <tr>
                                        <td>${sp.color.name}</td>
                                        <td>${sp.category.name}</td>
                                        <td>${sp.name}</td>
                                        <td>${sp.manufacTurer}</td>
                                        <td>${sp.sold}</td>
                                        <td>${sp.price}</td>
                                        <td>${sp.staTus == 1 ? "Còn hàng" : "Hết hàng"}</td>
                                        <td><img src="/assets/img/${sp.imageUrl}" height="90px" width="90px"></td>
                                        <td>
                                            <a href="/product/delete?id=${sp.id}" class="btn btn-danger" onclick="return confirm('Bạn chắc chắn có muốn xóa??')" style="text-decoration: none;color: white"><i class='bx bx-trash'></i></a>
                                            <a href="/product/detail/${sp.id}" class="btn btn-success" style="text-decoration: none;color: white; margin-top: 5px" ><i class='bi bi-arrow-repeat'></i></a>
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
                            <form method="post" action="/product/update/${sp.id}">
                                <div class="form-group">
                                    Color :
                                    <select name="color" class="form-select"  aria-label="Default select example">
                                        <c:forEach items="${listColor}" var="color">
                                            <option value="${color.id}">${color.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>


                                <div class="form-group">
                                    Category :
                                    <select name="category" class="form-select"  aria-label="Default select example">
                                        <c:forEach items="${listCategory}" var="category">
                                            <option value="${category.id}">${category.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div>
                                    Name :
                                    <input class="form-control" name="name" value="${sp.name}">
                                </div>
                                <div>
                                    Description :
                                    <input class="form-control" name="descripTion" value="${sp.descripTion}">
                                </div>
                                <div>
                                    Manufacturer :
                                    <input class="form-control" name="manufacTurer" value="${sp.manufacTurer}">
                                </div>
                                <div>
                                    AvailableQuantity :
                                    <input class="form-control" name="availableQuantity" value="${sp.availableQuantity}">
                                </div>
                                <div>
                                    Sold :
                                    <input class="form-control" name="sold" value="${sp.sold}">
                                </div>
                                <div>
                                    Price :
                                    <input class="form-control" name="price" value="${sp.price}">
                                </div>
                                <div>
                                    Importprice :
                                    <input class="form-control" name="importPrice" value="${sp.importPrice}">
                                </div>
                                <div>
                                    Date :
                                    <input class="form-control" name="date" type="date" value="${sp.date}">
                                </div>
                                <div>
                                    Status :<br>
                                    <input  type="radio" name="staTus" value="1" ${ sp.staTus == "1" ? "checked" : "" }> Còn Hàng <br>
                                    <input   type="radio" name="staTus" value="0" ${ sp.staTus == "0" ? "checked" : "" }> Hết hàng
                                </div>
                                <div>
                                    ImageUrl :
                                    <img src="/assets/img/${sp.imageUrl}" height="100px" width="100px">
                                    <input class="form-control" name="imageUrl" type="file"  value="${sp.imageUrl}">
                                </div>

                                <input type="submit" class="btn btn-primary" value="Update" style="margin-top: 10px">
                            </form>
                        </div>

                        <%--create--%>
                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                            <form method="post" action="/product/add">
                                <div class="form-group">
                                    Color :
                                    <select name="color" class="form-select"  aria-label="Default select example">
                                        <c:forEach items="${listColor}" var="color">
                                            <option value="${color.id}">${color.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>


                                <div class="form-group">
                                    Category :
                                    <select name="category" class="form-select"  aria-label="Default select example">
                                        <c:forEach items="${listCategory}" var="category">
                                            <option value="${category.id}" ${category.id==sp.category.id?"selected" : ""}>${category.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div>
                                    Name :
                                    <input class="form-control" name="name">
                                </div>
                                <div>
                                    Description :
                                    <input class="form-control" name="descripTion">
                                </div>
                                <div>
                                    Manufacturer :
                                    <input class="form-control" name="manufacTurer">
                                </div>
                                <div>
                                    AvailableQuantity :
                                    <input class="form-control" name="availableQuantity">
                                </div>
                                <div>
                                    Sold :
                                    <input class="form-control" name="sold">
                                </div>
                                <div>
                                    Importprice :
                                    <input class="form-control" name="importPrice">
                                </div>
                                <div>
                                    Price :
                                    <input class="form-control" name="price">
                                </div>
                                <div>
                                    Date :
                                    <input class="form-control" name="date" type="date">
                                </div>
                                <div>
                                    Status :<br>
                                    <input  type="radio" name="staTus" value="1" ${ sp.staTus == "1" ? "checked" : "" }> Còn Hàng <br>
                                    <input   type="radio" name="staTus" value="0" ${ sp.staTus == "0" ? "checked" : "" }> Hết hàng
                                </div>
                                <div>
                                    ImageUrl :
                                    <img src="/assets/img/${sp.imageUrl}" height="100px" width="100px">
                                    <input class="form-control" name="imageUrl" type="file"  >
                                </div>

                                <input type="submit" class="btn btn-primary" value="Add" style="margin-top: 10px">
                            </form>
                        </div>
                        <%--detail--%>
                        <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                            <form class="row g-3" action="/product/detail/${sp.id}" method="get">
                                <div class="form-group">
                                    Color : ${sp.color.name}
                                </div>
                                <div class="form-group">
                                    Category : ${sp.category.name}
                                </div>
                                <div class="form-group">
                                    Name : ${sp.name}
                                </div>
                                <div class="form-group">
                                    DescripTion : ${sp.descripTion}
                                </div>
                                <div class="form-group">
                                    ManufacTurer : ${sp.manufacTurer}
                                </div>
                                <div class="form-group">
                                    AvailableQuantity : ${sp.availableQuantity}
                                </div>
                                <div class="form-group">
                                    Sold : ${sp.sold}
                                </div>
                                <div class="form-group">
                                    Price : ${sp.price}
                                </div>
                                <div class="form-group">
                                    ImportPrice : ${sp.importPrice}
                                </div>
                                <div class="form-group">
                                    Date : ${sp.date}
                                </div>
                                <div class="form-group">
                                    StaTus : ${sp.staTus}
                                </div>
                                <div class="form-group">
                                    IMG : <img src="/assets/img/${sp.imageUrl}" height="100px" width="100px">
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



