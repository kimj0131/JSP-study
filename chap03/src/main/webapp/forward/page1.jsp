<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>page1</title>
	</head>
	<body>
		<h3>page1.jsp</h3>

		<p>
			<%=request.getParameter("firstName") %> <br />
			<% out.print(request.getParameter("lastName")); %> <br />
		</p>
	</body>
</html>
