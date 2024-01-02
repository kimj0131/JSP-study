<%@page import="java.util.List"%>
<%@page import="chap07.dto.FruitDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Fruits list</title>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/dbtest/css/fruitList.css">
	</head>
	<body>
		
		<h3># All Fruits</h3>

		<div class="fruit-list">
            <div id="col-name">[과일이름]</div>
            <div id="col-name">[가격]</div>
            <div id="col-name">[등급]</div>
		<%
			Object fruits = request.getAttribute("fruits");
		
			if (fruits != null){
				for (FruitDTO fruit : (List<FruitDTO>)fruits) {
					out.print(fruit.getDivRow());
				}
			} else {
				out.print("<div>No fruits here.</div>");
			}
			
		%>
		</div>
	</body>
</html>
