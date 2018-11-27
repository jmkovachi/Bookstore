$(document).ready(function() {
    $("#confirm").click(function() {
        const email = $("#email").val();
        const address = $("#address").val();
        const company = $("#company").val();
        const url = "/vendor/update";

        const data = {
            "email" : email,
            "address" : address,
            "company" : company
        };
        postAjax(url, JSON.stringify(data), "/profile/direct");
    });
});

function postAjax(url, data, redirectUrl) {
    $.ajax({
        type: "POST",
        url : url,
        dataType: "json",
        contentType: "application/json",
        data: data,
        success: function(res){
            alert("profile updated");
            window.location.href = redirectUrl;
        },
        error: function(res){
            const error = JSON.parse(res);
            alert(error.message);
        }
    });


}