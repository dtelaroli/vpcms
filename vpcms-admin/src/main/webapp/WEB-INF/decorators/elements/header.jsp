<nav class="navbar navbar-default" data-role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="<c:url value="/"/>">Dashboard</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav">
			<li class="active">
				<a href="<c:url value="/content"/>">Contents</a>
			</li>
			<li>
				<a href="<c:url value="/category"/>">Categories</a>
			</li>
			<li>
				<a href="<c:url value="/author"/>">Authors</a>
			</li>
			<li>
				<a href="<c:url value="/author"/>">Tags</a>
			</li>
			<li>
				<a href="<c:url value="/author"/>">Media</a>
			</li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					Settings <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li>
						<a href="#">Groups</a>
					</li>
					<li>
						<a href="#">Users</a>
					</li>
				</ul>
			</li>
		</ul>
		<form class="navbar-form navbar-right" data-role="search" data-ng-controller="SearchCtrl">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search" data-ng-model="filter">
				<span class="input-group-btn">
					<button type="submit" class="btn btn-default" data-ng-click="clear()">Clear</button>
				</span>
			</div>
		</form>
	</div>
	<!-- /.navbar-collapse -->
</nav>