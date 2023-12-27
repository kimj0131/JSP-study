<%@page import="java.util.HashMap"%> <%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Quiz 풀이</title>
	</head>
	<body>
		<h3># 요구사항</h3>

		<ul>
			<li>아이디와 비밀번호를 입력하고 로그인 버튼을 눌러 로그인을 할 수 있다</li>
			<li>
				회원가입은 아이디와 비밀번호만 입력하면 완료된다 (아이디 중복은 체크해야한다, 가입된 정보는 application
				영역에 등록한다)
			</li>
			<li>로그인에 성공한 사람은 세션이 유지되는 동안 로그인이 계속해서 유지되어야 한다</li>
			<li>로그인 한 사람은 새로운 메모를 등록할 수 있고, 예전에 등록했던 메모들도 볼 수 있다</li>
			<li>서버를 재시작했을때 모든 회원정보 및 메모가 사라져도 상관 없다</li>
			<li>
				페이지 개수에 제한은 없으며 모든 내용은 quiz폴더 밑에 만들 것 (서블릿을 사용하고 싶다면 URL을 quiz로
				맞출 것)
			</li>
		</ul>

		<hr />

		<!-- 작성순서 -->
		<!-- 회원가입용 버튼 추가 > register 폼 작성 > application 객체에 ID 등록  -->
		<!-- > 로그인 버튼 추가 > 로그인 폼 작성 -->

		<button onclick="location.href='/chap04/quiz_ans/loginForm.jsp';">로그인 하러가기</button>

		<button onclick="location.href='/chap04/quiz_ans/registerForm.jsp';">회원가입</button>

		<h3># 모든 어트리뷰트 찍어보기</h3>
		<ul>
		<% 
			// scope.getAttributeNames() : 해당 영역의 모든 어트리뷰트 이름들을 꺼낼 수 있는 객체를 반환
		 	java.util.Enumeration<String> names = application.getAttributeNames(); 
		
			while (names.hasMoreElements()) {
				String name = names.nextElement();
				
				out.print(String.format("<li>%s=%s</li>", name, application.getAttribute(name)));
			}
		%>
		</ul>

		<script>
			// 이런식으로도 사용 가능
			// <% if(request.getParameter("error") != null) { %>
			//     alert('회원가입 실패!!');
			// <% } %>

			<%
				if(request.getParameter("error") != null) {
					if (request.getParameter("dup") != null) {
						out.print("alert('이미 사용중인 아이디입니다!')");
					} else {
						out.print("alert('회원가입 실패!!')");
					}
				}
			 %>
		</script>
	</body>
</html>
