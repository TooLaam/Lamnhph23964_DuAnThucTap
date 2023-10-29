<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
    />
    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"
    ></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"
    ></script>
</head>
<body class="container">
<a href="/indexxx" >
    <svg style="width: 50px;height: 50px" xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 576 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M575.8 255.5c0 18-15 32.1-32 32.1h-32l.7 160.2c0 2.7-.2 5.4-.5 8.1V472c0 22.1-17.9 40-40 40H456c-1.1 0-2.2 0-3.3-.1c-1.4 .1-2.8 .1-4.2 .1H416 392c-22.1 0-40-17.9-40-40V448 384c0-17.7-14.3-32-32-32H256c-17.7 0-32 14.3-32 32v64 24c0 22.1-17.9 40-40 40H160 128.1c-1.5 0-3-.1-4.5-.2c-1.2 .1-2.4 .2-3.6 .2H104c-22.1 0-40-17.9-40-40V360c0-.9 0-1.9 .1-2.8V287.6H32c-18 0-32-14-32-32.1c0-9 3-17 10-24L266.4 8c7-7 15-8 22-8s15 2 21 7L564.8 231.5c8 7 12 15 11 24z"/></svg>
</a>
<div><h1>Employee</h1></div>
<a class="btn btn-primary" href="/employee/viewAdd">CREATE</a>
<form action="/employee/timKiem" method="get">
    <div class="col-md-6" style="margin-left: 350px;">
        <div  class="input-group flex-nowrap ">
            <input type="text" class="form-control" placeholder="Search by Name" aria-label="Username" aria-describedby="addon-wrapping" name="name1">
            <input type="text" class="form-control" placeholder="Search by PhoneNumber" aria-label="Username" aria-describedby="addon-wrapping" name="phone1">
            <button class="btn btn-light">
                <i>
                    <svg style="margin-top: 5px;" xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M416 208c0 45.9-14.9 88.3-40 122.7L502.6 457.4c12.5 12.5 12.5 32.8 0 45.3s-32.8 12.5-45.3 0L330.7 376c-34.4 25.2-76.8 40-122.7 40C93.1 416 0 322.9 0 208S93.1 0 208 0S416 93.1 416 208zM208 352a144 144 0 1 0 0-288 144 144 0 1 0 0 288z"/></svg>
                </i>
            </button>
        </div>
    </div>
</form>


<div class="row" style="margin-top: 100px;">
    <c:forEach items="${empList}" var="emp">
        <div class="col-md-3">
            <div class="thumbnail">
                <img src="" alt="Lights" style="width:100%">
                <div class="caption">
                    <p style="text-align: center; margin-top: 10px;font-weight: bold;">${emp.fullName}</p>
                    <ul>
                        <li >ID: ${emp.id}</li>
                        <li >Phone: ${emp.phoneNumber}</li>
                    </ul>
                    <a style="margin-left: 120px;" href="/employee/detail/${emp.id}" class="btn btn-primary">Chi tiết</a>
                </div>

            </div>
        </div>
    </c:forEach>

    <c:forEach items="${tim}" var="emp">
        <div class="col-md-3">
            <div class="thumbnail">
                <img src="" alt="Lights" style="width:100%">
                <div class="caption">
                    <p style="text-align: center; margin-top: 10px;font-weight: bold;">${emp.fullName}</p>
                    <ul>
                        <li >ID: ${emp.id}</li>
                        <li >Phone: ${emp.phoneNumber}</li>
                    </ul>
                    <a style="margin-left: 120px;" href="/employee/detail/${emp.id}" class="btn btn-primary">Chi tiết</a>
                </div>

            </div>
        </div>
    </c:forEach>
</div>






</body>
</html>
