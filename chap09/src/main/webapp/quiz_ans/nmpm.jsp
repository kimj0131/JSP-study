<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 서버측에서 쿠키 추가하기
	
	Cookie cookie = new Cookie("nmpm", "1");
	cookie.setMaxAge(30);
	cookie.setHttpOnly(true); 
	// ※ HttpOnly : 보안상의 이유로 자바스크립트측에서 사용할 수 없게 한다.
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
