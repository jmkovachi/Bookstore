<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<c:set var="books" value="${vendor.books}"/>
<c:set var="vendor" value="${vendor.vendor}"/>
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
        <style type="text/css">
            .multiple-select-dropdown li [type=checkbox]+label {
                height: 1rem;
            }
        </style>
        <script src="/js/common.js"></script>
        <script src="/js/vendor.js"></script>
    </head>

    <body class="category-v1 hidden-sn white-skin animated">

    <tags:nav vendor="true" username="${vendor.username}"/>

    <br/>
    <br/>
    <br/>
    <div class="container">

        <section class="section pt-4">
            <center>
                <h1>${vendor.company}</h1>
            </center>
    <!-- Grid 2ND ROW (BOOKS) -->
    <h2>Manage Books</h2>
    <hr>


    <div class="row">

        <!--Grid 1st column-->
        <div class="col-lg-4 col-md-12 mb-4">
            <center>
                <br/>
                <br/>
                <br/>
                <div>

                    <!-- Button trigger modal -->
                    <a href="#myModal2" role="button" class="btn btn-success" data-toggle="modal">Add New Book</a>

                    <!-- New Book Modal -->
                    <div id="myModal2" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <form id="addBook" name="addBook">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5>New Book</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>

                                    <div class="modal-body">

                                        <!-- Title -->
                                        <div class="md-form mb-5">
                                            <input type="text" name="title" id="orangeForm-bktitle" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-bktitle">Title</label>
                                        </div>

                                        <!-- Author -->
                                        <div class="md-form mb-5">
                                            <input type="text" name="author" id="orangeForm-bkauthor" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-bkauthor">Author</label>
                                        </div>

                                        <!-- Vendor -->
                                        <div class="md-form mb-5">
                                            <input type="text" name="vUsername" id="orangeForm-bkVendor" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-bkVendor">Vendor</label>
                                        </div>

                                        <!-- ISBN -->
                                        <div class="md-form mb-4">
                                            <input type="text" name="isbn" id="orangeForm-bookISBN" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-bookISBN">ISBN</label>
                                        </div>

                                        <!-- Genre -->
                                        <div class="md-form mb-5">
                                            <input type="text" name="category" id="orangeForm-addGenre" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-addGenre">Enter genre</label>
                                        </div>

                                        <!-- Image addr -->
                                        <div class="md-form mb-5">
                                            <input type="text" name="imageUrl" id="orangeForm-imageAddr" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-imageAddr">Enter image url</label>
                                        </div>

                                        <!-- Price -->
                                        <div class="md-form input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text md-addon">$</span>
                                                <input type="text" name="price" id="orangeForm-bkPrice" class="form-control validate" placeholder="0.00">
                                                <label data-error="" data-success="" for="orangeForm-bkPrice">Price</label>
                                            </div>
                                        </div>



                                        <!-- Book description -->
                                        <div class="form-group">
                                            <label for="descripxn">Book Description:</label>
                                            <textarea name="summary" class="form-control" rows="5" id="descripxn"></textarea>
                                        </div>

                                    </div> <!-- end of modal body -->

                                    <!-- Modal footer: -->
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Save changes</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>

                </div> <!-- modal-->
            </center>
        </div>  <!-- first col (ADD NEW BOOK button of grid)-->

        <!--Grid 2nd column-->
        <div class="col-lg-4 col-md-12 mb-4">
            <center>
                <form id="deleteBook">
                    <div class="md-form">
                        <input name="isbn" type="text" class="form-control" placeholder="Enter ISBN of Book to Delete">
                        <input class="username" name="username" type="hidden" value="${vendor.username}">
                    </div>
                    <button class="btn btn-danger" type="submit">
                        Delete Book
                    </button>
                </form>
            </center>
        </div>  <!-- 2nd col-->


        <!--Grid 3rd column-->
        <div class="col-lg-4 col-md-12 mb-4">
            <div class="md-form">
                <input type="text" id="editBookInput" class="form-control" placeholder="Enter ISBN of Book to Edit">
            </div>
            <center>

                <!-- Button trigger modal -->
                <a href="#myModalEditBook" role="button" id="editBookModalLink" class="btn btn-info" data-toggle="modal">Edit Book Info</a>


                <!-- modal-->

                <!-- Edit Book Modal -->
                <div id="myModalEditBook" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <form id="editBook" name="editBook">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5>Edit Book</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>

                                <div class="modal-body">

                                    <!-- ISBN -->
                                    <div class="md-form mb-4">
                                        <input id="editIsbn" type="hidden" name="isbn">
                                        <div class="text-left" id="isbnValue"></div>
                                    </div>

                                    <!-- Vendor -->
                                    <div class="md-form mb-5">
                                        <div class="text-left" data-error="" data-success="" for="orangeForm-editVendor">Vendor: ${vendor.company}</div>
                                    </div>

                                    <!-- Title -->
                                    <div class="md-form mb-5">
                                        <input type="text" name="title" id="orangeForm-editTitle" class="title form-control validate">
                                        <label class="active" data-error="" data-success="" for="orangeForm-editTitle">Title</label>
                                    </div>

                                    <!-- Author -->
                                    <div class="md-form mb-5">
                                        <input type="text" name="author" id="orangeForm-editAuthor" class="author form-control validate">
                                        <label class="active" data-error="" data-success="" for="orangeForm-editAuthor">Author</label>
                                    </div>

                                    <!-- Genre -->
                                    <div class="md-form mb-5">
                                        <input type="text" name="category" id="orangeForm-editGenre" class="genre form-control validate">
                                        <label class="active" data-error="" data-success="" for="orangeForm-editGenre">Enter genre</label>
                                    </div>

                                    <!-- Image addr -->
                                    <div class="md-form mb-5">
                                        <input type="text" name="imageUrl" id="orangeForm-editImg" class="imageUrl form-control validate">
                                        <label class="active" data-error="" data-success="" for="orangeForm-editImg">Enter image url</label>
                                    </div>

                                    <!-- Price -->
                                    <div class="md-form input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text md-addon">$</span>
                                            <input type="text" name="price" id="orangeForm-editPrice" class="price form-control validate" placeholder="0.00">
                                            <label class="active" data-error="" data-success="" for="orangeForm-editPrice">Price</label>
                                        </div>
                                    </div>

                                    <!-- Book description -->
                                    <div class="form-group">
                                        <label class="active" for="editDescription">Book Description:</label>
                                        <textarea name="summary" class="summary form-control" rows="5" id="editDescription"></textarea>
                                    </div>

                                </div> <!-- end of modal body -->

                                <!-- Modal footer: -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

            </center>
        </div>
    </div>




        <!-- row 2 -->
            <h3>My Published Books:</h3>
            <hr>
            <c:choose>
                <c:when test="${books.size() > 0}">
                    <c:forEach var="i" begin="0" step="3" end="${books.size()-1}">
                    <!-- Grid FIRST ROW -->
                    <div class="row">
                        <c:forEach var="j" begin="${i}" end="${i+2 > books.size()-1 ? books.size()-1 : i+2}">
                            <!--Grid 1st column-->
                            <div class="col-lg-4 col-md-12 mb-4">
                                <c:set var="book" value="${books.get(j)}" />
                                <!--Card-->
                                <div id="${book.isbn}" data-isbn="${book.isbn}" class="card card-ecommerce">
                                    <!--Card image-->
                                    <div class="view overlay">
                                        <img height="225" width="225" src="${book.imageUrl}" class="text-center" alt="">
                                        <a>
                                            <div class="mask rgba-white-slight"></div>
                                        </a>
                                    </div>
                                    <!--Card image-->
        
                                    <!--Card content-->
                                    <div class="card-body">
                                        <!--Category & Title-->
        
                                        <h5 class="card-title mb-1"><strong><a href="/details/book/${book.isbn}" class="dark-grey-text">${book.title}</a></strong></h5>
                                        by ${book.author}
        
                                        <!--Card footer-->
                                        <div class="card-footer pb-0">
                                            <div class="row mb-0">
                                                <span class="float-left"><strong>${book.isbn}</strong></span>
                                                <c:if test="${not empty username}">
                                                                    <span class="float-right">
                                                                        <a class="cart" data-username="${username}" data-isbn="${book.isbn}" data-toggle="tooltip" data-placement="top" title="Add to Cart"><i class="fa fa-shopping-cart ml-3"></i></a>
                                                                    </span>
                                                </c:if>
                                            </div>
                                        </div>
        
                                    </div>
                                    <!--Card content-->
        
                                </div>
                                <!--Card-->
        
                            </div>
                            <!--Grid column (first column) of first row-->
                        </c:forEach>
        
                        <!--Grid column (2nd column) of first row-->
                        <div class="col-lg-4 col-md-6 mb-4">
                            <!-- insert code here just like 1st column-->
                        </div>
        
                        <!--Grid column (3rd column)-->
                        <div class="col-lg-4 col-md-6 mb-4">
                        </div>
        
                    </div> <!-- END OF FIRST ROW -->
                </c:forEach>
            </c:when>
            <c:otherwise>
                <h2> Vendor has no published books </h2>
            </c:otherwise>
            </c:choose>
            </div>
        </section>
    </div>

    <br />
    <br />
    <br />


    <!--Footer-->
    <tags:footer />
    <!--/.Footer-->




    <!-- script for overall modal -->
    <script type="text/javascript">
        $('#exampleModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget); //Button that triggered the modal
            var modal = $(this);
        })
    </script>

    <!-- JQuery -->
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>

    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="/js/popper.min.js"></script>

    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>

    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="/js/mdb.min.js"></script>

    <script type="text/javascript">
        /* WOW.js init */
        new WOW().init();

        // Tooltips Initialization
        $(function () {
            $('[data-toggle="tooltip"]').tooltip()
        })
    </script>
    <script>
        // Material Select Initialization
        $(document).ready(function () {
            $('.mdb-select').material_select();
        });
    </script>
    <script>
        // SideNav Initialization
        $(".button-collapse").sideNav();
    </script>
    </body>

</html>

    </body>
</html>