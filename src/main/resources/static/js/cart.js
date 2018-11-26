$(document).ready(function() {
    $(".increaseQuantity").click(function() {
        const quantity = $(this).data("quantity")+1;
        const data = getData($(this), quantity);
        putAjax("/cart/update-item", data);
    });

    $(".decreaseQuantity").click(function() {
        const quantity = $(this).data("quantity")-1;
        const data = getData($(this), quantity);
        if (quantity == 0 && confirm("Are you sure you want to remove this item from your cart?")) {
            deleteAjax(data.isbn, data.cUsername);
        } else if (quantity > 0) {
            putAjax("/cart/update-item", data);
        }
    });

    $(".delete").click(function() {
        if (confirm("Are you sure you want to remove this item from your cart?")) {
            const isbn = $(this).data("isbn");
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
        error: function(xhr, status, message) {
           const res = JSON.parse(xhr.responseText);
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
        error: function(xhr, status, message) {
           const res = JSON.parse(xhr.responseText);
           alert(res.message);
       }
    });
}

function getData(element, quantity) {
    const username = $("#username").val();
    const isbn = element.data("isbn");
    return {
        "isbn": isbn,
        "quantity": quantity,
        "cUsername": username
    };
}