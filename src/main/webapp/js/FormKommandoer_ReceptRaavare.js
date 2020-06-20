$(document).ready(function() {
    var $receptRaavarer = $('#receptRaavare');
    var $receptRaavareID = $('#receptRaavareID');

    $('#vis-ReceptRaavare').on('click', function () {

        var receptRaavare = {
            nonNetto: '',
            tolerance: '',
            receptID: $receptRaavareID.val(),
            raavareID: '',

        };

        document.getElementById("recepterh2").innerHTML = 'Liste over recept ' + $receptRaavareID.val();

        $('#recepter').html('');
        $('#receptRaavare').html('');
        $.ajax({
            type: 'POST',
            url: 'api/receptRaavare/vis',
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: receptRaavare,
            success: function (data) {
                $('#recepterInfoTable').hide();
                $('#receptRaavareInfoTable').show();
                $.each(data, function (i, receptRaavares) {
                    $receptRaavarer.append('<tr><td>' + receptRaavares.receptID + '</td>' +
                        '<td>' + receptRaavares.raavareID + '</td>' +
                        '<td>' + receptRaavares.nonNetto + '</td>' +
                        '<td>' + receptRaavares.tolerance + '</td></tr>');
                });
            },
            error: function () {
                alert('Fejl ved indlæsning af receptråvarer');
            },
        });
    });
});
