function get(url, sFunk, eFunk){
    $.ajax({
        type:'GET',
        url:url,
        success: function (data) {
            sFunk(data);
        },
        error: function (data) {
            alert("Forbindelses fejl vedr. url" + url + ";");
        }
    });
}

function post(data,url,sFunk){
    $.ajax({
        type: 'POST',
        url: url,
        contentType: 'application/json',
        data: data,
        success: function (data){
            sFunk(data);
        }
    })

}

// REST Functions
function RaavareForm_REST_opretRaavare(row1,row2){

    var RaavareDTO ={
        raavareID:$(row1).find('.raavareId'.val()),
        raavareNavn:$(row2).find('.raavareNavn'.val())
    };
    alert("raavareId : " + RaavareDTO.raavareID + " , raavareNavn : " + RaavareDTO.raavareNavn);
    post(JSON.stringify(RaavareDTO), "rest/raavare/opret", function(data) {
        alert("oprettet " + RaavareDTO.toString());
    });
}