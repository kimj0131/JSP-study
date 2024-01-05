<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>광고</title>
	</head>
	<body>
		<c:url value="/asset/img/kobaco 광고.jpg" var="promoImg" />

		<img src="${promoImg}" alt="광고" width="500" />

		<div><input id="nm_pm_chk" name="nm_pm" type="checkbox" /> 30초동안 보이지 않음</div>
	</body>

	<script>
		const nmPm = document.querySelector("#nm_pm_chk");

		nmPm.addEventListener("click", (e) => {
			// 체크박스는 checked라는 속성을 통해 체크 여부를 판단할 수 있다.
			console.log(nmPm.checked);

			if (nmPm.checked) {
				console.log("체크가 되었습니다");

				// 클라이언트 측에서 직접 30초짜리 쿠키 추가
				document.cookie = "nmpm2=1; max-age=30; path=/chap09/quiz_ans";
				window.close();

				// 서버측으로 보내서 30초짜리 쿠키 추가
				// location.href = "nmpm.jsp";
			}
		});
	</script>
</html>
