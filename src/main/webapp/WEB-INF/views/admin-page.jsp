<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<head>
    <tags:dependency />
    <style type="text/css">
        .multiple-select-dropdown li [type=checkbox]+label {
            height: 1rem;
        }
    </style>
    <script src="/js/common.js"></script>
    <script src="/js/admin.js"></script>
    <script type="text/javascript" src="/js/checkout.js"></script>
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
                        <form id="addCustomer">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5>New Customer</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">

                                    <!-- Username-->
                                    <div class="md-form mb-5">
                                        <input type="text" name="username" id="orangeForm-usernameCust" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-usernameCust">Username</label>
                                    </div>

                                    <!-- Password -->
                                    <div class="md-form mb-5">
                                        <input type="text" name="password" id="orangeForm-passCust" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-passCust">Password</label>
                                    </div>

                                    <!-- First name-->
                                    <div class="md-form mb-5">
                                        <input type="text" name="firstName" id="orangeForm-firstName" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-firstName">First Name</label>
                                    </div>

                                    <!-- minit -->
                                    <div class="md-form mb-4">
                                        <input type="text" name="minit" id="orangeForm-midinit" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-midinit">Middle Initial</label>
                                    </div>

                                    <!-- Last Name -->
                                    <div class="md-form mb-5">
                                        <input type="text" name="lastName" id="orangeForm-lastName" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-lastName">Last Name</label>
                                    </div>

                                    <!-- Address -->
                                    <div class="md-form mb-4">
                                        <input type="text" name="address" id="orangeForm-addrCust" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-addrCust">Address</label>
                                    </div>

                                    <!-- Birthdate -->
                                    <div class="md-form mb-5">
                                        Birthday:
                                        <input name="birthDate" class="fields" id="birthday" placeholder="Enter your birthday..." type="date">
                                    </div>

                                    <!-- Newsletter -->
                                    <div class="custom-control custom-checkbox">
                                        <input name="newsletter" type="checkbox" class="custom-control-input" id="defaultRegisterFormNewsletter">
                                        <label class="custom-control-label" for="defaultRegisterFormNewsletter">Subscribe to our newsletter</label>
                                    </div>


                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>
                        </div>
                        </form>
                    </div>

                    <!-- New Vendor Modal -->
                    <div id="myModalVendor" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <form id="addVendor">
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
                                            <input type="text" name="username" id="orangeForm-usernameVendor" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-usernameVendor">Username</label>
                                        </div>
                                        <div class="md-form mb-5">
                                            <input type="text" name="company" id="orangeForm-companyVendor" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-companyVendor">Company</label>
                                        </div>
                                        <div class="md-form mb-5">
                                            <input type="text" name="address" id="orangeForm-addrVendor" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-addrVendor">Address</label>
                                        </div>
                                        <div class="md-form mb-5">
                                            <input type="text" name="password" id="orangeForm-passVendor" class="form-control validate">
                                            <label data-error="" data-success="" for="orangeForm-passVendor">Password</label>
                                        </div>

                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                </div>

                            </div>
                        </div>
                        </form>
                    </div>

                    <!-- New Client Modal -->
                    <div id="myModalClient" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <form id="addClient">
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
                                        <input name="username" type="text" id="orangeForm-username" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-username">Username</label>
                                    </div>
                                    <div class="md-form mb-5">
                                        <input name="name" type="text" id="orangeForm-name" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-name">Name</label>
                                    </div>
                                    <div class="md-form mb-5">
                                        <input name="company" type="text" id="orangeForm-company" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-company">Company Name</label>
                                    </div>

                                    <div class="md-form mb-4">
                                        <input name="address" type="text" id="orangeForm-addr" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-addr">Address</label>
                                    </div>
                                    <div class="md-form mb-5">
                                        <input name="password" type="text" id="orangeForm-passClient" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-passClient">Password</label>
                                    </div>

                                </div>

                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>
                        </div>
                        </form>
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
                        <a href="/edit/profile" class = "btn btn-info">Edit User Info</a>
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


        <!-- Grid 3rd ROW -->
        <h2>Orders</h2>
        <div class="row">

            <!--Grid 1st column-->
            <div class="col-lg-4 col-md-12 mb-4">
                <center>
                    <br/>
                    <br/><!-- Button trigger modal -->
                    <a href="#myModalOrder" role="button" id="addOrder" class="btn btn-success" data-toggle="modal">Add New Order</a>

                    <br/>
                    <div>

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
                    <!-- Button trigger modal -->
                    <a href="#myModalOrder" id="editOrder" role="button" class="btn btn-info" data-toggle="modal">Edit Order Info</a>
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
                                <form id="addPromotion">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">New Promotion</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="md-form mb-5">
                                                <input type="text" name="promoCode" id="addPromoCode" class="form-control validate">
                                                <label data-error="" data-success="" for="addPromoCode">Promotion Code</label>
                                            </div>

                                            Discount Amount:
                                            <div class="input-group mb-3">
                                                <input type="text" name="percentOff" class="form-control" placeholder="Percentage Off">
                                                <div class="input-group-append">
                                                    <span class="input-group-text">%</span>
                                                </div>
                                            </div>
                                            <br/>


                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            <button type="submit" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            </div> <!-- add promo modal -->
                    </div>

                </center>

            </div>  <!-- first col -->

            <!--Grid 2nd column-->
            <div class="col-lg-4 col-md-12 mb-4">
                <form id="deletePromotion">
                    <center>
                        <div class="md-form">
                            <input name="promoId" type="text" class="form-control" placeholder="Enter ID of Promotion to Delete">
                        </div>
                        <button type="submit" class="btn btn-danger">
                            Delete Promotion
                        </button>

                    </center>
                </form>
            </div>  <!-- 2nd col-->

            <!--Grid 3rd column-->
            <div class="col-lg-4 col-md-12 mb-4">
                <div class="md-form">
                    <input type="text" class="form-control" placeholder="Enter ID of Promotion to Edit">
                </div>
                <center>
                    <!-- Button trigger modal -->
                    <a href="#myModalEditPromo" role="button" class="btn btn-info" data-toggle="modal">Edit Promotion</a>

                    <!-- Modal -->
                    <div id="myModalEditPromo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <form id="editPromotion">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5>Edit Promotion</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="md-form mb-5">
                                        <input type="text" name="promoCode" id="orangeForm-editPromoCode" class="form-control validate">
                                        <label data-error="" data-success="" for="orangeForm-editPromoCode">Promotion Code</label>
                                    </div>

                                    Discount Amount:
                                    <div class="input-group mb-3">
                                        <input type="text" name="percentOff" class="form-control" placeholder="Percentage Off">
                                        <div class="input-group-append">
                                            <span class="input-group-text">%</span>
                                        </div>
                                    </div>
                                    <br/>



                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>
                        </div>
                        </form>
                    </div>


            </center>

            </div>  <!-- 3rd col -->
        </div> <!-- 4th row -->

        <hr>

    </section>


