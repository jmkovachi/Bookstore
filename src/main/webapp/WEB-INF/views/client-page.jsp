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

    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
</head>

<body class="category-v1 hidden-sn white-skin animated">

<tags:nav />

<br/>
<br/>
<br/>
<!-- 3 col layout -->
<div class="container">

    <section class="section pt-4">
        <center>
            <h1>Client Reports</h1>
            <hr>

            <div style="width:50%">
                <a type="button" href="/end-of-day-sales" class="btn btn-primary"><i class="fa fa-calendar-o">End of Day Sales</i></a>

                <a type="button" href="/book-sales" class="btn btn-primary"><i class="fa fa-book">Book Sales</i></a>

                <a type="button" href="/publisher-sales" class="btn btn-primary"><i class="fa fa-line-chart">Publisher Sales</i></a>

                <a type="button" href="/low-inv-notice" class="btn btn-primary"><i class="fa fa-warning">Low Inventory Notices</i></a>
            </div>


        </center>
    </section>

</div>






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
</body>
</html>