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