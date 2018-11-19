<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Material Design Bootstrap</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script
      src="https://code.jquery.com/jquery-3.3.1.min.js"
      integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
      crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <!-- Material Design Bootstrap -->
    <link href="/css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="/css/style.min.css" rel="stylesheet">
    <script src="/js/verify.js"></script>
</head>
<body>

<div class="card">
    <div class="card-body">
        <div class="container">
            <div class="row">
                <div class="col-md-12 center-block text-center">
                    <h5 class="card-title">Registration</h5>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 center-block text-center">
                    <p class="card-text">Registration confirmation<br /> <br />
                        Hi ${verify.username}, An email has been sent to ${verify.email} with a four digit PIN to confirm your identity. Please enter
                        the PIN below. Verifying emails helps us keep our site secure. We appreciate your understanding.
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 center-block text-center">
                    <p> PIN: </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 center-block text-center">
                    <input type="text" name="mycode" id="pin" maxlength="4" placeholder="XXXX">
                </div>
            </div>
        </div>
    </div>
    <center><button type="button" id="resend" class="btn btn-warning">Resend Email</button>
    <button type="button" id="confirm" class="btn btn-primary">Confirm</button></center>
</div>

<input type="hidden" id="username" value="${verify.username}" />
<input type="hidden" id="email" value="$[verify.email}" />

</body>
</html>