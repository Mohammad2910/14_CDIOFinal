$(document).ready(function() {
    var $raavarer = $('#raavarer');
    var $raavareId = $('#raavareId');
    var $raavareNavn = $('#raavareNavn');

    var raavare = {
        raavareId: $raavareId.val(),
        raavareNavn: $raavareNavn.val(),
    };

    $('#vis-Raavare').on('click', function () {


        $('#raavarer').html('');

        $.ajax({
            type: 'GET',
            url: 'api/raavare/vis',
            contentType: "application/json; charset=utf-8",
            data: raavare,
            success: function (data) {
                $.each(data, function (i, raavare) {
                    $raavarer.append('<li class="ListStyle"> Råvare ID: ' + raavare.raavareID + ' | | Råvare navn: ' + raavare.raavareNavn + '</li><br><br>');
                });
            },
            error: function () {
                alert('Fejl ved indlæsning af råvarer');
            }
        });
    });

    $('#opret-Raavare').on('click', function () {

        var raavare = {
            raavareId: $raavareId.val(),
            raavareNavn: $raavareNavn.val(),
        };
        console.log(JSON.stringify(raavare));
        $.ajax({
            type: 'POST',
            url: 'api/raavare/opret',
            data: raavare,
            success: function () {
                alert('Råvare oprettet!');
                $raavarer.append('<li>Råvare navn: ' + raavare.raavareNavn + '\t Råvare ID: ' + raavare.raavareId + '</li>');
            },
            error: function () {
                alert('Fejl ved oprettelse af råvare');
            }
        });
    });

    $('#rediger-Raavare').on('click', function () {


        $.ajax({
            type: 'POST',
            url: 'api/raavare/rediger',
            contentType: "application/json; charset=utf-8",
            success: function (raavarer) {
                $.each(raavarer, function (i, raavares) {
                    if (raavares.raavareId == raavare.raavareId) {
                        raavares.raavareNavn = raavare.raavareId;

                    }
                });
            },
            error: function (data) {
                alert('Fejl ved indlæsning af råvarer');
            }
        });
    });
});
