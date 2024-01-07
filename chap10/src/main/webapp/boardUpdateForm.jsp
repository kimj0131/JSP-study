<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>게시글 수정</title>
		<style>
			#board-warp {
				/* box-sizing: border-box; */
				width: 800px;
				height: 500px;
				/* border: 1px solid black; */
			}

			textarea {
				resize: none;
			}
		</style>
	</head>
	<body>
		<c:url value="/" var="boardListURL" />
		<button onclick="location.href = '${boardListURL}'">돌아가기</button>

		<h3>게시글 수정</h3>

		<br />
		<div id="board-warp">
			<form action="<%=request.getContextPath()%>/board/update" method="post">
				<input type="reset" value="되돌리기" />
				<input type="submit" value="수정완료" />
				<hr />
				<div>
					<input name="board_idx" type="number" value="${board.board_idx}" hidden />
					작성자 : <input name="write_name" type="text" value="${board.write_name}" disabled />
				</div>
				<hr />
				<div>
					제목 : <input name="board_title" type="text" value="${board.board_title}" style="width: 680px" />
					<br />
					<br />
					<textarea name="board_content" rows="20" cols="105">${board.board_content}</textarea>
				</div>
			</form>
		</div>
	</body>
</html>
