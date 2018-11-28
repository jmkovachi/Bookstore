$(document).ready(function () {
   $("#bookSales").on("submit", function (event) {
       event.preventDefault();
       const data = toJson($(this).serializeArray());
       console.log(data);
       $.ajax({
            method: "GET",
            url: "/book-sales/" + data.isbn,
            dataType: "json",
            contentType: "application/json",
            data: "",
            success: function (res) {
                console.log(res);
                $("#bookContent").removeClass("hide");
                $("#bookYearTotal").html(Number(res.totalYearAmount).toFixed(2));
                $("#bookYearSales").html(res.totalYearSales);
                $("#bookMonthTotal").html(Number(res.totalMonthAmount).toFixed(2));
                $("#bookMonthSales").html(res.totalMonthSales);
            },
            error: function (xhr, status, response) {
                console.log(xhr);
                $("#bookContent").addClass("hide");
                $("#bookYearSales").html();
                $("#bookMonthSales").html();
                $("#bookYearTotal").html();
                $("#bookMonthTotal").html();
                alert(xhr.responseJSON.message);
            }
       });
   });
});