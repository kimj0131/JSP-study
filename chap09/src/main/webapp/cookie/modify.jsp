<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키는 항상 요청에 포함되어 도착한다 (물론, 도메인과 path가 맞는 경우에만)
	// 원하는 쿠키를 하나만 받는 메서드는 기본적으로는 존재하지 않는다
	Cookie[] cookies = request.getCookies();

	// 쿠키가 하도 없는 경우를 대비
	if(cookies != null){
		for (Cookie cookie : cookies) {
			String cname = cookie.getName();
			
			if(cname.equals("age")){
				cookie.setMaxAge(300); // 원래 만료기간이 세션이던 쿠키를 5분으로 설정
				cookie.setValue("3-7");
				
				// 요청으로부터 전달받은 쿠키에는 path정보가 없다
				// 예전에 썼던 path를 그대로 슸기는 불가능하다
				System.out.println("age path : " + cookie.getPath());
				response.addCookie(cookie); // 응답에 실어야 수정사항이 반영됨
			} else if (cname.equals("fav")){
				// 정확하게 같은 쿠키를 쓰기 위해서는 name뿐만 아니라 path값도 일치시켜야 한다 (path가 다르면 다른 쿠키로 인식한다)
				cookie.setMaxAge(-1); // 수명을 음수로 바꾸면 해당 쿠키를 세션으로 설정
				cookie.setPath("/chap09");
				response.addCookie(cookie);
			}
		}
	}
	response.sendRedirect(request.getContextPath() + "/cookie/index.jsp");
%>