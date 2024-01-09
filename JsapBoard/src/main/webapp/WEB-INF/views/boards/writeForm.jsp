<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>글쓰기 페이지</title>
	</head>
	<body>
		<h3>글쓰기</h3>

		<form action="./write" method="post" id="writeForm">
			글 제목 : <input type="text" name="board_title" id="" /> <br />
			글쓴이 : <input type="text" name="board_writer" /> 글 비밀번호 :
			<input type="password" name="board_password" /> <br />
			<textarea name="board_content" id="" cols="30" rows="10"></textarea>
		</form>
		<button type="submit" form="writeForm">글쓰기</button>
		<button onclick="location.href = './'">글 목록</button>
	</body>
</html>
