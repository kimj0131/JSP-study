<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>JSTL</title>
	</head>
	<body>
		<h3># JSTL (JSP Standard Tag Library)</h3>

		<ul>
			<li>JSP에서 자바 코드를 사용할 때 코드가 너무 지저분해져서 등장한 커스텀 태그 라이브러리</li>
			<li>뷰 쪽에서 자주 쓰이는 자바 문법들을 html 태그와 유사한 형식으로 사용할 수 있는 기능을 제공한다</li>
			<li>
				자바의 모든 기능을 사용할 수 있는 것은 아니지만 뷰 페이지를 만들기에는 만들기에는 충분한 기능들이 태그
				형식으로 구현되어 있다
			</li>
			<li>Maven Repository에서 다운로드 할 수 있다</li>
			<li>taglib 문법으로 추가한 후 사용해야 한다</li>
		</ul>

		<h3># JSTL core</h3>

		<dl>
			<dt>c:set</dt>
			<dd>각 영역에 setAttribute를 편리하게 단축하여 사용할 수 있는 태그</dd>
			<dt>c:if</dt>
			<dd>if문을 간편하게 쓸 수 있는 태그. else if와 else는 없다</dd>
			<dt>c:choose, c:when, c:otherwise</dt>
			<dd>if, else if, else처럼 사용할 수 있는 태그</dd>
			<dt>c:forEach</dt>
			<dd>for문을 간편하게 사용할 수 있는 태그. 숫자를 통해 반복할 수도 있고, 순서대로 꺼내며 반복할 수도 있다</dd>
			<dt>c:forTokens</dt>
			<dd>전달한 문자열을 split한 결과로 반복을 수행하는 문법</dd>
			<dt>c:url</dt>
			<dd>경로를 사용할 때 알아서 contextPath를 추가해주는 문법</dd>
		</dl>
		
		
		<hr />
		
		<%
			// 각 영역에 어트리뷰트 추가해보기
			application.setAttribute("fruit", "사과");
			session.setAttribute("fruit", "귤");
			request.setAttribute("fruit", "바나나");
			pageContext.setAttribute("fruit", "오이");
		%>
		
		<c:set var="snack" value="초코파이" scope="application" />
		<c:set var="snack" value="초코하임" scope="session" />
		<c:set var="snack" value="포스틱" scope="request" />
		<c:set var="snack" value="바나나킥" scope="page" />
		<!-- 스코프 미지정시 page에 어트리뷰트 등록 -->
		<c:set var="snack" value="치토스" />
		
		<c:set var="coffee" value="카페라떼" scope="application" />
		
		
		<h5># JSP 페이지에서 어트리뷰트를 쉽게 꺼내 쓸 수 있는 기능을 제공한다(EL)</h5>

		<div>그냥 쓰기 : ${fruit}(기본적으로 가장 가까운 영역의 값을 사용) </div>
        <div>applicationScope : ${applicationScope.fruit}</div>
        <div>sessionScope : ${sessionScope.fruit} </div>
        <div>requestScope : <%=request.getAttribute("fruit") %></div>
        <div>pageScope : ${pageScope.fruit}</div>
        <div>app : ${applicationScope.snack}</div>
        <div>session : ${sessionScope.snack}</div>
        <div>req : ${requestScope.snack}</div>
        <div>page : ${pageScope.snack}</div>
        <div>커피 : ${coffee}</div>
        
        <h5># 어트리뷰트에 보관된 값을 활용해 쉽게 if문 사용하기</h5>
        <c:if test="${coffee == '카페라떼'}">
        	<div>if문이 실행되었습니다.</div>
        </c:if>
        
        <c:set var="num" value="555"/>
        <c:choose>
        	<c:when test="${num > 10 }">
        		<div>if</div>
        	</c:when>
        	<c:when test="${num > 0 }">
        		<div>else if</div>
        	</c:when>
        	<c:when test="${num > -10 }">
        		<div>else if</div>
        	</c:when>
        	<c:otherwise>
        		<div>else</div>
        	</c:otherwise>
        </c:choose>
		
		<h5># 원하는 횟수만큼 반복하기</h5>
		
		<ul>
		<c:forEach begin="0" end="9" var="i">
			<li id="list-item${i}"><%=pageContext.getAttribute("i")%>번째 리스트 데이터 입니다</li>
		</c:forEach>
		</ul>
		
		<table border="1">
		<c:forEach begin="0" end="19" var="i" step="4">
			<tr>
				<td>${i}</td>
				<td>${i + 1}</td>
			</tr>
		</c:forEach>
		</table>
				
		<h5># 배열, 리스트 등을 순차적으로 꺼내면서 반복하기(Iterable)</h5>
		
		<%
			String name = "김철수";
			String[] coffees = {"Americano", "Cafe Latte", "Americano", "Cafe Mocha", "카라멜 마끼야또"};
			ArrayList<String> foods = new ArrayList<>();
			
			pageContext.setAttribute("name", name);
			pageContext.setAttribute("coffees", coffees);
			pageContext.setAttribute("foods", foods);
			
			foods.add("피자");
			foods.add("햄버거");
			foods.add("삼겹살");
			foods.add("멸치국수");
			foods.add("소고기");
			foods.add("피자");
			
			java.util.Collections.sort(foods);
		%>
		
		<c:forEach items="${coffees}" var="co">
			<div>${co}</div>
		</c:forEach>
				
		<c:forEach items="${foods}" var="food">
			<div>${food}</div>
		</c:forEach>
		
		<h3># 반복하면서 varStatus 확인하기</h3>
		
		<ul>
			<li>varStatus.index : 현재 인덱스를 확인할 수 있다 (몇 번째 인가, 0부터 시작)</li>
			<li>varStatus.count : 현재 카운트를 확인할 수 있다 (몇 개 인가, 1부터 시작)</li>
			<li>varStatus.first : 첫 번째 요소일 때 true</li>
			<li>varStatus.last : 마지막 요소일 때 true</li>
			<li>varStatus.begin : 시작 값을 꺼내서 사용</li>
			<li>varStatus.end : 마지막 값을 꺼내서 사용</li>
			<li>varStatus.step : 증감값을 꺼내서 사용</li>
			<li>varStatus.current : 현재 값</li>
		</ul>
		
		<c:forEach items="${foods}" var="food" varStatus="v">
			<c:choose>
				<c:when test="${v.first}">
					<div class="first">${v.index}번째 음식 : ${food} (${v.count}개)</div>
				</c:when>
				<c:when test="${v.last}">
					<div class="last">${v.index}번째 음식 : ${food} (${v.count}개)</div>
				</c:when>
				<c:otherwise>
					<div class="mid">${v.index}번째 음식 : ${food} (${v.count}개)</div>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<h5>c:forTokens</h5>
		
		<c:set var="animals" value="pig#cat#dog:lion/tiger:zibra"/>
		
		<c:forTokens items="${animals}" delims="/#:" var="animal">
			<div>${animal}</div>
		</c:forTokens>
		
		<h5># url 깔끔하게 만들기</h5>

		<ul>
			<li><%=request.getContextPath()%>/abc/123</li>
			<li><c:url value="/abc/123"/></li>
			<li>경로에 파라미터 추가하기 : /abc/123?taste=banana&type=hot</li>
			<li>
				<c:url value="/abc/123/add" var="myURL2">
					<c:param name="employee_id" value="101"/>
					<c:param name="department_id" value="80"/>
				</c:url>
			</li>
		</ul>

		<!-- c:url에 var을 설정하면 해당 경로가 뷰에 출력되지 않고 어트리뷰트에 등록된다 -->
		<c:url value="abc/123/aaa" var="myURL1"/>
		<a href="${myURL1}">링크1</a>
		<a href="${myURL2}">링크2</a>

</body>
</html>
