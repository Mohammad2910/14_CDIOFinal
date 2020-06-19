$(document).ready(function() {
    var $raavareBatchesliste = $('#raavareBatchesliste');
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

    $('#visRaavareBatches').on('click', function () {
        $('#raavareBatchesliste').html('');
        $('#raavarebatchesRaavare').html('');

        $.ajax({
            type: 'POST',
            url: 'api/raavarebatch/vis',
            contentType: "application/json; charset=utf-8",
            data: raavarebatch,
            success: function (data) {
                $.each(data, function (i, raavarebatch) {
                    console.log(raavarebatch);
                    $raavareBatchesliste.append('<li>Råvarebatch ID: ' + raavarebatch.raavareBatchID + '\t Råvare mængde: ' + raavarebatch.raavareMaengde + '\t Leverandør: ' + raavarebatch.leverandoer + '\t Råvare ID: ' + raavarebatch.raavareID + '</li><br>');
                });
            },
            error: function () {
                alert('Fejl ved indlæsning af råvarebatch');
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
            contentType: "application/json; charset=utf-8",
            data: raavarebatch,
            success: function () {
                alert('Råvarebatch oprettet!');
                document.getElementById("raavarebatchNummer").value = '';
                document.getElementById("raavarebatchReceptNummer").value = '';
            },
            error: function () {
                alert('Fejl ved oprettelse af råvarebatch');
            }
        });
    });
});