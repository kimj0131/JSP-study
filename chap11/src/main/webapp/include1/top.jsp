<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8" />
		<title>Insert title here</title>
		<c:set var="fruit" value="apple" scope="page"/>
		<script>
			const a = 10;
			const b = '${fruit}';
		</script>
	</head>
	<body>
			
		<a href="./index.jsp">index</a> /
		<a href="./menu.jsp">메뉴</a> /