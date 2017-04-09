'use strict';

App.controller("UserController", ['$scope','$rootScope', 'DiskService', function ($scope,$rootScope, DiskService) {
    var self = this;
    self.user = {name: '', surname: '', age: 0, email: ''};
    self.users = [];
}]);