<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form method="post" action="/favor/update/${spyt.id}">
    <div class="mb-3">
        <label>Customer</label>
        <select name="customer" class="form-control">
            <c:forEach items="${listCustomer}" var="customer">
                <option value="${customer.id}">${customer.fullname}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label>Product</label>
        <select name="product" class="form-control">
            <c:forEach items="${listProduct}" var="product">
                <option value="${product.id}">${product.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label>Description</label>
        <input class="form-control" name="descripTion" value="${spyt.descripTion}">
    </div>
    <input type="submit" class="btn btn-primary" value="Update">
</form>
</body>
</html>