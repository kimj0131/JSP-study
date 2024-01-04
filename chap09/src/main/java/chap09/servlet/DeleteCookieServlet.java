package chap09.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/delete")
public class DeleteCookieServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie[] cookies = req.getCookies();
		String contextPath = req.getContextPath();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// 쿠키의 수명을 0으로 만들고 응답하면 해당 쿠키 삭제
				if (cookie.getName().equals("age")) {
					cookie.setPath(contextPath + "/cookie");
					cookie.setMaxAge(0); // 0초이므로 만료됨
					resp.addCookie(cookie);
				} else if (cookie.getName().equals("fav")) {
					cookie.setPath(contextPath);
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}
			}
		}
		resp.sendRedirect(contextPath + "/cookie/index.jsp");
	}
}
