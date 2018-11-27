$(document).ready(function() {
    $("#confirm").click(function() {
        const fname = $("#fname").val();
        const lname = $("#lname").val();
        const email = $("#email").val();
        const address = $("#address").val();
        const birthdate = $("#birthdate").val();
        const newsletter = $('input[name="newsletter"]:checked').val();\
        console.log(newsletter + "newsletter");
        const url = "/customer/update";
        const data = {
            "firstName" : fname,
            "lastName" : lname,
            "email" : email,
            "address" : address,
            "birthDate" : birthdate,
            "newsletter" : newsletter
        };
        postAjax(url, JSON.stringify(data), "/profile/direct");
    });
});

function postAjax(url, data, redirectUrl){
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
