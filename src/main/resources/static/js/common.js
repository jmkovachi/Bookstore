$(document).ready(() => {
    $("#addBook").on("submit", function (event) {
        event.preventDefault();
        const data = toJson($(this).serializeArray());
        console.log(data);
        postAjax("/book/insert", data);
    });

    $("#deleteBook").on("submit", function (event) {
        event.preventDefault();
        const data = toJson($(this).serializeArray());
        console.log(data);
        deleteAjax("/book/delete/" + data.isbn + "?vendor=" + data.username, "");
    });

    $("#editBook").on("submit", function (event) {
        event.preventDefault();
        const data = toJson($(this).serializeArray());
        postAjax("/book/update", data);
    });

    $("#deleteCustomer").on("submit", function (event) {
        event.preventDefault();
        const data = toJson($(this).serializeArray());
        deleteAjaxRedirect("/customer/delete/" + data.username, "", "/logout");
    });

    $("#deleteClient").on("submit", function (event) {
        event.preventDefault();
        const data = toJson($(this).serializeArray());
        deleteAjaxRedirect("/client/delete/" + data.username, "", "/logout");
    });

    $("#deleteVendor").on("submit", function (event) {
        event.preventDefault();
        const data = toJson($(this).serializeArray());
        deleteAjaxRedirect("/vendor/delete/" + data.username, "", "/logout");
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
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function(res) {
            alert("Successfully updated.");
        },
        error: function(xhr, status, message) {
            console.log(xhr);
            alert(xhr.responseJSON.message);
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
        error: function(xhr) {
            console.log(xhr);
            alert(xhr.responseJSON.message);
        }
    })
}

function deleteAjaxRedirect(url, data, redirecturl) {
    $.ajax({
        type: "DELETE",
        url: url,
        contentType: "application/json",
        data: data,
        success: function(res) {
            alert("Successfully deleted.");
            if (redirecturl !== "") {
                window.location.href = redirecturl;
            }
        },
        error: function(xhr) {
            console.log(xhr);
            alert(xhr.responseJSON.message);
        }
    })
}