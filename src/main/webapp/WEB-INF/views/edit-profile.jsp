<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<head>
    <tags:dependency />
    <script type="text/javascript" src="/js/confirm-profile.js"></script>
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
        <div class="col-md-6">First Name</div>
        <input class="col-md-5" id="fname" value="${customer.firstName}" type="text">
        <br/>
        <br/>
        <div class="col-md-6">Last Name</div>
        <input class="col-md-5" id="lname" value="${customer.lastName}" type="text">
        <br/>
        <br/>
        <div class="col-md-6">Email</div>
        <input class="col-md-5" id="email" value="${customer.email}" type="text">
        <br/>
        <br/>
        <div class="col-md-6">Address</div>
        <input class="col-md-5" id="address" value="${customer.address}" type="text">
        <br/>
        <br/>
        <div class="col-md-6">Birth Date</div>
        <input class="col-md-5" id="birthdate" value=${customer.birthDate} type="date">
        <br/>
        <br/>
        <div class="col-md-6">Newsletter Status</div>
        <div class="header radio-header"> Receive newsletter? </div>
                        <input class="radio" type="radio" name="newsletter" value="true"> <div class="radio-label"> Yes </div>
                        <input class="radio" type="radio" name="newsletter" value="false"> <div class="radio-label"> No </div>
        <br/>
        <br/>
    </div>
    <center><a id="confirm" class="btn btn-primary" data-customer="${customer.username}">Confirm</a></center>
    <br>
    <br>
    <hr>
    <form id="deleteCustomer">
        <input  name="username" type="hidden" value="${customer.username}">
        <center><button type="submit" id="delete" class="btn btn-danger" data-customer="${customer.username}">Delete Registration</button></center>
    </form>
</div>

<br />
<br />
<br />

<!--Footer-->
<tags:footer />
<!--/.Footer-->

</body>
</html>