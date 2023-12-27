<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>메모 메인페이지</title>
	</head>
	<body>
		<h1>Memo Main</h1>

		<div>
			<%
				java.util.Map<String, Object> infoMap = (java.util.Map) session.getAttribute("info");
	
				java.util.List<String> memoList = (java.util.List) infoMap.get("memoList");
	
				if (memoList == null) {
					out.print("<div>메모가 아직 없습니다.</div>");
				} else {
	
					for (String memo : memoList) {
						out.print(String.format("<div class=\"memo\">%s</div>", memo));
					}
	
				}
			%>
		</div>

		<form action="./add" method="post">
			<input name="memo" type="text" /><button>추가</button>
		</form>
	</body>
</html>
