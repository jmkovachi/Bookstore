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

    <tags:nav />

    <br/>
    <br/>
    <br/>
    <div class="container">

        <section class="section pt-4">
            <center>
                <h1>Vendor</h1>
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
                        <form name="addBook">
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
                                            <textarea class="form-control" rows="5" id="descripxn"></textarea>
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
                <div class="md-form">
                    <input type="text" class="form-control" placeholder="Enter ISBN of Book to Delete">
                </div>
                <button class="btn btn-danger" type="button">
                    Delete Book
                </button>

            </center>
        </div>  <!-- 2nd col-->


        <!--Grid 3rd column-->
        <div class="col-lg-4 col-md-12 mb-4">
            <div class="md-form">
                <input type="text" class="form-control" placeholder="Enter ISBN of Book to Edit">
            </div>
            <center>

                <!-- Button trigger modal -->
                <a href="#myModalEditBook" role="button" class="btn btn-info" data-toggle="modal">Edit Book Info</a>


                <!-- modal-->

                <!-- Edit Book Modal -->
                <div id="myModalEditBook" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <form name="editBook">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5>Edit Book</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>

                                <div class="modal-body">

                                    <!-- Title -->
                                    <div class="md-form mb-5">
                                        <input type="text" name="title" id="orangeForm-editTitle" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-editTitle">Title</label>
                                    </div>

                                    <!-- Author -->
                                    <div class="md-form mb-5">
                                        <input type="text" name="author" id="orangeForm-editAuthor" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-editAuthor">Author</label>
                                    </div>

                                    <!-- Vendor -->
                                    <div class="md-form mb-5">
                                        <input type="text" name="vUsername" id="orangeForm-editVendor" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-editVendor">Vendor</label>
                                    </div>

                                    <!-- ISBN -->
                                    <div class="md-form mb-4">
                                        <input type="text" name="isbn" id="orangeForm-editISBN" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-editISBN">ISBN</label>
                                    </div>

                                    <!-- Genre -->
                                    <div class="md-form mb-5">
                                        <input type="text" name="category" id="orangeForm-editGenre" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-editGenre">Enter genre</label>
                                    </div>

                                    <!-- Image addr -->
                                    <div class="md-form mb-5">
                                        <input type="text" name="imageUrl" id="orangeForm-editImg" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-editImg">Enter image url</label>
                                    </div>

                                    <!-- Price -->
                                    <div class="md-form input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text md-addon">$</span>
                                            <input type="text" name="price" id="orangeForm-editPrice" class="form-control validate" placeholder="0.00">
                                            <label data-error="" data-success="" for="orangeForm-editPrice">Price</label>
                                        </div>
                                    </div>



                                    <!-- Book description -->
                                    <div class="form-group">
                                        <label for="editDescription">Book Description:</label>
                                        <textarea class="form-control" rows="5" id="editDescription"></textarea>
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
            <div class="row">
                <div class="col-lg-4 col-md-12 mb-4">
                    <!--Card-->
                    <div class="card card-ecommerce">
                        <!--Card image-->
                        <div class="view overlay">
                            <img height="225" width="225" src="#" class="text-center" alt="">
                            <a>
                                <div class="mask rgba-white-slight"></div>
                            </a>
                        </div>


                        <!--Card content-->
                        <div class="card-body">

                            <!--Title-->
                            <h5 class="card-title mb-1"><strong><a href="#" class="dark-grey-text">Title</a></strong></h5>
                            by Author

                            <!--Card footer-->
                            <div class="card-footer pb-0">
                                <div class="row mb-0">
                                    <span class="float-left"><strong>Price</strong></span>
                                </div>
                            </div>

                        </div>
                        <!--Card content-->

                    </div>
                    <!--Card-->

            </div>
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
        var slider = $("#calculatorSlider");
        var developerBtn = $("#developerBtn");
        var corporateBtn = $("#corporateBtn");
        var privateBtn = $("#privateBtn");
        var reseller = $("#resellerEarnings");
        var client = $("#clientPrice");
        // var percentageBonus = 30; // = 30%
        var license = {
            corpo: {
                active: true,
                price: 319,
            },
            dev: {
                active: false,
                price: 149,
            },
            priv: {
                active: false,
                price: 79,
            }
        }

        function calculate(price, value) {
            client.text((Math.round((price - (value / 100 * price)))) + '$');
            reseller.text((Math.round(((percentageBonus - value) / 100 * price))) + '$')
        }

        function reset(price) {
            slider.val(0);
            client.text(price + '$');
            reseller.text((Math.round((percentageBonus / 100 * price))) + '$');
        }
        developerBtn.on('click', function (e) {
            license.dev.active = true;
            license.corpo.active = false;
            license.priv.active = false;
            reset(license.dev.price)
        });
        privateBtn.on('click', function (e) {
            license.dev.active = false;
            license.corpo.active = false;
            license.priv.active = true;
            reset(license.priv.price);
        });
        corporateBtn.on('click', function (e) {
            license.dev.active = false;
            license.corpo.active = true;
            license.priv.active = false;
            reset(license.corpo.price);
        });
        slider.on("input change", function (e) {
            if (license.priv.active) {
                calculate(license.priv.price, $(this).val());
            } else if (license.corpo.active) {
                calculate(license.corpo.price, $(this).val());
            } else if (license.dev.active) {
                calculate(license.dev.price, $(this).val());
            }
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