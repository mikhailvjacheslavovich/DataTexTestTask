'use strict';

App.controller("takenDisksCtrl", ['$scope', 'DiskService', function ($scope, DiskService) {
    var self = this;
    self.disk = {id: 0, title: '', rating: '', description: ''};
    self.disks = [];

    self.getTakenByMeDisks = function () {
        DiskService.getTakenByMeDisks(1).then(
            function (d) {
                self.disks = d;
            },
            function (errResponse) {
                console.error('error');
            }
        )
    };

    self.getTakenByMeDisks();
    $scope.returnDisk = function (disk_id, user_id) {
        DiskService.returnDisk(disk_id, user_id);
        self.getTakenByMeDisks();
    }
}]);