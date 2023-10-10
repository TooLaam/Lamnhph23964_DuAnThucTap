<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <style><%@include file="style.css"%></style>
</head>

<div class="container">
    <img src="/assets/img/banner/banner3.jpg" class="banner" alt="" />
    <div class="row">
        <c:forEach items="${listProduct}" var="sp">
            <div class="col-md-3 col-6">
                <a href="/product/index.html" class="link-recommend">
                    <img src="/assets/img/${sp.imageUrl}" class="img-recommend" alt="" />
                    <div class="overlay">${sp.category.name}</div>
                </a>
            </div>
        </c:forEach>
    </div>
    <div class="frame">
        <p>Deals Of The Month</p>
        <div class="row">
            <c:forEach items="${listProduct}" var="sp">
                <div class="col-md-3 col-6">
                    <div class="thumnail">
                        <a href="../detail/${sp.id}">
                            <img src="/assets/img/${sp.imageUrl}" alt="" />
                            <div class="caption">
                                <p>${sp.name}</p>
                                <span class="price">$${sp.price}</span>
                                <span class="sold">${sp.sold} sold</span>
                            </div>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="frame">
        <p>New Arrivals</p>
        <div class="row">
            <c:forEach items="${listProduct}" var="sp">
                <div class="col-md-3 col-6">
                    <div class="thumnail">
                        <a href="../detail/${sp.id}">
                            <img src="/assets/img/${sp.imageUrl}" alt="" />
                            <div class="caption">
                                <p>${sp.name}</p>
                                <span class="price">$${sp.price}</span>
                                <span class="sold">${sp.sold} sold</span>
                            </div>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="frame">
        <p>Best selling</p>
        <div class="row">
            <c:forEach items="${listProduct}" var="sp">
                <div class="col-md-3 col-6">
                    <div class="thumnail">
                        <a href="../detail/${sp.id}">
                            <img src="/assets/img/${sp.imageUrl}" alt="" />
                            <div class="caption">
                                <p>${sp.name}</p>
                                <span class="price">$${sp.price}</span>
                                <span class="sold">${sp.sold} sold</span>
                            </div>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<br />