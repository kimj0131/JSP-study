<%@page import="java.util.ArrayList"%>
<%@page import="chap08.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	ArrayList<Student> stus = new ArrayList<>();

	// DB에서 학생 여러 행을 조회한 데이터라고 가정
	stus.add(new Student("A123", "김자바", 20, 80, 80, 80));
	stus.add(new Student("A234", "박이썬", 20, 70, 80, 80));
	stus.add(new Student("A555", "최씨플", 20, 80, 50, 80));
	stus.add(new Student("A611", "고틀린", 20, 80, 89, 80));
	stus.add(new Student("A991", "김고", 20, 80, 99, 100));
	
	pageContext.setAttribute("students", stus);

	Student stu = new Student();
	
	// DB에서 학생 한명을 조회한 데이터라고 가정
	stu.setStu_age(15);
	stu.setStu_id("STU1234");
	stu.setStu_name("김말이");
	stu.setStu_kor(100);
	stu.setStu_eng(80);
	stu.setStu_math(70);
	
	pageContext.setAttribute("stu1", stu);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>EL</title>
	</head>
	<body>
		<h3># JSP Expression Language(EL)</h3>

		<ul>
			<li>JSP에서 어트리뷰트에 실려있는 값들을 간단하게 꺼내 쓸 수 있는 문법</li>
			<li>문법의 생김새가 JavaScript의 format string과 똑같이 생겨서 JSP내부에서는 충돌이 발생한다</li>
			<li>어트리뷰트에 객체가 들어있는 경우 해당 객체의 getter를 통해 속성을 꺼내 사용할 수 있다</li>
			<li>여러 영역에 어트리뷰트가 같은 이름으로 등록되어 있는 경우 기본적으로 가장 좁은 범위의 어트리뷰트를 사용한다 
				(page -> request -> session -> application 순)</li>
			
		</ul>
		
		<h5># EL로 객체를 호출해 사용하는 경우</h5>
		
		<ul>
			<li>객체를 그냥 출력하는 경우 해당 객체의 toString()을 호출해 사용한다</li>
			<li>해당 객체에 .을 찍고 속성을 호출하면 실제로는 해당 객체의 Getter 메서드를 호출하여 사용한다</li>
			<li>${stu1}</li>
			<!-- 실제로는 getter를 호출하여 사용한다 -->
			<li>${stu1.stu_name }</li>
			<li>${stu1.stu_kor }</li>
			<li>${stu1.stu_math }</li>
			<li>${stu1.avg }</li>
		</ul>

		<h5># 반복문과 함께 활용해보기</h5>
		
		<table border="1">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>나이</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
			</tr>
		
			<core:forEach items="${students}" var="student">
			<tr>
				<td>${student.stu_id }</td>
				<td>${student.stu_name }</td>
				<td>${student.stu_age }</td>
				<td>${student.stu_kor }</td>
				<td>${student.stu_eng }</td>
				<td>${student.stu_math }</td>
			</tr>
			</core:forEach>
		</table>
		
		<h5># EL의 리터럴</h5>
		
		<ul>
			<li>정수 : ${123}, ${10 * 10}, ${123 + 456}</li>
			<li>실수 : ${123.1234}, ${123.1234 * 5}</li>
			<li>문자열 : ${'Hello!!'}, ${"문자열!"}, ${"${food}"}</li>
			<li>boolean : ${true}, ${false}</li>
		</ul>
		
		<h5># EL의 연산자</h5>
		
		<ul>
			<li>산술 연산자 : +, -, *, /, %, mod</li>
			<li>비교 연산자 : ==, !=, eq, ne, lt, gt, le, ge, 부등호</li>
			<li>논리 연산자 : and, or, not, &&, ||, !</li>
			<li>empty : 해당 값이 null 또는 ""일때 true</li>
		</ul>
		
		<core:set var="a" value="80"/>
		<core:set var="b" value="7"/>
		<core:set var="f" value="banana"/>
		<core:set var="h" value="null"/>
		<% pageContext.setAttribute("j", null); %>
		
		<!-- EL로 계산이 어느정도 가능하지만.. 포워딩으로 JSP에 오기 전에 모든 계싼을 끝내는편이 좋다 -->
		<div>${a + b}, ${a - b}, ${a * b}, ${a / b}, ${a % b}, ${a mod b}</div>
		<div>${a == b}, ${a eq b}, ${a != b}, ${a ne b},
		 ${10 < 7}, ${10 lt 7}, ${10 > 7}, ${10 gt 7},
		 ${10 <= 7}, ${10 le 7}, ${10 >= 7}, ${10 ge 7}</div>
		<div>${a == b and a % 2 == 0}, ${a == 10}, ${not(a == 10)}</div>
		<div>${empty f}, ${empty g}, ${empty h}, ${empty j}</div>
		<div>필요한 사과 바구니 개수 : ${a % 10 eq 0 ? a / 10 : a / 10 + 1}</div>
				 
		<core:set var="food" value="파스타"/>
		<script>
			const food = '육개장';
			console.log(`오늘 메뉴는 ${food}입니다`);
			console.log(`오늘 메뉴는 ${'${food}'}입니다`);
		</script>
	</body>
</html>
