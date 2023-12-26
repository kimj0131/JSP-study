<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//	HashMap<String, String> users = new HashMap<>();
	HashMap<String, String> users = (HashMap)application.getAttribute("users");
	
	String id = request.getParameter("createId");
	String pw = request.getParameter("createPW");
	
	if (users.containsKey(id)){
		response.getWriter().append("<h2>이미 가입한 아이디입니다...</h2>");
	} else if (id.length() < 4) {
		response.getWriter().append("<h2>ID는 4자리 이상이어야 합니다...</h2>");
	} else if (pw.length() < 6){
		response.getWriter().append("<h2>비밀번호는 6자리 이상이어야 합니다...</h2>");
	} else {
		users.put(id, pw);
	
		application.setAttribute("users", users);
		
		response.getWriter().append("<h2>가입 완료</h2>");
	}
	response.setHeader("Refresh", "2; /chap04/quiz/index.jsp");
%>