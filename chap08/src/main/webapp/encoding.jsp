<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>한글 사용하기</title>
	</head>
	<body>
		<h3># JSP의 여러가지 charset 설정</h3>

		<dl>
			<dt>1. meta 태그의 charset</dt>
			<dd>이 페이지를 읽게되는 클라이언트의 웹브라우저가 이 페이지를 해석할 때 사용할 charset 설정</dd>
			<dt>2. contentType의 chartset</dt>
			<dd>이 서블릿에서 응답하는 결과물의 종류 및 charset설정</dd>
			<dt>3. pageEncoding의 charset</dt>
			<dd>.jsp로 작성한 코드를 .java로 변환할 때의 charset</dd>
			<dt>4. 현재 파일에서 사용하고 있는 charset</dt>
			<dd>
				우리가 Ctrl + S를 눌러서 이클립스를 통해 하드디스크에 저장할 때 사용하는 charset 현재파일 우클릭 후
				properties에서 확인할 수 있다
			</dd>
			<dt>5. server.xml의 URIEncoding</dt>
			<dd>GET 방식 파라미터가 다시 문자로 합쳐질 때 사용할 charset을 설정</dd>
			<dt>6. request 객체의 CharacterEncoding</dt>
			<dd>POST 방식 파라미터 값을 해석할 때 사용할 charset을 설정</dd>
		</dl>

		<h3># GET 방식 파라미터로 한글을 보냈을 때</h3>

		<ol>
			<li>GET 방식 파라미터 값은 URL에 포함되어 전달되고 그 URL의 해석은 서버가 담당한다.</li>
			<li>URL의 해석을 서버 프로그램이 담당하기 때문에 서버의 설정을 바꿔야 한다</li>
			<li>
				server.xml의 Connector에 URIEncoding="EUC-KR"을 추가 (톰캣의 기본 은 UTF-8이므로 이클립스의 기본인코딩을
				네가지 전부 UTF-8로 설정해도 된다)
			</li>
		</ol>

		GET :
		<input type="text" name="animal" value="호랑이" form="form1" />
		<input type="submit" value="보내기" form="form1" />
		<form action="<%=request.getContextPath()%>/test" id="form1" method="get"></form>

		<h3># POST방식 파라미터로 한글을 보냈을 때</h3>

		<ol>
			<li>POST 방식 파라미터 값은 요청객체 내부에 실려서 서버에 도착하므로 URIEncoding의 영향을 받지 않는다.</li>
			<li>
				request.setCharacterEncoding("EUC-KR")(UTF-8로 전부 설정했으면 UTF-8로 해야한다)로 요청 객체의 인코딩
				방식을 설정하여 해결할 수 있다
			</li>
		</ol>

		POST :
		<input type="text" name="animal" value="거북이" form="form2" />
		<input type="submit" value="보내기" form="form2" />
		<form action="<%=request.getContextPath()%>/test" id="form2" method="post"></form>
	</body>
</html>
