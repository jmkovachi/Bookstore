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
                <tags:nav username="${confirm.order.username}"/>
            </div>
            <br />
            <br />
            <br />

            <div class="row">
                <div class="col-md-12 center-block text-center">
                    <p class="card-text">Order confirmation<br /> <br />
                        ${confirm.order.username}, your order has been placed! <br />
                        Thank you for shopping at Bookstore.com! <br /> <br />
                        Order ID: ${confirm.order.orderId}
                    </p>



                    <!-- Shopping Cart table -->
                    <div class="table-responsive">

                      <table class="table product-table">

                        <!-- Table head -->
                        <thead>
                          <tr>
                            <th></th>
                            <th class="font-weight-bold">
                              <strong>Book</strong>
                            </th>
                            <th class="font-weight-bold">
                                <strong>Author</strong>
                            </th>
                            <th class="text-center font-weight-bold">
                              <strong>Quantity</strong>
                            </th>
                            <th class="font-weight-bold">
                              <strong>Amount</strong>
                            </th>
                            <th></th>
                          </tr>
                        </thead>
                        <!-- /.Table head -->

                        <!-- Table body -->
                        <tbody>
                          <c:forEach items="${confirm.orderItemWithBooks}" var="orderItemWithBook">
                              <!-- First row -->
                              <tr>
                                <th scope="row">
                                  <!-- TODO: update books with SMALL image url (zoom=2) instead of THUMBNAIL (zoom=1) url -->
                                  <img src="${orderItemWithBook.book.imageUrl}" width="150" height="225" alt="" class="img-fluid z-depth-0">
                                </th>
                                <td>
                                  <h5 class="mt-3">
                                    <strong>${orderItemWithBook.book.title}</strong>
                                  </h5>
                                </td>
                                <td>${orderItemWithBook.book.author}</td>
                                <td class="text-center text-md-left">
                                  <span class="qty"> ${orderItemWithBook.orderItem.quantity} </span>
                                </td>
                                <td class="font-weight-bold">
                                  <strong>$<tags:doubleFormat num="${orderItemWithBook.orderItem.finalPrice}" /></strong>
                                </td>
                              </tr>
                              <!-- /.First row -->
                          </c:forEach>
                        </tbody>
                        <!-- /.Table body -->

                      </table>
                    </div>
                    <h2 style="text-right">Total: $<tags:doubleFormat num="${confirm.order.total}" /></h2>

                </div>
            </div>
        </div>
    </body>
</html>