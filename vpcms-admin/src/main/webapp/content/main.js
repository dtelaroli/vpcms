'use strict';

angular.module('myApp.controllers').

constant('REST_URL', '/vp-admin/api/v1/content').

config(
		[ '$routeProvider', '$locationProvider',
				function($routeProvider, $locationProvider) {
					$routeProvider.when('/', {
						templateUrl : 'content-grid.tpl.html',
						controller : 'ContentGridCtrl'
					}).when('/add', {
						templateUrl : 'content-form.tpl.html',
						controller : 'ContentAddCtrl'
					}).when('/:id', {
						templateUrl : 'content-form.tpl.html',
						controller : 'ContentEditCtrl'
					}).when('/:id/remove', {
						templateUrl : 'content-grid.tpl.html',
						controller : 'ContentDeleteCtrl'
					}).otherwise({
						redirectTo : '/'
					});

					$locationProvider.html5Mode(false).hashPrefix('!');
				} ]).

controller(
		'ContentGridCtrl',
		[
				'$scope',
				'$filter',
				'$restService',
				'ngTableParams',
				'$dialog',
				function($scope, $filter, $rest, Table, $dialog) {

					$scope.tableParams = {};

					$rest.query(function(data) {
						$scope.list = data;
						$scope.tableParams = new Table({
							page : 1,
							total : data.length,
							count : 10
						});
					});

					$scope.$watch('tableParams',
							function(params) {
								var orderedData = params.filter ? $filter(
										'filter')($scope.list, params.filter)
										: $scope.list;
								orderedData = params.sorting ? $filter(
										'orderBy')(orderedData,
										params.orderBy()) : orderedData;

								if (typeof orderedData != 'undefined') {
									params.total = orderedData.length;

									$scope.items = orderedData.slice(
											(params.page - 1) * params.count,
											params.page * params.count);
								}
							}, true);

				} ]).

controller(
		'ContentAddCtrl',
		[ '$scope', '$restService', '$routeParams',
				function($scope, $rest, $routeParams) {

					$scope.model = new $rest();
					$scope.persist = function() {
						$scope.model.$save();
					};

				} ]).

controller(
		'ContentEditCtrl',
		[ '$scope', '$restService', '$routeParams',
				function($scope, $rest, $routeParams) {

					$rest.get({
						id : $routeParams.id
					}, function(result) {
						$scope.model = result;
					});

					$scope.persist = function() {
						$scope.model.$update({
							id : $scope.model.id
						});
					};

				} ]).

controller(
		'ContentDeleteCtrl',
		[
				'$scope',
				'$restService',
				'$dialog',
				'$routeParams',
				'$location',
				function($scope, $rest, $dialog, $routeParams, $location) {
					var msgbox = $dialog.messageBox('Delete Item',
							'Are you sure?', [ {
								label : 'Yes, I\'m sure',
								result : true
							}, {
								label : 'Nope',
								result : false
							} ]);
					msgbox.open().then(function(result) {
						if (result) {
							Rest.remove({
								id : $routeParams.id
							}, function() {
								$location.path('/');
							});
						} else {
							$location.path('/');
						}
					});
				} ]).

directive('ckEditor', [ function() {
	return {
		require : '?ngModel',
		link : function($scope, elm, attr, ngModel) {

			var ck = CKEDITOR.replace(elm[0]);

			ck.on('instanceReady', function() {
				ck.setData(ngModel.$viewValue);
			});

			ck.on('pasteState', function() {
				$scope.$apply(function() {
					ngModel.$setViewValue(ck.getData());
				});
			});

			ngModel.$render = function(value) {
				ck.setData(ngModel.$modelValue);
			};
		}
	};
} ]);

;