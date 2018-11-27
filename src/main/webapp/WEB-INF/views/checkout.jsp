<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>

<c:set var="customer" value="${checkout.customer}" />
<c:set var="cartItems" value="${checkout.cartItems}" />

<head>
  <tags:dependency />
  <script type="text/javascript" src="/js/jquery.serializeToJSON.js"></script>
  <script type="text/javascript" src="/js/checkout.js"></script>
</head>

<body class="grey lighten-3">

  <tags:nav username="${customer.username}"/>

  <!--Main layout-->
  <main class="mt-5 pt-4">
    <div class="container wow fadeIn">

      <!-- Heading -->
      <h2 class="my-5 h2 text-center">Checkout form</h2>
      <!--Grid row-->
      <div class="row">

        <!--Grid column-->
        <div class="col-md-8 mb-4">

          <!--Card-->
          <div class="card">

            <!--Card content-->
            <form class="checkout card-body">

              <!--Grid row-->
              <div class="row">
                <!--Grid column-->
                <div class="col-md-2 mb-2">
                </div>
                <!--Grid column-->
                <!--Grid column-->
                <div style="text-align:center" class="col-md-8 mb-2">

                  <!--Message-->
                  <div style="text-align:center">
                    ${customer.firstName}, please fill out the billing information below in order to checkout.
                  </div>

                </div>
                <!--Grid column-->
                <div class="col-md-2 mb-2">
                </div>
                <!--Grid column-->

              </div>
              <!--Grid row-->

              <!--Username-->
              <div class="md-form input-group pl-0 mb-5">
                <div> Username: ${customer.username} </div>
              </div>

              <!--email-->
              <div class="md-form mb-5">
                <div>
                    Email: ${customer.email}
                </div>
              </div>

              <!--address-->
              <div class="md-form mb-5">
                <input type="text" name="address" id="address" class="form-control" placeholder="1234 Main St">
                <label for="address" class="">Billing Address</label>
              </div>

              <!--Grid row-->
              <div class="row">

                <!--Grid column-->
                <div class="col-lg-4 col-md-12 mb-4">


                    <input type="text" name="city" id="city" class="form-control" placeholder="Athens">
                    <label for="city" class="">City</label>
                    <div class="invalid-feedback">
                        Please provide a city name.
                      </div>

                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-lg-4 col-md-6 mb-4">

                  <input type="text" name="state" id="state" class="form-control" placeholder="Georgia">
                  <label for="state" class="">State</label>
                  <div class="invalid-feedback">
                    Please provide a valid state.
                  </div>

                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-lg-4 col-md-6 mb-4">


                  <input type="text" name="zip" class="form-control" id="zip" placeholder="-----" required>
                  <label for="zip">Zip</label>
                  <div class="invalid-feedback">
                    Zip code required.
                  </div>

                </div>
                <!--Grid column-->

              </div>
              <!--Grid row-->

              <hr>

              <div class="d-block my-3">
                <div class="custom-control custom-radio">
                  <input id="credit" name="paymentType" value="CREDIT" type="radio" class="custom-control-input" checked required>
                  <label class="custom-control-label" for="credit">Credit/Debit card</label>
                </div>
                <div class="custom-control custom-radio">
                  <input id="cash" name="paymentType" value="CASH" type="radio" class="custom-control-input" required>
                  <label class="custom-control-label" for="cash">Cash</label>
                </div>
                <div class="custom-control custom-radio">
                  <input id="check" name="paymentType" value="CHECK" type="radio" class="custom-control-input" required>
                  <label class="custom-control-label" for="check">Check</label>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6 mb-3">
                  <label for="cc-number">Credit card number</label>
                  <input type="password" name="cardNum" class="form-control" id="cc-number" placeholder="" required>
                  <div class="invalid-feedback">
                    Credit card number is required
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-3 mb-3">
                  <label for="cc-expiration">Expiration</label>
                  <input name="expDate" type="text" class="form-control" id="cc-expiration" placeholder="mm-yyyy" required>
                  <div class="invalid-feedback">
                    Expiration date required
                  </div>
                </div>
                <div class="col-md-3 mb-3">
                  <label for="cc-expiration">CVV</label>
                  <input name="securityCode" type="text" class="form-control" id="cc-cvv" placeholder="" required>
                  <div class="invalid-feedback">
                    Security code required
                  </div>
                </div>
              </div>
              <hr class="mb-4">
              <button class="checkout btn btn-primary btn-lg btn-block" type="submit">Place Order</button>
              <input type="hidden" name="username" id="username" value="${customer.username}"/>
            </form>

          </div>
          <!--/.Card-->

        </div>
        <!--Grid column-->

        <!--Grid column-->
        <div class="col-md-4 mb-4">

          <!-- Heading -->
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-muted">Your cart</span>
            <span class="badge badge-secondary badge-pill">${cartItems.size()}</span>
          </h4>

          <!-- Cart -->
          <ul class="cartItems list-group mb-3 z-depth-1">
            <c:forEach items="${cartItems}" var="cartItem">
                <li class="cartItem list-group-item d-flex justify-content-between lh-condensed">
                  <div>
                    <h6 class="my-0">${cartItem.book.title}</h6>
                    <small class="text-muted">${cartItem.publisher}</small>
                  </div>
                  <c:if test="${!cartItem.cartItem.finalPrice.equals(cartItem.cartItem.originalPrice)}">
                    <div style="color: red;"><strike>$<tags:doubleFormat num="${cartItem.cartItem.originalPrice}"/></strike></div>
                  </c:if>
                  <span style="color: green;">$<tags:doubleFormat num="${cartItem.cartItem.finalPrice}"/></span>
                  <input class="cartData" type="hidden" data-isbn="${cartItem.book.isbn}" data-finalprice="${cartItem.cartItem.finalPrice}"
                    data-quantity="${cartItem.cartItem.quantity}" />
                </li>
            </c:forEach>
            <li style="text-align:right" class="list-group-item d-flex justify-content-between lh-condensed">
                <h6 class="my-0">Total Price: $<tags:doubleFormat num="${checkout.totalAmount}"/></h6>
            </li>
          </ul>
          <!-- Cart -->

          <!-- Promo code -->
          <form id="promo" class="card p-2">
            <div class="input-group">
              <input type="text" id="promoCode" class="form-control" placeholder="Promo code" aria-label="Recipient's username" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <button type="submit" class="btn btn-secondary btn-md waves-effect m-0" type="button">Redeem</button>
              </div>
            </div>
          </form>
          <!-- Promo code -->

        </div>
        <!--Grid column-->

      </div>
      <!--Grid row-->

    </div>
  </main>
  <!--Main layout-->

  <!-- SCRIPTS -->
  <!-- JQuery -->
  <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="/js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="/js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="/js/mdb.min.js"></script>
  <!-- Initializations -->
  <script type="text/javascript">
    // Animations initialization
    new WOW().init();
  </script>
</body>

</html>