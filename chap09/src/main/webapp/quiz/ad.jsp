<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>광고창</title>
	</head>
	<body>
		<div style="font-size: 13px">
			<div>
				<img src="../asset/img/kobaco 광고.jpg" alt="코바코 광고사진" width="500" />
			</div>

			<label for="chk1">30초 동안 창닫기</label> <input type="checkbox" id="chk1" name="adCookie" />
		</div>

		<script src="<%=request.getContextPath()%>/asset/js/quiz/ad.js"></script>
	</body>
</html>
