<!DOCTYPE html>
<html lang="en">
<head>
<title>Content</title>
</head>
<body>
	<aside>
		<nav>
			<div class="span2">
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
			</div>
		</nav>
	</aside>
	<section>
		<div class="span10">
			<div data-ng-view></div>
		</div>
	</section>
</body>
</html>