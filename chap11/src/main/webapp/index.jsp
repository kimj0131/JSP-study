<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>File Include</title>
	</head>
	<body>
		<h3># include 기능을 사용해 뷰 파일 분할하기</h3>

		<ol>
			<li>
				JSP Include : 포워드 처럼 request와 response를 다른 jsp로 그대로 전달하여 처리를 진행한 후에 다시
				돌아오는 기능. 다른 페이지로 잠깐 갔다가 다시 돌아오는 기능이기 때문에 include하는 페이지에서는
				pageScope의 값을 사용할 수 없다.
			</li>
			<li>
				File Include : 해당 파일을 컴파일하기 전에 통째로 현재 페이지에 포함해버리는 방식. 다른 파일과 하나로
				합쳐진 후 컴파일되기 때문에 pageScope가 유효하다.
			</li>
		</ol>

		<a href="./include1/index.jsp">JSP include</a> <br />
		<a href="./include2/index.jsp">File include</a>
	</body>
</html>
