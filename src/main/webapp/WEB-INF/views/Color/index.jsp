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
<form method="post" action="/color/add">
    <div class="mb-3">
        <label>Name</label>
        <input class="form-control" name="name">
    </div>
    <input type="submit" class="btn btn-primary" value="Add">
</form>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Ten</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listColor}" var="mau">
        <tr>
            <td>${mau.id}</td>
            <td>${mau.name}</td>

            <td>
                <a href="/color/delete/${mau.id}" class="btn btn-success">Delete</a>
                <a href="/color/detail/${mau.id}" class="btn btn-danger">Detail</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>