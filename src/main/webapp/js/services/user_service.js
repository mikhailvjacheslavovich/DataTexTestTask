'use strict';

App.factory('UserService', ['$http', '$q', function ($http, $q) {
    return {
        fetchAllUsers: function () {
            return $http.get('/getUsers')
                .then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    console.error('error');
                    return $q.reject(errResponse);
                }
            )
        }
    }
}]);
