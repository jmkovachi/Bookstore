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

</head>

<body class="category-v1 hidden-sn white-skin animated">

<tags:nav />

<br/>
<br/>
<br/>
<!-- 3 ool layout -->
<div class="container">

    <section class="section pt-4">
        <center>
            <h1>Manage</h1>
        </center>

        <!-- Grid FIRST ROW -->
        <h2>Users</h2>
        <div class="row">

            <!--Grid 1st column-->
            <div class="col-lg-4 col-md-12 mb-4">
                <center>
                    <br/>
                    <br/>
                    <br/>
                <div class="dropdown">
                    <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Add New User
                    </button>

                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#myModalCustomer" data-toggle="modal">Customer</a>
                        <a class="dropdown-item" href="#myModalVendor" data-toggle="modal">Vendor</a>
                        <a class="dropdown-item" href="#myModalClient" data-toggle="modal">Client</a>
                    </div>

                    <!-- New Customer Modal -->
                    <div id="myModalCustomer"  class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5>New Customer</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">

                                    <!-- Username -->
                                    <div class="md-form mb-5">
                                        <input type="text" id="orangeForm-usernameCust" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-usernameCust">Username</label>
                                    </div>

                                    <!-- Password -->
                                    <div class="md-form mb-5">
                                        <input type="text" id="orangeForm-passCust" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-passCust">Password</label>
                                    </div>

                                    <!-- First name-->
                                    <div class="md-form mb-5">
                                        <input type="text" id="orangeForm-firstName" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-firstName">First Name</label>
                                    </div>

                                    <!-- minit -->
                                    <div class="md-form mb-4">
                                        <input type="text" id="orangeForm-midinit" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-midinit">Middle Initial</label>
                                    </div>

                                    <!-- Last Name -->
                                    <div class="md-form mb-5">
                                        <input type="text" id="orangeForm-lastName" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-lastName">Last Name</label>
                                    </div>

                                    <!-- Address -->
                                    <div class="md-form mb-4">
                                        <input type="text" id="orangeForm-addrCust" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-addrCust">Address</label>
                                    </div>

                                    <!-- Birthdate -->
                                    <div class="md-form mb-5">
                                        Birthday:
                                        <input class="fields" id="birthday" placeholder="Enter your birthday..." type="date">
                                    </div>

                                    <!-- Newsletter -->
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input" id="defaultRegisterFormNewsletter">
                                        <label class="custom-control-label" for="defaultRegisterFormNewsletter">Subscribe to our newsletter</label>
                                    </div>


                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- New Vendor Modal -->
                    <div id="myModalVendor" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5>New Vendor</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="modal-body mx-3">
                                        <div class="md-form mb-5">
                                            <input type="text" id="orangeForm-usernameVendor" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-usernameVendor">Username</label>
                                        </div>
                                        <div class="md-form mb-5">
                                            <input type="text" id="orangeForm-companyVendor" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-companyVendor">Company</label>
                                        </div>
                                        <div class="md-form mb-5">
                                            <input type="text" id="orangeForm-addrVendor" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-addrVendor">Address</label>
                                        </div>
                                        <div class="md-form mb-5">
                                            <input type="text" id="orangeForm-passVendor" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-passVendor">Password</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- New Client Modal -->
                    <div id="myModalClient" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5>New Client</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body mx-3">
                                    <!-- Modal fields -->
                                    <div class="md-form mb-5">
                                        <input type="text" id="orangeForm-username" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-username">Username</label>
                                    </div>
                                    <div class="md-form mb-5">
                                        <input type="text" id="orangeForm-name" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-name">Name</label>
                                    </div>
                                    <div class="md-form mb-5">
                                        <input type="text" id="orangeForm-company" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-company">Company Name</label>
                                    </div>

                                    <div class="md-form mb-4">
                                        <input type="text" id="orangeForm-addr" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-addr">Address</label>
                                    </div>
                                    <div class="md-form mb-5">
                                        <input type="text" id="orangeForm-passClient" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-passClient">Password</label>
                                    </div>
                                </div>

                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>
                        </div>

                    </div> <!-- Client Modal -->


                </div>
                </center>
            </div>  <!-- first col of Admin Menu grid (still on first row)-->

            <!--Grid 2nd column-->
            <div class="col-lg-4 col-md-12 mb-4">
                <center>
                    <div class="md-form">
                        <input type="text" class="form-control" placeholder="Enter Username to Delete">
                    </div>
                    <button class="btn btn-danger" type="button">
                        Delete User
                    </button>

                </center>
            </div>  <!-- 2nd col-->

            <!--Grid 3rd column-->
            <div class="col-lg-4 col-md-12 mb-4">
                <div class="md-form">
                    <input type="text" class="form-control" placeholder="Enter Username to Edit">
                </div>
                <center>
                    <button class="btn btn-info" type="button">
                        Edit User Info
                    </button>

                </center>

            </div>  <!-- 3rd col -->
        </div> <!-- first row-->

        <hr>

        <!-- Grid 2ND ROW (BOOKS) -->
        <h2>Books</h2>
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
                                            <input type="text" id="orangeForm-bktitle" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-bktitle">Title</label>
                                        </div>

                                        <!-- Author -->
                                        <div class="md-form mb-5">
                                            <input type="text" id="orangeForm-bkauthor" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-bkauthor">Author</label>
                                        </div>

                                        <!-- Price -->
                                        <div class="md-form input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text md-addon">$</span>
                                                <input type="text" id="orangeForm-bkPrice" class="form-control validate" placeholder="0.00">
                                                <label data-error="" data-success="" for="orangeForm-bkPrice">Price</label>
                                            </div>
                                        </div>

                                        <!-- ISBN -->
                                        <div class="md-form mb-4">
                                            <input type="text" id="orangeForm-bookISBN" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-bookISBN">ISBN</label>
                                        </div>

                                        <!-- Image src field -->
                                        <div class="md-form mb-5">
                                            <input type="text" id="orangeForm-imageAddr" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-imageAddr">Enter image url</label>
                                        </div>
                                        <h4><strong>Browse Image:</strong></h4>
                                        <!-- Image preview (script is at bottom) -->
                                        <div class="md-form mb-5">
                                            <input type="file" accept="image/*" onchange="loadFile(event)">
                                            <img style="width:100%; height:80%" id="output"/>
                                        </div>


                                        <!-- Book description -->
                                        <div class="form-group">
                                            <label for="comment">Book Description:</label>
                                            <textarea class="form-control" rows="5" id="comment"></textarea>
                                        </div>

                                    </div> <!-- end of modal body -->

                                    <!-- Modal footer: -->
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save changes</button>
                                    </div>
                                </div>
                            </div>

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

                    <!-- EDIT Book Modal -->
                    <div id="myModalEditBook" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5>Edit Book</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">


                                    <!--Grid row-->
                                    <div class="row wow fadeIn">

                                        <!--Grid column-->
                                        <div class="col-md-6 mb-4">
                                            <img src="https://res.cloudinary.com/vop/image/fetch/c_lfill,f_auto,g_center,w_800/https://bi-admin.bibleinfo.com/sites/default/files/images/2017/ShieldOfFaith.med-750px.jpg" class="img-fluid" alt="">
                                            <!-- block with input and button to add an image -->

                                            <div class = "img-upload">
                                                <br/>
                                                <input type = "text" placeholder = "Enter image source"/>
                                                <button class="btn btn-primary">Insert Image</button>
                                            </div>

                                        </div>
                                        <!--Grid column-->

                                        <!--Grid column-->
                                        <div class="col-md-6 mb-4">

                                            <!--Content-->
                                            <div class="p-4" style="word-wrap: break-word">
                                                <!-- word wrap ensures that text doesn't go outside div-->
                                                <h3 contenteditable="true">Book Title</h3>
                                                <h6 contenteditable="true">by Author</h6>
                                                <p contenteditable="true" class="lead">
                                                    <span>$20</span>
                                                </p>
                                            </div>
                                            <!--Grid column-->

                                        </div> <!-- Grid row -->
                                    </div> <!-- modal body/content area -->

                                    <!-- Book Description -->
                                    <div class="form-group">
                                        <label for="comment">Description:</label>
                                        <textarea class="form-control" rows="5" id="comment"></textarea>
                                    </div>



                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save changes</button>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div> <!-- modal-->

                </center>

            </div>  <!-- 3rd col -->
        </div> <!-- 2ND ROW -->

        <hr>


        <!-- Grid 3rd ROW -->
        <h2>Orders</h2>
        <div class="row">

            <!--Grid 1st column-->
            <div class="col-lg-4 col-md-12 mb-4">
                <center>
                    <br/>
                    <br/>
                    <br/>
                    <div>
                        <!-- Button trigger modal -->
                        <a href="#myModal3" role="button" class="btn btn-success" data-toggle="modal">Add New Order</a>

                        <!-- Modal -->
                        <div id="myModal3" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5>New Order</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        ...
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save changes</button>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </center>
            </div>  <!-- first col -->

            <!--Grid 2nd column-->
            <div class="col-lg-4 col-md-12 mb-4">
                <center>
                    <div class="md-form">
                        <input type="text" class="form-control" placeholder="Enter ID of Order to Delete">
                    </div>
                    <button class="btn btn-danger" type="button">
                        Delete Order
                    </button>

                </center>
            </div>  <!-- 2nd col-->

            <!--Grid 3rd column-->
            <div class="col-lg-4 col-md-12 mb-4">
                <div class="md-form">
                    <input type="text" class="form-control" placeholder="Enter ID of Order to Edit">
                </div>
                <center>
                    <button class="btn btn-info" type="button">
                        Edit Order Info
                    </button>

                </center>

            </div>  <!-- 3rd col -->
        </div> <!-- 3rd row -->

        <hr>

        <!-- Grid 4th ROW -->
        <h2>Promotions</h2>
        <div class="row">

            <!--Grid 1st column-->
            <div class="col-lg-4 col-md-12 mb-4">
                <center>
                    <br/>
                    <br/>
                    <br/>
                    <div>
                        <!-- Button trigger modal -->
                            <a href="#myModal4" role="button" class="btn btn-success" data-toggle="modal">Add Promotion</a>

                            <!-- Modal -->
                            <div id="myModal4" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">New Promotion</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            ...
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                </div>

                            </div>
                    </div>

                </center>

            </div>  <!-- first col -->

            <!--Grid 2nd column-->
            <div class="col-lg-4 col-md-12 mb-4">
                <center>
                    <div class="md-form">
                        <input type="text" class="form-control" placeholder="Enter ID of Promotion to Delete">
                    </div>
                    <button class="btn btn-danger" type="button">
                        Delete Promotion
                    </button>

                </center>
            </div>  <!-- 2nd col-->

            <!--Grid 3rd column-->
            <div class="col-lg-4 col-md-12 mb-4">
                <div class="md-form">
                    <input type="text" class="form-control" placeholder="Enter ID of Promotion to Edit">
                </div>
                <center>
                    <button class="btn btn-info" type="button">
                        Edit Promotion
                    </button>

                </center>

            </div>  <!-- 3rd col -->
        </div> <!-- 4th row -->

        <hr>

    </section>









<!-- SCRIPTS -->
    <!-- script for previewing book image in modal after entering src-->
    <script>
        var loadFile = function(event) {
            var output = document.getElementById('output');
            output.src = URL.createObjectURL(event.target.files[0]);
        };
    </script>


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