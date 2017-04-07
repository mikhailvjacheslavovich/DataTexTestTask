'use strict';

App.controller("freeDisksCtrl", ['$scope', 'DiskService', function ($scope, DiskService) {
    var self = this;
    self.disk = {id: 0, title: '', rating: '', description: ''};
    self.disks = [];

    self.idGet = 0;

    self.getFreeDisks = function () {
        DiskService.getFreeDisks().then(
            function (d) {
                self.disks = d;
            },
            function (errResponse) {
                console.error('error');
            }
        )
    };

    self.getFreeDisks();

    $scope.rentDisk = function (disk_id, user_id) {
        DiskService.rentDisk(disk_id, user_id);
        self.getFreeDisks();
    }
}]);