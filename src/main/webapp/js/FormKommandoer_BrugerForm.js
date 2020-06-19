$(document).ready(function() {
    var $brugere = $('#brugere');
    var $brugerCpr = $('#brugerCpr');
    var $brugerNavn = $('#brugerNavn');
    var $brugerIni = $('#brugerIni');
    var $brugerRolle = $('#brugerRolle');
    var $sletCPR = $('#sletCPRBruger');

    var $redigerCpr = $('#redigerID');
    var $redigerNavn = $('#redigerNavn');
    var $redigerIni = $('#redigerIni');
    var $redigerRolle = $('#redigerRolle');


    $('#vis-Brugere').on('click', function () {
        var bruger = {
            brugerCpr: $brugerCpr.val(),
            brugerNavn: $brugerNavn.val(),
            brugerIni: $brugerIni.val(),
            brugerRolle: $brugerRolle.val(),
            brugerStatus: 'Aktiv',
        };

        $('#brugere').html('');

        $.ajax({
            type: 'GET',
            url: 'api/bruger/vis',
            contentType: "application/json; charset=utf-8",
            data: bruger,
            success: function (data) {
                $.each(data, function (i, bruger) {
                    $brugere.append('<tr><td>' + bruger.cprNr + '</td>' +
                        '<td>' + bruger.brugerNavn + '</td>' +
                        '<td>' + bruger.ini + '</td>' +
                        '<td>' + bruger.rolle + '</td>' +
                        '<td>' + bruger.brugerStatus + '</td></tr>');
                });
            },
            error: function () {
                alert('Fejl ved indlæsning af brugere');
            },
        });
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
                    document.getElementById("brugerCpr").value = '';
                    document.getElementById("brugerNavn").value = '';
                    document.getElementById("brugerIni").value = '';
                    document.getElementById("brugerRolle").value = "admin";
                    $brugere.append('<li>Bruger CPR: ' + bruger.brugerCpr + ', Bruger navn: ' + bruger.brugerNavn + ', Bruger initialer: ' + bruger.brugerIni + ', Bruger rolle: ' + bruger.brugerRolle + ', Bruger status: ' + bruger.brugerStatus + '</li>');
                },
                error: function () {
                    alert('Fejl ved oprettelse af bruger');
                }
            });
        } else {
            alert('CPR-nummer er for kort')
        }
    });

    $('#slet-Brugere').on('click', function () {
        var bruger = {
            brugerCpr: $sletCPR.val(),
            brugerNavn: '',
            brugerIni: '',
            brugerRolle: '',
            brugerStatus: '',
        };

        if (bruger.brugerCpr.length === 10) {
            $.ajax({
                type: 'POST',
                url: 'api/bruger/slet',
                contentType: "application/json; charset=utf-8",
                data: bruger,
                success: function () {
                    alert('Bruger slettet!');
                    document.getElementById("sletCPRBruger").value = '';
                },
                error: function (e) {
                    console.log(e);
                    alert(e);
                }
            });
        } else {
            alert('CPR-nummer er for kort')
        }
    });

    $('#rediger-Bruger').on('click', function () {
        var redigerbruger = {
            brugerCpr: $redigerCpr.val(),
            brugerNavn: $redigerNavn.val(),
            brugerIni: $redigerIni.val(),
            brugerRolle: $redigerRolle.val(),
            brugerStatus: 'Aktiv',
        };

        $.ajax({
            type: 'POST',
            url: 'api/bruger/rediger',
            contentType: "application/json; charset=utf-8",
            data: redigerbruger,
            success: function () {
                alert('Bruger redigeret!');
                document.getElementById("redigerID").value = '';
                document.getElementById("redigerNavn").value = '';
                document.getElementById("redigerIni").value = '';
                document.getElementById("redigerRolle").value = '';
            },
            error: function () {
                alert('Fejl ved redigering af bruger');
            }
        });
    });
});
