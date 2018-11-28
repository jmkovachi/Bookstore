<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>Bookstore</title>

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

<tags:nav username="${catalog.username}"/>

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

            <div class="dropdown">
                <button class="dropdownText btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Search by...
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a value="isbn" class="dropdown-item">ISBN</a>
                    <a value="title" class="dropdown-item">Title</a>
                    <a value="author" class="dropdown-item">Author</a>
                </div>
            </div>
            <div class="">
                <!-- Search form -->
                <form id="search" class="form-inline search-form" style="width: 60%;">
                    <div class="form-group md-form my-0 waves-light">
                        <input id="searchInput" name="searchInput" type="hidden" class="searchInput" />
                        <input name="searchText" class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search...">
                        <button class="btn btn-success btn-rounded btn-sm my-0" type="submit">Search</button>
                    </div>
                </form>
            </div>
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
                    <!-- Genres-->
                    <div class="col-md-6 col-lg-12 mb-5">
                        <h5 class="font-weight-bold dark-grey-text"><strong>Search by Genre</strong></h5>
                        <div class="divider"></div>

                        <!--Collapsible Genres-->
                        <div class="panel-group" id="accordionTwo">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <a  class="btn btn-outline-success dropdown-toggle" data-toggle="collapse" data-parent="#accordionTwo" href="#collapseFour">Genres</a>
                                </div>
                                <div class="panel-collapse collapse in" id="collapseFour">
                                    <div class="list-group">
                                        <c:forEach items="${catalog.categories}" var="genre">
                                            <a href="/catalog?genre=${genre}" class="list-group-item" style="border:none">${genre}</a>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
                <!-- /Grid row -->

            </div>
        </div>
        <!-- end of Genres sidebar -->

        <!-- Content -->
        <div class="col-lg-9">
            <!-- Products Grid -->
            <div class="row">
                <c:if test="${catalog.books.size() > 0 and not empty catalog.viewCategory}">
                    <h3 style="margin-top: 10px;">Results for ${catalog.viewCategory}s matching query <q>${catalog.viewString}</q></h3>
                    <a href="/catalog" style="margin-left: 15px;" class="btn btn-danger">Clear</a>
                </c:if>
            </div>
            <section class="section pt-4">
                <c:choose>
                    <c:when test="${catalog.books.size() > 0}">
                        <c:forEach var="i" begin="0" step="3" end="${catalog.books.size()-1}">
                            <!-- Grid FIRST ROW -->
                            <div class="row">
                                <c:forEach var="j" begin="${i}" end="${i+2 > catalog.books.size()-1 ? catalog.books.size()-1 : i+2}">
                                    <!--Grid 1st column-->
                                    <div class="col-lg-4 col-md-12 mb-4">
                                        <c:set var="book" value="${catalog.books.get(j)}" />
                                        <!--Card-->
                                        <div id="${book.isbn}" data-isbn="${book.isbn}" class="card card-ecommerce">
                                            <!--Card image-->
                                            <div class="view overlay">
                                                <img height="225" width="225" src="${book.imageUrl}" class="text-center" alt="">
                                                <a>
                                                    <div class="mask rgba-white-slight"></div>
                                                </a>
                                            </div>
                                            <!--Card image-->

                                            <!--Card content-->
                                            <div class="card-body">
                                                <!--Category & Title-->

                                                <h5 class="card-title mb-1"><strong><a href="/details/book/${book.isbn}" class="dark-grey-text">${book.title}</a></strong></h5>
                                                by ${book.author}

                                                <!--Card footer-->
                                                <div class="card-footer pb-0">
                                                    <div class="row mb-0">
                                                        <span class="float-left"><strong>$<tags:doubleFormat num="${book.price}"/></strong></span>
                                                        <c:if test="${not empty catalog.username}">
                                                            <span class="float-right">
                                                                <a class="cart" data-username="${catalog.username}" data-isbn="${book.isbn}" data-toggle="tooltip" data-placement="top" title="Add to Cart"><i class="fa fa-shopping-cart ml-3"></i></a>
                                                            </span>
                                                        </c:if>
                                                    </div>
                                                </div>

                                            </div>
                                            <!--Card content-->

                                        </div>
                                        <!--Card-->

                                    </div>
                                    <!--Grid column (first column) of first row-->
                                </c:forEach>

                                <!--Grid column (2nd column) of first row-->
                                <div class="col-lg-4 col-md-6 mb-4">
                                    <!-- insert code here just like 1st column-->
                                </div>

                                <!--Grid column (3rd column)-->
                                <div class="col-lg-4 col-md-6 mb-4">
                                </div>

                            </div> <!-- END OF FIRST ROW -->
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h2> No results for the given query </h2>
                    </c:otherwise>
                </c:choose>
                <!-- Grid 2nd row -->
                <div class="row">
                    <!-- insert columns here just like the first row -->
                </div>

                <!-- /. end of Content -->
            </section>
        </div>  <!-- col-lg-9 (RHS of page. The left three cols of page are for Genres)-->
    </div> <!-- row-pt-4-->
</div> <!--Main Container-->




<!--Footer-->
<tags:footer />
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

<!-- Catalog.js -->
<script type"text/javascript" src="/js/catalog.js"></script>

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