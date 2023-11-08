





    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <section class="section dashboard">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <form action="/employee/update" method="post">
                            <nav>
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item active"><h1>Info Employee</h1></li>
                                    <li style="margin-top: 20px" class="breadcrumb-item"><a href="/employee/index">Home</a></li>
                                </ol>
                            </nav>
                            <div><h1></h1></div>

                                <div class="row" style="margin-top: 50px;">
                                    <div class="col-md-6">
                                        <b><label class="form-label">ID:</label></b>
                                        <input type="text" class="form-control" name="id" value="${emp.id}" readonly />

                                        <b><label class="form-label">Full Name:</label></b>
                                        <input type="text" class="form-control" value="${emp.fullName}" name="fullName" />

                                        <b> <label class="form-label">Date Of Birth</label></b>
                                        <input type="date" class="form-control" value="${emp.dateOfBirth}" name="dateOfBirth" />

                                        <b><label class="form-label">Gender</label></b>
                                        <br />
                                        <select class="form-select" aria-label="Default select example" name="gender">
                                            <option value="${emp.gender}">${emp.gender==1?"Male":"Female"}</option>
                                            <option value="1">Male</option>
                                            <option value="2">Female</option>

                                        </select>

                                        <b><label class="form-label">Phone Number</label></b>
                                        <input type="number" class="form-control" value="${emp.phoneNumber}" name="phoneNumber" />

                                        <b><label class="form-label">Email</label></b>
                                        <input type="email" class="form-control" value="${emp.email}" name="email" />
                                    </div>

                                    <div class="col-md-6">

                                        <b> <label class="form-label">Address</label></b>
                                        <input type="text" class="form-control"  value="${emp.address}" name="address" />

                                        <b><label class="form-label">Role</label></b>
                                        <select class="form-select" aria-label="Default select example" name="idRole">
                                            <option value="${emp.role.id}">${emp.role.name} </option>
                                            <c:forEach items="${role}" var="r">
                                                <option value="${r.id}">${r.name}</option>
                                            </c:forEach>
                                        </select>

                                        <b><label class="form-label">Username</label></b>
                                        <input type="text" class="form-control" value="${emp.username}" name="username" />

                                        <b><label class="form-label">Password</label></b>
                                        <input type="password" class="form-control" value="${emp.password}" name="password" />


                                        <b><label class="form-label">Date created</label></b>
                                        <input type="date" class="form-control" value="${emp.datecreated}" name="datecreated" readonly />

                                        <b><label class="form-label">Status</label></b>
                                        <select class="form-select" aria-label="Default select example" name="status">
                                            <option value="${emp.status}">${emp.status==1?"ON":"OFF"} </option>
                                            <option value="1">ON</option>
                                            <option value="2">OFF</option>

                                        </select>
                                    </div>
                                </div>

                            <c:if test="${erCheckRole != null}" >
                                <p style="color: red">${erCheckRole}</p>
                            </c:if>

                            <button type="submit" class="btn btn-primary">Edit</button>
                        </form>

                    </div>

                </div>
            </div>
        </div>

    </section>






