'use strict';

angular.module('myApp.cloudadmin', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/cloudadmin', {
    templateUrl: 'CloudAdmin/cloudadmin.html',
    controller: 'CloudAdminCtrl'
  });
}])

.controller('CloudAdminCtrl', [function() {

}]);
