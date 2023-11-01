<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <style>
        <%@include file="style.css" %>
    </style>
</head>

<br/>
<div class="container">
    <div class="content">
        <span class="text-content">Lips </span>
        <span class="available">(35)</span>
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-outline dropdown-toggle" data-bs-toggle="dropdown"
                    aria-expanded="false">
                Best selling
            </button>
            <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Lip Dior</a></li>
                <li><a class="dropdown-item" href="#">Lip Channel</a></li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <h6 class="text-filter">Filter</h6>
            <h6 class="filter">BRAND</h6>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value=""/>
                <label class="form-check-label">
                    Lip MAC
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value=""/>
                <label class="form-check-label">
                    Lip Dior
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value=""/>
                <label class="form-check-label">
                    Lip Channel
                </label>
            </div>
            <h6 class="filter">PRICE</h6>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="price" value=""/>
                <label class="form-check-label">
                    Under 100000$
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="price" value=""/>
                <label class="form-check-label">
                    100000$ - 300000$
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="price" value=""/>
                <label class="form-check-label">
                    300000$ - 500000$
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="price" value=""/>
                <label class="form-check-label">
                    500000$ - 1000000$
                </label>
            </div>
            <%--<h6 class="filter">COLOR</h6>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value=""/>
                <label class="form-check-label">
                    Strong - rich chocolate
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value=""/>
                <label class="form-check-label">
                    Gifted - deep dusty plum
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value=""/>
                <label class="form-check-label">
                    Fun - neutral mauve
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value=""/>
                <label class="form-check-label">
                    Creative - muted peach
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value=""/>
                <label class="form-check-label">
                    Humble - rose mauve
                </label>
            </div>--%>
        </div>
        <div class="col-9">
            <div class="row">
                <c:forEach items="${listProduct}" var="sp">
                    <div class="col-md-3 col-6">
                        <div class="thumnail">
                            <a href="/product_detail/indexcus/${sp.productDetailId}">
                                <img src="/assets/img/product/${sp.image}">
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
    <ul class="pagination">
        <li class="pagea-item">
            <a class="pagea-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li class="pagea-item-active"><a class="pagea-link" href="#">1</a></li>
        <li class="pagea-item"><a class="pagea-link" href="#">2</a></li>
        <li class="pagea-item"><a class="pagea-link" href="#">3</a></li>
        <li class="pagea-item">
            <a class="pagea-link" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</div>
<br>