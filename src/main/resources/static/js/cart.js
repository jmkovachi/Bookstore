$(document).ready(function() {
    $(".increaseQuantity").click(function() {
        const quantity = $(".increaseQuantity").data("quantity")+1;
        const data = getData(".increaseQuantity", quantity);
        putAjax("/cart/update-item", data);
    });

    $(".decreaseQuantity").click(function() {
        const quantity = $(".decreaseQuantity").data("quantity")-1;
        const data = getData(".decreaseQuantity", quantity);
        if (quantity == 0 && confirm("Are you sure you want to remove this item from your cart?")) {
            deleteAjax(data.isbn, data.cUsername);
        } else if (quantity > 0) {
            putAjax("/cart/update-item", data);
        }
    });

    $(".delete").click(function() {
        if (confirm("Are you sure you want to remove this item from your cart?")) {
            const isbn = $(".delete").data("isbn");
            const username = $("#username").val();
            deleteAjax(isbn, username);
        }
    });
});

function putAjax(url, data) {
    $.ajax({
        method: "PUT",
        url: url,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function() {
            location.reload();
        },
        error: function(res) {
            alert(res.message);
        }
    });
}

function deleteAjax(isbn, username) {
    $.ajax({
        method: "DELETE",
        url: "/cart/delete-item/" + username + "/" + isbn,
        contentType: "application/json",
        data: "",
        success: function() {
            location.reload();
        },
        error: function(res) {
            alert(res.message);
        }
    });
}

function getData(className, quantity) {
    const username = $("#username").val();
    const isbn = $(className).data("isbn");
    return {
        "isbn": isbn,
        "quantity": quantity,
        "cUsername": username
    };
}