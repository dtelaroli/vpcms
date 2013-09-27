<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="fragment" content="!" />
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title><decorator:title /> - VPls CMS</title>
<jsp:include page="./elements/head.jsp"></jsp:include>
<decorator:head />
</head>
<body data-ng-app="myApp" class="admin">
	<header>
		<jsp:include page="./elements/header.jsp"></jsp:include>
	</header>
	
	<section>
		<div class="row">
			<decorator:body />
		</div>
	</section>
	
	<footer>
		<jsp:include page="./elements/footer.jsp"></jsp:include>
	</footer>
	<jsp:include page="./elements/js.jsp"></jsp:include>
</body>
</html>