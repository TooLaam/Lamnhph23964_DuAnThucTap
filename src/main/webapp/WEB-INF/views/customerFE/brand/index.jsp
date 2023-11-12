<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <style><%@include file="style.css"%></style>
</head>

<br />
<div class="container">
    <div class="content">
        <span class="text-content">Brand </span>
        <span class="available">(${quantityBrand})</span>
    </div>
    <div class="row">
        <c:forEach items="${listBrand}" var="sp">
            <div class="col-md-2 col-4">
                <div class="thumnail">
                    <a href="/product/indexcus/brand/${sp.id}">
                        <img src="/assets/img/brand/${sp.image}" alt="" class="imageBrand" />
                        <div class="nameBrand" title="${sp.name}">${sp.name}</div>
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
<script src="https://www.gstatic.com/dialogflow-console/fast/messenger/bootstrap.js?v=1"></script>
<df-messenger
        intent="WELCOME"
        chat-title="ChatBot"
        agent-id="c9aa1141-ab88-427a-9131-9140328e202b"
        language-code="vi"
></df-messenger>