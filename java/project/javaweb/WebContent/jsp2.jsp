<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>JSP 2</h1>
		userName= ${param.userName}
		<br>
		requestAttr= ${requestScope.requestAttr} ${requestAttr}
		<br>
		sessionAttr= ${sessionScope.sessionAttr} ${sessionAttr}
	</body>
</html>
