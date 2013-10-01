'use strict';

angular.module('myApp').constant('URL', '/vp-api/v1/category').config(
	[ '$routeProvider', routes ])

.controller(
	'CategoryEditCtrl',
	[ '$scope', '$restService', '$routeParams',
		function($scope, $rest, $routeParams) {
		    if ($routeParams.id === undefined) {
			$rest().query(function(result) {
			    $scope.$categories = result;
			});
		    } else {
			$rest().query({
			    id : $routeParams.id,
			    action : 'list-exclude.json'
			}, function(result) {
			    $scope.$categories = result;
			});
		    }

		} ]);