<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title>E-Commerce - MDBootstrap</title>

  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

  <!-- Bootstrap core CSS -->
  <link href="/css/bootstrap.min.css" rel="stylesheet">

  <!-- Material Design Bootstrap -->
  <link href="/css/cartmdb.css" rel="stylesheet">

  <link href="/css/cart-custom.css" rel="stylesheet">

  <!-- Custom style cart-v1-->
  <style>
    @media only screen and (max-width: 768px) {

/* Force table to not be like tables anymore */
table,
thead,
tbody,
th,
td,
tr {
  display: block;
  text-align: center;
}
table.table td {
  padding-top: 1.5rem;
  padding-bottom: .4rem;

}
img {}
/* Hide table headers (but not display: none;, for accessibility) */
thead tr {
  position: absolute;
  top: -9999px;
  left: -9999px;
}

img {
  display: block;
  margin: 0 auto;
}
td {
  /* Behave  like a "row" */
  border: none;
  position: relative;
  padding-left: 50%;

}

td:before {
  /* Now like a table header */
  position: absolute;
  /* Top/left values mimic padding */
  top: 6px;
  left: 6px;
  white-space: nowrap;
}

td:nth-of-type(1):before {
  content: "Product";
  font-weight: 400;
  left: 50%;
  transform: translate(-50%);
}
td:nth-of-type(2):before {
  content: "Color";
  font-weight: 400;
  left: 50%;
  transform: translate(-50%);
}
td:nth-of-type(3) {
  position: absolute;
  border: none !important;
}
td:nth-of-type(4):before {
  content: "Price";
  left: 50%;
  transform: translate(-50%);
  font-weight: 400;
}
td:nth-of-type(5):before {
  content: "QTY";
  left: 50%;
  transform: translate(-50%);
  font-weight: 400;
}
td:nth-of-type(5) {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  padding-top: 1.9rem !important;
}
td:nth-of-type(6):before {
  content: "Amount";
  left: 50%;
  transform: translate(-50%);
  font-weight: 400;
}
td:nth-of-type(7):before {
  content: "Remove item";
  left: 50%;
  transform: translate(-50%);
  font-weight: 400;
}
.btn-group {
  margin-left: 0 !important;
}
tr:nth-child(4) td:nth-of-type(4):before,
tr:nth-child(4) td:nth-of-type(1):before,
tr:nth-child(4) td:nth-of-type(2):before {
  content: '';
}
tr:nth-child(4) td:nth-of-type(1) {
  position: absolute;
  border: none !important;
}
tr:nth-child(4) td:nth-of-type(3) {
  position: relative;
  display: flex;
  justify-content: center;
}
tr:nth-child(4) td:nth-of-type(4) {
  border-top: none !important;
  display: flex;
  justify-content: center;
  border-bottom : 1px solid #dee2e6;
}

}
    </style>
</head>

