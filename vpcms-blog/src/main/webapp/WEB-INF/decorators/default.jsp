<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="fragment" content="!" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><decorator:title /> - VPls CMS</title>
<jsp:include page="./elements/head.jsp"></jsp:include>
<decorator:head />
</head>
<body data-ng-app="VPlus">
	<header>
		<jsp:include page="./elements/header.jsp"></jsp:include>
		<jsp:include page="./elements/menu.jsp"></jsp:include>
	</header>

	<decorator:body />

	<footer>
		<jsp:include page="./elements/footer.jsp"></jsp:include>
	</footer>
	<jsp:include page="./elements/js.jsp"></jsp:include>
</body>
</html>