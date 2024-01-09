<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>글 수정하기</title>
	</head>
	<body>
		<h3>글 수정하기</h3>

		글 제목 : <input name="board_title" type="text" value="${oldData.board_title}" form="modiForm" /> <br />
		글쓴사람 : ${oldData.board_writer} <br />
		조회수 ${oldData.view_count} 작성일 : ${oldData.write_date}<br />
		<textarea name="board_content" cols="30" rows="10" form="modiForm">${oldData.board_content}</textarea><br />

		<button id="modiConfirmBtn">수정</button>
		<button id="listBtn">목록</button>

		<!-- POST방식은 ?id=10 같은 방식으로 파라미터를 보낼 수 없어서 hidden타입 input을 사용해서 보낸다 -->
		<input type="hidden" name="board_id" value="${oldData.board_id}" form="modiForm" />
		<form id="modiForm" action="./modify" method="post"></form>

		<c:url value="/resources/board/js/modi.js" var="modiJS" />
		<script src="${modiJS}"></script>
	</body>
</html>
