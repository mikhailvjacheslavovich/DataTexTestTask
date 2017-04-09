'use strict';

App.controller("givenDisksCtrl", ['$scope','$rootScope', 'DiskService', function ($scope,$rootScope, DiskService) {
    var self = this;
    self.disk = {id: 0, title: '', rating: '', description: '', whoTake: ''};
    self.disks = [];

    self.getGivenDisks = function () {
        DiskService.getGivenDisks($rootScope.userId).then(
            function (d) {
                self.disks = d;
                for (var i = 0; i < self.disks.length; i++) {
                    self.disks[i].whoTake = d[i].users[0].name + ' ' + d[i].users[0].surname;
                }
            },
            function (errResponce) {
                console.error('error');
            }
        )
    };

    self.getGivenDisks();

}]);