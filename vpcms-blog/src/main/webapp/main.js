'use strict';

angular.module('myApp.controllers').constant('REST_URL',
		'/vp-api/v1/content').

config(
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
				} ]).

controller(
		'HomeCtrl',
		[ '$scope', '$restService',
				function($scope, $rest) {

					$rest.query(function(data) {
						$scope.$list = data;
					});

				} ]).

controller(
		'ViewCtrl',
		[ '$scope', '$restService', '$routeParams',
				function($scope, $rest, $routeParams) {

					$rest.get({
						id : $routeParams.id
					}, function(result) {
						$scope.$model = result;
					});

				} ]);
