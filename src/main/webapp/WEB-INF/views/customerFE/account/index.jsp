<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <style><%@include file="style.css"%></style>
</head>

<br />
<div class="container">
    <div class="row">
        <div class="col-3">
            <div class="content">
                <span class="account-name">Tuan Bean's Account </span>
                <a href="/home/index.html" class="link-text-logout">(Logout)</a>
            </div>
            <div class="link">
                <a href="/account/index.html" class="link-text-active">Account Info</a>
            </div>
        </div>
        <div class="col-9">
            <div class="information">
                <p>Account Info</p>
                <form>
                    <div class="mb-3">
                        <label class="form-label">FullName: </label>
                        <label class="form-label text-inf">Tuan Bean's</label>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Username: </label>
                        <label class="form-label text-inf">tuanbeans</label>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Password: </label>
                        <input type="password" class="form-label text-inf password" value="123123">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">PhoneNumber: </label>
                        <label class="form-label text-inf">0987654321</label>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Email: </label>
                        <label class="form-label text-inf">tuanbeans@gmail.com</label>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Birthday: </label>
                        <label class="form-label text-inf">01/01/2003</label>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Gender: </label>
                        <label class="form-label text-inf">Male</label>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Address: </label>
                        <label class="form-label text-inf">Hanoi</label>
                    </div>
                    <button type="button" class="btn">Change Account Info</button>
                </form>
            </div>
        </div>
    </div>
    <br />
</div>