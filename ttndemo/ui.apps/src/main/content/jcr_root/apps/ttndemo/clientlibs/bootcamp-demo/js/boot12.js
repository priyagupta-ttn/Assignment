console.log("we are in clientlib");

var onSubmit = function() {
    var fname = $('#fname').val();
    var lname = $('#lname').val();
    var email = $('#email').val();

    var url = "/bin/contactformsubmit";

    $.ajax({
        url: url,
        data: JSON.stringify({
            "fname": fname,
            "lname": lname,
            "email": email
        }),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        crossDomain: true,
        type: 'POST',
        success: function(result) {
            console.log(result); // result is an object which is created from the returned JSON
        },
        error: function(xhr, status, error) {
            console.error("An error occurred:", status, error);
            try {
                console.error("Response text:", xhr.responseText);
            } catch (e) {
                console.error("Unable to parse response text");
            }
        }
    });
};



