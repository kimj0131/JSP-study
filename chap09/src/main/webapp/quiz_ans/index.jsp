<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>퀴즈</title>
	</head>
	<body>
		<h3># Quiz 풀이</h3>

		<ul>
			<li>이 페이지에 접속할 때 광고창이 하나 뜨게 만들어주세요</li>
			<li>광고창에는 적당한 이미지 하나와 체크박스 버튼이 있어야 함</li>
			<li>체크 박스를 체크하고 창을 닫으면 30초 동안 이 페이지에 접속하더라도 광고창이 뜨지 않음</li>
		</ul>

		<c:url value="/quiz_ans/promotion.jsp" var="pmURL" />

		<!-- JSP페이지 에서는 EL로 쿠키값을 쉽게 꺼내 쓸 수 있다 (cookie.쿠키이름.value != 쿠키값) -->
		<c:if test="${cookie.nmpm2.value != 1}">
			<script>
				// open할 때 내가 연 새창의 인스턴스를 반환한다.
				const a = open("${pmURL}", "_blank", "width=580, height=840, top=80, left=100");
				// a.close();
			</script>
		</c:if>
	</body>
</html>
