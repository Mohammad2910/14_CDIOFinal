$(document).ready(function() {
    var $recepter;
    var $receptID = $('#receptID');
    var $receptNavn = $('#receptNavn');
    var $raavareMaengde = $('#raavareMaengde');
    var $tolerance = $('#tolerance');

    $.ajax({
        type: 'GET',
        url: 'api/recept/vis',
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            $.each(data, function (i, recept) {
                $recepter.append('<li>Recept ID: ' + recept.receptID + ', Recept navn: ' + recept.receptNavn +  '</li>');
            });
        },
        error: function () {
            alert('Fejl ved indlæsning af recepten');
        }
    });

    $('#opret-Recept').on('click', function () {
        var recept = {
            receptID: $receptID.val(),
            receptNavn: $receptNavn.val(),
            raavareId: $raavareId.val(),
            raavareMaengde: $raavareMaengde.val(),
            tolerance: $tolerance.val(),
        };
        $.ajax({
            type: 'POST',
            url: 'api/recept/opret',
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: recept,
            success: function () {
                $recepter.append('<li>Recept ID: ' + recept.receptID + ', Recept navn: ' + recept.receptNavn + ', Råvare ID: ' + recept.raavareId + ', Råvare mængde: ' + recept.raavareMaengde + ', Tolerance: ' + recept.tolerance +'</li>');
            },
            error: function () {
                alert('Fejl ved oprettelse af recepten');
            }
        });
    });

    $('#vis-Alle-Recept').on('click', function () {
        var recept = {
            receptID: $receptID.val(),
            receptNavn: $receptNavn.val(),
            raavareId: $raavareId.val(),
            raavareMaengde: $raavareMaengde.val(),
            tolerance: $tolerance.val(),
        };
        $.ajax({
            type: 'POST',
            url: 'api/recept/opret',
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: recept,
            success: function () {
                $recepter.append('<li>Recept ID: ' + recept.receptID + ', Recept navn: ' + recept.receptNavn + ', Råvare ID: ' + recept.raavareId + ', Råvare mængde: ' + recept.raavareMaengde + ', Tolerance: ' + recept.tolerance +'</li>');
            },
            error: function () {
                alert('Fejl ved oprettelse af recepten');
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