<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.getWriter().append("유저 목록 : " + application.getAttribute("users").toString());

	String loginId = request.getParameter("loginId");
	String loginPW = request.getParameter("loginPW");


	HashMap<String, String> users = (HashMap)application.getAttribute("users");

	String compareId = users.get(loginId);
	
	if (compareId == null || compareId.equals(loginPW) == false){
		response.getWriter().append("<h2>ID 또는 비밀번호가 잘못되었습니다...</h2>");
		response.setHeader("Refresh", "2; /chap04/quiz/index.jsp");
	} else {
		response.getWriter().append("<h2>로그인 성공</h2>");
		
		if (application.getAttribute(loginId) == null) {
			Map<String, Object> userNote = new HashMap<>();
			
			List<String> noteList = new ArrayList<>();
				
			userNote.put(loginId, noteList);
			
			application.setAttribute(loginId, userNote.get(loginId));
		}

		session.setMaxInactiveInterval(3600);
		session.setAttribute("loginId", loginId);
		response.setHeader("Refresh", "1; /chap04/quiz/notepad.jsp");
		//request.getRequestDispatcher("/quiz/notepad.jsp").forward(request, response);
	}
%>