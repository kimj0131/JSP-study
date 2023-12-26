<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String scope = request.getParameter("scope");

    if(scope.endsWith("application")){
    	application.setAttribute("food", request.getParameter("food"));
    } else if (scope.endsWith("sesstion")){
    	session.setAttribute("food", request.getParameter("food"));
    } else if (scope.endsWith("request")){
    	request.setAttribute("food", request.getParameter("food"));
    } else if (scope.endsWith("page")){
    	// 이 페이지내에서만 남아있으므로 페이지가 넘어가면 사라짐
    	pageContext.setAttribute("food", request.getParameter("food"));
    }

    request.getRequestDispatcher("/attribute/index.jsp").forward(request, response);
%>