'use strict';

angular.module('myApp.controllers')

.constant('REST_URL', '/vp-api/v1/content')

.config(
	[ '$routeProvider', '$locationProvider',
		function($routeProvider, $locationProvider) {

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

		    $locationProvider.html5Mode(false).hashPrefix('!');

		} ])

.controller(
	'GridCtrl',
	[ '$scope', '$restService', '$filter', '$dialog', 'ngTableParams',
		function($scope, $rest, $filter, $dialog, $table) {

		    function filter(list, params) {
			if (params.filter) {
			    var data = $filter('filter')(list, params.filter);
			    return order(data, params);
			}
			return order(list, params);
		    }

		    function order(data, params) {
			if (params.sorting) {
			    return $filter('orderBy')(data, params.orderBy());
			}
			return data;
		    }

		    function paginate(data, params) {
			var start = (params.page - 1) * params.count;
			var count = params.page * params.count;
			return data.slice(start, count);
		    }

		    $scope.$tableParams = {};

		    $rest.query(function(data) {
			$scope.$list = data;
			$scope.$tableParams = new $table({
			    page : 1,
			    total : data.length,
			    count : 10
			});
		    });

		    $scope.$watch('$tableParams', function(params) {
			var orderedData = filter($scope.$list, params);
			if (typeof orderedData != 'undefined') {
			    params.total = orderedData.length;
			    $scope.$items = paginate(orderedData, params);
			}
		    });

		} ])

.controller(
	'AddCtrl',
	[ '$scope', '$restService', '$routeParams',
		function($scope, $rest, $routeParams) {

		    $scope.$model = new $rest();
		    $scope.persist = function() {
			$scope.$model.$save();
		    };

		} ])

.controller(
	'EditCtrl',
	[ '$scope', '$restService', '$routeParams',
		function($scope, $rest, $routeParams) {

		    $rest.get({
			id : $routeParams.id
		    }, function(result) {
			$scope.$model = result;
		    });

		    $scope.persist = function() {
			$scope.$model.$update({
			    id : $scope.$model.id
			});
		    };

		} ])

.controller(
	'DeleteCtrl',
	[ '$scope', '$restService', '$location', '$dialog', '$routeParams',
		function($scope, $rest, $location, $dialog, $routeParams) {

		    var options = {
			backdrop : true,
			keyboard : true,
			backdropClick : true,
			templateUrl : 'template/dialog/message.html',
			controller : 'DialogCtrl'
		    };

		    $dialog.dialog(options)

		    .open().then(function(result) {
			if (result) {
			    $rest.remove({
				id : $routeParams.id
			    }, function() {
				$location.path('/');
			    });
			} else {
			    $location.path('/');
			}
		    });

		} ])

.controller('DialogCtrl', [ '$scope', 'dialog', function($scope, dialog) {

    $scope.cancel = function(result) {
	dialog.close(false);
    };

    $scope.ok = function() {
	dialog.close(true);
    };

} ])

.directive('ckEditor', [ function() {
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