(function() {
    'use strict';

    angular
        .module('restaurant')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['reservationService', '$routeParams','$rootScope','$location'];

    function LoginController(reservationService, $routeParams, $rootScope,$location) {
        var loginVm = this;


        loginVm.userDetails = null;

        loginVm.getUserByEmailId = function(emailId) {

            reservationService
                .getUserByEmailId(emailId)
                .then(function(data){
                    loginVm.userDetails = data;
                    if(loginVm.userDetails != null){
                        $rootScope.isOwner = true;
                        console.log("Is user owner: "+$rootScope.isOwner);
                    }
                }, function (error){
                    console.log(error);
                });
            //$location.path("/profiles/1");
        }

    }//End of function LoginController
})();