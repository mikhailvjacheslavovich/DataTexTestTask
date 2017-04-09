'use strict';

App.controller("loginCtrl", ['$scope', '$rootScope', 'DiskService', function ($scope, $rootScope, DiskService) {
    var self = this;
    $rootScope.userId = 0;
    self.user = {name: '', surname: ''};
    self.logi = function () {
        DiskService.getLogin($scope.email, $scope.password).then(
            function (d) {
                self.user = d;
                $rootScope.userId = d.id;
            }
        )
    };

    self.logined = function () {
        if ($rootScope.userId == 0)
            return false;
        else
            return true;
    }


    self.logOut = function () {
        $rootScope.userId = 0;
    }
}]);



