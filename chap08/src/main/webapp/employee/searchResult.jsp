<%@page import="chap08.dao.EmployeeDao_ans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String searchQuery = request.getParameter("searchQuery");
	String searchType = request.getParameter("searchType");
	
	System.out.println(searchQuery);
	System.out.println(searchType);
	
	EmployeeDao_ans dao = new EmployeeDao_ans();
	
	request.setAttribute("emps", dao.search(searchType, searchQuery));
%>

<!-- forwward() -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>검색 결과</title>
	</head>
	<body>
		<h3># 검색 결과</h3>
		
		<c:forEach items="${emps}" var="emp">
			<div>${emp}</div>
		</c:forEach>
		
	</body>
</html>
