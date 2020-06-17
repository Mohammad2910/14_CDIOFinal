$(document).ready(function() {
    var $brugerCpr = $('#cpr');



    $('#submit').on('click', function () {
        var bruger = {
            brugerCpr: $brugerCpr.val(),
            brugerNavn: 'a',
            brugerIni: 'a',
            brugerRolle: 'admin',     // samme navn som i brugerDTO
            brugerStatus: 'aktiv',
        };
        console.log(bruger);
        $.ajax({
            type: 'POST',
            url: 'api/authentication/login/' + $brugerCpr.val(),
            contentType: "application/json; charset=utf-8",
            //data: bruger,
            success: function (data) {
                alert(bruger.brugerRolle);
                console.log(data)
            },
            error: function () {
                alert('Fejl');

            }
        })
    });
});