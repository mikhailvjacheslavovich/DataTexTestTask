'use strict';

App.factory('LoginService', ['$http', '$q', function ($http, $q) {
    return {
        getLogin: function (email, password) {
            return $http({
                method: 'GET',
                url: "/getLogin",
                params: {email: email, password: password}
            }).then(
                function (response) {
                    return response.data
                },
                function (errResponse) {
                    console.error('error');
                    return $q.reject(errResponse);
                }
            )
        }
    }
}]);