<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello의 뷰 페이지</title>
</head>
<body>
	
	
	<h3># 뷰 페이지를 WEB-INF밑에 넣으면 경로를 통한 파일 직접접근이 불가능해진다</h3>
	
	<p>하지만 포워드를 통해서는 접근할 수 있다</p>
	
	
	<%
		for (String emp : (Set<String>)request.getAttribute("result")){
			out.print(String.format("<div>%s</div>", emp));
		}
	%>
	
</body>
</html>