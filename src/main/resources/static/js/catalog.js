$(document).ready(function() {
    const searchInput = $("#searchInput");
    const dropdownText = $(".dropdownText");
    $('.dropdown-item').click(function() {
      const text = $(this).text();
      switch (text) {
        case "Author":
            dropdownText.html("Author");
            searchInput.val("author");
            break;
        case "ISBN":
            dropdownText.html("ISBN");
            searchInput.val("isbn");
            break;
        case "Title":
            dropdownText.html("Title");
            searchInput.val("title");
      }
    });

   $( "#search" ).on("submit", function(event) {
            event.preventDefault();  //prevent form from submitting
            const data = $( this ).serializeArray();
            const searchInput = data[0].value;
            const searchText = data[1].value;
            if (searchInput == "") {
                alert("Please select a search option");
            } else if (searchText == "") {
                alert("Please input some search text");
            } else {
                window.location.href = "/catalog?" + searchInput + "=" + searchText;
            }
            //console.log(data); //use the console for debugging, F12 in Chrome, not alerts
    });

    $(".cart").click(function() {
        const isbn = $(this).data("isbn");
        const username = $(this).data("username");
        console.log(username);
        $.ajax({
            method: "POST",
            url: "cart/add-item",
            dataType: "json",
            contentType: "application/json",
            data : JSON.stringify({
                "isbn": isbn,
                "cUsername": username,
                "quantity": 1
            }),
            success: function() {
                alert("Successfully updated cart.");
            },
            error: function(xhr, status, message) {
                const res = JSON.parse(xhr.responseText);
                alert(res.message);
            }
        });
    });
});