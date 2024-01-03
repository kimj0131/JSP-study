<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>사원 검색 해보기</title>
	</head>
	<body>
		<h3># Search</h3>

		<ul>
			<li>검색을 통해 사원들을 조회할 수 있는 페이지를 만들어 보세요</li>
			<li>검색할 수 있는 컬럼 : first_name, last_name, department_name</li>
			<li>검색어를 직접 입력하고 검색 버튼을 누르면 사원들이 조회되어야 합니다</li>
		</ul>

		<hr />
		
		<h5># 검색할 속성을 하나만 입력 (대소문자 구분)</h5>
		
		<c:url value="/empSearch" var="search" />
		<form action="${search}" method="post">
			first_name : <input type="text" name="first_name" placeholder="first_name" /> <br />
			last_name : <input type="text" name="last_name" placeholder="last_name" /> <br />
			department_name : <input type="text" name="department_name" placeholder="department_name" /> <br />
			<input type="submit" value="검색" />
		</form>

		<table class="search-result" border="1">
			<tr>
				<td>employee_id</td>
				<td>first_name</td>
				<td>last_name</td>
				<td>salary	</td>
				<td>commission_pct</td>
				<td>hire_date</td>
				<td>job_id</td>
				<td>manager_id</td>
				<td>department_id</td>
			</tr>
			
			<c:choose>
				<c:when test="${employees == null}">
					<tr>
						<td colspan="9" style="text-align: center">데이터 없음</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${employees}" var="emp">
					<tr>
						<td>${emp.employee_id}</td>
						<td>${emp.first_name}</td>
						<td>${emp.last_name}</td>
						<td>${emp.salary}</td>
						<td>${emp.commission_pct}</td>
						<td>${emp.hire_date}</td>
						<td>${emp.job_id}</td>
						<td>${emp.manager_id}</td>
						<td>${emp.department_id}</td>
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
		</table>
	</body>
</html>
