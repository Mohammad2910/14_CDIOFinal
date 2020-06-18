$(document).ready(function() {
    var $receptRaavarer = $('#receptRaavarer')
    var $receptRaavareID = $('#receptRaavareID')

    $('#vis-ReceptRaavare').on('click', function () {

        var receptRaavare = {
            nonNetto: '',
            tolerance: '',
            receptID: $receptRaavareID.val(),
            raavareID: '',

        };

        $('#recepter').html('');
        $('#receptRaavarer').html('');
        $.ajax({
            type: 'POST',
            url: 'api/receptRaavare/vis',
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: receptRaavare,
            success: function (data) {
                $.each(data, function (i, receptRaavares) {
                    $receptRaavarer.append('<li>Recept ID: ' + receptRaavares.receptID + ', Råvare ID: ' + receptRaavares.raavareID +  ', Netto vægt (i kg): ' + receptRaavares.nonNetto + ', Tolerance: ' + receptRaavares.tolerance + '</li><br>');
                });
            },
            error: function () {
                alert('Fejl ved indlæsning af receptråvarer');
            },
        });
    });
});
