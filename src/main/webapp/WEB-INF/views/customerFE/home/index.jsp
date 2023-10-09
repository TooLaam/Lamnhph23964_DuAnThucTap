<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="style.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <title>Document</title>
    <style>
        #freeShip{
            text-align: center;
            height: 31px;
            width: 100%;
            color: white;
            background-color: #00575C;
        }
        #freeShip a{
            color: white !important;
        }
        #freeShip a:hover{
            color: white !important;
            text-decoration: none;
        }
        #text_logo{
            color: #00575C;
            font-size: 24px;
            font-weight: 600;
            line-height: 29px;
            letter-spacing: 0em;
            text-align: left;
            margin-bottom: 60px;
        }
        .logo{
            width: 100%;
        }
        footer{
            clear: both;
        }
        #text_subscribe{
            font-size: 18px;
            font-weight: 600;
            line-height: 21px;
            letter-spacing: 0em;
            text-align: left;
            color: #000000;
        }
        #text_blog{
            font-size: 14px;
            font-weight: 400;
            line-height: 16px;
            letter-spacing: 0em;
            text-align: left;
            color: #7A7A7A;
        }
        .btn{
            color: white !important;
            background-color: #00575C !important;
        }
        .input-group>.btn{
            border-radius: 30px;
            margin-right: 0rem;
        }
        .btn:hover{
            background-color: #FFB800 !important;
        }
        .input-group>input{
            width: 375px;
            height: 53px;
            border-radius: 100px;
        }
        #track_order{
            font-size: 13px;
            font-weight: 600;
            line-height: 15px;
            letter-spacing: 0em;
            text-align: center;
            width: 128px;
            height: 35px;
            margin-bottom: 10px;
            border-radius: 100px;
            color: white !important;
            background-color: #00575C;
        }
        .fa{
            font-size: 20px !important;
            color: #00575C;
            transition: all 0.2s ease-in-out;
        }
        .fa:hover{
            color: #FFB800;
        }
        nav .fa{
            margin: 15px 0 15px 25px !important;
        }
        footer .fa{
            margin-right: 25px;
        }
        #logo_appstore{
            width: 132px;
            top: 128px;
            left: -2px;
        }
        #Copyright{
            font-size: 14px;
            font-weight: 400;
            line-height: 16px;
            letter-spacing: 0em;
            margin-bottom: 1rem;
            text-align: center;
            color: #7A7A7A;
        }
        .text_content_footer{
            font-size: 18px;
            font-weight: 600;
            line-height: 21px;
            letter-spacing: 0em;
            text-align: left;
            color: #000000;
        }
        .text_footer{
            color: #7A7A7A;
        }
        .link_footer{
            text-decoration: none;
            color: #7A7A7A;
        }
        .link_footer:hover{
            text-decoration: underline 1.5px #7A7A7A;
        }
        .col-md-4{
            margin-bottom: 30px;
        }
        .bd-footer{
            padding-top: 6rem!important;
            border-top: 2px solid #00575C;
        }
        .justify-content-end>.nav-item>.nav-link{
            text-decoration: underline 1.5px #000000;
            color: #000000 !important;
        }
        .justify-content-end>.nav-item>.nav-link:hover{
            text-decoration: none;
        }
        .nav-search{
            margin: 1rem 0;
        }
        .nav-shadow{
            box-shadow: 0px 1px 1px 0px #0000001A;
            margin-bottom: 1px;
        }
        .nav-underline>.nav-item>.nav-link{
            padding: 8px 0;
            font-variant: small-caps;
            font-weight: 500;
            font-size: large;
            color: #000000;
            transition: all 0.3s ease-in-out;
        }
        .nav-underline>.nav-item>.nav-link:hover{
            position: relative;
            color: #00575C;
        }
        .nav-underline>.nav-item>.nav-link:hover:after{
            content: "";
            position: absolute;
            height: 2px;
            width: 80px;
            transform: scale(1);
            background-color: #00575C;
            bottom: 0;
            right: 0;
            left: 0;
            margin: 0 auto;
        }
        .caption{
            margin: 1rem;
        }
        .caption>p{
            color: black;
            word-wrap: break-word;
            white-space: normal;
            overflow: hidden;
            display: -webkit-box;
            text-overflow: ellipsis;
            -webkit-box-orient: vertical;
            -webkit-line-clamp: 2;
            text-decoration: none
        }
        .caption>.price{
            font-size: large;
            font-weight: 500;
            color: #00575C;
            text-decoration: none
        }
        .caption>.sold{
            font-size: 15px;
            font-weight: 400;
            line-height: 18px;
            letter-spacing: 0em;
            float: right;
            color: #7A7A7A !important;

        }
        .thumnail{
            background-color: white;
            position: relative;
            height: 100%;
            transition: all 0.3s ease-in-out;
        }
        .thumnail>a{
            text-decoration: none !important;
        }
        .thumnail:hover{
            -moz-box-shadow: 1px 2px 4px rgba(0, 0, 0,0.5);
            -webkit-box-shadow: 1px 2px 4px rgba(0, 0, 0, .5);
            box-shadow: 1px 2px 4px rgba(0, 0, 0, .5);
        }
        .thumnail img{
            width: 100%;
        }
        .thumnail:hover::after {
            content: '';
            position: absolute;
            z-index: -1;
            -webkit-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.3);
            -moz-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.3);
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.3);
            width: 70%;
            left: 15%;
            height: 100px;
            bottom: 0;
        }
        .main{
            background-color: #F7F7F7 !important;
        }
        .banner{
            width: 100%;
            margin: 2rem 0;
        }
        .link-recommend{
            position: relative;
            width: 50%;
            max-width: 300px;
        }
        .img-recommend {
            display: block;
            width: 100%;
            height: auto;
        }
        .col-md-3{
            display: inline-block;

        }
        .overlay {
            position: absolute;
            bottom: 0;
            background: rgb(0, 0, 0);
            background: rgba(0, 0, 0, 0.5);
            color: #f1f1f1;
            width: 100%;
            transition: 0.5s ease;
            opacity: 0;
            color: white;
            font-size: 20px;
            padding: 20px;
            text-align: center;
        }
        .link-recommend:hover .overlay {
            opacity: 1;
        }
        .frame{
            border: 1px solid #00575C;
            border-radius: 15px;
            margin-top: 60px;
            padding: 30px 30px 10px 30px;
            position: relative;
        }
        .frame>p{
            width: Hug (251px);
            height: Hug (48px);
            padding: 10px 19px 10px 19px;
            gap: 10px;
            font-size: 24px;
            font-weight: 500;
            line-height: 28px;
            letter-spacing: 0em;
            text-align: center;
            position: absolute;
            top: -20px;
            left: 50%;
            transform: translateX(-50%);
            background-color: #F7F7F7;
            padding: 0 10px;
        }
    </style>
