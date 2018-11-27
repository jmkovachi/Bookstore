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
<!-- 3 ool layout -->
<div class="container">

    <section class="section pt-4">
        <center>
            <h1>Client Reports</h1>
        </center>

        <!-- Grid FIRST ROW -->
        <div class="row">
            <!--Grid 1st column-->
            <div class="col-lg-4 col-md-12 mb-4">
                VIEW REPORT 1
            </div>

            <!-- Grid 2nd column-->
            <div class="col-lg-4 col-md-12 mb-4">
                VIEW REPORT 2
            </div>

            <!-- Grid 3rd column -->
            <div class="col-lg-4 col-md-12 mb-4">
                VIEW REPORT 3
            </div>
        </div>
    </section>
</div>

</body>
</html>