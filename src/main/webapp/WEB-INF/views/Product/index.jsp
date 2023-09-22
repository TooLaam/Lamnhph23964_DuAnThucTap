<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="col-8 offset-2 bg-light">
<form method="post" action="/product/add">
    <div class="row mt-2">
    <div cclass="col-6">
        <label>Color</label>
        <select name="color" class="form-control">
            <c:forEach items="${listColor}" var="color">
                <option value="${color.id}">${color.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-6">
        <label>Category</label>
        <select name="category" class="form-control">
            <c:forEach items="${listCategory}" var="category">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-6">
        <label>Name</label>
        <input class="form-control" name="name" >
    </div>
    <div class="col-6">
        <label>Description</label>
        <input class="form-control" name="descripTion" >
    </div>
    <div class="col-6">
        <label>Manufacturer</label>
        <input class="form-control" name="manufacTurer">
    </div>
    <div class="col-6">
        <label>AvailableQuantity</label>
        <input class="form-control" name="availableQuantity" >
    </div>
    <div class="col-6">
        <label>Sold</label>
        <input class="form-control" name="sold" >
    </div>
    <div class="col-6">
        <label>Price</label>
        <input class="form-control" name="price" >
    </div>
    <div class="col-6">
        <label>Importprice</label>
        <input class="form-control" name="importPrice">
    </div>
    <div class="col-6">
        <label>Date</label>
        <input class="form-control" name="date" type="date">
    </div>
    <div class="col-6">
        <label>Status : </label><br>
        <input  type="radio" name="staTus" value="0"> Còn Hàng <br>
        <input   type="radio" name="staTus" value="1"> Hết hàng
    </div>
    <div class="col-6">
        <label>ImageUrl</label>
        <input class="form-control" name="imageUrl" type="file">
    </div>
    </div>

        <input type="submit" class="btn btn-primary" value="Add">
</form>

</div>
<table class="table bg-light">
    <thead>
    <tr>
        <th>ID</th>
        <th>Color</th>
        <th>Category</th>
        <th>Name</th>
        <th>Description</th>
        <th>Manufacturer</th>
        <th>AvailableQuantity</th>
        <th>Sold</th>
        <th>Price</th>
        <th>Importprice</th>
        <th>Date</th>
        <th>Status</th>
        <th>ImageUrl</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.color.name}</td>
            <td>${sp.category.name}</td>
            <td>${sp.name}</td>
            <td>${sp.descripTion}</td>
            <td>${sp.manufacTurer}</td>
            <td>${sp.availableQuantity}</td>
            <td>${sp.sold}</td>
            <td>${sp.price}</td>
            <td>${sp.importPrice}</td>
            <td>${sp.date}</td>
            <td>${sp.staTus == 1 ? "Còn hàng" : "Hết hàng"}</td>
            <td><img src="/assets/img/${sp.imageUrl}" height="100px" width="100px"></td>
            <td>
                <a href="/product/delete?id=${sp.id}" class="btn btn-success">Delete</a>
                <a href="/product/detail/${sp.id}" class="btn btn-danger">Detail</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>