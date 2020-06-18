$(document).ready(function() {
    var $brugerCpr = $('#cpr');



    $('#submit').on('click', function () {
        var bruger = {
            cprNr: $brugerCpr.val(),
            brugerNavn: 'a',
            ini: 'a',
            roller: 'admin',     // samme navn som i brugerDTO
            brugerStatus: 'aktiv',
        };
        console.log(bruger);
        $.ajax({
            type: 'POST',
            url: 'api/authentication/login/' + $brugerCpr.val(),
            contentType: "application/json; charset=utf-8",
            data: bruger,
            success: function (data) {
                if(data.roller === 'Admin') {
                    window.location = "/UserAdminPage.html";
                } else if (data.roller === 'Laborant') {
                    window.location = "/LaborantAfvejning.html";
                }
                console.log(data)
            },
            error: function () {
                alert('Ugyldigt cpr');

            }
        })
    });
});