<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>회원가입 양식</title>
	</head>
	<body>
		<h3>회원가입</h3>

		<!-- 서블릿 사용 -->
		<form action="/chap04/quiz_ans/register" method="post">
			ID <input type="text" name="id" /> <br />
			PASSWORD <input type="password" name="pwd" /> <br />
			<input type="submit" value="가입하기" />
		</form>
	</body>
</html>
