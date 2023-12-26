<%@page import="java.util.List"%> 
<%@page import="java.util.ArrayList"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>노트패드</title>
	</head>
	<body>
		<h3 id="idField"></h3>

		<br />

		<button id="logoutBtn">로그아웃</button>

		<hr />

		<h3>노트</h3>

		<form action="/chap04/quiz/notepadSave.jsp" method="post">
			<textarea name="note" id="notepadArea" cols="50" rows="20"></textarea> <br />
			<!-- <input id="notepad" name="note" type="text" style="width: 300px" /> <br /> -->
			<br />
			<input id="noteSaveInput" type="submit" value="저장" />
		</form>

		<hr />

		<h3>작성한 노트 목록</h3>
		
		<div id="noteList">
			<%
				String userId = session.getAttribute("loginId").toString();
				List<String> noteList = (ArrayList)application.getAttribute(userId);
				
				for (int i = 0; i < noteList.size(); i++){
					out.print("<div>" + i + "번 노트 : " + noteList.get(i) + "</div>");
					out.print("\n");
				}
			%>
		</div>
		
		<script>
			const userId = '<%=session.getAttribute("loginId") %>';
			const idField = document.getElementById("idField");
			idField.textContent = '"' + userId + '"의 노트';

			const logoutBtn = document.getElementById('logoutBtn');
			logoutBtn.addEventListener('click', (e) =>{
				location.href = "/chap04/quiz/logout.jsp";
			});

			const notepad = document.getElementById("notepad");
			const noteSaveInput = document.getElementById("noteSaveInput");
			// notepad.focus();

			noteSaveInput.addEventListener("click", (e) => {
				location.href = "/chap04/quiz/notepadSave.jsp";//?note=" + notepad.value; // + "&scope=application";
			});

		</script>
	</body>
</html>
