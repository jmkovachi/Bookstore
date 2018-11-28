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
            const res = JSON.parse(xhr.responseText);
            alert(res.message);
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