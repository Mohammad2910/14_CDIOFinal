$(document).ready(function() {
    var $raavareBatches = $('#raavareBatches');
    var $raavarebatchNummer = $('#raavarebatchNummer');
    var $raavarebatchMaengde = $('#raavarebatchMaengde');
    var $raavarebatchLeverandoer = $('#raavarebatchLeverandoer');
    var $raavarebatchRaavareID = $('#raavarebatchRaavareID');

    var raavarebatch = {
        raavarebatchNummer: $raavarebatchNummer.val(),
        raavarebatchMaengde: $raavarebatchMaengde.val(),
        raavarebatchLeverandoer:$raavarebatchLeverandoer.val(),
        raavarebatchRaavareID:$raavarebatchRaavareID.val()
    };

    $('#visRaavareBatch').on('click', function () {
        $('#raavareBatches').html('');

        $.ajax({
            type: 'GET',
            url: 'api/raavarebatch/vis',
            contentType: "application/json; charset=utf-8",
            data: raavarebatch,
            success: function (data) {
                $.each(data, function (i, raavarebatch) {
                    $raavareBatches.append('<li>Råvarebatch ID: ' + raavarebatch.raavareBatchID + '\t Mængde: ' + raavarebatch.raavareMaengde + '</li><br>');
                });
            },
            error: function () {
                alert('Fejl ved indlæsning af Råvarebatch');
            }
        });
    });



    $('#opret-raavarebatch').on('click', function () {
        var raavarebatch = {
            raavarebatchNummer: $raavarebatchNummer.val(),
            raavarebatchMaengde: $raavarebatchMaengde.val(),
            raavarebatchLeverandoer:$raavarebatchLeverandoer.val(),
            raavarebatchRaavareID:$raavarebatchRaavareID.val()
        };

        $.ajax({
            type: 'POST',
            url: 'api/raavarebatch/opret',
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: raavarebatch,
            success: function () {
                alert('Råvarebatch oprettet!');
                document.getElementById("raavarebatchNummer").value = '';
                document.getElementById("raavarebatchMaengde").value = '';
                document.getElementById("raavarebatchLeverandoer").value = '';
                document.getElementById("raavarebatchRaavareID").value = '';
            },
            error: function () {
                alert('Fejl ved oprettelse af Råvarebatch');
            }
        });
    });
});