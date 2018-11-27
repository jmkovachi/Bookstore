<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<html lang="en">
    <head>
    </head>
    <body>
        <div class="col-md-12 center-block text-center">
            <p class="card-text">Order confirmation<br /> <br />
                ${confirm.order.username}, your order has been placed! <br />
                Thank you for shopping at Bookstore.com!

            </p>
        </div>



    </body>
</html>