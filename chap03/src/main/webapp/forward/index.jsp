<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Forward</title>
	</head>
	<body>
		<h3># Forward</h3>

		<ul>
			<li>사용자가 보낸 요청을 한 서블릿에서 일부 처리하고 다음 서블릿으로 넘겨 처리하는 것</li>
			<li>
				요청, 응답 객체를 그대로 다음 서블릿으로 전달하기 때문에 해당 요청에 실려있던 파라미터들도 그대로 함께
				전달된다
			</li>
		</ul>

		<h3># Forward의 용도</h3>

		<ul>
			<li>서블릿에서는 자바 코드를 만들기 편하고 .jsp파일에서는 HTML 코드 작성이 편하다</li>
			<li>
				하나의 요청에 대해 서블릿에서 1차로 자바에 관련된 모든 처리를 마친 후 포워드를 통해 2차로 .jsp페이지로
				넘겨 HTML 코드에 관한 처리를 마치는 방식을 많이 사용한다 (DB > java(servlet) > jsp 이런식으로)
			</li>
			<li>이것을 view와 controller의 분리라고 한다</li>
			<li>forward를 사용하면 실제 view페이지의 위치가 노출되지 않는다 (요청보낸 주소가 변하지 않는다)</li>
		</ul>

		<h3># forward Test1</h3>

		<form action="/chap03/forward/test/1" method="get">
			<input type="hidden" name="firstName" value="Smith" />
			<input type="hidden" name="lastName" value="King" />
			<input type="submit" value="보내기" />
		</form>

		<h3># forward Test2</h3>

		<p>JSP도 Servlet이기 때문에 form으로 요청 보내는 것이 가능하다</p>

		<form action="/chap03/forward/forwardTestJsp.jsp" method="get">
			<input type="hidden" name="firstName" value="Smith" />
			<input type="hidden" name="lastName" value="King" />
			<input type="submit" value="보내기" />
		</form>

		<h3># Redirect</h3>

		<ul>
			<li>요청을 받으면 해당 요청을 보낸 클라이언트에게 다른 주소로 다시 요청을 보내라고 응답하는 것</li>
			<li>
				리다이렉트는 새로운 요텅을 다시 보내는 것이기 때문에 이전 요청에 보냈던 파라미터는 기본적으로는 남아있을
				수 없다
			</li>
			<li>처음 요청보냈던 주소가 그대로 유지되지 않는다 (새로운 요청을 만드는 것이기 때문에)</li>
		</ul>

		<h3># redirect Test1</h3>

		<form action="/chap03/forward/test/2" method="get">
			<input type="hidden" name="firstName" value="Smith" />
			<input type="hidden" name="lastName" value="King" />
			<input type="submit" value="보내기" />
		</form>
	</body>
</html>
