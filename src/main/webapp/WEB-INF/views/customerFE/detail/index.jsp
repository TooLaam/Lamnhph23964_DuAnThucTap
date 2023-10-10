<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
  <style><%@include file="style.css"%></style>
</head>

    <br />
    <div class="container">
      <div class="row">
        <div class="col-6">
          <div class="product-big-img">
            <img src="/assets/img/product/kingda-sexy.jpg" alt="" />
          </div>
        </div>
        <div class="col-6">
          <h5>${sp.name}</h5>
          <p>${sp.sold} <span class="sold">Sold</span></p>
          <p class="price">$${sp.price}</p>
          <div class="row">
            <div class="col-3">
              <span class="text-content">Color</span>
            </div>
            <div class="col-9">
              <input type="radio" class="btn-check" name="options" id="Strong" autocomplete="off" checked>
              <label class="btn options" for="Strong">Strong</label>

              <input type="radio" class="btn-check" name="options" id="Gifted" autocomplete="off">
              <label class="btn options" for="Gifted">Gifted</label>

              <input type="radio" class="btn-check" name="options" id="Fun" autocomplete="off">
              <label class="btn options" for="Fun">Fun</label>

              <input type="radio" class="btn-check" name="options" id="Creative" autocomplete="off">
              <label class="btn options" for="Creative">Creative</label>

              <input type="radio" class="btn-check" name="options" id="Humble" autocomplete="off">
              <label class="btn options" for="Humble">Humble</label>
            </div>
          </div>
          <br>
          <div class="row">
            <div class="col-3">
              <span class="text-content">Quantity</span>
            </div>
            <div class="col-3">
              <div class="input-group mb-3">
                <button class="btn btn-outline">-</button>
                <input type="text" class="form-control" value="1" />
                <button class="btn btn-outline">+</button>
              </div>
            </div>
            <div class="col-6">
              <span class="text-content">${sp.sold} Products Available</span>
            </div>
          </div>
          <br>
          <div class="d-grid gap-2">
            <div class="row">
              <div class="col-10">
                <button class="btn btn-outline" type="button">
                  ADD TO CART
                </button>
              </div>
              <div class="col-2">
                <button class="fa fa-heart-o" type="button"></button>
              </div>
            </div>
            <button class="btn" type="button">BUY IT NOW</button>
          </div>
          <br>
          <strong>LIPSTICK WORLD'S COMMITMENT</strong>
          <ul class="list-unstyled">
            <li>
              <i class="fa fa-check">
                GUARANTEED 100% GENUINE QUALITY PRODUCTS
              </i>
            </li>
            <li>
              <i class="fa fa-check">
                LATEST DATE
              </i>
            </li>
            <li>
              <i class="fa fa-check">
                SERVE UNTIL CUSTOMERS ARE SATISFIED
              </i>
            </li>
          </ul>
        </div>
      </div>
      <div class="recently">
        <p>Recently viewed products</p>
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
      <br />
      <div class="recently">
        <p>You may also like</p>
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
      <br />
    </div>