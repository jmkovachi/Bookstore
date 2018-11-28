$(document).ready(function () {
    $("#editBookModalLink").click(function () {
        const isbn = $("#editBookInput").val();
        $.ajax({
            method: "GET",
            url: "/book/metadata/" + isbn,
            dataType: "json",
            contentType: "application/json",
            success: function (res) {
                console.log(res);
                if (res.vUsername !== $(".username").val()) {
                    $("#isbnValue").html("Cannot edit isbn " + res.isbn + " because it does not belong to " + res.vusername);
                } else {
                    $(".author").val(res.author);
                    $(".title").val(res.title);
                    $(".summary").val(res.summary);
                    $(".price").val(Number(res.price).toFixed(2));
                    $("#isbnValue").html("Isbn: " + res.isbn);
                    $("#editIsbn").val(res.isbn);
                    $(".genre").val(res.category);
                    $(".imageUrl").val(res.imageUrl);
                }
            },
            error: function (xhr, status, message) {
                console.log(xhr);
                alert(xhr.responseJSON.message);
            }
        });
    });
});