<!--[if lt IE 9]>
	<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<script src="/vp-static/lib/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="/vp-static/lib/bootstrap-3.0.0/js/bootstrap.js" type="text/javascript"></script>
<script src="/vp-static/lib/ckeditor/ckeditor.js" type="text/javascript"></script>
<script src="/vp-static/lib/angular/angular.js" type="text/javascript"></script>
<script src="/vp-static/lib/angular/angular-route.js" type="text/javascript"></script>
<script src="/vp-static/lib/angular/angular-resource.js" type="text/javascript"></script>
<script src="/vp-static/lib/angulartics/angulartics.min.js" type="text/javascript"></script>
<script src="/vp-static/lib/angulartics/angulartics-google-analytics.min.js" type="text/javascript"></script>
<script src="/vp-static/lib/ng-table/ng-table.js" type="text/javascript"></script>
<script src="/vp-static/lib/ui-bootstrap/ui-bootstrap-tpls-0.5.0.js" type="text/javascript"></script>

<script src="/vp-static/js/app.js" type="text/javascript"></script>
<script src="/vp-static/js/filters.js" type="text/javascript"></script>
<script src="/vp-static/js/directives.js" type="text/javascript"></script>
<script src="/vp-static/js/services.js" type="text/javascript"></script>
<script src="/vp-static/js/controllers.js" type="text/javascript"></script>

<!-- <script src="/vp-static/js/vplus.js" type="text/javascript"></script> -->

<vp:js value="/main.js" />

<div id="fb-root"></div>
<script>
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
</script>

<script>
    (function(i, s, o, g, r, a, m) {
	i['GoogleAnalyticsObject'] = r;
	i[r] = i[r] || function() {
	    (i[r].q = i[r].q || []).push(arguments)
	}, i[r].l = 1 * new Date();
	a = s.createElement(o), m = s.getElementsByTagName(o)[0];
	a.async = 1;
	a.src = g;
	m.parentNode.insertBefore(a, m)
    })(window, document, 'script', '//www.google-analytics.com/analytics.js',
	    'ga');

    ga('create', 'UA-44457604-1', 'dtelaroli.org');
    //ga('send', 'pageview');
</script>