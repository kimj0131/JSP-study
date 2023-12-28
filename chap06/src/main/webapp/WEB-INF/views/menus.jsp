<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>피자 메뉴</title>
<style>
#menuList {
	display: grid;
	grid-template-columns: 1fr 1fr 1fr 1fr;
    padding-left: 10px;
}

#menuList > div {
    background-color: #ccc;
    margin-left: 5px;
    padding-left: 5px;
    text-align: center;
}

#select {
    cursor: pointer;
    color: white;
    background-color: black;
}
</style>
</head>
<body>
	<div id="menuList">
		<%
            List<String> menuList = (List<String>) request.getAttribute("menus");
            Map<String, int[]> menuPrice = (Map<String, int[]>) request.getAttribute("price");
            
            int size = 0;
            for (String menu : menuList) {
                out.print("<div id=\"menuInfo\">");
                out.print(String.format("<span>%s</span><br><br>", menu));
                out.print(String.format(" <span id=\"select\">L %d원</span> ", menuPrice.get(menu)[0]));
                out.print(String.format(" <span id=\"select\">M %d원</span> ", menuPrice.get(menu)[1]));
        %>
        <form action="/chap06/orderList" method="post">
            <label for="<%=size%>_L">Large</label>
            <input type="checkbox" name="<%=size%>_pizza_L" id="<%=size%>_L">
            <label for="<%=size%>_M">Medium</label>
            <input type="checkbox" name="<%=size%>_pizza_M" id="<%=size%>_M">
            <input type="submit" value="추가하기">
        </form>
        <%
                out.print("</div>");
                size++;
            }
		%>
	</div>

    <hr>
    <!-- <button id="orderBtn" onclick="location='/chap06/menuResult'">주문하기</button> -->

	<script>
        const orderBtn = document.getElementById("orderBtn");
        orderBtn.addEventListener('click', (e) => {
            
        });

    </script>
</body>
</html>
