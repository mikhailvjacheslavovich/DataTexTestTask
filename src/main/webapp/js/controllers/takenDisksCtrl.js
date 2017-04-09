'use strict';

App.controller("takenDisksCtrl", ['$scope', '$rootScope', 'DiskService', function ($scope, $rootScope, DiskService) {
    var self = this;
    self.disk = {id: 0, title: '', rating: '', description: ''};
    self.disks = [];

    self.getTakenByMeDisks = function () {
        DiskService.getTakenByMeDisks($rootScope.userId).then(
            function (d) {
                self.disks = d;
            },
            function (errResponse) {
                console.error('error');
            }
        )
    };

    self.getTakenByMeDisks();
    $scope.returnDisk = function (disk_id) {
        DiskService.returnDisk(disk_id, $rootScope.userId);
        self.getTakenByMeDisks();
    }



}]);