'use strict';

App.controller("takenDisksCtrl", ['$rootScope', 'DiskService', function ($rootScope, DiskService) {
    var self = this;
    self.disk = {id: 0, title: '', rating: '', description: ''};
    self.disks = [];

    self.getTakenByMeDisks = function () {
        DiskService.getTakenByMeDisks($rootScope.userId).then(
            function (d) {
                self.disks = d;
            },
            function (errResponse) {
                console.error('error while getting taken disks');
            }
        )
    };

    self.getTakenByMeDisks();
    self.returnDisk = function (disk_id) {
        DiskService.returnDisk(disk_id).then(
            function () {
                self.getTakenByMeDisks();
            }
        );
    }
}]);