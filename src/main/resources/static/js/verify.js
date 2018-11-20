$(document).ready(function() {
    const username = $("#username").val();
    $("#resend").click(function() {
        $.ajax({
            type: "GET",
            url: "/verify/" + username,
            data: "",
            dataType: "text",
            success: function() {
                console.log("success!");
            }
        });
    });

    $("#confirm").click(function() {
        const code = $("#pin").val();
        $.ajax({
            type: "POST",
            url: "/verify/" + username + "/" + code,
            contentType: "application/json",
            data: "",
            success: function() {
                window.location.href = "/home";
            },
            error: function(res) {
                alert("The code that was entered failed. Please try a different code.");
            }
        })
    })
});