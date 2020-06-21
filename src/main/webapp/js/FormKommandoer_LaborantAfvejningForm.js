$(document).ready(function() {
    var $afvejninger = $('#afvejninger');
    var $produktBatchID = $('#afvejningProduktBatchID');

    $('#afvejningmenu').on('click',function() {
        document.getElementById("afvejningh2").innerHTML = 'Angiv produktbatch';
        $('#afvejningProduktBatchID').show();
        $('#visAfvejning').show();
        document.getElementById("afvejninger").innerHTML = "";
        document.getElementById("afvejningProduktBatchID").value = '';

    });


    $('#visAfvejning').on('click', function () {
        var produktBatch = {
            tara: '',
            netto: '',
            raavareBatchID: '',
            cpr: '',
            produktBatchID: $produktBatchID.val(),
            timestamp: ''
        }

        $.ajax({
            type: 'POST',
            url: 'api/afvejning/vis',
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: produktBatch,
            success: function (data) {
                $('#afvejningProduktBatchID').hide();
                $('#visAfvejning').hide();
                document.getElementById("afvejningh2").innerHTML = 'Afvejning for produktbatch ' + $produktBatchID.val();
                $.each(data, function (i, produktbatch) {
                    if (produktbatch.tara !== 0) {
                        $afvejninger.append('<li> Tara: ' + produktbatch.tara + ' Netto: ' + produktbatch.netto + ' Råvarebatch ID: ' + produktbatch.raavareBatchID + 'CPR: ' + produktbatch.cpr + ' Produktbatch ID: ' + produktbatch.produktBatchID + ' Tidspunkt: ' + produktbatch.timestamp + '')
                    }
                    else{
                        var tomBatch = {
                            produktBatchID: $produktBatchID.val(),
                            raavareNavn: '',
                            nonNetto: '',
                            tolerance: ''
                        }

                        var antal = 0;

                        $.ajax({
                            type: 'POST',
                            url: 'api/afvejning/vistomme',
                            dataType: "json",
                            contentType: "application/json; charset=utf-8",
                            data: tomBatch,
                            success: function (data2) {
                                $.each(data2, function (i, tombatch) {
                                    console.log(tombatch)
                                    $afvejninger.append('<li> ProduktbatchID: ' + tombatch.produktBatchID + '\xa0\xa0\xa0\xa0\xa0\xa0\xa0 Råvarenavn: ' + tombatch.raavareNavn + '\xa0\xa0\xa0\xa0\xa0\xa0\xa0 Netto: ' + tombatch.nonNetto + 'kg\xa0\xa0\xa0\xa0\xa0\xa0\xa0 Tolerance: ' + tombatch.tolerance + '\%');
                                    $afvejninger.append('<li> <input id="tara + i" type="number" step="0.001" placeholder="Indtast tara vægten">' +
                                        '        <input id="batchNummer + i" type="number" placeholder="Raavarebatch nummer">' +
                                        '        <input id="netto + i" type="number" placeholder="Raavare vægt (Netto)"><br><br><br>');
                                    antal++;
                                });
                                if (antal !== 0) {
                                    $afvejninger.append('<button id="opret-afvejning" type="button" class="right"> Gem </button> ')
                                }
                            },
                            error: function () {
                                alert('Produktbatch findes ikke');
                            },
                        });
                    }
                });
            },
            error: function () {
                alert('Produktbatch findes ikke');
            },
        });
    });
});
