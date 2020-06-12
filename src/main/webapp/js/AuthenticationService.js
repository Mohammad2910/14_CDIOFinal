$(document).ready(function() {
    $('#submit').click(function () {
        var cpr = document.getElementById('cpr').value;
        $.ajax({
            url: "localhost:8080/webshop/",
            type: "POST",
            data: {'cpr': cpr},
            success: function (result) {
            }
        })
    });
});