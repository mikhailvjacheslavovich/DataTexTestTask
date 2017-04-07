'use strict';

App.controller("givenDisksCtrl", ['$scope', 'DiskService', function ($scope, DiskService) {
    var self = this;
    self.disk = {id: 0, title: '', rating: '', description: '', whoTake: ''};
    self.disks = [];

    self.getGivenDisks = function () {
        DiskService.getGivenDisks(1).then(
            function (d) {
                self.disks = d;
                for (var i = 0; i < self.disks.length; i++) {
                    self.disks[i].whoTake = d[i].users[0].name + ' ' + d[i].users[0].surname;
                    ;
                }
            },
            function (errResponce) {
                console.error('error');
            }
        )
    };

    self.getGivenDisks();

}]);