<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3># JSP</h3>

	<ul>
		<li>Java Server Pages(JSP)</li>
		<li>동적 웹 페이지를 생성하기 위한 Java API</li>
		<li>HTML안에 자바 코드를 활용하여 상황에 따라 변하는 웹페이지를 만들 수 있다</li>
	</ul>

	<h3># Web Server(Apache)</h3>

	<ul>
		<li>요청이 오면 URI에 해당하는 알맞은 자원을 응답하는 프로그램</li>
		<li>.html 파일을 요청 -> .html 파일을 응답</li>
		<li>그림 파일을 요청 -> 그림 파일을 응답</li>
		<li>정적 컨텐츠 처리</li>
	</ul>

	<h3># Web Application Server(Apache-Tomcat)</h3>

	<ul>
		<li>jsp 파일을 요청 -> Java 해석 및 실행 -> .html 파일 생성 -> 응답</li>
		<li>단순 응답이 아닌 상황에 따라 변화하는 동적 페이지 처리를 담당한다</li>
		<li>Apache-Tomcat이 JSP의 해석을 담당하는 프로그램이다</li>
	</ul>

	<%-- JSP 주석 --%>

	<%-- JSP Script --%>

	<%--
	
		<%  %> : 해당 영역 내부에서 자바 코드를 사용할 수 있다 (메서드 내부의 영역)
		<%= %> : 자바에 있는 값을 HTML로 출력할 수 있다 (out.print의 축약형)
		<%! %> : 메서드를 선언할 수 있다 (클래스 내부의 인스턴스 영역)
		<%@ %> : 현재 페이지를 설정할 수 있다
		
	 --%>

	<%
	String str = "Hello, JSP!";
	String firstName = "Smite";

	for (int i = 0; i < 10; i++) {
		System.out.println(str + i);	
	}
	
	// java.sql.DriverManager.getConnection();
	
	out.print("<div>" + str + "</div>");	// 자바에서 웹 페이지로 값을 내보낼 수 있다
	out.print(rabbit());
	
	
	// 자바를 써야하는 이유 : DB에서 꺼낸 값을 웹에 뿌리기 위해 
	// => DB에서 꺼낸 값을 웹 페이지로 내보낼 수 있다.
	// (자바스크립트는 DB에 직접 접근할 수 없음 >> 웹에서만 동작하는 언어이기 떄문에)
	%>
	
	
	<%!
	// <pre> : 웹 페이지내에서 텍스트의 모양을 그대로 유지할 수 있는 태그
	public String rabbit() {
		return "<pre>"
			+	" /)/)\n"
			+  "(  ..)\n"
			+  "(   >$\n</pre>";
	}
	
	%>
	
	<%
		out.print("<div id=\""+ firstName + "\">" + firstName + "</div>");
	%>
	<div id="<%=firstName%>"><%=firstName%></div>
	
	<h3># .jsp 파일의 처리 순서</h3>
	
	<ol>
		<li>.jsp 파일은 우선 .java 파일로 변환된다 (1차 컴파일)</li>
		<li>변환된 .java 파일을 컴파일 한다 (2차 컴파일)</li>
		<li>컴파일된 결과물은 웹 컨텍스트(Tomcat)에 등록되어 사용자의 요청을 기다린다</li>
		<li>사용자가 요청하면 웹 컨텍스트에 등록된 결과물을 실행하여 응답한다</li>
	</ol>
	
</body>
</html>