(function(){
    'use strict';
    angular
        .module('restaurant')
        .controller('TableListController', TableListController);

    TableListController.$inject = ['reservationService'];

    function TableListController(reservationService){
        var tableListVm = this;
        tableListVm.tableList = [];

        reservationService.getTableList().then(function(data){
            tableListVm.tableList = data;
        },function(error){
            console.log(error);
        });
    }
})();