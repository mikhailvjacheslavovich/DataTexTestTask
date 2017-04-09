'use strict';

App.controller("UserController", ['$scope','$rootScope', 'DiskService', function ($scope,$rootScope, DiskService) {
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

    self.sayHello = function () {
        alert($rootScope.userId)
    }

}]);