</div>
<br />
<br />
<br />
<!--Footer-->
<tags:footer />
<!--/.Footer-->

<tags:orderDetailsModal />





<!-- SCRIPTS -->

<!-- Order Modal: If Credit radio button is selected, show credit card fields -->
<script>
    $(document).ready(function() {
        $('input[type="radio"]').click(function() {
         if($(this).attr('id') == 'credit') {
            $('#showCreditFields').show();
        }
    else {
        $('#showCreditFields').hide();
    }
    });
    });
</script>

<!-- Order modal: if check is selected -->
<script>
    $(document).ready(function() {
        $('input[type="radio"]').click(function() {
            if($(this).attr('id') == 'check') {
                $('#showCheckFields').show();
            }
            else {
                $('#showCheckFields').hide();
            }
        });
    });
</script>


<!-- Order Modal: if cash is selected -->
<script>
    $(document).ready(function() {
        $('input[type="radio"]').click(function() {
            if($(this).attr('id') == 'cash') {
                $('#showCashMsg').show();
            }
            else {
                $('#showCashMsg').hide();
            }
        });
    });
</script>

    <!-- FOR ADDING BOOK ISBN'S TO ORDER -->
    <script>
        $(document).ready(function(){
            $('#addbtn').click(function() {
                var isbn = $('#add').val();
                var quantity = $('#quantity').val();
                var uniqid = Math.round(new Date().getTime() + (Math.random() * 100));
                $('#list').append('<li id="'+uniqid+'" class="list-group-item">' +
                    '   <div class="row"> ' +
                    '       <div class="col-4"> ISBN: '+isbn+' </div> ' +
                    '       <div class="col-4"> Quantity: '+quantity+' </div> ' +
                    '       <div class="col-4"> <input type="button" data-isbn="'+isbn+'" data-quantity="'+quantity+'" + ' +
                    '          data-id="'+uniqid+'" class="listelement" value="X"/></div> ' +
                    '   </div> ' +
                    '<input type="hidden" name="listed[]" value="'+isbn+'"></li>');


                $('#add').val(''); // resets the field after submitting (i.e. clicking the "Add to List" button)
                $('#quantity').val('');
                return false;
            });
            $('#list').delegate(".listelement", "click", function() {
                var elemid = $(this).attr('data-id');
                $("#"+elemid).remove();
            });
        });
    </script>



    <!-- FOR ADDING BOOK ISBN'S TO PROMOTION -->
    <script>
        $(document).ready(function(){
            // add item to list
            $('#addbtnPromo').click(function(){
                var newitem = $('#addPromo').val();
                var uniqid = Math.round(new Date().getTime() + (Math.random() * 100));
                $('#listPromo').append('<li id="'+uniqid+'" class="list-group-item"><input type="button" data-id="'+uniqid+'" class="listelement" value="X" /> '+newitem+'<input type="hidden" name="listed[]" value="'+newitem+'"></li>');
                $('#addPromo').val('');
                return false;
            });
            // remove item from list
            $('#listPromo').delegate(".listelement", "click", function() {
                var elemid = $(this).attr('data-id');
                $("#"+elemid).remove();
            });
        });
    </script>

