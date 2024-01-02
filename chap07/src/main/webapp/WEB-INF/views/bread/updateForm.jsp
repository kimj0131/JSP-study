<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Update Bread Page!</title>
	</head>
	<body>
		<h3># 빵 수정 하기</h3>

		<form action="./update" method="post">
			수정할 빵 이름 : <input name="find_bread_name" type="text" /> <br />
			<hr />
			이름 : <input name="bread_name" type="text" /> <br />
			가격 : <input name="bread_price" type="number" min="0" step="100" value="1000" /> <br />
			<input type="submit" value="수정하기" />
		</form>
	</body>
</html>
