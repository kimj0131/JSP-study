<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	// 이런식으로 JSP를 사용하면 Servlet과 다를바가 없다 )
	
	
	
	// request.getRequestDispatcher("/forward/page1.jsp").forward(request, response);
%>

<%-- JSP 문법으로 forward 하기 --%>
<jsp:forward page="/forward/page1.jsp"/>