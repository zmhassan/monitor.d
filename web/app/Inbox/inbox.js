'use strict';

angular.module('myApp.inbox', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/inbox', {
    templateUrl: 'Inbox/inbox.html',
    controller: 'InboxCtrl'
  });
}])

.controller('InboxCtrl', [function() {

}]);
