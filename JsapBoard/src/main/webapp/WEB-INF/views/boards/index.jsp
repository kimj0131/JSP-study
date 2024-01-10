<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>게시판</title>
	</head>
	<body>
		<h1>board list!</h1>

		<table border="3">
			<tr>
				<th>No</th>
				<th>Title</th>
				<th>Writer</th>
				<th>Timestamp</th>
				<th>View</th>
				<th>Replies</th>
			</tr>
			<c:forEach items="${boards}" var="board">
				<tr>
					<td>${board.board_id}</td>
					<td><a href="./detail?board_id=${board.board_id}">${board.board_title}</a></td>
					<td>${board.board_writer}</td>
					<td>${board.write_date}</td>
					<td>${board.view_count}</td>
					<td>${replySizes.get(board.board_id)}</td>
				</tr>
			</c:forEach>
		</table>

		<button id="writeBtn">글쓰기</button>

		<c:url value="/resources/board/js/index.js" var="indexJS" />
		<c:url value="./write" var="writePageURL" />

		<script>
			// js에서 jstl을 사용하는 법
			const writePageURL = "${writePageURL}";
		</script>
		<script src="${indexJS}"></script>
	</body>
</html>
