$(document).ready(function() {
    var $produktbatches = $('#produktBatches');
    var $produktbatchNummer = $('#produktbatchNummer');
    var $produktbatchReceptNummer = $('#produktbatchReceptNummer');

    var produktbatch = {
        produktbatchID: $produktbatchNummer.val(),
        produktbatchReceptNummer: $produktbatchReceptNummer.val(),
        status:'',
        cpr:'',
        raavareBatchID:'',
        tara:'',
        netto:''
    };

    $('#visProduktBatch').on('click', function () {
        $('#produktbatches').html('');

        $.ajax({
            type: 'GET',
            url: 'api/produktbatch/vis',
            contentType: "application/json; charset=utf-8",
            data: produktbatch,
            success: function (data) {
                $.each(data, function (i, produktbatch) {
                    $produktbatches.append('<li>Produktbatch ID: ' + produktbatch.produktBatchID + '\t Recept ID: ' + produktbatch.receptID + '</li><br>');
                });
            },
            error: function () {
                alert('Fejl ved indlæsning af produktbatch');
            }
        });
    });



    $('#opret-produktBatches').on('click', function () {
        var produktbatch = {
            produktbatchID: $produktbatchNummer.val(),
            produktbatchReceptNummer: $produktbatchReceptNummer.val(),
            status:'',
            cpr:'',
            raavareBatchID:'',
            tara:'',
            netto:''
        };

        $.ajax({
            type: 'POST',
            url: 'api/produktbatch/opret',
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: produktbatch,
            success: function () {
                alert('Produktbatch oprettet!');
                document.getElementById("produktbatchNummer").value = '';
                document.getElementById("produktbatchReceptNummer").value = '';
            },
            error: function () {
                alert('Fejl ved oprettelse af produktbatch');
            }
        });
    });
});