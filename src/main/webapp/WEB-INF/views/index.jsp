<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<html>
  <head>
    <tags:dependency />
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/lrstyle.css">
  </head>
  <body>
    <h1 style="text-align:center">Bookstore.com</h1>
    <div id="loginOuterBox">
      <h3 style="text-align:center">Login</h3>
      <form name="login" method="POST" action="/login">
        <p>Username</p>
        <input class="fields" name="username" id="username" placeholder="Enter your username..." type="text">
        <br>
        <p>Password</p>
        <input class="fields" name="password" id="password" placeholder="Enter your password..." type="password">
        <br>
        <button type="submit" name="submit" id="loginButton" class="btn btn-primary buttons">Login</button>
        <hr>
        <h2 style="text-align:center">New User?</h2>
        <a id="registerButton" href="/register/customer" class="btn btn-primary buttons">Register Here</a>
      </form>
    </div>
    <c:choose>
      <c:when test="${not empty message}">
          <div style="text-align: center; padding-top: 20px; color: red;" class="alert alert-error">
              ${message.message}
          </div>
      </c:when>
    </c:choose>
  </body>
</html>