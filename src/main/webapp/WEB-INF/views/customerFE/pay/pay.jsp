<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h2>Payment Information</h2>
            <form method="post" action="/bill/placeorder">
                <div class="form-group">
                    <label for="receiverName">Receiver Name:</label>
                    <%--<input type="text" class="form-control" value="${inputReceiverName}" id="receiverName"
                           name="receiverName">
                    <c:if test="${not empty receiverNameError}">
                        <div class="alert alert-danger">${receiverNameError}</div>
                    </c:if>--%>
                    <c:choose>
                        <c:when test="${not empty customer}">
                            <input type="text" class="form-control" value="${customer.fullname}" id="receiverName"
                                   name="receiverName">
                        </c:when>
                        <c:otherwise>
                            <input type="text" class="form-control" value="${inputReceiverName}" id="receiverName"
                                   name="receiverName">
                            <c:if test="${not empty receiverNameError}">
                                <div class="alert alert-danger">${receiverNameError}</div>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="form-group">
                    <label for="customerPhone">Customer Phone:</label>
                    <c:choose>
                        <c:when test="${not empty customer}">
                            <input type="text" class="form-control" value="${customer.phone}" id="customerPhone"
                                   name="customerPhone">
                        </c:when>
                        <c:otherwise>
                            <input type="text" class="form-control" value="${inputCustomerPhone}" id="customerPhone"
                                   name="customerPhone">
                            <c:if test="${not empty customerPhoneError}">
                                <div class="alert alert-danger">${customerPhoneError}</div>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="form-group">
                    <label for="addressDelivery">Address Delivery:</label>
                    <c:choose>
                        <c:when test="${not empty customer}">
                            <textarea type="text" class="form-control" id="addressDelivery" name="addressDelivery">${customer.address}</textarea>
                        </c:when>
                        <c:otherwise>
                    <textarea class="form-control" id="addressDelivery" data-value="${inputReceiverName}"
                              name="addressDelivery"></textarea>
                            <c:if test="${not empty addressDeliveryError}">
                                <div class="alert alert-danger">${addressDeliveryError}</div>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="form-group">
                    <label for="addressDelivery">Payment:</label>
                    <div class="form-check">
                        <input class="form-check-input" value="2f7fbcf3-3007-4180-a5fe-84d2bcdf171b" type="radio" name="PaymentId" id="flexRadioDefault1">
                        <label class="form-check-label" for="flexRadioDefault1">
                            Ship (COD)
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" value="1f7fbcf3-3007-4180-a5fe-84d2bcdf171b" type="radio" name="PaymentId" id="flexRadioDefault2" checked>
                        <label class="form-check-label" for="flexRadioDefault2">
                            Bank transfer
                        </label>
                    </div>
                    <c:if test="${not empty addressDeliveryError}">
                        <div class="alert alert-danger">${addressDeliveryError}</div>
                    </c:if>
                </div>
                <button type="submit" class="btn btn-primary">Place Order</button>
            </form>
        </div>
        <div class="col-md-6">
            <h2>Your shopping cart</h2>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cartDetail}" var="gh">
                    <tr>
                        <td>${gh.productDetail.product.name}</td>
                        <td>${gh.productDetail.price}</td>
                        <td>${gh.quantity}</td>
                        <td>${gh.productDetail.price * gh.quantity}VND</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <%--<h4>Total: ${total}</h4>--%>
            <h4>Total: ${cart.totalMoney}</h4>
        </div>
    </div>
</div>