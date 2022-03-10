<!DOCTYPE html>
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
        <main class="page product-page">
            <section class="clean-block clean-product dark">
                <div class="container">
                    <div class="block-heading">
                        <h2 class="text-info">Product Page</h2>
                    </div>
                    <div class="block-content">
                        <div class="product-info">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="gallery">
                                        <div id="product-preview" class="vanilla-zoom">
                                            <div class="zoomed-image"></div>
                                            <div class="sidebar"><img class="img-fluid d-block small-preview" src="${item.imgpath}"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <form action = "<%=request.getContextPath()%>/add-form" method="post">
                                        <div class="info form-group">
                                            <h3>${item.name}</h3>
                                            <div class="rating"><img src="assets/img/star.svg"><img src="assets/img/star.svg"><img src="assets/img/star.svg"><img src="assets/img/star-half-empty.svg"><img src="assets/img/star-empty.svg"></div>
                                            <div class="price">
                                                <h3>${item.unitPrice}</h3>
                                                <input type="number" name="id" value="${item.id}" style="display: none;">
                                                <br>
                                                <label for="quantity">Enter quantity:</label><input type="number" name="quantity" value="${1}">
                                            </div>
                                            <button class="btn btn-primary" type="submit" name = "button-add-to-cart"><i class="icon-basket"></i>Add to Cart</button>
                                            <div class="summary">
                                                <p>Description:</p>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="clean-related-items"></div>
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