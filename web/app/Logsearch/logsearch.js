'use strict';

angular.module('myApp.logsearch', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/logsearch', {
    templateUrl: 'Logsearch/logsearch.html',
    controller: 'LogsearchCtrl'
  });
}])

.controller('LogsearchCtrl', [function() {

}]);
