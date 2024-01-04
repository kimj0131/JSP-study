<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>퀴즈</title>
	</head>
	<body>
		<h3># Quiz</h3>

		<ul>
			<li>이 페이지에 접속할 때 광고창이 하나 뜨게 만들어주세요</li>
			<li>광고창에는 적당한 이미지 하나와 체크박스 버튼이 있어야 함</li>
			<li>체크 박스를 체크하고 창을 닫으면 30초 동안 이 페이지에 접속하더라도 광고창이 뜨지 않음</li>
		</ul>

		<script src="<%=request.getContextPath()%>/asset/js/quiz/index.js"></script>
	</body>
</html>
