'use strict';

App.controller("addDiskCtrl", ['$scope', 'DiskService', function ($scope, DiskService) {
    var self = this;
    self.disk = {title: '', rating: '', description: ''};


    self.addDisk = function () {
        DiskService.addDisk(self.disk);
    };

}]);