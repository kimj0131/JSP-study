<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키는 웹 브라우저에 저장하는 값이기 때문에 문자열만 보관 가능하다
	Cookie cookie = new Cookie("age", "21-50");	// 1. 기본 쿠키 (maxAge >> 브라우저 종료시까지 유지된다)
	
	Cookie cookie2 = new Cookie("fav", "drama"); // 2. 직접 설정한 쿠키
	cookie2.setMaxAge(600); // 10초(단위 = 초)
	cookie2.setHttpOnly(true); // 자바스크립트에서 이 쿠키를 사용하지 못하도록 한다(보안상 필요)	
	cookie2.setPath("/chap09"); // 해당 쿠키가 적용되는 범위를 설정
	cookie2.setValue("comedy"); // 값을 변경하는 것은 가능하다(쿠키 이름은 변경 불가)
	
	// 쿠키는 응답에 실어 보내야 클라이언트측에 반영된다
	response.addCookie(cookie);
	response.addCookie(cookie2);
	response.sendRedirect(request.getContextPath() + "/cookie/index.jsp");
%>
