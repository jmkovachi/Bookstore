<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Customer registration</title>
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
    <link rel="stylesheet" href="/css/lrstyle.css">
    <script src="/js/register-customer.js"></script>
    </head>
    <body>
        <h1 style="text-align:center">Bookstore.com</h1>
        <div id="outerBox">
            <h3 style="text-align:center">Register</h3>
            <p>Create a Username</p>
            <input class="fields" id="username" placeholder="Enter your username..." type="text">
            <br>
            <p>Create a Password</p>
            <input class="fields" id="password" placeholder="Enter your password..." type="password">
            <br>
            <p>Re-enter Password</p>
            <input class="fields" id="repassword" placeholder="Enter your password again..." type="password">
            <br>
            <p>First Name</p>
            <input class="fields" id="first" placeholder="Enter your first name..." type="text">
            <br>
            <p>Middle initial</p>
            <input class="fields" id="minit" maxLength="1" placeholder="Enter your middle initial..." type="text">
            <br>
            <p>Last Name</p>
            <input class="fields" id="last" placeholder="Enter your last name..." type="text">
            <br>
            <p>Address</p>
            <input class="fields" id="address" placeholder="Enter your address..." type="text">
            <br>
            <p>Email</p>
            <input class="fields" id="email" placeholder="Enter your email..." type="text">
            <br>
            <p>Birthday</p>
            <input class="fields" id="birthday" placeholder="Enter your email..." type="date">
            <br>
                <div class="header radio-header"> Receive newsletter? </div>
                <input class="radio" type="radio" name="newsletter" value="true"> <div class="radio-label"> Yes </div>
                <input class="radio" type="radio" name="newsletter" value="false"> <div class="radio-label"> No </div>
            <br>
            <a id="register" class="buttons">Create Account</a>
            <hr>
            <h2 style="text-align:center">Already Have an Account?</h2>
            <a id="login" href="/login" class="buttons">Login Here</a>
        </div>
    </body>
</html>