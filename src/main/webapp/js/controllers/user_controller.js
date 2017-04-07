'use strict';

App.controller("UserController", ['$scope', 'DiskService', function ($scope, DiskService) {
    var self = this;
    self.user = {name: '', surname: '', age: 0, email: ''};
    self.users = [];

    self.fetchAllUsers = function () {
        DiskService.fetchAllUsers().then(
            function (d) {
                self.users = d;
            },
            function (errResponse) {
                console.error('error');
            }
        );
    };
    self.fetchAllUsers();
}]);