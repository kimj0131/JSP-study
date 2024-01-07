<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>숙제</title>
		<!-- <link rel="stylesheet" href="/asset/css/board.css" /> -->
		<style>
			#board {
				width: 1000px;
				/* border: 1px black solid; */
			}

			#board-head1 {
				width: 100px;
				border-bottom: 1px black solid;
			}

			#board-head2 {
				width: 200px;
				border-bottom: 1px black solid;
			}

			#board-head3 {
				width: 700px;
				border-bottom: 1px black solid;
			}

			#board-body {
				border-radius: 10px;
				text-align: center;
				background-color: #ccc;
			}
		</style>
	</head>
	<body>
		<c:if test="${writeErr}">
			<script>
				alert("게시글 작성에 실패했습니다");
				location.href = "../";
			</script>
		</c:if>
		<c:if test="${pwdErr}">
			<script>
				alert("비밀번호가 다릅니다.");
				location.href = "../";
			</script>
		</c:if>
		<c:if test="${updated}">
			<script>
				alert("수정 완료");
				location.href = "../";
			</script>
		</c:if>
		<c:if test="${deleted}">
			<script>
				alert("삭제 완료");
				location.href = "../";
			</script>
		</c:if>
		<h3># 게시판 만들어보기</h3>

		<ol>
			<li>DB에 게시판 정보를 담을 수 있는 테이블 구조를 설계한다</li>
			<li>필요한 기능은 댓글을 달 수 있는 게시판이다</li>
			<li>글을 쓸 때 해당 글에 대한 비밀번호 설정이 필요하다</li>
			<li>글을 수정/삭제할 때 해당 글의 비밀번호가 맞으면 수정/삭제가 가능하다</li>
			<li>글 비밀번호는 해쉬값으로 저장해야 한다</li>
			<li>글을 삭제하는경우 해당 글의 댓글들도 DB에서 함께 삭제되어야 한다.</li>
			<li>시간이 남으면 게시판의 디자인을 이쁘게 꾸며보자</li>
			<li>그래도 시간이 남으면 대댓글 기능을 어떻게 구현해야할지 생각해보자</li>
		</ol>

		<hr />
		<c:url value="/board/writeform" var="boardWriteURL" />
		<h3>게시글 목록</h3>
		<!-- 게시판 작성 링크 연결 버튼 or div -->
		<button onclick="location.href = '${boardWriteURL}'">게시글 작성하기</button>

		<hr />
		<c:url value="/board/detail" var="boardDetailURL" />
		<div id="board">
			<table>
				<thead>
					<tr>
						<th id="board-head1">글번호</th>
						<th id="board-head2">작성자</th>
						<th id="board-head3">글제목</th>
					</tr>
				</thead>
				<tbody>
					<!-- 이쪽에 DB데이터 받아서 리스트 출력 -->
					<c:forEach items="${boardTitleList}" var="board">
						<tr>
							<td id="board-body">${board.board_idx}</td>
							<td id="board-body">${board.write_name}</td>
							<td id="board-body">
								<a href="${boardDetailURL}?board_idx=${board.board_idx}">${board.board_title}</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>
