<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <main class="page shopping-cart-page">
            <section class="clean-block clean-cart dark">
                <div class="container">
                    <div class="block-heading">
                        <h2 class="text-info">Shopping Cart</h2>
                    </div>
                    <div class="content">
                        <div class="row g-0">
                            <div class="col-md-12 col-lg-8">
                                <div class="items">
                                    <c:forEach var="cartItem" items="${cart.getCartItems()}">
                                        <div class="product">
                                            <div class="row justify-content-center align-items-center">
                                                <div class="col-md-3">
                                                    <div class="product-image"><img class="img-fluid d-block mx-auto image" src='${cartItem.getItem().getImgpath()}'></div>
                                                </div>
                                                <div class="col-md-5 product-info"><a class="product-name" href="add-form?id=<c:out value='${cartItem.item.id}'/>"><c:out value="${cartItem.getItem().name}"/></a>
                                                    <div class="product-specs">
                                                        <div><span>Description:&nbsp;</span></div>
                                                    </div>
                                                </div>
                                                <div class="col-6 col-md-2 quantity"><label class="form-label d-none d-md-block" for="quantity">Quantity</label><input type="number" id="number" class="form-control quantity-input" value="${cartItem.getQuantity()}"></div>
                                                <div class="col-6 col-md-2 price"><span>${cartItem.getPrice()}</span></div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="col-md-12 col-lg-4">
                                <form action = "<%=request.getContextPath()%>/checkout" method="post">
                                    <div class="summary">
                                        <h3>Summary</h3>
                                        <h4><span class="text">Subtotal</span><span class="price">0</span></h4>
                                        <h4><span class="text">Discount</span><span class="price">0</span></h4>
                                        <h4><span class="text">Shipping</span><span class="price">0</span></h4>
                                        <h4><span class="text">Total</span><span class="price">${cart.getTotalPrice()}</span></h4><button class="btn btn-primary btn-lg d-block w-100" type="submit" name="button-checkout">Checkout</button>
                                    </div>
                                </form>
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