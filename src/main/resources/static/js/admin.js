$(document).ready(function () {
    $("#addPromotion").on("submit", function (event) {
        event.preventDefault();
        const data = toJson($(this).serializeArray());
        console.log(data);
        postAjax("/promotion/add", data);
    });

    $("#editPromotion").on("submit", function (event) {
        event.preventDefault();
        const data = toJson($(this).serializeArray());
        console.log(data);
        postAjax("/promotion/edit", data);
    });

    $("#deletePromotion").on("submit", function (event) {
        event.preventDefault();
        const data = toJson($(this).serializeArray());
        console.log(data);
        deleteAjax("/promotion/delete", data.promoId);
    });

    $('.btnOrder').click(function() {
        var isbn = $('#isbnOrder').val();
        var quantity = $('#quantityOrder').val();
        var uniqid = Math.round(new Date().getTime() + (Math.random() * 100));
        $('#listOrder').append('<li id="'+uniqid+'" class="list-group-item">' +
            '   <div class="cartItem row"> ' +
            '       <div class="col-4"> ISBN: '+isbn+' </div> ' +
            '       <div class="col-4"> Quantity: '+quantity+' </div> ' +
            '       <div class="col-4"> <input type="button" data-isbn="'+isbn+'" data-quantity="'+quantity+'" + ' +
            '          data-id="'+uniqid+'" class="cartData listelement" value="X"/></div> ' +
            '   </div> ' +
            '<input type="hidden" name="listed[]" value="'+isbn+'"></li>');


        $('.addOrder').val(''); // resets the field after submitting (i.e. clicking the "Add to List" button)
        $('.quantityOrder').val('');
        return false;
    });
    $('#listOrder').delegate(".listelement", "click", function() {
        var elemid = $(this).attr('data-id');
        $("#"+elemid).remove();
    });

    $("#addOrder").click(function () {
        console.log("hi");
        $("#editOrderTitle").addClass("hide");
        $("#addOrderTitle").removeClass("hide");
    });

    $("#editOrder").click(function () {
        $("#editOrderTitle").removeClass("hide");
        $("#addOrderTitle").addClass("hide");
    });

    $("#addBook").on("submit", function (event) {
        event.preventDefault();
        const data = toJson($(this).serializeArray());
        console.log(data);
        postAjax("/book/insert", data);
    })

    $("#editBookModalLink").click(function () {
        const isbn = $("#editBookInput").val();
        $.ajax({
            method: "GET",
            url: "/book/metadata/" + isbn,
            dataType: "json",
            contentType: "application/json",
            success: function (res) {
                console.log(res);
                $(".author").val(res.author);
                $(".title").val(res.title);
                $(".summary").val(res.summary);
                $(".price").val(Number(res.price).toFixed(2));
                $("#isbnValue").html("Isbn: " + res.isbn);
                $("#editIsbn").val(res.isbn);
                $(".genre").val(res.category);
                $(".imageUrl").val(res.imageUrl);
            },
            error: function (xhr, status, message) {
                console.log(xhr);
                alert(xhr.responseJSON.message);
            }
        });
    });
});

function postAjax(url, data) {
    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function(res) {
            alert("Successfully updated.");
        },
        error: function(res) {
            console.log(res);
            alert(JSON.parse(res).message);
        }
    });
}

function deleteAjax(url, data) {
    $.ajax({
        type: "DELETE",
        url: url,
        contentType: "application/json",
        data: "",
        success: function(res) {
            alert("Successfully deleted.");
        },
        error: function(res) {
            console.log(res);
            alert(JSON.parse(res).message);
        }
    })
}