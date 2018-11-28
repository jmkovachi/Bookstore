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
    <div class="container">

        <section class="section pt-4">
            <center>
                <h1>Publisher Sales Report</h1>
                <hr style="width:50%;">
                <p>Publisher: ${pubSales.publisher}</p>
                <p>Total Sales: $${pubSales.totalSales}</p>
                <p>Average Sales: $${pubSales.averageSales} per book</p>
                <p>Total Sales: $${pubSales.totalSales}</p>
                <p>Best Selling Book: <a href="/details/book/${pubSales.bestSellingBook.isbn}">${pubSales.bestSellingBook}</a></p>
                <p>This Week&#39;s Sales: $${pubSales.thisWeekSales}</p>
            </center>
        </section>
    </div>

<br />
<br />
<br />

<!--Footer-->
<tags:footer2 />
<!--/.Footer-->

<!-- JQuery -->
<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>

<!-- Bootstrap tooltips -->
<script type="text/javascript" src="/js/popper.min.js"></script>

<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="/js/bootstrap.min.js"></script>

<!-- MDB core JavaScript -->
<script type="text/javascript" src="/js/mdb.min.js"></script>
</body>
</html>