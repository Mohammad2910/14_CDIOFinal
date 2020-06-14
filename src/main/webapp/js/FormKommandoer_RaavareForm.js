$(function(){
    var $raavarer = $('#raavarer');
    var $raavareId = $('#raavareId');
    var $raavareNavn = $('#raavareNavn');


    $.ajax({
        type:'GET',
        url:'/api/raavare',
        success: function (raavarer) {
            $.each(raavarer, function(i, raavare){
                $raavarer.append('<li>Råvare navn: ' + raavare.raaavareNavn +', Råvare ID: '+ raavare.raavareId + '</li>');
            });
        },
        error: function (data) {
            alert('Fejl ved indlæsning af råvarer');
        }
    });
    $('#opret-Raavare').on('click',function () {

        var raavare = {
            raavareId: $raavareId.val(),
            raavareNavn: $raavareNavn.val(),
        };

        $.ajax({
            type: 'POST',
            url: '/api/raavare/opret',
            dataType: "json",
            data: raavare,
            success: function(nyRaavare){
                $raavarer.append('<li>Råvare navn: ' + nyRaavare.raavareNavn + ', Råvare ID: ' + nyRaavare.raavareId + '</li>');
            },
            error: function() {
                alert('Fejl ved oprettelse af råvare');
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