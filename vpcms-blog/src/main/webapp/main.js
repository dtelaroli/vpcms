'use strict';

angular.module('VPlus.Config').constant('URL', '/vp-admin/api/v1/content').constant(
		'menus', '')

.config(
		[ '$routeProvider', '$locationProvider',
				function($routeProvider, $locationProvider) {
					$routeProvider.when('/', {
						templateUrl : 'home.tpl.html',
						controller : 'HomeCtrl'
					}).when('/:id', {
						templateUrl : 'view.tpl.html',
						controller : 'ViewCtrl'
					}).otherwise({
						redirectTo : '/'
					});

					$locationProvider.html5Mode(false).hashPrefix('!');
				} ]);

angular.module('VPlus').controller(
		'HomeCtrl',
		[ '$scope', '$filter', 'Rest', 'ngTableParams', '$dialog',
				function($scope, $filter, Rest, Table, $dialog) {

					Rest.query(function(data) {
						$scope.list = data;
					});

				} ]).controller(
		'ViewCtrl',
		[ '$scope', 'Rest', '$routeParams',
				function($scope, Rest, $routeParams) {

					Rest.get({
						id : $routeParams.id
					}, function(result) {
						$scope.model = result;
					});

				} ]);

