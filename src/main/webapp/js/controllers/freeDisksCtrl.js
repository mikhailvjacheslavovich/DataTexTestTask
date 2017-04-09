'use strict';

App.controller("freeDisksCtrl", ['$rootScope', 'DiskService', function ($rootScope, DiskService) {
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

    self.rentDisk = function (disk_id) {
        DiskService.rentDisk(disk_id, $rootScope.userId).then(
            function () {
                self.getFreeDisks();
            }
        )
    };

    self.logined = function () {
        if ($rootScope.userId == 0)
            return false;
        else
            return true;
    }
}]);