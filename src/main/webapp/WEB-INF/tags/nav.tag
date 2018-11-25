<%@ attribute name="username" required="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--Navigation-->
<header>
  <!-- Navbar -->
  <nav class="navbar fixed-top navbar-expand-lg  navbar-light scrolling-navbar white">
    <div class="container">
      <!-- SideNav slide-out button -->

      <a class="navbar-brand font-weight-bold" href="/catalog"><strong>BOOKSTORE</strong></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-4" aria-controls="navbarSupportedContent-4"
              aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent-4">
        <ul class="navbar-nav ml-auto">
          <c:if test="${not empty username}">
              <li class="nav-item">
                <a class="nav-link waves-effect waves-light dark-grey-text font-weight-bold" href="/cart/view"><i class="fa fa-shopping-cart blue-text"></i> View Cart <span class="sr-only">(current)</span></a>
              </li>
          </c:if>

          <li class="nav-item dropdown ml-3">
            <a class="nav-link dropdown-toggle waves-effect waves-light dark-grey-text font-weight-bold" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
               aria-haspopup="true" aria-expanded="false"><i class="fa fa-user blue-text"></i> Profile </a>
            <div class="dropdown-menu dropdown-menu-right dropdown-cyan" aria-labelledby="navbarDropdownMenuLink-4">
              <a class="dropdown-item waves-effect waves-light" href="/profile/direct">My account</a>
              <a class="dropdown-item waves-effect waves-light" href="#">Log out</a>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <!-- /.Navbar -->

</header>
<!-- /.Navigation -->