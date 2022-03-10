<%@page import="BookStoreOnlineSystem.model.item.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Catalog - Online Shopping System</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
        <link rel="stylesheet" href="assets/fonts/simple-line-icons.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
        <link rel="stylesheet" href="assets/css/vanilla-zoom.min.css">
    </head>

    <body>
        <nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
            <div class="container"><a class="navbar-brand logo" href="<%=request.getContextPath()%>/shopping">Online Shopping System</a><button data-bs-toggle="collapse" data-bs-target="#navcol-2" class="navbar-toggler"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"></li>
                        <li class="nav-item"></li>
                        <li class="nav-item"></li>
                        <li class="nav-item"></li>
                        <li class="nav-item"></li>
                    </ul>
                </div>
                <div class="collapse navbar-collapse" id="navcol-2">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"></li>
                        <li class="nav-item"></li>
                        <li class="nav-item"><a class="nav-link" href="#">Hello, ${account.getUsername()}</a></li>
                        <li class="nav-item"></li>
                        <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/cart">View cart</a></li>
                        <li class="nav-item"></li>
                        <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/logout">Log out</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <main class="page catalog-page">
            <section class="clean-block clean-catalog dark">
                <div class="container">
                    <div class="block-heading">
                        <h2 class="text-info">Shopping Page</h2>
                    </div>
                    <div class="content">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="products">
                                    <div class="row g-0">
                                        <!--div class="col-12 col-md-6 col-lg-4">
                                            <div class="clean-product-item">
                                                <div class="image"><a href="#"><img class="img-fluid d-block mx-auto" src="assets/img/tech/boots1.jpg"></a></div>
                                                <div class="product-name"><a href="#">Lorem ipsum dolor sit amet</a></div>
                                                <div class="about">
                                                    <div class="price">
                                                        <h3>$100</h3>
                                                    </div>
                                                    <div class="rating"><img src="assets/img/star.svg"><img src="assets/img/star.svg"><img src="assets/img/star.svg"><img src="assets/img/star-half-empty.svg"><img src="assets/img/star-empty.svg"></div>
                                                    <div><a href="#">Add to cart</a></div>
                                                </div>
                                            </div>
                                        </div-->

                                        <c:forEach var="item" items="${itemList}">
                                            <div class="col-12 col-md-6 col-lg-4">
                                                <div class="clean-product-item">
                                                    <div class="image"><a href="#"><img class="img-fluid d-block mx-auto" src='${item.getImgpath()}'></a></div>
                                                    <div class="product-name"><a href="#"><c:out value="${item.getName()}"/></a></div>
                                                    <div class="about">
                                                        <div class="rating"><img src="assets/img/star.svg"><img src="assets/img/star.svg"><img src="assets/img/star.svg"><img src="assets/img/star-half-empty.svg"><img src="assets/img/star-empty.svg"></div>
                                                        <div><a href="add-form?id=<c:out value='${item.id}' />">View details</a></div>
                                                        <div class="price">
                                                            <h3><c:out value="${item.getUnitPrice()}"/></h3>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!--div class="col-12 col-md-6 col-lg-4">
                                                <div class="clean-product-item">
                                                    <div class="image"><a href="#"><img class="img-fluid d-block mx-auto" src="assets/img/tech/image2.jpg"></a></div>
                                                    <div class="product-name"><a href="#">Lorem ipsum dolor sit amet</a></div>
                                                    <div class="about">
                                                        <div class="price">
                                                            <h3>$100</h3>
                                                        </div>
                                                        <div class="rating"><img src="assets/img/star.svg"><img src="assets/img/star.svg"><img src="assets/img/star.svg"><img src="assets/img/star-half-empty.svg"><img src="assets/img/star-empty.svg"></div>
                                                        <div><a href="#">Add to cart</a></div>
                                                    </div>
                                                </div>
                                            </div-->
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
        <script src="assets/js/vanilla-zoom.js"></script>
        <script src="assets/js/theme.js"></script>
    </body>

</html>