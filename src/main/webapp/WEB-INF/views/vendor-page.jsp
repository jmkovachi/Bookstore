<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Material Design Bootstrap</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="/css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="/css/style.min.css" rel="stylesheet">
</head>
<body>
    <tags:nav />
    <br/>
    <br/>
    <br/>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <center><strong>Vendor Profile</strong></center>
            </div>
        </div>
        <br/>
        <br/>
        <div class="row">
            <div class="col-md-6">Username</div>
            <div class="col-md-6">${vendor.username}</div>
            <br/>
            <br/>
            <div class="col-md-6">Email</div>
            <div class="col-md-6">${vendor.email}</div>
            <br/>
            <br/>
            <div class="col-md-6">Company</div>
            <div class="col-md-6">${vendor.company}</div>
            <br/>
            <br/>
            <div class="col-md-6">Address</div>
            <div class="col-md-6">${vendor.address}</div>
            <br/>
            <br/>
        </div>
        <center><a href="/edit/vendor" class = "btn btn-primary">Edit Profile</a></center>
    </div>

    <br />
    <br />
    <br />

    <!--Footer-->
    <tags:footer />
    <!--/.Footer-->

</body>
</html>