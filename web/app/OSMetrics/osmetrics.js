'use strict';

angular.module('myApp.osmetrics', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/osmetrics', {
    templateUrl: 'OSMetrics/osmetrics.html',
    controller: 'osmetricsCtrl'
  });
}])

.controller('osmetricsCtrl', [function() {

}]);
