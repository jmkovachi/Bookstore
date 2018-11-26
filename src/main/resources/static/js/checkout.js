$(document).ready(function() {
    $(".checkout").on("submit", function(event) {
        event.preventDefault();
        const data = toJson($(".checkout").serializeArray());
        const order = {
            username: data.username,
            paymentType: data.paymentType
        };
        const paymentInfo = {
            cardNum: data.cardNum,
            expDate: data.expDate,
            securityCode: data.securityCode,
            username: data.username,
        };
        const shippingAddress = {
            address: data.address,
            city: data.city,
            zip: data.zip,
            state: data.state
        };
        const list = [];
        $(".cartItems").each(function(i, elem) {
            const cartItem = $(this).find(".cartData");
            console.log(cartItem);
            list.push({
                isbn: cartItem.data("isbn"),
                finalPrice: cartItem.data("finalprice"),
                quantity: cartItem.data("quantity")
            });
        });
        const postData = {
            order: order,
            shippingAddress: shippingAddress,
            paymentInfo: paymentInfo,
            orderItems: list
        };
        console.log(JSON.stringify(postData));
        postAjax("/order",JSON.stringify(postData));
    });

});

function toJson(formSerializeArr){
 var jsonObj = {};
 jQuery.map( formSerializeArr, function( n, i ) {
     jsonObj[n.name] = n.value;
 });

 return jsonObj;
}

function postAjax(url, data) {
    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",
        contentType: "application/json",
        data: data,
        success: function(res) {
            alert("Successfully ordered.");
            const order = JSON.parse(res);
            window.location.href = "/order/" + order.orderId;
        },
        error: function(res) {
            console.log(res);
            const message = JSON.parse(res);
            alert(message);
        }
    });
}