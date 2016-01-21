(function() {
    'use strict';

    angular
        .module('restaurant')
        .controller('CreateReservationController', CreateReservationController);

    CreateReservationController.$inject = ['reservationService', '$routeParams','$rootScope'];

    function CreateReservationController(reservationService, $routeParams, $rootScope) {
        var createReservationVm = this;
        createReservationVm.isOwner = $rootScope.isOwner;
        console.log("is owner: "+ $rootScope.isOwner);
        console.log("in vm:"+createReservationVm.isOwner);
        createReservationVm.reservationDetails = null;
        createReservationVm.infoMsg = "";
        createReservationVm.successFlag = "";
        reservationService
            .getReservationById($routeParams.id)
            .then(function(data){
                createReservationVm.reservationDetails = data;
                createReservationVm.reservationDetails.reserveDate = new Date(createReservationVm.reservationDetails.reserveDate);
            }, function (error){
                console.log(error);
            });

        createReservationVm.saveReservationDetails = function(details) {
            reservationService
                .createReservation(details)
                .then(function (data) {
                    createReservationVm.reservationDetails = data;
                    createReservationVm.successFlag = "true";
                    createReservationVm.infoMsg = "Successfully saved reservation details!";
                }, function (error) {
                    console.log(error);
                    createReservationVm.successFlag = "false";
                    createReservationVm.infoMsg = "Error saving reservation details!";
                });
        }//end of createReservationVm.saveReservationDetails


        createReservationVm.deleteReservationDetails = function(reserveId) {
            reservationService
                .deleteReservationDetails(reserveId)
                .then(function (data) {
                    createReservationVm.reservationDetails = data;
                    createReservationVm.successFlag = "true";
                    createReservationVm.infoMsg = "Successfully deleted reservation details!";
                }, function (error) {
                    console.log(error);
                    createReservationVm.successFlag = "false";
                    createReservationVm.infoMsg = "Error deleting reservation details!";
                });
        }//end of createReservationVm.deleteReservationDetails


        createReservationVm.findReservationDetails = function(reserveId) {
            reservationService
                .getReservationById(reserveId)
                .then(function(data){
                    createReservationVm.reservationDetails = data;
                    createReservationVm.reservationDetails.reserveDate = new Date(createReservationVm.reservationDetails.reserveDate);
                }, function (error){
                    console.log(error);
                });
        }//end of createReservationVm.findReservationDetails


    }//End of function CreateReservationController
})();