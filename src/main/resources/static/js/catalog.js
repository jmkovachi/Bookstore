$(document).ready(function() {
    $(".cart").click(function() {
        const isbn = $(this).data("isbn");
        const username = $(this).data("username");
        console.log(isbn);
        console.log(username);
        $.ajax({
            method: "POST",
            url: "cart/add-item",
            dataType: "json",
            contentType: "application/json",
            data : JSON.stringify({
                "isbn": isbn,
                "cUsername": username,
                "quantity": 1
            }),
            success: function() {
                alert("Successfully updated cart.");
            },
            error: function(xhr, status, message) {
                const res = JSON.parse(xhr.responseText);
                alert(res.message);
            }
        });
    });
});