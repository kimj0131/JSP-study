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

@WebServlet("/quiz_ans/register")
public class RegisterServlet extends HttpServlet{

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 서블릿에서 application 영역 사용하기
		ServletContext application = req.getServletContext();
		// 서블릿에서 session 영역 사용하기
		// req.getSession();
		
		
		
		// 파라미터는 웹에서 만들어져 오는 값이므로 무조건 String으로 반환된다
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		// *** 파라미터의 값이 빈 값인지 검증할 때 null뿐만 아니라 빈 문자도 체크해야 한다
		if (id == null || pwd == null || id.equals("") || pwd.equals("")) {
			resp.sendRedirect("/chap04/quiz_ans/index.jsp?error=1");
			return;
		}
		
		// ID가 이미 있는지 체크
		if (application.getAttribute(id) != null) {
			resp.sendRedirect("/chap04/quiz_ans/index.jsp?error=1&dup=1");
			return;
		}
		
		// 비밀번호 정규표현식으로 검증..? (포함되야할 문자, 특수문자 방지 등등)
		
		// 아이디 application 객체에 등록 (원래는 DB에 넣어야 함)
		Map<String, Object> infoMap = new HashMap<>();
		
		infoMap.put("pwd", pwd);
		
		application.setAttribute(id, infoMap);
		resp.sendRedirect("/chap04/quiz_ans/index.jsp");
	}

}
