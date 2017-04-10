'use strict';

App.controller("loginCtrl", ['$rootScope', 'DiskService', function ($rootScope, DiskService) {
    var self = this;
    $rootScope.userId = 0;
    self.email = '';
    self.password = '';
    self.user = {name: '', surname: ''};
    self.logi = function () {
        DiskService.getLogin(self.email, self.password).then(
            function (d) {
                if (d == ''){
                    alert("Вы ыыели неправильно логин или пароль");
                    self.email = '';
                    self.password = '';
                }
                else {
                    self.user = d;
                    $rootScope.userId = d.id;
                }
            }
        )
    };

    self.logined = function () {
        if ($rootScope.userId == 0)
            return false;
        else
            return true;
    };


    self.logOut = function () {
        $rootScope.userId = 0;
        self.email = '';
        self.password = '';
    }
}]);



