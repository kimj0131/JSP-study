<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("nmpm", "1");
	cookie.setMaxAge(30);
	cookie.setHttpOnly(true);
	response.addCookie(cookie);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>blank</title>
	</head>
	<body>
		<script>
			close();
		</script>
	</body>
</html>
