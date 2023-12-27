package chap04.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/quiz_ans/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// JSP에서는 자동으로 만들어져 있는 객체들 (JSP 내장 객체)
		ServletContext application = req.getServletContext();
		HttpSession session = req.getSession();

		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");

		Map<String, Object> infoMap = (Map) application.getAttribute(id);
		if (infoMap == null) {
			resp.sendRedirect("/chap04/quiz_ans/index.jsp");
			System.out.println("로그인 실패");
			return;
		}

		String pwd2 = (String) infoMap.get("pwd");

		// ID가 존재하고 해당 ID의 비밀번호를 맞추면 로그인 성공
		if (pwd2 != null && pwd2.equals(pwd)) {
			// 어트리뷰트는 Context 내부에서 활용하는 값이기 때문에 모든 자바 객체 타입을 값으로 활용할 수 있다
			infoMap.put("login", "ok");

			session.setAttribute("info", infoMap);
			resp.sendRedirect("/chap04/quiz_ans/memo/main");
		} else {
			resp.sendRedirect("/chap04/quiz_ans/index.jsp");
		}
	}

}
