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