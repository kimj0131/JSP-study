<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>${boardDetail.board_title}</title>
		<style>
			#board-warp {
				box-sizing: border-box;
				width: 800px;
				height: auto;
				/* border: 1px solid black; */
			}

			#board-info > div {
				height: 21px;
				border-bottom: 1px solid black;
				padding-left: 5px;
				margin-top: 3px;
			}

			#board-content {
				height: 90%;
				background-color: #ccc;
				padding: 5px;
			}
		</style>
	</head>
	<body>
		<c:url value="/" var="boardListURL" />
		<c:url value="/board/updateForm" var="boardUpdateURL" />
		<c:url value="/board/deleteForm" var="boardDeleteURL" />
		<button onclick="location.href = '${boardListURL}'">처음으로</button>
		<hr />

		<form action="${boardUpdateURL}" method="post">
			<input name="update_idx" type="number" value="${boardIdx}" hidden />
			<input name="update_chk_pwd" type="password" placeholder="게시글 비밀번호를 입력" />
			<button type="submit">수정하기</button>
		</form>

		<form action="${boardDeleteURL}" method="post">
			<input name="del_idx" type="number" value="${boardIdx}" hidden />
			<input name="del_chk_pwd" type="password" placeholder="게시글 비밀번호를 입력" />
			<button type="submit">삭제하기</button>
		</form>
		<hr />
		<div id="board-warp">
			<div id="board-info">
				<div>제목 : ${boardDetail.board_title}</div>
				<div>작성자 : ${boardDetail.write_name}</div>
			</div>
			<div id="board-content">${boardDetail.board_content}</div>
		</div>
		<hr />
		<div id="comment-warp">
			<div id="comment-list"><span>작성자칸</span><span> : </span><span>내용칸</span></div>
		</div>
	</body>
</html>
