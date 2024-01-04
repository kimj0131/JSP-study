package chap09.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/quiz/adStop")
public class AdStopServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie cookie = new Cookie("ad", "close");
		
		cookie.setMaxAge(30);
//		cookie.setHttpOnly(true);
		cookie.setPath(req.getContextPath() + "/quiz");
		
		resp.addCookie(cookie);
		
		resp.sendRedirect(req.getContextPath() + "/quiz/index.jsp");
	}
}
