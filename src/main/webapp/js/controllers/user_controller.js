'use strict';

App.controller("UserController", ['$scope', 'UserService', function ($scope, UserService) {
    var self = this;
    self.user = {name: '', surname: '', age: 0, email: ''};
    self.users = [];

    self.fetchAllUsers = function () {
        UserService.fetchAllUsers().then(
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