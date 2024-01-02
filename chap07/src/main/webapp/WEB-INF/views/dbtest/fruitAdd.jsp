<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Add Fruit</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/dbtest/css/fruitList.css" />
	</head>
	<body>
		<button onclick="location='<%=request.getContextPath()%>'">초기화면으로</button>
		<hr />

		<iframe src="./fruitList" width="100%" height="300" frameborder="1"></iframe>

		<h3># Add Fruit</h3>

		<form action="<%=request.getContextPath()%>/addFruitDB" method="post">
			<input id="input" type="text" name="fruit-name" placeholder="과일이름" />
			<input id="input" type="text" name="fruit-price" placeholder="가격" />
			<input id="input" type="text" name="fruit-grade" placeholder="등급" /> <br />
			<button type="submit">추가하기</button>
		</form>
	</body>
</html>
