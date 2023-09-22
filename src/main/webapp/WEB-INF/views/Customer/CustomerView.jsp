<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body class="container">

<form action="/action_page.php">
    <h1>Danh sách Customer</h1>
    <div class="form-group">
        <label >Số điện thoại:</label>
        <input type="number" class="form-control">
    </div>

    <button type="submit" class="btn btn-default">Tìm kiếm</button>

    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>FullName</th>
            <th>PhoneNumber</th>
            <th>DateOfBirth</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cusList}" var="kh">
            <tr>
                <td>${kh.Id}</td>
                <td>${kh.fullname}</td>
                <td>${kh.phone}</td>
                <td>${kh.dateofbirth}</td>
                <td>
                    <a class="btn btn-default" >Chi tiết</a>
                    <a class="btn btn-default" >ADD</a>

                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</form>
</body>
</html>