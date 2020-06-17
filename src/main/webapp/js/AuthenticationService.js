$(document).ready(function() {
    var $brugerCpr = $('#cpr');



    $('#submit').on('click', function () {
        var bruger = {
            brugerCpr: $brugerCpr.val(),
            brugerNavn: 'a',
            brugerIni: 'a',
            brugerRolle: 'admin',
            brugerStatus: 'aktiv',
        };
        console.log(bruger);
        $.ajax({
            type: 'GET',
            url: 'api/authentication/login',
            contentType: "application/json; charset=utf-8",
            data: bruger,
            success: function (data) {
                alert(data.brugerRolle);
                console.log(data)
            },
            error: function () {
                alert('Fejl');

            }
        })
    });
});