<!-- Edit Promotion -->
<!-- FOR ADDING BOOK ISBN'S TO PROMOTION -->
<script>
    $(document).ready(function(){
        // add item to list
        $('#addbtnEditPromo').click(function(){
            var newitem = $('#addEditPromo').val();
            var uniqid = Math.round(new Date().getTime() + (Math.random() * 100));
            $('#listEditPromo').append('<li id="'+uniqid+'" class="list-group-item"><input type="button" data-id="'+uniqid+'" class="listelement" value="X" /> '+newitem+'<input type="hidden" name="listed[]" value="'+newitem+'"></li>');
            $('#addEditPromo').val('');
            return false;
        });
        // remove item from list
        $('#listEditPromo').delegate(".listelement", "click", function() {
            var elemid = $(this).attr('data-id');
            $("#"+elemid).remove();
        });
    });
</script>

<!-- Edit Order -->
<script>
    $(document).ready(function(){
        $('#addbtnEditOrder').click(function() {
            var isbn = $('#addEditOrder').val();
            var quantity = $('#quantityEditOrder').val();
            var uniqid = Math.round(new Date().getTime() + (Math.random() * 100));
            $('#listEditOrder').append('<li id="'+uniqid+'" class="list-group-item">' +
                '   <div class="row"> ' +
                '       <div class="col-4"> ISBN: '+isbn+' </div> ' +
                '       <div class="col-4"> Quantity: '+quantity+' </div> ' +
                '       <div class="col-4"> <input type="button" data-isbn="'+isbn+'" data-quantity="'+quantity+'" + ' +
                '          data-id="'+uniqid+'" class="listelement" value="X"/></div> ' +
                '   </div> ' +
                '<input type="hidden" name="listed[]" value="'+isbn+'"></li>');


            $('#addEditOrder').val(''); // resets the field after submitting (i.e. clicking the "Add to List" button)
            $('#quantityEditOrder').val('');
            return false;
        });
        $('#listEditOrder').delegate(".listelement", "click", function() {
            var elemid = $(this).attr('data-id');
            $("#"+elemid).remove();
        });
    });


</script>
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