


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="section dashboard">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <form action="/customer/add" method="post">
                        <nav>
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item active"><h1>Create Customer</h1></li>
                                <li style="margin-top: 20px" class="breadcrumb-item"><a href="/customer/index">Home</a></li>
                            </ol>
                        </nav>

                            <div class="row" style="margin-top: 50px;">
                                <div class="col-md-6">

                                    <b><label class="form-label">Full Name:</label></b>
                                    <input type="text" class="form-control"  name="fullname" />

                                    <b> <label class="form-label">Date Of Birth</label></b>
                                    <input type="date" class="form-control"  name="dateofbirth" />

                                    <b> <label class="form-label">Address</label></b>
                                    <input type="text" class="form-control"   name="address" />

                                    <b><label class="form-label">Phone Number</label></b>
                                    <input type="number" class="form-control"  name="phone" />


                                </div>

                                <div class="col-md-6">
                                    <b><label class="form-label">Gender</label></b>
                                    <br />
                                    <select class="form-select" aria-label="Default select example" name="gender">
                                        <option value="1">Male</option>
                                        <option value="2">Female</option>

                                    </select>

                                    <b><label class="form-label">Email</label></b>
                                    <input type="email" class="form-control"  name="email" />


                                    <b><label class="form-label">Username</label></b>
                                    <input type="text" class="form-control"  name="username" />

                                    <b><label class="form-label">Password</label></b>
                                    <input type="password" class="form-control"  name="password" />

                                </div>
                            </div>



                        <button type="submit" class="btn btn-primary">ADD</button>
                    </form>

                </div>

            </div>
        </div>
    </div>

</section>