<body class="cart-v1 hidden-sn white-skin animated">
  <tags:nav username="${cart.username}"/>

  <!--Main Layout-->
  <main>

    <!-- Main Container -->
    <div class="main container">
      <div class="row">
        <h2> ${cart.username}&#39;s cart </h2>
      </div>
      <section class="section pb-5">

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
                <th class="font-weight-bold">
                  <strong>Price</strong>
                </th>
                <th class="text-center font-weight-bold">
                  <strong>QTY</strong>
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
              <c:forEach items="${cart.cartItems}" var="cartItem">
                  <!-- First row -->
                  <tr>
                    <th scope="row">
                      <!-- TODO: update books with SMALL image url (zoom=2) instead of THUMBNAIL (zoom=1) url -->
                      <img src="${cartItem.book.imageUrl}" width="150" height="225" alt="" class="img-fluid z-depth-0">
                    </th>
                    <td>
                      <h5 class="mt-3">
                        <strong>${cartItem.book.title}</strong>
                      </h5>
                      <p class="text-muted">${cartItem.publisher}</p>
                    </td>
                    <td>${cartItem.book.author}</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${cartItem.singleFinalPrice}" /></td>
                    <td class="text-center text-md-left">
                      <span class="qty"> ${cartItem.cartItem.quantity} </span>
                      <div class="btn-group ml-2">
                        <label data-isbn="${cartItem.cartItem.isbn}" data-quantity="${cartItem.cartItem.quantity}"
                            class="decreaseQuantity btn btn-sm btn-primary btn-rounded">
                          <div name="options">&mdash;</div>
                        </label>
                        <label data-isbn="${cartItem.cartItem.isbn}" data-quantity="${cartItem.cartItem.quantity}"
                            class="increaseQuantity btn btn-sm btn-primary btn-rounded">
                          <div name="options">+</div>
                        </label>
                      </div>
                    </td>
                    <td class="font-weight-bold">
                      <strong><fmt:formatNumber type="number" maxFractionDigits="2" value="${cartItem.cartItem.finalPrice}" /></strong>
                    </td>
                    <td>
                      <button type="button" class="delete btn btn-sm btn-primary" data-isbn="${cartItem.cartItem.isbn}"
                      data-quantity="${cartItem.cartItem.quantity}" data-toggle="tooltip" data-placement="top" title="Remove item">X
                      </button>
                    </td>
                  </tr>
                  <!-- /.First row -->
              </c:forEach>
            </tbody>
            <!-- /.Table body -->

          </table>
          <c:if test="${cart.cartItems.size() > 0}">
            <h1 style="text-align:center"><a href="/checkout" class="checkout btn btn-primary btn-lg" type="submit">Proceed to checkout</a></h1>
          </c:if>
        </div>
        <!-- Shopping Cart table -->

      </section>


    </div>
    <!-- /Main Container -->
  </main>
  <!--Main Layout-->

  <!-- Cart Modal -->
  <div class="modal fade cart-modal" id="cart-modal-ex" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
      <!--Content-->
      <div class="modal-content">
        <!--Header-->
        <div class="modal-header">

          <h4 class="modal-title font-weight-bold dark-grey-text" id="myModalLabel">Your cart</h4>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <!--Body-->
        <div class="modal-body">

          <table class="table table-hover">
            <thead>
              <tr>
                <th>#</th>
                <th>Product name</th>
                <th>Price</th>
                <th>Remove</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>Product 1</td>
                <td>100$</td>
                <td>
                  <a>
                    <i class="fa fa-remove"></i>
                  </a>
                </td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>Product 2</td>
                <td>100$</td>
                <td>
                  <a>
                    <i class="fa fa-remove"></i>
                  </a>
                </td>
              </tr>
              <tr>
                <th scope="row">3</th>
                <td>Product 3</td>
                <td>100$</td>
                <td>
                  <a>
                    <i class="fa fa-remove"></i>
                  </a>
                </td>
              </tr>
              <tr>
                <th scope="row">4</th>
                <td>Product 4</td>
                <td>100$</td>
                <td>
                  <a>
                    <i class="fa fa-remove"></i>
                  </a>
                </td>
              </tr>

            </tbody>
          </table>

          <button class="btn btn-primary btn-rounded btn-sm">Checkout</button>

        </div>
        <!--Footer-->
        <div class="modal-footer">
          <button type="button" class="btn btn-grey btn-rounded btn-sm" data-dismiss="modal">Close</button>
        </div>
      </div>
      <!--/.Content-->
    </div>
  </div>

  <!-- /.Cart Modal -->

    <br />
    <br />
    <br />

  <!--Footer-->
  <tags:footer />
  <!--/.Footer-->

  <!-- Username hidden input -->
  <input type="hidden" id="username" value="${cart.username}" />

  <!-- SCRIPTS -->

  <!-- JQuery -->
  <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>

  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="/js/popper.min.js"></script>

  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="/js/bootstrap.min.js"></script>

  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="/js/cartmdb.js"></script>
  <script type"text/javascript" src="/js/cart.js"></script>
  <script type="text/javascript">
    /* WOW.js init */
    new WOW().init();

    // MDB Lightbox Init
    $(function () {
      $("#mdb-lightbox-ui").load("mdb-addons/mdb-lightbox-ui.html");
    });

    // Tooltips Initialization
    $(function () {
      $('[data-toggle="tooltip"]').tooltip()
    })

    // SideNav Initialization
    $(".button-collapse").sideNav();

    // Material Select Initialization
    $(document).ready(function () {
      $('.mdb-select').material_select();
    });

  </script>

</body>

</html>
