$(document).ready(function() {
    var $brugere = $('#brugere');
    var $brugerCpr = $('#brugerCpr');
    var $brugerNavn = $('#brugerNavn');
    var $brugerIni = $('#brugerIni');
    var $brugerRolle = $('#brugerRolle');


    $.ajax({

        type: 'GET',
        url: 'api/bruger/vis',
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            $.each(data, function (i, bruger) {
                $brugere.append('<li>Bruger CPR: ' + bruger.brugerCpr + ', Bruger navn: ' + bruger.brugerNavn + ', Bruger initialer: ' + bruger.brugerIni + ', Bruger rolle: ' + bruger.brugerRolle + ', Bruger status: ' + bruger.brugerStatus + '</li>');


            });
        },
        error: function () {
            alert('Fejl ved indlæsning af brugere');
        },
    });


    $('#opret-Bruger').on('click', function () {

        var bruger = {
            brugerCpr: $brugerCpr.val(),
            brugerNavn: $brugerNavn.val(),
            brugerIni: $brugerIni.val(),
            brugerRolle: $brugerRolle.val(),
            brugerStatus: 'Aktiv',
        };

        if (bruger.brugerCpr.length === 10) {
            $.ajax({
                type: 'POST',
                url: 'api/bruger/opret',
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                data: bruger,
                success: function () {
                    alert('Bruger oprettet!');
                    $brugere.append('<li>Bruger CPR: ' + bruger.brugerCpr + ', Bruger navn: ' + bruger.brugerNavn + ', Bruger initialer: ' + bruger.brugerIni + ', Bruger rolle: ' + bruger.brugerRolle + ', Bruger status: ' + bruger.brugerStatus + '</li>');
                },
                error: function () {
                    alert('Fejl ved oprettelse af bruger');
                }
            });
        }
        else {
            alert('CPR-nummer er for kort')
        }
    });

});
