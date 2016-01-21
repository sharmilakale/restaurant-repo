(function(){
    'use strict';

    angular
        .module('restaurant', ['ngRoute', 'angular-loading-bar','ngMessages'])
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider'];
    function moduleConfig ($routeProvider) {
        $routeProvider
            .when('/home', {
                templateUrl: 'html/home.tmpl.html',

            })
            .when('/reservations', {
                templateUrl: 'html/reservation-list.tmpl.html',
                controller: 'ReservationListController',
                controllerAs: 'reservationListVm'
            })

            .when('/reservations/:id', {
                templateUrl: 'html/reservation-detail.tmpl.html',
                controller: 'ReservationDetailController',
                controllerAs: 'reservationDetailVm'
            })

            .when('/createReservation', {
                templateUrl: 'html/create-reservation.tmpl.html',
                controller: 'CreateReservationController',
                controllerAs: 'createReservationVm'
            })
            .when('/findReservation', {
                templateUrl: 'html/find-reservation.tmpl.html',
                controller: 'FindReservationController',
                controllerAs: 'findReservationVm'
            })

            .when('/tableList', {
                templateUrl: 'html/table-list.tmpl.html',
                controller: 'TableListController',
                controllerAs: 'tableListVm'
            })
            .when('/customerList', {
                templateUrl: 'html/customer-list.tmpl.html',
                controller: 'CustomerListController',
                controllerAs: 'customerListVm'
            })
            .when('/profiles/:id', {
                templateUrl: 'html/profile-settings.tmpl.html',
                controller: 'ProfileSettingsController',
                controllerAs: 'profileSettingsVm'
            })
            .when('/aboutUs', {
                templateUrl: 'html/about-us.tmpl.html',
                controller: 'AboutUsController',
                controllerAs: 'aboutUsVm'
            })
            .when('/contactUs', {
                templateUrl: 'html/contact-us.tmpl.html'

            })
            .when('/login', {
                templateUrl: 'html/login.tmpl.html',
                controller: 'LoginController',
                controllerAs: 'loginVm'

            })
            .when('/ownerPage', {
                templateUrl: 'html/owner-page.tmpl.html',
                controller: 'OwnerController',
                controllerAs: 'ownerVm'

            })
            .otherwise({
                redirectTo: '/home'
            })
    }


})();
