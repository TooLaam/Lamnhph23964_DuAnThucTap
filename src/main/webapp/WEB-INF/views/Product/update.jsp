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
<body style="margin-left: 100px;margin-right: 100px">
<form method="post" action="/product/update/${sp.id}">
    <div class="mb-3">
        <label>Color</label>
        <select name="color" class="form-control">
            <c:forEach items="${listColor}" var="color">
                <option value="${color.id}">${color.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label>Category</label>
        <select name="category" class="form-control">
            <c:forEach items="${listCategory}" var="category">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label>Name</label>
        <input class="form-control" name="name" value="${sp.name}">
    </div>
    <div class="mb-3">
        <label>Description</label>
        <input class="form-control" name="descripTion" value="${sp.name}">
    </div>
    <div class="mb-3">
        <label>Manufacturer</label>
        <input class="form-control" name="manufacTurer" value="${sp.manufacTurer}">
    </div>
    <div class="mb-3">
        <label>AvailableQuantity</label>
        <input class="form-control" name="availableQuantity" value="${sp.availableQuantity}">
    </div>
    <div class="mb-3">
        <label>Sold</label>
        <input class="form-control" name="sold" value="${sp.sold}">
    </div>
    <div class="mb-3">
        <label>Price</label>
        <input class="form-control" name="price" value="${sp.price}">
    </div>
    <div class="mb-3">
        <label>Importprice</label>
        <input class="form-control" name="importPrice" value="${sp.importPrice}">
    </div>
    <div class="mb-3">
        <label>Date</label>
        <input class="form-control" name="date" type="date" value="${sp.date}">
    </div>
    <div class="mb-3">
        <label>Status</label>
        <input  type="radio" name="staTus" value="1"> Còn Hàng <br>
        <input   type="radio" name="staTus" value="0"> Hết hàng
    </div>
    <div class="mb-3">
        <label>ImageUrl</label>
        <img src="/assets/img/${sp.imageUrl}" height="100px" width="100px">
        <input class="form-control" name="imageUrl" type="file"  value="${sp.imageUrl}">
    </div>
    <input type="submit" class="btn btn-primary" value="Update">
</form>
</body>
</html>