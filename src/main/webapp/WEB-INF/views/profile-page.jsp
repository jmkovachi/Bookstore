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
        <tags:nav username="${username}"/>
        <br/>
        <br/>
        <br/>
        <div class="container">
            <div class="card">
                <div class="card-body">
                    <center><strong>User Profile</strong></center>
                </div>
            </div>
            <br/>
            <br/>
            <div class="row">
                <div class="col-md-6">Username</div>
                <div class="col-md-auto">${customer.username}</div>
                <br/>
                <br/>
                <div class="col-md-6">First Name</div>
                <div class="col-md-auto">${customer.firstName}</div>
                <br/>
                <br/>
                <div class="col-md-6">Last Name</div>
                <div class="col-md-auto">${customer.lastName}</div>
                <br/>
                <br/>
                <div class="col-md-6">Email</div>
                <div class="col-md-auto">${customer.email}</div>
                <br/>
                <br/>
                <div class="col-md-6">Address</div>
                <div class="col-md-auto">${customer.address}</div>
                <br/>
                <br/>
                <div class="col-md-6">Birth Date</div>
                <div class="col-md-auto">${customer.birthDate}</div>
                <br/>
                <br/>
                <div class="col-md-6">Newsletter Status</div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" checked="@customer.newsletter" class="custom-control-input" id="defaultUnchecked">
                    <label class="custom-control-label" for="defaultUnchecked">Subscribed</label>
                </div>
                <br/>
                <br/>
            </div>
            <center><a href="/edit/profile" class = "btn btn-primary">Edit Profile</a></center>
        </div>

        <br />
        <br />
        <br />

        <!--Footer-->
        <tags:footer2 />
        <!--/.Footer-->

    </body>
</html>