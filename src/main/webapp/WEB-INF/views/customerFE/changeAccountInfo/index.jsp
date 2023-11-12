<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <style>
        <%@include file="style.css" %>
    </style>
</head>

<br/>
<div class="container">
    <div class="row">
        <div class="col-3">
            <div class="content">
                <span class="account-name">${cus.fullname} Account </span>
                <a href="/customer/logout" class="link-text-logout">(SignOut)</a>
            </div>
            <div class="link">
                <a href="/customer/indexcus" class="link-text">Account Info</a>
            </div>
            <div class="link">
                <a href="/customer/indexcus/changeAccountInfo" class="link-text-active">Change Account Info</a>
            </div>
        </div>
        <div class="col-9">
            <div class="information">
                <p>Change Account Info</p>
                <form>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label form-label">FullName</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="fullname" value="${cus.fullname}">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label form-label">Username</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="username" value="${cus.username}">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label form-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="password" value="${cus.password}">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label form-label">PhoneNumber</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" name="phone" value="${cus.phone}">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label form-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" name="email" value="${cus.email}">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label form-label">Birthday</label>
                        <div class="col-sm-10">
                            <input type="date" class="form-control" name="dateofbirth" value="${cus.dateofbirth}">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label form-label">Gender</label>
                        <div class="col-sm-10">
                            <select class="form-select" aria-label="Default select example" name="gender">
                                <option value="0" ${ cus.gender == "0" ? "selected" : "" }>Male</option>
                                <option value="1" ${ cus.gender == "1" ? "selected" : "" }>Female</option>
                            </select>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label form-label">Address</label>
                        <div class="col-sm-10">
                            <textarea type="text" class="form-control" name="address">${cus.address}</textarea>
                        </div>
                    </div>
                    <button type="submit" class="btn">Save</button>
                </form>
            </div>
        </div>
    </div>
    <br/>
</div>