(function() {
    'use strict';

    angular
        .module('restaurant')
        .controller('ReservationDetailController', ReservationDetailController);

    ReservationDetailController.$inject = ['reservationService', '$routeParams'];

    function ReservationDetailController(reservationService, $routeParams) {
        var reservationDetailVm = this;

        reservationDetailVm.reservationDetails = null;
        reservationDetailVm.infoMsg = "";
        reservationDetailVm.successFlag = "";
        reservationService
            .getReservationById($routeParams.id)
            .then(function(data){
                reservationDetailVm.reservationDetails = data;
                reservationDetailVm.reservationDetails.reserveDate = new Date(reservationDetailVm.reservationDetails.reserveDate);
            }, function (error){
                console.log(error);
            });

        reservationDetailVm.saveReservationDetails = function(details) {
            reservationService
                .saveReservationDetails(details)
                .then(function (data) {
                    reservationDetailVm.reservationDetails = data;
                    reservationDetailVm.successFlag = "true";
                    reservationDetailVm.infoMsg = "Successfully saved reservation details!";
                }, function (error) {
                    console.log(error);
                    reservationDetailVm.successFlag = "false";
                    reservationDetailVm.infoMsg = "Error saving reservation details!";
                });
        }//end of reservationDetailVm.saveReservationDetails


        reservationDetailVm.deleteReservationDetails = function(reserveId) {
            reservationService
                .deleteReservationDetails(reserveId)
                .then(function (data) {
                    reservationDetailVm.reservationDetails = data;
                    reservationDetailVm.successFlag = "true";
                    reservationDetailVm.infoMsg = "Successfully deleted reservation details!";
                }, function (error) {
                    console.log(error);
                    reservationDetailVm.successFlag = "false";
                    reservationDetailVm.infoMsg = "Error deleting reservation details!";
                });
        }//end of reservationDetailVm.deleteReservationDetails


        reservationDetailVm.findReservationDetails = function(reserveId) {
            reservationService
                .getReservationById(reserveId)
                .then(function(data){
                    reservationDetailVm.reservationDetails = data;
                    reservationDetailVm.reservationDetails.reserveDate = new Date(reservationDetailVm.reservationDetails.reserveDate);
                }, function (error){
                    console.log(error);
                });
        }//end of reservationDetailVm.findReservationDetails


    }//End of function ReservationDetailController
})();