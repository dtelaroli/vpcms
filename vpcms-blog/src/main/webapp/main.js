'use strict';

angular.module('myApp').constant('REST_URL', '/vp-api/v1/content')

.config([ '$routeProvider', function($routeProvider) {
    $routeProvider.when('/', {
	templateUrl : 'home.tpl.html',
	controller : 'IndexCtrl'
    }).when('/:id', {
	templateUrl : 'view.tpl.html',
	controller : 'ViewCtrl'
    }).otherwise({
	redirectTo : '/'
    });

} ]);
