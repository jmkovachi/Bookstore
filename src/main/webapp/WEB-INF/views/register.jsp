<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<html>
    <head>
        <tags:dependency />
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