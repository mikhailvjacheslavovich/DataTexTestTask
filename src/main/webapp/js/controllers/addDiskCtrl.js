'use strict';

App.controller("addDiskCtrl", ['$rootScope', 'DiskService', function ($rootScope, DiskService) {
    var self = this;
    self.disk = {title: '', rating: '', description: ''};


    self.addDisk = function () {
        DiskService.addDisk(self.disk,$rootScope.userId);
        self.disk = {title: '', rating: '', description: ''};
    };
    self.addingDisk = function () {
        if ($rootScope.userId == 0)
            return false;
        else
            return true;
    }
}]);