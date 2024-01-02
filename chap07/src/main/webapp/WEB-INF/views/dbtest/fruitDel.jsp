<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Delete Fruit</title>
	</head>
	<body>
		<button onclick="location='<%=request.getContextPath()%>'">초기화면으로</button>
		<hr />

		<iframe src="./fruitList" width="100%" height="300" frameborder="1"></iframe>

		<h3># Delete Fruit</h3>

		<form action="<%=request.getContextPath()%>/delFruitDB" method="post">
			<input id="input" type="text" name="fruit-name" placeholder="과일이름" />
			<button type="submit">삭제하기</button>
		</form>
	</body>
</html>
