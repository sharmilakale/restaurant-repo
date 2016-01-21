(function() {
    'use strict';

    angular
        .module('restaurant')
        .service('reservationService', reservationService);

    reservationService.$inject = ['$http', '$q', 'rootUrl'];

    function reservationService ($http, $q, rootUrl) {

        var self = this;


        self.getReservationList = function () {
            var defer = $q.defer();

            $http
                .get(rootUrl + '/api/reservations',{cache:false})
                .then(function (response){
                    defer.resolve(response.data);
                }, function (error){
                    defer.reject(error.status);
                });
            return defer.promise;
        };

        self.getReservationById = function (id) {
            var defer = $q.defer();
            $http
                .get(rootUrl + '/api/reservations/' + id,{cache:false})
                .then(function (response){
                    defer.resolve(response.data);
                }, function (error){
                    defer.reject(error.status);
                });
            return defer.promise;
        };

        self.saveReservationDetails = function (reservationDetails) {
            var defer = $q.defer();
            $http
                .put(rootUrl + '/api/reservations/'+reservationDetails.id ,reservationDetails,{cache:false})
                .then(function (response){
                    defer.resolve(response.data);
                }, function (error){
                    defer.reject(error.status);
                });
            return defer.promise;
        };
        self.createReservation = function (reservationDetails) {
            var defer = $q.defer();
            $http
                .post(rootUrl + '/api/reservations' ,reservationDetails,{cache:false})
                .then(function (response){
                    defer.resolve(response.data);
                }, function (error){
                    defer.reject(error.status);
                });
            return defer.promise;
        };
        self.deleteReservationDetails = function (reserveId) {
            var defer = $q.defer();
            $http
                .delete(rootUrl + '/api/reservations/'+reserveId ,{cache:false})
                .then(function (response){
                    defer.resolve(response.data);
                }, function (error){
                    defer.reject(error.status);
                });
            return defer.promise;
        };

        self.getTableList = function () {
            var defer = $q.defer();

            $http
                .get(rootUrl + '/api/tableReservation',{cache:false})
                .then(function (response){
                    defer.resolve(response.data);
                }, function (error){
                    defer.reject(error.status);
                });
            return defer.promise;
        };
        self.getCustomerList = function () {
            var defer = $q.defer();

            $http
                .get(rootUrl + '/api/reservations',{cache:false})
                .then(function (response){
                    defer.resolve(response.data);
                }, function (error){
                    defer.reject(error.status);
                });
            return defer.promise;
        };
        self.getProfileDetailsById = function (id) {
            var defer = $q.defer();
            $http
                .get(rootUrl + '/api/profiles/' + id,{cache:false})
                .then(function (response){
                    defer.resolve(response.data);
                }, function (error){
                    defer.reject(error.status);
                });
            return defer.promise;
        };

        self.saveProfileDetails = function (profileDetails) {
            var defer = $q.defer();
            $http
                .put(rootUrl + '/api/profiles/'+profileDetails.restId ,profileDetails,{cache:false})
                .then(function (response){
                    defer.resolve(response.data);
                }, function (error){
                    defer.reject(error.status);
                });
            return defer.promise;
        };

        self.getUserByEmailId = function (emailId) {

            var defer = $q.defer();
            $http
                .get(rootUrl + '/api/users/email/' + emailId,{cache:false})
                .then(function (response){
                    defer.resolve(response.data);
                }, function (error){
                    defer.reject(error.status);
                });
            return defer.promise;
        };
    }
})();