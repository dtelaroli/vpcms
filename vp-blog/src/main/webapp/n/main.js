'use strict';

angular.module('VPlus.Config').constant('URL', '/vp-admin/content').constant(
		'menus', '')

.config(
		[ '$routeProvider', '$locationProvider',
				function($routeProvider, $locationProvider) {
					$routeProvider.when('/', {
						templateUrl : 'home.tpl.html',
						controller : 'ContentGridCtrl'
					}).when('/content', {
						templateUrl : 'content-grid.tpl.html',
						controller : 'ContentGridCtrl'
					}).when('/content/add', {
						templateUrl : 'content-form.tpl.html',
						controller : 'ContentAddCtrl'
					}).when('/content/:id', {
						templateUrl : 'content-form.tpl.html',
						controller : 'ContentEditCtrl'
					}).when('/content/:id/remove', {
						templateUrl : 'content-grid.tpl.html',
						controller : 'ContentDeleteCtrl'
					}).otherwise({
						redirectTo : '/'
					});

					$locationProvider.html5Mode(false).hashPrefix('!');
				} ]);

angular
		.module('VPlus')
		.controller(
				'ContentGridCtrl',
				[
						'$scope',
						'$filter',
						'Rest',
						'ngTableParams',
						'$dialog',
						function($scope, $filter, Rest, Table, $dialog) {

							$scope.tableParams = {};

							Rest.query(function(data) {
								$scope.list = data;
								$scope.tableParams = new Table({
									page : 1,
									total : data.length,
									count : 10
								});
							});

							$scope.$watch('tableParams', function(params) {
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

						} ])
		.controller(
				'ContentAddCtrl',
				[ '$scope', 'Rest', '$routeParams',
						function($scope, Rest, $routeParams) {

							$scope.model = new Rest();
							$scope.persist = function() {
								$scope.model.$save();
							};

						} ])
		.controller(
				'ContentEditCtrl',
				[ '$scope', 'Rest', '$routeParams',
						function($scope, Rest, $routeParams) {

							Rest.get({
								id : $routeParams.id
							}, function(result) {
								$scope.model = result;
							});

							$scope.persist = function() {
								$scope.model.$update({
									id : $scope.model.id
								});
							};

						} ])
		.controller(
				'ContentDeleteCtrl',
				[
						'$scope',
						'Rest',
						'$dialog',
						'$routeParams',
						'$location',
						function($scope, Rest, $dialog, $routeParams, $location) {
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
										$location.path('/content');
									});
								} else {
									$location.path('/content');
								}
							});
						} ]).directive('ckEditor',
				[ function() {
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