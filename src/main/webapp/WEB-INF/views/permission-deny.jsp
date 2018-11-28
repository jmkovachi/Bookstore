<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<html lang="en">
    <head>
        <tags:dependency />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <tags:nav/>
            </div>
            <br />
            <br />
            <br />

            <div class="row">
                <div class="col-md-12 center-block text-center">
                    <h5 class="card-title">Access Denied<br /> <br />
                        Sorry! You do not have the proper permissions to access this page!
                    </h5>
                </div>
            </div>
        </div>

        <br />
        <br />
        <br />

        <!--Footer-->
        <tags:footer2 />
        <!--/.Footer-->
    </body>
</html>