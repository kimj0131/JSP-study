<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>새 게시글 작성</title>
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

		<h3>새 게시글 작성</h3>

		<!-- <div>게시 번호 : ${nextBoard_idx}</div> -->
		<br />
		<div id="board-warp">
			<form action="<%=request.getContextPath()%>/board/write" method="post">
				<input type="reset" value="내용 지우기" />
				<input type="submit" value="등록하기" />
				<hr />
				<div>
					<input name="board_idx" type="number" value="${nextBoard_idx}" hidden />
					<input name="write_name" type="text" placeholder="작성자이름" />
					※ 글 비밀번호 : <input name="write_passward" type="password" placeholder="비밀번호" />
				</div>
				<hr />
				<div>
					<input name="board_title" type="text" placeholder="제목을 입력해 주세요" style="width: 780px" />
					<br />
					<br />
					<textarea name="board_content" placeholder="게시글 내용" rows="20" cols="105"></textarea>
				</div>
			</form>
		</div>
	</body>
</html>
