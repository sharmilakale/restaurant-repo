/**
 * Created by skale on 12/27/15.
 */


$(document).ready(function () {
    $("#btnFindReservation").click(function(){
        window.location.href="reservationDetails.html";
    });

    $('.editBtn').click(function () {
        //Enable disable code goes here

        $(this).html($(this).html() == 'Edit' ? 'Save' : 'Edit');
    });

});