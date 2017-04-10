'use strict';

var App = angular.module('myApp',["ngRoute"]);
App.config(function ($routeProvider) {
    $routeProvider
        .when("/freeDisks",{
            templateUrl:"/views/freeDisks.html",
            controller:"freeDisksCtrl"
        }).when("/takenDisks",{
            templateUrl:"/views/takenDisks.html",
            controller:"takenDisksCtrl"
        }).when("/givenDisks",{
            templateUrl:"/views/givenDisks.html",
            controller:"givenDisksCtrl"
        }).when("/addDisk",{
            templateUrl:"/views/addDisk.html",
            controller:"addDiskCtrl"
        })
});

