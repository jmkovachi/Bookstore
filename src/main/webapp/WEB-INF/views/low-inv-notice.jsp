<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>Bookstore</title>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Material Design Bootstrap -->
    <link href="/css/catalogmdb.css" rel="stylesheet">


    <style type="text/css">
        .multiple-select-dropdown li [type=checkbox]+label {
            height: 1rem;
        }
    </style>

    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
</head>

<body class="category-v1 hidden-sn white-skin animated">

<div class="container">
            <div class="row">
                <tags:nav username="${confirm.order.username}"/>
            </div>
            <br />
            <br />
            <br />

            <div class="row">
                <div class="col-md-12 center-block text-center">
                    <h1 class="card-title">Books with Low Inventory
                    </h1>
                    <hr style="width:50%;">

                    <!-- Low Inventory table -->
                    <div class="table-responsive">

                      <table class="table product-table">

                        <!-- Table head -->
                        <thead>
                          <tr>
                            <th class="font-weight-bold"><a href="/book-details"></a>
                              <strong>Book</strong>
                            </th>
                            <th class="font-weight-bold">
                                <strong>Title</strong>
                            </th>
                              <th class="font-weight-bold">
                                  <strong>ISBN</strong>
                              </th>
                            <th class="text-center font-weight-bold">
                              <strong>Total Inventory</strong>
                            </th>

                          </tr>
                        </thead>
                        <!-- /.Table head -->

                        <!-- Table body -->
                        <tbody>
                          <c:forEach items="${lowinv.books}" var="book">
                              <!-- First row -->
                              <tr>
                                <th scope="row">
                                  <!-- TODO: update books with SMALL image url (zoom=2) instead of THUMBNAIL (zoom=1) url -->
                                  <img src="${book.imageUrl}" width="150" height="225" alt="" class="img-fluid z-depth-0">
                                </th>
                                <td>
                                  <h5 class="mt-3">
                                    <strong>${book.title}</strong>
                                  </h5>
                                </td>
                                <td>${book.isbn}</td>
                                <td class="text-center text-md-left">
                                  <span class="qty"> ${book.totalInventory} </span>
                                </td>
                              </tr>
                              <!-- /.First row -->
                          </c:forEach>
                        </tbody>
                        <!-- /.Table body -->

                      </table>
                    </div>

                </div>
            </div>
        </div>

        <br />
        <br />
        <br />

        <!--Footer-->
        <tags:footer2 />
        <!--/.Footer-->


<!-- JQuery -->
<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>

<!-- Bootstrap tooltips -->
<script type="text/javascript" src="/js/popper.min.js"></script>

<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="/js/bootstrap.min.js"></script>

<!-- MDB core JavaScript -->
<script type="text/javascript" src="/js/mdb.min.js"></script>
</body>
</html>