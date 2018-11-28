<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<head>
    <tags:dependency />
    <script type="text/javascript" src="/js/confirm-vendor.js"></script>
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
        <div class="col-md-6">Email</div>
        <input class="col-md-5" id="email" value="${vendor.email}" type="text">
        <br/>
        <br/>
        <div class="col-md-6">Company</div>
        <input class="col-md-5" id="company" value="${vendor.company}" type="text">
        <br/>
        <br/>
        <div class="col-md-6">Address</div>
        <input class="col-md-5" id="address" value="${vendor.address}" type="text">
    </div>
    <center><a id="confirm" class="btn btn-primary" data-vendor="${vendor.username}">Confirm</a></center>

<br>
<br>
<hr>
<form>
    <input id="deleteVendor" type="hidden" value="${vendor.username}">
    <center><a id="delete" class="btn btn-danger" data-vendor="${vendor.username}">Delete Registration</a></center>
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