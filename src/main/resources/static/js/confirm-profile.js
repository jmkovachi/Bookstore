$(document).ready(function() {
    $("#confirm").click(function() {
        const username = $("#username").val();
        const fname = $("#fname").val();
        const lname = $("#lname").val();
        const email = $("#email").val();
        const address = $("#address").val();
        const birthdate = $("#birthdate").val();
        const newsletter = $('input[name="newsletter"]:checked').val();
        console.log(newsletter + "#newsletter");
        const url = "confirm/user"
    })
});