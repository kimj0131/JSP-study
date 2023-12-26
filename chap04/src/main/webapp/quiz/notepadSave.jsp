<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	request.setCharacterEncoding("utf-8");

	String userId = session.getAttribute("loginId").toString();
	
	List<String> noteList = (ArrayList)application.getAttribute(userId);
	
	int noteListLen = noteList.size();
	String noteContent = request.getParameter("note");
	
	System.out.println(request.getParameter("note"));
	
	noteList.add(noteListLen++, noteContent);
	
	//request.getRequestDispatcher("/quiz/notepad.jsp").forward(request, response);
	response.sendRedirect("/chap04/quiz/notepad.jsp");
%>