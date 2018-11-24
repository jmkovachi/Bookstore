
<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>E-Commerce - MDBootstrap</title>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Material Design Bootstrap -->
    <link href="/css/catalogmdb.css" rel="stylesheet">
    <style type="text/css">
        .multiple-select-dropdown li [type=checkbox]+label {
            height: 1rem;
        }
    </style>

</head>

<body class="category-v1 hidden-sn white-skin animated">

<tags:nav />

<!-- Main Container -->
<div class="container mt-5 pt-3">


    <!--Navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark primary-color mt-5 mb-5">

        <!-- Navbar brand -->
        <a class="font-weight-bold white-text mr-4" href="#">Bookstore</a>

        <!-- Collapse button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1"
                aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>

        <!-- Collapsible content -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent1">

            <!-- Links -->
            <ul class="navbar-nav mr-auto">
            </ul>


            <!-- Search form -->
            <form class="search-form" role="search">
                <div class="form-group md-form my-0 waves-light">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
            </form>
        </div>
        <!-- Collapsible content -->

    </nav>
    <!--/.Navbar-->


    <div class="row pt-4">

        <!-- Sidebar (book genres) -->
        <div class="col-lg-3">

            <div class="">
                <!-- Grid row -->
                <div class="row">


                    <!-- Filter by category-->
                    <div class="col-md-6 col-lg-12 mb-5">
                        <h5 class="font-weight-bold dark-grey-text"><strong>Filter by Genre</strong></h3>
                            <div class="divider"></div>

                            <!--Radio group-->
                            <div class="form-group ">
                                <input class="form-check-input" name="group100" type="radio" id="radio100">
                                <label for="radio100" class="form-check-label dark-grey-text">All</label>
                            </div>

                            <div class="form-group">
                                <input class="form-check-input" name="group100" type="radio" id="radio101" checked>
                                <label for="radio101" class="form-check-label dark-grey-text">Laptop</label>
                            </div>

                            <div class="form-group">
                                <input class="form-check-input" name="group100" type="radio" id="radio102">
                                <label for="radio102" class="form-check-label dark-grey-text">Smartphone</label>
                            </div>

                            <div class="form-group">
                                <input class="form-check-input" name="group100" type="radio" id="radio103">
                                <label for="radio103" class="form-check-label dark-grey-text">Tablet</label>
                            </div>

                            <div class="form-group">
                                <input class="form-check-input" name="group100" type="radio" id="radio104">
                                <label for="radio104" class="form-check-label dark-grey-text">Headphones</label>
                            </div>
                            <!--Radio group-->
                    </div>
                    <!-- /Filter by category-->
                </div>
                <!-- /Grid row -->

                <!-- Grid row -->
                <div class="row">

                </div>
                <!-- /Grid row -->
            </div>

        </div>
        <!-- /.Sidebar -->

        <!-- Content -->
        <div class="col-lg-9">
            <!-- Products Grid -->
            <section class="section pt-4">

                <!-- Grid row -->
                <div class="row">

                    <!--Grid column-->
                    <div class="col-lg-4 col-md-12 mb-4">

                        <!--Card-->
                        <div class="card card-ecommerce">

                            <!--Card image-->
                            <div class="view overlay">
                                <img src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/1.jpg" class="img-fluid" alt="">
                                <a>
                                    <div class="mask rgba-white-slight"></div>
                                </a>
                            </div>
                            <!--Card image-->

                            <!--Card content-->
                            <div class="card-body">
                                <!--Category & Title-->

                                <h5 class="card-title mb-1"><strong><a href="" class="dark-grey-text">iPad</a></strong></h5>


                                <!--Card footer-->
                                <div class="card-footer pb-0">
                                    <div class="row mb-0">
                                        <span class="float-left"><strong>1439$</strong></span>
                                        <span class="float-right">

                                        <a class="" data-toggle="tooltip" data-placement="top" title="Add to Cart"><i class="fa fa-shopping-cart ml-3"></i></a>
                                        </span>
                                    </div>
                                </div>

                            </div>
                            <!--Card content-->

                        </div>
                        <!--Card-->

                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-4 col-md-6 mb-4">
                        <!--Card-->
                        <div class="card card-ecommerce">

                            <!--Card image-->
                            <div class="view overlay">
                                <img src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/15.jpg" class="img-fluid" alt="">
                                <a>
                                    <div class="mask rgba-white-slight"></div>
                                </a>
                            </div>
                            <!--Card image-->

                            <!--Card content-->
                            <div class="card-body">
                                <!--Category & Title-->
                                <h5 class="card-title mb-1"><strong><a href="" class="dark-grey-text">Sony T56-v</a></strong></h5>

                                <!--Card footer-->
                                <div class="card-footer pb-0">
                                    <div class="row mb-0">
                                        <span class="float-left"><strong>1439$</strong></span>
                                        <span class="float-right">

                                                <a class="" data-toggle="tooltip" data-placement="top" title="Add to Cart"><i class="fa fa-shopping-cart ml-3"></i></a>
                                                </span>
                                    </div>
                                </div>

                            </div>
                            <!--Card content-->


                        </div>
                        <!--Card-->

                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-4 col-md-6 mb-4">

                        <!--Card-->
                        <div class="card card-ecommerce">

                            <!--Card image-->
                            <div class="view overlay">
                                <img src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/6.jpg" class="img-fluid" alt="">
                                <a>
                                    <div class="mask rgba-white-slight"></div>
                                </a>
                            </div>
                            <!--Card image-->

                            <!--Card content-->
                            <div class="card-body">
                                <!--Category & Title-->

                                <h5 class="card-title mb-1"><strong><a href="" class="dark-grey-text">Headphones</a></strong></h5>


                                <!--Card footer-->
                                <div class="card-footer pb-0">
                                    <div class="row mb-0">
                                        <span class="float-left"><strong>1439$</strong></span>
                                        <span class="float-right">

                                            <a class="" data-toggle="tooltip" data-placement="top" title="Add to Cart"><i class="fa fa-shopping-cart ml-3"></i></a>
                                            </span>
                                    </div>
                                </div>

                            </div>
                            <!--Card content-->

                        </div>
                        <!--Card-->

                    </div>
                    <!--Grid column-->

                </div>
                <!--Grid row-->

                <!-- Grid row -->
                <div class="row">

                    <!--Grid column-->
                    <div class="col-lg-4 col-md-12 mb-4">

                        <!--Card-->
                        <div class="card card-ecommerce">

                            <!--Card image-->
                            <div class="view overlay">
                                <img src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/13.jpg" class="img-fluid" alt="">
                                <a>
                                    <div class="mask rgba-white-slight"></div>
                                </a>
                            </div>
                            <!--Card image-->

                            <!--Card content-->
                            <div class="card-body">
                                <!--Category & Title-->

                                <h5 class="card-title mb-1"><strong><a href="" class="dark-grey-text">Samsung CT-567</a></strong></h5>


                                <!--Card footer-->
                                <div class="card-footer pb-0">
                                    <div class="row mb-0">
                                        <span class="float-left"><strong>1439$</strong></span>
                                        <span class="float-right">
                                            <a class="" data-toggle="tooltip" data-placement="top" title="Add to Cart"><i class="fa fa-shopping-cart ml-3"></i></a>
                                            </span>
                                    </div>
                                </div>

                            </div>
                            <!--Card content-->

                        </div>
                        <!--Card-->

                    </div>
                    <!--Grid column-->

                </div>


                <!--Grid row-->
            </section>
            <!-- /.Products Grid -->

        </div>
        <!-- /.Content -->

    </div>

