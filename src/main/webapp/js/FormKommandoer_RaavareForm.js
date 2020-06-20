$(document).ready(function() {
    var $raavarer = $('#raavarer');
    var $raavareId = $('#raavareId');
    var $raavareNavn = $('#raavareNavn');
    var $retRaavareID = $('#retRaavareID');
    var $retRaavareNavn = $('#retRaavareNavn');

    var raavare = {
        raavareId: $raavareId.val(),
        raavareNavn: $raavareNavn.val(),
    };

    $('#vis-Raavare').on('click', function () {
        $('#recepterInfoTable').show();
        $('#receptRaavareInfoTable').hide();
        $('#receptRaavareThead').hide();
        $('#raavarer').html('');

        $.ajax({
            type: 'GET',
            url: 'api/raavare/vis',
            contentType: "application/json; charset=utf-8",
            data: raavare,
            success: function (data) {
                $.each(data, function (i, raavare) {
                    $raavarer.append('<tr><td>' + raavare.raavareID + '</td>' +
                        '<td>' + raavare.raavareNavn + '</td></tr>');
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
            },
            error: function () {
                alert('Fejl ved oprettelse af råvare');
            }
        });
    });

    $('#ret-Raavare').on('click', function () {
        var raavare = {
            raavareId: $retRaavareID.val(),
            raavareNavn: $retRaavareNavn.val(),
        };
        console.log(raavare);
        $.ajax({
            type: 'POST',
            url: 'api/raavare/rediger',
            data: raavare,
            success: function () {
                alert("Råvare ændret")
            },
            error: function () {
                alert('Fejl ved rettelse af råvare');
            }
        });
    });
});