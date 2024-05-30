<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 	<head>
	    <title>index</title>
	    <link rel="stylesheet" href="css/style.css">
 	</head>

	<body>
		<%-- jsp의 액션요소 중 다른 jsp의 결과를 포함시키는 요소: include --%>
		<jsp:include page="menu.jsp" />
		<%-- 현 위치에 menu.jsp의 실행결과(html)을 가져온다. --%>
	</body>
</html>