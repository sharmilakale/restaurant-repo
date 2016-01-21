(function() {
    'use strict';

    angular
        .module('restaurant')
        .controller('GlobalConstantController', GlobalConstantController);

    GlobalConstantController.$inject = ['$scope', '$window'];

    function GlobalConstantController($scope, $window) {
       $scope.timeOptions = [{
           id:'6.00 PM',
           value:'6.00 PM'
       },
           {
               id:'6.30 PM',
               value:'6.30 PM'
           },
           {
               id:'6.45 PM',
               value:'6.45 PM'
           },
           {
               id:'7.00 PM',
               value:'7.00 PM'
           },
           {
               id:'7.15 PM',
               value:'7.15 PM'
           }
       ]


    }//End of function ReservationDetailController
})();