</head>

<body>
<div id="freeShip">
    <span>FREE SHIPPING with $20 Purchase </span>
    <a href="#">Details</a>
</div>
<div class="container">
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <a class="nav-link" href="#">Help</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/signup/index.html">Sign Up</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/login/index.html">Login</a>
        </li>
    </ul>
    <nav class="nav-search">
        <div class="row">
            <div class="col-md-2 col-4">
                <a href="/home/index.html"><img src="/assets/img/logo.png" class="logo" alt="logo" />
                </a>
            </div>
            <div class="col-md-1 col-0"></div>
            <div class="col-md-6 col-4">
                <div class="input-group mb-3" id="nav-search">
                    <input type="text" class="form-control" placeholder="What can we help you find?"
                           aria-label="Recipient's username" />
                    <button class="btn" type="button" id="button-addon2">
                        SEARCH
                    </button>
                </div>
            </div>
            <div class="col-md-1 col-0"></div>
            <div class="col-md-2 col-4">
                <ul class="list-unstyled" style="display: flex;">
                    <li>
                        <a href="/account/index.html">
                            <span class="fa fa-user"></span>
                        </a>
                    </li>
                    <li>
                        <a href="/wishlist/index.html">
                            <span class="fa fa-heart"></span>
                        </a>
                    </li>
                    <li>
                        <a href="/cart/index.html">
                            <span class="fa fa-shopping-cart"></span>
                        </a>
                    </li>
                    <li>
                        <a href="/bill/index.html">
                            <span class="fa fa-sticky-note"></span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="nav-shadow">
    <ul class="nav nav-underline nav-justified container">
        <li class="nav-item">
            <a class="nav-link" href="/home/index.html">home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/product/index.html">lips</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/aboutus/index.html">about us</a>
        </li>
    </ul>
</div>
<div id="nav-bottom"></div>
<div class="main">
    <div class="container">
        <img src="/assets/img/banner/banner3.jpg" class="banner" alt="" />
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                <c:forEach items="${listProduct}" var="sp">
                    <div class="col-md-3">

                    <a href="/product/index.html" class="link-recommend">
                        <img src="/assets/img/${sp.imageUrl}" class="img-recommend" alt="" />
                        <div class="overlay">Lip MAC</div>
                    </a>
                    </div>
                </c:forEach>
                </div>
            </div>
