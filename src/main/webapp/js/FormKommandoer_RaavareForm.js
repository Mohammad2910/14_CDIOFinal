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
                    $raavarer.append('<tr><td>' + raavare.raavareNavn + '</td>' +
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
                $raavarer.append('<li class="raavarer">Råvare navn: ' + raavare.raavareNavn + '&nbsp; Råvare ID: ' + raavare.raavareId + '</li>');
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








// function post(data,url,sFunk){
//     $.ajax({
//         type: 'POST',
//         url: url,
//         contentType: 'application/json',
//         data: data,
//         success: function (data){
//             sFunk(data);
//         }
//     })
//
// }

// REST Functions
// function RaavareForm_REST_opretRaavare(row1,row2){
//
//     var RaavareDTO ={
//         raavareID:$(row1).find('.raavareId'.val()),
//         raavareNavn:$(row2).find('.raavareNavn'.val())
//     };
//     alert("raavareId : " + RaavareDTO.raavareID + " , raavareNavn : " + RaavareDTO.raavareNavn);
//     post(JSON.stringify(RaavareDTO), "rest/raavare/opret", function(data) {
//         alert("oprettet " + RaavareDTO.toString());
//     });
// }