$(document).ready(function() {
    var $recepter = $('#recepter');
    var $receptID = $('#receptID');
    var $receptNavn = $('#receptNavn');

    $('#vis-Alle-Recept').on('click', function () {
        var recept = {
            receptID: $receptID.val(),
            receptNavn: $receptNavn.val(),
        };

        $('#recepter').html('');

        $.ajax({
            type: 'GET',
            url: 'api/recept/vis',
            contentType: "application/json; charset=utf-8",
            data: recept,
            success: function (data) {
                $.each(data, function (i, recept) {
                    $recepter.append('<li>Recept navn: ' + recept.receptNavn + ', Recept ID: ' + recept.receptID + '</li><br>');
                });
            },
            error: function () {
                alert('Fejl ved indlæsning af recept');
            }
        });
    });

    $('#opret-Recept').on('click', function () {

        var recept = {
            receptID: $receptID.val(),
            receptNavn: $receptNavn.val(),
        };

        $.ajax({
            type: 'POST',
            url: 'api/recept/opret',
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: recept,
            success: function () {
                alert('Recept oprettet!');
                $recepter.append('<li>Recept navn: ' + recept.receptNavn + ', Recept ID: ' + recept.receptID + '</li>');
            },
            error: function () {
                alert('Fejl ved oprettelse af recept');
            }
        });
    });
});