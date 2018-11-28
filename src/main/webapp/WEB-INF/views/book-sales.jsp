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

        .hide {
            display: none;
        }
    </style>

    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
    <script src="/js/common.js"></script>
    <script src="/js/book-sales.js"></script>
</head>

<body class="category-v1 hidden-sn white-skin animated">

<tags:nav />


<br/>
<br/>
<br/>
<div class="container">

    <section class="section pt-4">
            <center>
            <h1>Book Sales Report</h1>
            <hr style="width:50%;">

                    <h3>All Books</h3>
                    <p>This year's total number of sales: ${sales.totalYearSales}" </p>
                    <p>This year's total amount: $<tags:doubleFormat  num="${sales.totalYearAmount}"/></p>
                    <p>This month's total number of sales: ${sales.totalMonthSales}</p>
                    <p>This month's total amount: $<tags:doubleFormat num="${sales.totalMonthAmount}"/> </p>

                <br>
                <br>

                <center>
                    <h3>Sales of a Specific Book</h3>
                    <div class="col-6 center-block">
                        <div class="input-group mb-3">
                            <form id="bookSales">
                                <input name="isbn" type="text" class="form-control" placeholder="Enter Book ISBN" aria-label="bookISBN" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="submit">Generate Sales</button>
                                </div>
                            </form>
                        </div>
                        <div class="hide" id="bookContent">
                            <p>This year's number of sales: $<p style="display: inline;" id="bookYearSales"></p></p>
                            <p>This year's total amount: $<p style="display: inline;" id="bookYearTotal"></p></p>
                            <p>This month's sales: $ <p style="display: inline;" id="bookMonthSales"></p></p>
                            <p>This month's total amount : $<p style="display: inline;" id="bookMonthTotal"></p></p>
                        </div>
                    </div>
                </center>

</center>
    </section>
</div>

<br />
<br />
<br />


<!--Footer-->
<tags:footer />
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
</html>>