'use strict';

angular.module('myApp').constant('REST_URL', '/vp-api/v1/content')

.config([ '$routeProvider', function($routeProvider) {

    $routeProvider.when('/', {
	templateUrl : 'content-grid.tpl.html',
	controller : 'GridCtrl'
    }).when('/add', {
	templateUrl : 'content-form.tpl.html',
	controller : 'AddCtrl'
    }).when('/:id', {
	templateUrl : 'content-form.tpl.html',
	controller : 'EditCtrl'
    }).when('/:id/remove', {
	templateUrl : 'content-grid.tpl.html',
	controller : 'DeleteCtrl'
    }).otherwise({
	redirectTo : '/'
    });

} ]);