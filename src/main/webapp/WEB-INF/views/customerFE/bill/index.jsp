<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <style><%@include file="style.css"%></style>
</head>

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
                        <td>ReceiverName</td>
                        <td>TotalMoney</td>
                        <td>CustomerPhone</td>
                        <td>AddressDelivery</td>
                        <td>CreatedDate</td>
                        <td>Status</td>
                        <td>Action</td>
                    </tr>
                    <c:forEach items="${listBill}" var="bill">
                        <tr onclick="goToPage('/bill_detail/index/${bill.id}')">
                            <td>${bill.receiverName}</td>
                            <td>${bill.totalMoney}</td>
                            <td>${bill.customerPhone}</td>
                            <td>${bill.addressDelivery}</td>
                            <td>${bill.createdDate}</td>
                            <td>${bill.billStatus.name}</td>
                            <td>
                                <a href="/bill/orderComplete/${bill.id}" class="btn btn-success">Detail</a>
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