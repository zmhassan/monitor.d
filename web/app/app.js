'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.view1',
  'myApp.view2',
  'myApp.settings',
  'myApp.inbox',
  'myApp.kubeadmin',
  'myApp.login',
  'myApp.logsearch',
  'myApp.osmetrics',
  'myApp.settings',
  'myApp.cloudadmin',
  'myApp.deployments',
  'myApp.dashboard',
  'myApp.version'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/dashboard'});
}]);
