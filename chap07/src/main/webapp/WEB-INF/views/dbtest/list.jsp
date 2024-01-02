<%@page import="java.util.List"%>
<%@page import="chap07.dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Employee List</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/dbtest/css/empList.css">
	</head>
	<body>
		<h3># All Employees</h3>
		
		<div class="emp-list">
			<%
			Object employees = request.getAttribute("employees");
			
			if(employees != null){
				for(EmployeeDTO emp : (List<EmployeeDTO>) employees){
					out.print(emp.getDivRow());
				}
				
			} else {
				out.print("<div>No employees here.</div>");
			}
			
			%>
		</div>
	</body>
</html>
