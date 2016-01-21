(function() {
    'use strict';

    angular
        .module('restaurant')
        .controller('OwnerController', OwnerController);

    OwnerController.$inject = ['reservationService', '$routeParams','$scope'];

    function OwnerController(reservationService, $routeParams, $scope) {
        var ownerVm = this;


    }//End of function OwnerController
})();