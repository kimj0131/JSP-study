<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Attribute</title>
	</head>
	<body>
		<h3># Attribute</h3>

		<ul>
			<li>Parameter : 클라이언트의 form에서 서버측의 서블릿으로 보내는 데이터</li>
			<li>Attribute : 하나의 서블릿에서 다른 서블릿으로 전달할 수 있는 데이터 (forward를 염두에둔 데이터)</li>
			<li>각 Attribute는 종류별로 유요한 범위(Scope)가 존재하며 용도에 맞게 활용해야 한다</li>
			<li>종류로는 application, session, request, page가 있다</li>
		</ul>

		<h3># Attribute Scope</h3>

		<dl>
			<dt>1. application scope</dt>
			<dd>
				WAS에 저장해놓는 Attribute, 서버가 종료되기 전까지 계속 유지된다. 모든 서블릿에서 접근할 수 있다. (전역
				static 변수같은 느낌)
			</dd>
			<dt>2. session scope</dt>
			<dd>
				하나의 세션이 만료되기전까지 유지되는 Attribute, 각 클라이언트마다 각자의 세션을 가지고 있다. (서버에서
				제공해주는 개인 보관함)
			</dd>
			<dt>3. request scope</dt>
			<dd>
				하나의 요청이 만료되기전(요청에 대한 응답을 하기 전)까지 유지되는 Attribute, forward, include가 진행되는
				동안은 유지되기 때문에 다음 처리로 데이터를 전달하는 용도로 많이 사용된다. (redirect는 X) (매개 변수
				느낌)
			</dd>
			<dt>4. page scope</dt>
			<dd>
				해당 JSP 페이지 내부에서만 사용할 수 있는 Attribute, forward 또는 include로 다른 페이지로 넘어가는 경우
				사라진다. (지역 변수 느낌)
			</dd>
		</dl>

		<h3># 어트리뷰트 출력해보기</h3>

		<ul>
			<li>application : <%=application.getAttribute("food") %></li>
			<li>session : <%=session.getAttribute("food") %></li>
			<li>request : <%=request.getAttribute("food") %></li>
			<li>page : <%=pageContext.getAttribute("food") %></li>
		</ul>

		<input id="applicationInput" type="text" value="orange" name="food" />
		<button id="applicationBtn">application에 데이터 추가하기</button> <br />

		<input id="sessionInput" type="text" value="orange" name="food" />
		<button id="sessionBtn">session에 데이터 추가하기</button> <br />

		<input id="requestInput" type="text" value="orange" name="food" />
		<button id="requestBtn">request에 데이터 추가하기</button> <br />

		<input id="pageInput" type="text" value="orange" name="food" />
		<button id="pageBtn">page에 데이터 추가하기</button> <br />


		<div>
			<a href="/chap04/session/index.jsp">세션 정보 보러가기</a>
		</div>
        
		<script>
			const applicationBtn = document.getElementById("applicationBtn");
			const applicationInput = document.getElementById("applicationInput");

            applicationBtn.addEventListener('click', (e) => {
                location.href = '/chap04/attribute/add.jsp?food=' + applicationInput.value + '&scope=application';
            });

			const sessionBtn = document.getElementById('sessionBtn');
			const sessionInput = document.getElementById('sessionInput');

			sessionBtn.addEventListener('click', (e) => {
				location.href = '/chap04/attribute/add.jsp?food=' + sessionInput.value + '&scope=sesstion';
			});

			const requestBtn = document.getElementById('requestBtn');
			const requestInput = document.getElementById('requestInput');

			requestBtn.addEventListener('click', (e) => {
				location.href = '/chap04/attribute/add.jsp?food=' + requestInput.value + '&scope=request';
			});
			
			const pageBtn = document.getElementById('pageBtn');
			const pageInput = document.getElementById('pageInput');

			pageBtn.addEventListener('click', (e) => {
				location.href = '/chap04/attribute/add.jsp?food=' + pageInput.value + '&scope=pageContext';
			})
		</script>
	</body>
</html>