</div>
<!-- /.Main Container -->

</main>


<!--Footer-->
<footer class="page-footer text-center text-md-left stylish-color-dark pt-0">

    <div style="background-color: #4285f4;">
        ><div class="container">
            </div>
        </div>
    </div>


    <!-- Copyright-->
    <div class="footer-copyright py-3 text-center">
        <div class="container-fluid">
            © 2018 Copyright: <a href="https://mdbootstrap.com/bootstrap-tutorial/" target="_blank"> MDBootstrap.com </a>
        </div>
    </div>
    <!--/.Copyright -->

</footer>
<!--/.Footer-->


<!-- SCRIPTS -->

<!-- JQuery -->
<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>

<!-- Bootstrap tooltips -->
<script type="text/javascript" src="/js/popper.min.js"></script>

<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="/js/bootstrap.min.js"></script>

<!-- MDB core JavaScript -->
<script type="text/javascript" src="/js/mdb.min.js"></script>

<script type="text/javascript">
    /* WOW.js init */
    new WOW().init();

    // Tooltips Initialization
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })
</script>
<script>
    var slider = $("#calculatorSlider");
    var developerBtn = $("#developerBtn");
    var corporateBtn = $("#corporateBtn");
    var privateBtn = $("#privateBtn");
    var reseller = $("#resellerEarnings");
    var client = $("#clientPrice");
    // var percentageBonus = 30; // = 30%
    var license = {
        corpo: {
            active: true,
            price: 319,
        },
        dev: {
            active: false,
            price: 149,
        },
        priv: {
            active: false,
            price: 79,
        }
    }

    function calculate(price, value) {
        client.text((Math.round((price - (value / 100 * price)))) + '$');
        reseller.text((Math.round(((percentageBonus - value) / 100 * price))) + '$')
    }

    function reset(price) {
        slider.val(0);
        client.text(price + '$');
        reseller.text((Math.round((percentageBonus / 100 * price))) + '$');
    }
    developerBtn.on('click', function (e) {
        license.dev.active = true;
        license.corpo.active = false;
        license.priv.active = false;
        reset(license.dev.price)
    });
    privateBtn.on('click', function (e) {
        license.dev.active = false;
        license.corpo.active = false;
        license.priv.active = true;
        reset(license.priv.price);
    });
    corporateBtn.on('click', function (e) {
        license.dev.active = false;
        license.corpo.active = true;
        license.priv.active = false;
        reset(license.corpo.price);
    });
    slider.on("input change", function (e) {
        if (license.priv.active) {
            calculate(license.priv.price, $(this).val());
        } else if (license.corpo.active) {
            calculate(license.corpo.price, $(this).val());
        } else if (license.dev.active) {
            calculate(license.dev.price, $(this).val());
        }
    })
</script>
<script>
    // Material Select Initialization
    $(document).ready(function () {
        $('.mdb-select').material_select();
    });
</script>
<script>
    // SideNav Initialization
    $(".button-collapse").sideNav();
</script>
</body>

</html>
