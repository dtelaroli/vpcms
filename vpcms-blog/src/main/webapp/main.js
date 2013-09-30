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

/** facebook **/
(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id))
	return;
    js = d.createElement(s);
    js.id = id;
    js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=257805934292825";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
