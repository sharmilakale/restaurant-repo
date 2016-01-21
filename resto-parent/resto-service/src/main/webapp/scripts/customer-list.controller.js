(function(){
    'use strict';
    angular
        .module('restaurant')
        .controller('CustomerListController', CustomerListController);

    CustomerListController.$inject = ['reservationService'];

    function CustomerListController(reservationService){
        var customerListVm = this;
        customerListVm.customerList = [];

        reservationService.getCustomerList().then(function(data){
            customerListVm.customerList = data;
        },function(error){
            console.log(error);
        });
    }
})();