<%--            <div class="col-md-3 col-6">--%>
<%--                <a href="/product/index.html" class="link-recommend">--%>
<%--                    <img src="../images/recommend/MAC.jpg" class="img-recommend" alt="" />--%>
<%--                    <div class="overlay">Lip MAC</div>--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="col-md-3 col-6">--%>
<%--                <a href="/product/index.html" class="link-recommend">--%>
<%--                    <img src="../images/recommend/MAC.jpg" class="img-recommend" alt="" />--%>
<%--                    <div class="overlay">Lip MAC</div>--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="col-md-3 col-6">--%>
<%--                <a href="/product/index.html" class="link-recommend">--%>
<%--                    <img src="../images/recommend/MAC.jpg" class="img-recommend" alt="" />--%>
<%--                    <div class="overlay">Lip MAC</div>--%>
<%--                </a>--%>
<%--            </div>--%>
        </div>
        <div class="frame">
            <p>Deals Of The Month</p>
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <c:forEach items="${listProduct}" var="sp">
                            <div class="col-md-3">
                                   <a href="/product/index.html" class="link-recommend" style="text-decoration: none">
                                       <div class="thumnail">
                                     <img src="/assets/img/${sp.imageUrl}" class="img-recommend" alt="" />
                                       <div class="caption">
                                           <p>${sp.name}</p>
                                           <span class="price">${sp.price}</span>
                                           <span class="sold">${sp.sold} sold</span>
                                       </div>
                                       </div>
                                   </a>
                            </div>

                        </c:forEach>
                    </div>

                </div>
<%--                <div class="col-md-3 col-6">--%>
<%--                    <div class="thumnail">--%>
<%--                        <a href="/detail/index.html">--%>
<%--                            <img src="../images/product/kingda-sexy.jpg" alt="" />--%>
<%--                            <div class="caption">--%>
<%--                                <p>MAC Kinda Sexy</p>--%>
<%--                                <span class="price">$450000</span>--%>
<%--                                <span class="sold">10 sold</span>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-md-3 col-6">--%>
<%--                    <div class="thumnail">--%>
<%--                        <a href="/detail/index.html">--%>
<%--                            <img src="../images/product/kingda-sexy.jpg" alt="" />--%>
<%--                            <div class="caption">--%>
<%--                                <p>MAC Kinda Sexy</p>--%>
<%--                                <span class="price">$450000</span>--%>
<%--                                <span class="sold">10 sold</span>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-md-3 col-6">--%>
<%--                    <div class="thumnail">--%>
<%--                        <a href="/detail/index.html">--%>
<%--                            <img src="../images/product/kingda-sexy.jpg" alt="" />--%>
<%--                            <div class="caption">--%>
<%--                                <p>MAC Kinda Sexy</p>--%>
<%--                                <span class="price">$450000</span>--%>
<%--                                <span class="sold">10 sold</span>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="frame">--%>
<%--            <p>New Arrivals</p>--%>
<%--            <div class="row">--%>
<%--                <div class="col-md-3 col-6">--%>
<%--                    <div class="thumnail">--%>
<%--                        <a href="/detail/index.html">--%>
<%--                            <img src="../images/product/kingda-sexy.jpg" alt="" />--%>
<%--                            <div class="caption">--%>
<%--                                <p>MAC Kinda Sexy</p>--%>
<%--                                <span class="price">$450000</span>--%>
<%--                                <span class="sold">10 sold</span>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-md-3 col-6">--%>
<%--                    <div class="thumnail">--%>
<%--                        <a href="/detail/index.html">--%>
<%--                            <img src="../images/product/kingda-sexy.jpg" alt="" />--%>
<%--                            <div class="caption">--%>
<%--                                <p>MAC Kinda Sexy</p>--%>
<%--                                <span class="price">$450000</span>--%>
<%--                                <span class="sold">10 sold</span>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-md-3 col-6">--%>
<%--                    <div class="thumnail">--%>
<%--                        <a href="/detail/index.html">--%>
<%--                            <img src="../images/product/kingda-sexy.jpg" alt="" />--%>
<%--                            <div class="caption">--%>
<%--                                <p>MAC Kinda Sexy</p>--%>
<%--                                <span class="price">$450000</span>--%>
<%--                                <span class="sold">10 sold</span>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-md-3 col-6">--%>
<%--                    <div class="thumnail">--%>
<%--                        <a href="/detail/index.html">--%>
<%--                            <img src="../images/product/kingda-sexy.jpg" alt="" />--%>
<%--                            <div class="caption">--%>
<%--                                <p>MAC Kinda Sexy</p>--%>
<%--                                <span class="price">$450000</span>--%>
<%--                                <span class="sold">10 sold</span>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
        </div>
        <div class="frame">
            <p>Best selling</p>
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <c:forEach items="${listProduct}" var="sp">
                            <div class="col-md-3">
                                <a href="/product/index.html" class="link-recommend" style="text-decoration: none">
                                    <div class="thumnail">
                                        <img src="/assets/img/${sp.imageUrl}" class="img-recommend" alt="" />
                                        <div class="caption">
                                            <p>${sp.name}</p>
                                            <span class="price">${sp.price}</span>
                                            <span class="sold">${sp.sold} sold</span>
                                        </div>
                                    </div>
                                </a>
                            </div>

                        </c:forEach>
                    </div>

                </div>
