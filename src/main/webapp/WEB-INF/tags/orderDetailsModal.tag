<!-- Modal -->
<div id="myModalOrder" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <form class="checkout" id="order">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 id="editOrderTitle">Edit Order</h5>
                    <h5 id="addOrderTitle">Add Order</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="md-form mb-5">
                        <input type="text" name="username" id="orangeForm-editOrderCust" class="form-control validate">
                        <label data-error="" data-success="" for="orangeForm-editOrderCust">Customer Username</label>
                    </div>

                    <!-- Editable list of Book ISBN's -->

                    <div class="container">
                        <div class="form-group" >

                            <h5>Enter Books to add to Order:</h5>
                            <br/>
                            <input type="text" name="item" id="isbnOrder" placeholder="Enter ISBN of Book">
                            <input type="text" name="quantity" id="quantityOrder" placeholder="Enter quantity">
                            <br/>
                            <button name="addbtn" class="btnOrder btn btn-primary">Add to List</button>

                        </div>


                        <div class="form-group">


                            <ul id="listOrder" class="cartItems list-group">
                            </ul>
                        </div>

                        <hr>

                        <hr>
                        <h3>Total: $</h3>
                        <hr>

                        <!-- Shipping info -->
                        <div class="shippingInfo">

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
                        </div>
                        <!-- Shipping info -->

                        <div class="d-block my-3">
                            <div class="custom-control custom-radio">
                                <input id="credit" value="CREDIT" name="paymentType" type="radio" class="custom-control-input" checked>
                                <label class="custom-control-label" for="credit">Credit card</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="check" value="CHECK" name="paymentType" type="radio" class="custom-control-input">
                                <label class="custom-control-label" for="check">Check</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="cash" value="CASH" name="paymentType" type="radio" class="custom-control-input">
                                <label class="custom-control-label" for="cash">Cash</label>
                            </div>
                        </div>

                        <div id = "showCreditFields">
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="cc-number">Credit card number</label>
                                    <input name="cardNum" type="text" class="form-control" id="cc-number" placeholder="" required>
                                    <div class="invalid-feedback">
                                        Credit card number is required
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3 mb-3">
                                    <label for="cc-expiration">Expiration</label>
                                    <input name="expDate" type="text" class="form-control" id="cc-expiration" placeholder="" required>
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
                        </div> <!-- id: showCreditFields (for Javascript) -->


                        <div id = "showCheckFields" style="display:none">
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="cc-name">Bank Name</label>
                                    <input name="bank" type="text" class="form-control" id="cc-bankname" placeholder="">
                                    <div class="invalid-feedback">
                                        Bank name is required
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="cc-number">Routing #</label>
                                    <input name="routing" type="text" class="form-control" id="cc-banknumber" placeholder="">
                                    <div class="invalid-feedback">
                                        Routing # is required
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="cc-expiration">Bank Account #</label>
                                    <input name="accountNumber" type="text" class="form-control" id="cc-bankAccountNum" placeholder="">
                                    <div class="invalid-feedback">
                                        Bank Account # is required
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="cc-expiration">Enter 'Checking' or 'Savings'</label>
                                    <input type="text" class="form-control" id="cc-accountType" placeholder="">
                                    <div class="invalid-feedback">
                                        Account type is required
                                    </div>
                                </div>
                            </div>
                        </div> <!-- id: showCheckFields (for Javascript) -->


                        <div id="showCashMsg" style="display:none">
                            <h3>In-store only</h3>
                        </div>
                    </div> <!-- container -->
                </div> <!-- modal body -->

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Submit changes</button>
                </div>
            </div>
        </div>
    </form>
</div>

<style>
    hide {
        display: none;
    }
</style>