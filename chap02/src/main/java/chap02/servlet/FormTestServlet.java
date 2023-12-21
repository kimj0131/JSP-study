package chap02.servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formTest")
public class FormTestServlet extends HttpServlet{

	// doGet() : GET방식 요청을 받으면 호출되는 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET방식 요청의 암묵적인 뜻 : DB에서 꺼낸 데이터를 내놔라
		System.out.println("GET방식 요청이 왔습니다...");
	}
	
	// doPost() : POST방식 요청을 받으면 호출되는 메서드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// POST방식 요청의 암묵적인 뜻 : 받은 데이터를 DB에 INSERT해라
		System.out.println("POST방식 요청이 왔습니다...");
	}
	
	// service() : 요청방식을 구분하지 않고 요청을 받으면 무조건 호출되는 메서드
	// service 메서드의 기본 동작은 요청방식을 보고 doGet, doPost등을 호출해주는 것이다
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Service가 먼저 호출되었습니다");
		
//		// form으로 실어보낸 데이터는 request.getParameter(name)으로 꺼낼 수 있다
//		// 존재하지 않는 name값으로 조회하면 null을 반환한다
		System.out.println(req.getParameter("user-name"));
		System.out.println(req.getParameter("user-age"));
		System.out.println(req.getParameter("user-password"));
		System.out.println(req.getParameter("user-color"));
		
		resp.getWriter().append("<h1> OK! </h1>");
		
		// 요청 방식은 요청 객체에 실려있다
		if(req.getMethod().equals("GET")) {
			doGet(req, resp);
		}else if (req.getMethod().equals("POST")) {
			doPost(req, resp);
		}
	}
}
