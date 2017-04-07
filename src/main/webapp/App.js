'use strict';

var App = angular.module('myApp',["ngRoute"]);
App.config(function ($routeProvider) {
    $routeProvider
        .when("/freedisks",{
            templateUrl:"/views/freeDisks.html",
            controller:"freeDisksCtrl"
        }).when("/takendisks",{
            templateUrl:"/views/takenDisks.html",
            controller:"takenDisksCtrl"
        }).when("/givendisks",{
            templateUrl:"/views/givenDisks.html",
            controller:"givenDisksCtrl"
        }).when("/addDisk",{
            templateUrl:"/views/addDisk.html",
            controller:"addDiskCtrl"
        })
});

