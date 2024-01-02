<%@page import="java.util.List"%>
<%@page import="chap07.dto.BreadDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Bread List</title>
	</head>
	<body>
		<h3># All bread</h3>

		<div>
            <%
                for(BreadDTO bread : (List<BreadDTO>)request.getAttribute("breads")){
                    out.print(String.format("<div>%s</div><div>%d</div>", 
                        bread.getBread_name(), bread.getBread_price()));
                }
            %>
        </div>
	</body>
</html>
