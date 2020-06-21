$(document).ready(function() {
    var $produktBatchesliste = $('#produktBatchesliste');
    var $produktbatchNummer = $('#produktbatchNummer');
    var $produktbatchReceptNummer = $('#produktbatchReceptNummer');
    var $produktbatchIDRaavare = $('#produktbatchIDRaavare');
    var $produktbatchesRaavare = $('#produktbatchesRaavare');

    var produktbatch = {
        produktbatchID: $produktbatchNummer.val(),
        produktbatchReceptNummer: $produktbatchReceptNummer.val(),
        status:'',
        cpr:'',
        raavareBatchID:'',
        tara:'',
        netto:''
    };


    $('#visProduktBatches').on('click', function () {
        $('#produktBatchInfoTable').show();
        $('#produktBatchRaavareInfoTable').hide();
        $('#produktBatchesliste').html('');
        $('#produktbatchesRaavare').html('');
        document.getElementById("produktbatchIDRaavare").value = '';

        $.ajax({
            type: 'POST',
            url: 'api/produktbatch/vis',
            contentType: "application/json; charset=utf-8",
            data: produktbatch,
            success: function (data) {
                $.each(data, function (i, produktbatch) {
                    $produktBatchesliste.append('<tr><td>' + produktbatch.produktBatchID + '</td>' +
                        '<td>' + produktbatch.receptID + '</td>' +
                        '<td>' + produktbatch.status + '</td></tr>');
                });
            },
            error: function () {
                alert('Fejl ved indlæsning af produktbatch');
            }
        });
    });



    $('#opret-produktbatch').on('click', function () {
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

    $('#vis-produktbatchRaavare').on('click', function () {

        var produktbatch = {
            produktbatchID: $produktbatchIDRaavare.val(),
            produktbatchReceptNummer: '',
            status:'',
            cpr:'',
            raavareBatchID:'',
            tara:'',
            netto:''
        };

        document.getElementById("produktbatchh2").innerHTML = 'Liste over produktbatch ' + $produktbatchIDRaavare.val();

        $('#produktBatchesliste').html('');
        $('#produktbatchesRaavare').html('');
        $.ajax({
            type: 'POST',
            url: 'api/produktbatch/visEnkelt',
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: produktbatch,
            success: function (data) {
                $('#produktBatchInfoTable').hide();
                $('#produktBatchRaavareInfoTable').show();
                $.each(data, function (i, produktbatch) {
                    console.log(produktbatch);
                    document.getElementById("produktbatchIDRaavare").value = '';
                    if (!(produktbatch.raavareBatchID === 0)) {
                        $produktbatchesRaavare.append('<tr><td>' + produktbatch.produktBatchID + '</td>' +
                            '<td>' + produktbatch.receptID + '</td>' +
                            '<td>' + produktbatch.status + '</td>' +
                            '<td>' + produktbatch.cpr + '</td>' +
                            '<td>' + produktbatch.raavareBatchID + '</td>' +
                            '<td>' + produktbatch.tara + '</td>' +
                            '<td>' + produktbatch.netto + '</td></tr>');
                    }
                    else{
                        $produktbatchesRaavare.append('<tr><td>' + produktbatch.produktBatchID + '</td>' +
                            '<td>' + produktbatch.receptID + '</td>' +
                            '<td>' + produktbatch.status + '</td>' +
                            '<td>' + produktbatch.cpr + '</td>' +
                            '<td>' + "Ikke påbegyndt" + '</td>' +
                            '<td>' + "Ikke påbegyndt" + '</td>' +
                            '<td>' + "Ikke påbegyndt" + '</td></tr>');
                    }
                });
            },
            error: function () {
                alert('Fejl ved indlæsning af produktbatch');
            }
        });
    });
});