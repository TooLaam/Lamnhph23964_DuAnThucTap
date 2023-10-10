<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
  <style><%@include file="style.css"%></style>
</head>

    <br />
    <div class="container">
      <div class="content">
        <span class="text-content">Wishlist </span>
        <span class="available">(4)</span>
      </div>
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

        <ul class="pagination">
          <li class="pagea-item">
            <a class="pagea-link" href="#" aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
          <li class="pagea-item"><a class="pagea-link" href="#">1</a></li>
          <li class="pagea-item"><a class="pagea-link" href="#">2</a></li>
          <li class="pagea-item"><a class="pagea-link" href="#">3</a></li>
          <li class="pagea-item">
            <a class="pagea-link" href="#" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
        </ul>
      </div>
    </div>