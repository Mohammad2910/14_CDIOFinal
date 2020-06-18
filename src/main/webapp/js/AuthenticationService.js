$(document).ready(function() {
    var $brugerCpr = $('#cpr');



    $('#submit').on('click', function () {
        var bruger = {
            cprNr: $brugerCpr.val(),
            brugerNavn: 'a',
            ini: 'a',
            rolle: 'admin',
            brugerStatus: 'aktiv',
        };
        $.ajax({
            type: 'POST',
            url: 'api/authentication/login/' + $brugerCpr.val(),
            contentType: "application/json; charset=utf-8",
            data: bruger,
            success: function (data) {
                if(data.rolle === 'Admin') {
                    window.location = 'UserAdminPage.html';
                } else if (data.rolle === 'Laborant') {
                    window.location = 'LaborantAfvejning.html';
                } else if (data.rolle === 'Produktionsleder') {
                    window.location = 'ProduktionslederLogin.html';
                } else if (data.rolle === 'Farmaceut') {
                    window.location = 'FarmaceutLogin.html';
                }
                console.log(data)
            },
            error: function () {
                alert('Ugyldigt cpr');

            }
        })
    });
});