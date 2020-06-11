
//Funktion til knapper for at vise div content og vise at de er selected
function toggleDivContent(id) {
    $('.form').hide();
    $(document.getElementById(id)).show();
    $('button').on('click', function(){
        $('button').removeClass('selected');
        $(this).addClass('selected');
    });
}