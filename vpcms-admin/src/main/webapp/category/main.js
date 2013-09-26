'use strict';

angular.module('myApp').constant('REST_URL', '/vp-api/v1/category').config(
	[ '$routeProvider', routes ])

.controller(
	'CategoryEditCtrl',
	[ '$scope', '$restService', '$routeParams',
		function($scope, $rest, $routeParams) {
		    if ($routeParams.id === undefined) {
			$rest.$delegate().query(function(result) {
			    $scope.$categories = result;
			});
		    } else {
			$rest.$delegate().query({
			    id : $routeParams.id,
			    action : 'list-exclude.json'
			}, function(result) {
			    $scope.$categories = result;
			});
		    }

		} ]);