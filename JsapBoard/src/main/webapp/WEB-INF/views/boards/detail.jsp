<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>${detail.board_title}</title>
	</head>
	<body>
		<button onclick="location.href='./'">목록으로</button>

		<h3>조회 완료</h3>

		글 제목 : <input type="text" value="${detail.board_title}" readonly /> <br />
		글쓴사람 : <input type="text" value="${detail.board_writer}" readonly /> <br />
		조회수 ${detail.view_count} 작성일 : ${detail.write_date}<br />
		<textarea cols="30" rows="10" readonly>${detail.board_content}</textarea><br />

		<input id="inputPassword" type="password" name="board_password" placeholder="비밀번호" />
		<button id="modiBtn">수정하기</button>
		<button id="delBtn">삭제하기</button>
		<button id="delBtn2">삭제하기(팝업창)</button>

		<form action="./delete" method="post" id="delForm">
			<input type="hidden" name="board_id" value="${detail.board_id}" />
			<input type="hidden" name="check_password" value="${detail.board_password}" />
			<input id="hiddenPassword" type="hidden" name="board_password" />
		</form>

		<hr />

		<c:choose>
			<c:when test="${replies.size() == 0}">
				<div>※ 댓글이 아직 없습니다</div>
			</c:when>
			<c:when test="${replies.size() > 0}">
				<c:forEach items="${replies}" var="reply">
					<div>[${reply.reply_writer}] ${reply.reply_content} <span>${reply.reply_date}</span></div>
				</c:forEach>
			</c:when>
		</c:choose>

		<hr />

		<div id="replyWriteDiv">
			<textarea id="replyContent" name="reply_content" id="" cols="80" rows="5" form="replyForm"></textarea>
			<br />
			댓글쓴이<input id="replyWriter" type="text" name="reply_writer" form="replyForm" /> <br />
			비밀번호<input id="replyPassword" type="password" name="reply_password" form="replyForm" />
			<button id="replyWriteBtn" form="replyForm">댓글 쓰기</button>
		</div>

		<form id="replyForm" action="./reply/add" method="post">
			<input type="hidden" name="board_id" value="${detail.board_id}" />
		</form>

		<c:url value="/resources/board/js/detail.js" var="detailJS" />
		<c:url value="/resources/board/js/detailreply.js" var="detailreplyJS" />
		<c:url value="/resources/board/js/sha256.js" var="sha256JS" />
		<script>
			const boardPassword = "${detail.board_password}";
			const board_id = ${detail.board_id};
		</script>
		<script src="${sha256JS}"></script>
		<script src="${detailJS}"></script>
		<script src="${detailreplyJS}"></script>
	</body>
</html>
