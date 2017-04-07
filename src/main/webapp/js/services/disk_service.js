'use strict';

App.factory('DiskService', ['$http', '$q', function ($http, $q) {
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
        },

        getFreeDisks: function () {
            return $http.get('/getFreeDisks')
                .then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    console.error('error');
                    return $q.reject(errResponse);
                }
            )
        },
        getTakenByMeDisks: function (id) {
            return $http({
                method: 'GET',
                url: '/getTakenDisks',
                params: {id: id}
            }).then(
                function (responce) {
                    return responce.data
                },
                function (errResponse) {
                    console.error('error');
                    return $q.reject(errResponse);
                }
            )
        },

        getGivenDisks: function (user_id) {
            return $http({
                method: 'GET',
                url: '/getGivenDisks',
                params: {user_id: user_id}
            }).then(
                function (response) {
                    return response.data
                },
                function (errResponse) {
                    console.error('error');
                    return $q.reject(errResponse);
                }
            )
        },

        rentDisk: function (disk_id, user_id) {
            return $http({
                method: 'POST',
                url: '/rentDisk',
                params: {disk_id: disk_id, user_id: user_id}
            });
        },
        returnDisk: function (disk_id, user_id) {
            return $http({
                method: 'POST',
                url: '/returnDisk',
                params: {disk_id: disk_id, user_id: user_id}
            });
        },
        addDisk: function (disk) {
            return $http({
                method: 'POST',
                url: '/addDisk',
                params: {title: disk.title, rating: disk.rating, description: disk.description}
                //data: 'title=' + disk.title + '&rating=' + disk.rating + '&description=' + disk.description,
                //headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            });
        }
    }
}]);
