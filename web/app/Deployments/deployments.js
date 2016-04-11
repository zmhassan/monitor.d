'use strict';

angular.module('myApp.deployments', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/deployments', {
    templateUrl: 'Deployments/deployments.html',
    controller: 'DeploymentsCtrl'
  });
}])

.controller('DeploymentsCtrl', [function() {

}]);
