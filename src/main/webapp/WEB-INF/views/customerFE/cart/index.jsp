<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <style>
        <%@include file="style.css" %>
    </style>
</head>

<div class="container">
    <br/>
    <div class="row">
        <div class="col-8">
            <div class="table-responsive">
                <table class="table align-middle">
                    <thead>
                    <tr>
                        <%--                  <th scope="col">--%>
                        <%--                    <input class="form-check-input" type="checkbox" onchange="checkAll(this)" />--%>
                        <%--                  </th>--%>
                        <th scope="col" colspan="2">Product</th>
                        <th scope="col" class="text-sp">Quantity</th>
                        <th scope="col" class="text-sp">Total</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cartDetail}" var="gh">
                        <tr>
                            <td>${gh.productName}</td>
                            <td>${gh.quantity}</td>
                            <td style="font-weight: bold;color: red">${gh.price}VND</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-4">
            <div class="table-responsive">
                <div class="checkout">
                    <p>Congratulations! You've got free shipping!</p>
                    <div class="total">
                        <span>Item(s) total</span>
                        <span class="after">${total}</span>
                    </div>
                    <div class="ship">
                        <div>
                            <span>Shipping</span>
                            <span class="after">$0</span>
                        </div>
                        <div>
                            <span class="location">(To Vietnam)</span>
                            <span class="delivery-fee">$50000</span>
                        </div>
                    </div>
                    <hr/>
                    <div class="total-item">
                        <span>Total (${quantity} items)</span>
                        <span class="after">${total}</span>
                    </div>
                    <div class="d-grid">
                        <button class="btn" type="button">CHECK OUT</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br/>
</div>