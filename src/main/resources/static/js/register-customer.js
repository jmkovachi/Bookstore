$(document).ready(function() {
    $("#register").click(function() {
        const username = $("#username").val();
        const password = $("#password").val();
        const repassword = $("#repassword").val();
        const date = $("#birthday").val();
        const first = $("#first").val();
        const minit = $("#minit").val();
        const last = $("#last").val();
        const address = $("#address").val();
        const email = $("#email").val();
        const newsletter = $('input[name="newsletter"]:checked').val();
        const imageUrl = "";
        console.log(newsletter + "newsletter");
        if (password !== repassword) {
            alert("Passwords do not match. Try again.");
            return;
        }
        if (username.length == 0 || password.length == 0 || date == null || first.length == 0
            || first.length == 0 || minit.length == 0 || last.length == 0 || email.length == 0) {
            alert("Please fill out all fields.");
        } else {
            const url = "/register/customer";
            const data = {
                "firstName" : first,
                "minit" : minit,
                "lastName" : last,
                "address" : address,
                "birthDate" : date,
                "verified" : "false",
                "newsletter" : newsletter,
                "username" : username,
                "password" : password,
                "email" : email,
                "role" : "ROLE_CUSTOMER",
                "imageUrl" : imageUrl
             };
            postAjax(url, JSON.stringify(data), "/verify/" + username);
        }
    });
});


function postAjax(url, data, redirectUrl) {
    $.ajax({
        type: "POST",
        url: url,
        dataType: "json",
        contentType: "application/json",
        data: data,
        success: function(res) {
            alert("Successfully registered.");
            window.location.href = redirectUrl;
        },
        error: function(res) {
            alert("Could not register user at this time. Please try again later.");
        }
    });
}