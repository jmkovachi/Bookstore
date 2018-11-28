<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<html lang="en">
    <head>
        <tags:dependency />
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

    <br />
    <br />
    <br />

    <!--Footer-->
    <tags:footer2 />
    <!--/.Footer-->
</html>