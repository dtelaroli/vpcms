<!DOCTYPE html>
<html lang="en">
<head>
<title>Content</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<nav>
					<ul>
						<li>
							<a href="<c:url value="/"/>">Home</a>
						</li>
						<li>
							<a href="#!/">Grid</a>
						</li>
						<li>
							<a href="#!/add">Add</a>
						</li>
					</ul>
				</nav>
			</div>
			<div class="col-md-8">
				<div data-ng-view></div>
			</div>
		</div>
	</div>
</body>
</html>