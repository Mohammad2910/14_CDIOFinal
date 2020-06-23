$(document).ready(function() {
    var $afvejninger = $('#afvejninger');
    var $produktBatchID = $('#afvejningProduktBatchID');
    var antal = 0;

    $('#afvejningmenu').on('click', function () {
        document.getElementById("afvejningh2").innerHTML = 'Angiv produktbatch';
        $('#afvejningProduktBatchID').show();
        $('#visAfvejning').show();
        document.getElementById("afvejninger").innerHTML = "";
        document.getElementById("afvejningProduktBatchID").value = '';
        $('#opret-afvejning').show();
        $('#cprNummer').show();

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
                    } else {
                        var tomBatch = {
                            produktBatchID: $produktBatchID.val(),
                            raavareNavn: '',
                            nonNetto: '',
                            tolerance: ''
                        }

                        antal = 0;

                        $.ajax({
                            type: 'POST',
                            url: 'api/afvejning/vistomme',
                            dataType: "json",
                            contentType: "application/json; charset=utf-8",
                            data: tomBatch,
                            success: function (data2) {
                                $.each(data2, function (i, tombatch) {
                                    $afvejninger.append('<li> ProduktbatchID: ' + tombatch.produktBatchID + '\xa0\xa0\xa0\xa0\xa0\xa0\xa0 Råvarenavn: ' + tombatch.raavareNavn + '\xa0\xa0\xa0\xa0\xa0\xa0\xa0 Netto: ' + tombatch.nonNetto + 'kg\xa0\xa0\xa0\xa0\xa0\xa0\xa0 Tolerance: ' + tombatch.tolerance + '\%');
                                    $afvejninger.append('<li> <input id="tara" type="number" step="0.001" placeholder="Indtast tara vægten">' +
                                        '        <input id="batchNummer" type="number" placeholder="Raavarebatch nummer">' +
                                        '        <input id="netto" type="number" placeholder="Raavare vægt (Netto)"><br><br><br>');
                                    antal++;
                                });
                                if (antal !== 0) {
                                    $('#opretAfvejning').show();
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


    $('#opret-afvejning').on('click', function () {
        var $brugerCpr = $('#cprNummer');

        if ($brugerCpr.val().length === 10) {
            for (let i = 0; i < antal; i++) {
                var $netto = $('#netto');
                var $batchnummer = $('#batchNummer');
                var $tara = $('#tara');
                var $brugerCpr = $('#cprNummer');

                var afvejning = {
                    produktBatchID: $produktBatchID.val(),
                    tara: $tara.val(),
                    raavaereBatchNummer: $batchnummer.val(),
                    netto: $netto.val(),
                    cpr: $brugerCpr.val(),
                };

                console.log(afvejning)

                $.ajax({
                    type: 'POST',
                    url: 'api/afvejning/opret',
                    contentType: "application/json; charset=utf-8",
                    data: afvejning,
                    success: function () {
                        if (i === antal - 1) {
                            alert("Afvejning gemt")
                            window.location = 'LaborantAfvejning.html'
                        }
                    },
                    error: function () {
                        alert('Fejl ved at gemme afvejning' + '\nIndtast venligst alle oplysninger i felterne');
                    }
                });
                document.getElementById('afvejninger').removeChild(document.getElementById('afvejninger').childNodes[(0)])
                document.getElementById('afvejninger').removeChild(document.getElementById('afvejninger').childNodes[(0)])
            }
            $('#opret-afvejning').hide();
            $('#cprNummer').hide();
        } else {
            alert("CPR for kort")
        }
    });
});