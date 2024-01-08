<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Insert title here</title>
	</head>
	<body>
		<h3>조회 완료</h3>

		글 제목 : <input type="text" value="${detail.board_title}" readonly /> <br />
		글쓴사람 : <input type="text" value="${detail.board_writer}" readonly /> <br />
		조회수 ${detail.view_count} 작성일 : ${detail.write_date}<br />
		<textarea cols="30" rows="10" readonly>${detail.board_content}</textarea><br />
	</body>
</html>
