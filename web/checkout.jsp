<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Payment - Online Shopping System</title>
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
        <main class="page payment-page">
            <section class="clean-block payment-form dark">
                <div class="container">
                    <div class="block-heading">
                        <h2 class="text-info">Payment</h2>    
                    </div>
                    <form>
                        <div class="products">
                            <h3 class="title">Checkout</h3>
                            <c:forEach var="cartItem" items="${cart.getCartItems()}">
                                <div class="item"><span class="price">${cartItem.getPrice()}</span>
                                    <p class="item-name">${cartItem.getItem().getName()}</p>
                                    <p class="item-description">Description:</p>
                                </div>
                            </c:forEach>
                            <div class="total"><span>Total</span><span class="price">${cart.totalPrice}</span></div>
                        </div>
                        <div class="card-details">
                            <h3 class="title">Credit Card Details</h3>
                            <div class="row">
                                <div class="col-sm-7">
                                    <div class="mb-3"><label class="form-label" for="card_holder">Card Holder</label><input class="form-control" type="text" id="card_holder" placeholder="Card Holder" name="card_holder"></div>
                                </div>
                                <div class="col-sm-5">
                                    <div class="mb-3"><label class="form-label">Expiration date</label>
                                        <div class="input-group expiration-date"><input class="form-control" type="text" placeholder="MM" name="expiration_month"><input class="form-control" type="text" placeholder="YY" name="expiration_year"></div>
                                    </div>
                                </div>
                                <div class="col-sm-8">
                                    <div class="mb-3"><label class="form-label" for="card_number">Card Number</label><input class="form-control" type="text" id="card_number" placeholder="Card Number" name="card_number"></div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="mb-3"><label class="form-label" for="cvc">CVC</label><input class="form-control" type="text" id="cvc" placeholder="CVC" name="cvc"></div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="mb-3"><button class="btn btn-primary d-block w-100" type="submit">Proceed</button></div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </section>
        </main>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
        <script src="assets/js/vanilla-zoom.js"></script>
        <script src="assets/js/theme.js"></script>
    </body>

</html>