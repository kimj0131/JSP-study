<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./taglibs.jspf" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Insert title here</title>
	</head>
	<body>
	
	<h3># file include</h3>
	
	<p>파일로 include하는 경우 해당 파일의 내용을 현재 .jsp파일로 통째로 가져와서 사용한다</p>
	
	<p>포함하려하는 파일은 컴파일하지 않기 때문에 jsp 컴파일 형식을 지키지 않아도 된다.</p>
	
	<p>가져오는 파일은 컴파일되지 않는다고 표시하기 위해 .jspf(jsp fragment)확장자를 사용하기도 한다.</p>
	
	<div id="gogodan">
		<%@ include file="./gugudan.jspf" %>
	</div>
	
	<h3>for</h3>
	
	<ul>
		<c:forEach begin="0" end="9" var="i">
			<li id="item${i}">list-item${i}</li>
		</c:forEach>
	</ul>
	
	</body>
</html>
