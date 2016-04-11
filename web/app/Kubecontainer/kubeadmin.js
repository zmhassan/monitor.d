'use strict';

angular.module('myApp.kubeadmin', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/kubeadmin', {
    templateUrl: 'Kubecontainer/kubeadmin.html',
    controller: 'kubeadminCtrl'
  });
}])

.controller('kubeadminCtrl', [function() {

}]);
