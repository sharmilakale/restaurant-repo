(function() {
    'use strict';

    angular
        .module('restaurant')
        .controller('ProfileSettingsController', ProfileSettingsController);

    ProfileSettingsController.$inject = ['reservationService', '$routeParams'];

    function ProfileSettingsController(reservationService, $routeParams) {
        var profileSettingsVm = this;

        var timeOptions = [
            {'id':'Select','value':'Select'},

            {'id':'6.00 PM','value':'6.00 PM'},
            {'id':'6.15 PM','value':'6.15 PM'},
            {'id':'6.30 PM','value':'6.30 PM'},
            {'id':'6.45 PM','value':'6.45 PM'},
            {'id':'7.00 PM','value':'7.00 PM'},
            {'id':'7.15 PM','value':'7.15 PM'},
            {'id':'7.30 PM','value':'7.30 PM'},

            {'id':'7.45 PM','value':'7.45 PM'},
            {'id':'8.00 PM','value':'8.00 PM'},
            {'id':'8.15 PM','value':'8.15 PM'},
            {'id':'8.30 PM','value':'8.30 PM'},
            {'id':'8.45 PM','value':'8.45 PM'},
            {'id':'9.00 PM','value':'9.00 PM'},
            {'id':'9.15 PM','value':'9.15 PM'},
            {'id':'9.30 PM','value':'9.30 PM'},
            {'id':'9.45 PM','value':'9.45 PM'},
            {'id':'10.00 PM','value':'10.00 PM'},
            {'id':'11.00 PM','value':'11.00 PM'},
            {'id':'12.00 PM','value':'12.00 PM'}
        ];
        profileSettingsVm.timeOptions = timeOptions;

        profileSettingsVm.profileDetails = null;
        profileSettingsVm.infoMsg = "";
        profileSettingsVm.successFlag = "";
        reservationService
            .getProfileDetailsById($routeParams.id)
            .then(function(data){
                profileSettingsVm.profileDetails = data;
            }, function (error){
                console.log(error);
            });

        profileSettingsVm.saveProfileDetails = function(details) {
            reservationService
                .saveProfileDetails(details)
                .then(function (data) {
                    profileSettingsVm.profileDetails = data;
                    profileSettingsVm.successFlag = "true";
                    profileSettingsVm.infoMsg = "Successfully saved profile details!";
                }, function (error) {
                    console.log(error);
                    profileSettingsVm.successFlag = "false";
                    profileSettingsVm.infoMsg = "Error saving profile details!";
                });
        }//end of profileSettingsVm.saveProfileDetails


    }//End of function ProfileSettingsController
})();