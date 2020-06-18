$(document).ready(function() {
    var $recepter = $('#recepter');
    var $receptID = $('#receptID');
    var $receptNavn = $('#receptNavn');

    var recept = {
        receptID: $receptID.val(),
        receptNavn: $receptNavn.val(),
    };
    $('#vis-Alle-Recept').on('click', function () {


        $('#recepter').html('');

        $.ajax({
            type: 'GET',
            url: 'api/recept/vis',
            contentType: "application/json; charset=utf-8",
            data: recept,
            success: function (data) {
                $.each(data, function (i, recept) {
                    $recepter.append('<li class="ListStyle">Recept ID: ' + recept.receptID + ' | | Recept navn: ' + recept.receptNavn + '</li><br><br>');
                });
            },
            error: function () {
                alert('Fejl ved indlæsning af recept');
            }
        });
    });

    $('#opret-Recept').on('click', function () {


        $.ajax({
            type: 'POST',
            url: 'api/recept/opret',
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: recept,
            success: function () {
                alert('Recept oprettet!');
                $recepter.append('<li>Recept navn: ' + recept.receptNavn + '\t Recept ID: ' + recept.receptID + '</li>');
            },
            error: function () {
                alert('Fejl ved oprettelse af recept');
            }
        });
    });
});