<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	System.out.println(session.getAttribute("info"));
	// 이미 로그인된 상태라면 메모 페이지로 리다이렉트
	if(session.getAttribute("info") != null){
		response.sendRedirect("/chap04/quiz_ans/memo/main");
		return;
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>로그인 하는 곳</title>
	</head>
	<body>
		<h3># 로그인</h3>

		<!-- form 속성(폼태그는 id속성)을 통해 직접 폼태그로 감싸지 않아도 적용시킬 수 있다 -->
		ID : <input type="text" form="form1" name="id" /> <br />
		PASSWORD : <input type="password" form="form1" name="pwd" /> <br />
		<button type="submit" form="form1">로그인</button>

		<!-- form태그 밖에 있는 요소들도 이 폼의 소속으로 설정할 수 있다 -->
		<form id="form1" action="/chap04/quiz_ans/login" method="post"></form>
	</body>
</html>
