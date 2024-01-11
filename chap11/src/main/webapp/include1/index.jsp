<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jsp:include는 forward처럼 webapp밑의 경로를 사용해야 한다 -->
<jsp:include page="./top.jsp" />

<h1>Index.jsp</h1>

<p>
	Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis quaerat eos laudantium nostrum itaque obcaecati,
	ipsa quas, eius distinctio, optio est aspernatur. Accusantium voluptatum saepe amet reprehenderit fugiat vel!
	Doloribus.
</p>

<p>자바스크립트는 클라이언트에서 작동하는 언어이기 때문에 3분할의 영향을 받지 않는다...</p>

<p>
	결과는 하나로 합쳐지지만 다른 페이지에서 완성된 결과가 합쳐지는 것이기 때문에 각 jsp 페이지를 완성하기 취한 재료는
	각자의 페이지에서 따로 존재해야 한다 (ex: jstl, page...)
</p>

<c:forEach begin="0" end="9" var="i">
	<p>paragraph${i}, ${fruit}</p>
</c:forEach>

<jsp:include page="./bottom.jsp" />