<%--                <div class="col-md-3 col-6">--%>
<%--                    <div class="thumnail">--%>
<%--                        <a href="/detail/index.html">--%>
<%--                            <img src="../images/product/kingda-sexy.jpg" alt="" />--%>
<%--                            <div class="caption">--%>
<%--                                <p>MAC Kinda Sexy</p>--%>
<%--                                <span class="price">$450000</span>--%>
<%--                                <span class="sold">10 sold</span>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-md-3 col-6">--%>
<%--                    <div class="thumnail">--%>
<%--                        <a href="/detail/index.html">--%>
<%--                            <img src="../images/product/kingda-sexy.jpg" alt="" />--%>
<%--                            <div class="caption">--%>
<%--                                <p>MAC Kinda Sexy</p>--%>
<%--                                <span class="price">$450000</span>--%>
<%--                                <span class="sold">10 sold</span>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                </div>--%>

            </div>
        </div>
    </div>
    <br />
</div>
<footer class="bd-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-12">
                <div class="row">
                    <div class="col-md-12 col-12">
                        <img src="/assets/img/logo.png" class="logo" alt="logo" />
                        <p id="text_logo">We Have Everything For Lipstick Here!</p>
                    </div>
                    <div class="col-md-12 col-12">
                        <p id="text_subscribe">Subscribe To Our Newsletter</p>
                        <p id="text_blog">New blogs about lipsticks every week!</p>
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" placeholder="YOUR EMAIL ADDRESS"
                                   aria-label="Recipient's username" aria-describedby="button-addon2" />
                            <button class="btn" type="button" id="button-addon2">
                                SUBSCRIBE
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-1 col-12"></div>
            <div class="col-md-7 col-12">
                <div class="row">
                    <div class="col-md-4 col-6">
                        <p class="text_content_footer">Where's my order?</p>
                        <button class="btn" id="track_order" type="button">
                            TRACK ORDER
                        </button>
                        <p class="text_footer">
                            Please note, it may take longer than usual to fulfill orders
                            due to the impacts of COVID-19.
                        </p>
                    </div>
                    <div class="col-md-4 col-6">
                        <p class="text_content_footer">Shipping</p>
                        <p class="text_footer">About Free Shipping</p>
                        <p class="text_footer">Shipping Information</p>
                    </div>
                    <div class="col-md-4 col-6">
                        <p class="text_content_footer">Shopping App</p>
                        <p class="text_footer">
                            Try our View in Your Room feature, manage registries and save
                            payment info.
                        </p>
                        <img src="../images/logo_appstore.png" id="logo_appstore" />
                    </div>
                    <div class="col-md-4 col-6">
                        <p class="text_content_footer">Our Company</p>
                        <ul class="list-unstyled">
                            <li class="p-1">
                                <a href="#" class="link_footer">About Us</a>
                            </li>
                            <li class="p-1">
                                <a href="#" class="link_footer">Careers</a>
                            </li>
                            <li class="p-1">
                                <a href="#" class="link_footer">Contact</a>
                            </li>
                            <li class="p-1">
                                <a href="#" class="link_footer">Store locations</a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-4 col-6">
                        <p class="text_content_footer">Social Media</p>
                        <ul class="list-unstyled" style="display: flex;">
                            <li>
                                <a href="#">
                                    <span class="fa fa-facebook-square"></span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="fa fa-instagram"></span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="fa fa-youtube-play"></span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="fa fa-twitter"></span>
                                </a>
                            </li>
                        </ul>
                        <span class="text_footer">Show us your cat with:</span>
                        <span class="text_footer">#meowshop</span>
                        <br />
                        <span class="text_footer">#themeowshop</span>
                    </div>
                    <div class="col-md-4 col-6">
                        <p class="text_content_footer">Policies</p>
                        <ul class="list-unstyled">
                            <li class="p-1">
                                <a href="#" class="link_footer">Shipping Policy</a>
                            </li>
                            <li class="p-1">
                                <a href="#" class="link_footer">Refund Policy</a>
                            </li>
                            <li class="p-1">
                                <a href="#" class="link_footer">Privacy Policy</a>
                            </li>
                            <li class="p-1">
                                <a href="#" class="link_footer">Terms of Service</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <br />
        <hr />
        <div id="Copyright">
            Copyright © 2023 The Meow Shop. All rights reserved
        </div>
    </div>
</footer>
</body>

</html>