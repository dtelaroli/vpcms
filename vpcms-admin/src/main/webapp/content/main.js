'use strict';

angular.module('myApp').constant('REST_URL', '/vp-api/v1/content').config(
	[ '$routeProvider', routes ])

.controller('CategoryEditCtrl',
	[ '$scope', '$restService', function($scope, $rest) {

	    $rest.$delegate('/vp-api/v1/category').query(function(result) {
		$scope.categories = result;

		$scope.$watch('$parent.$model.categories', function(val) {
		    if (val !== undefined) {
			angular.forEach(val, function(value, key) {
			    angular.forEach($scope.categories, function(v, k) {
				if (value.id === v.id) {
				    v.checked = true;
				}
			    });
			});
		    }
		});
	    });

	    $scope.persist = function() {
		$scope.$parent.$model.categories = [];
		angular.forEach($scope.categories, function(value, key) {
		    if (value.checked) {
			this.push({
			    id : value.id
			});
		    }
		}, $scope.$parent.$model.categories);
		$scope.$parent.persist();
	    };

	} ]);