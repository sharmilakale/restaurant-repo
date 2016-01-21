(function(){
    'use strict';
    angular
        .module('restaurant')
        .controller('ReservationListController', ReservationListController);

    ReservationListController.$inject = ['reservationService'];

    function ReservationListController(reservationService){
        var reservationListVm = this;
        reservationListVm.reservationList = [];

        reservationService.getReservationList().then(function(data){
            reservationListVm.reservationList = data;
        },function(error){
            console.log(error);
        });
    }
})();