<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<head>
    <tags:dependency />
    <script src="/js/register-customer.js"></script>
</head>
<body>

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
        <input class="col-md-5" id="username" placeholder="Enter your new username..." type="text">
        <br/>
        <br/>
        <div class="col-md-6">First Name</div>
        <input class="col-md-5" id="fname" placeholder="Enter your new first name..." type="text">
        <br/>
        <br/>
        <div class="col-md-6">Last Name</div>
        <input class="col-md-5" id="lname" placeholder="Enter your new last name..." type="text">
        <br/>
        <br/>
        <div class="col-md-6">Email</div>
        <input class="col-md-5" id="email" placeholder="Enter your new email..." type="text">
        <br/>
        <br/>
        <div class="col-md-6">Address</div>
        <input class="col-md-5" id="address" placeholder="Enter your new address..." type="text">
        <br/>
        <br/>
        <div class="col-md-6">Birth Date</div>
        <input class="col-md-5" id="birthdate" placeholder="Enter your new birth date..." type="date">
        <br/>
        <br/>
        <div class="col-md-6">Newsletter Status</div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="newsletter">
            <label class="custom-control-label" for="defaultUnchecked">Subscribed</label>
        </div>
        <br/>
        <br/>
    </div>
    <center><a id = "confirm" class = "btn btn-primary">Edit Profile</a></center>
</div>

</body>
</html>