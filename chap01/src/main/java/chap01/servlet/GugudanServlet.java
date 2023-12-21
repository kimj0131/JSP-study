package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	/chap01/gugudan으로 접속하는 사용자에게
 	멋있는 구구단 페이지를 응답하는 서블릿을 만들어보세요

*/
@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\" />");
		out.print("<title>Gugudan</title>");
		// 웹의 절대 경로는 프로토콜 이름부터 시작되는 경로다
		// 상대 경로는 이 페이지에 접속했던 URL기준의 상대 경로다
		// a태그 뿐만이 아니라 link, img, script 태그 등은 
		// 페이지에 사용하는 것만으로도 서버로 요청을 보내 정적 자원을 받아와서 활용한다
		out.print("<link rel=\"stylesheet\" href=\"../chap01/assets/gugudan.css\" />");
		out.print("</head>");
		out.print("<style>");
		out.print(".gugudan {"
				+ "display: grid;\n"
				+ "grid-template-columns: repeat(4, 1fr);\n"
				+ "width: 600px;\n"
				+ "gap: 10px;\n"
				+ "}\n"
				
				+ ".gugudan > div {"
				+ "border-radius: 20%;\n"
				+ "width: auto;\n"
				+ "height: 270px;\n"
				+ "font-size: 20px;\n"
				+ "font-weight: bold;\n"
				+ "text-align: center;\n"
				+ "background-color: #ccc;\n"
				+ "padding-top: 10px;\n"
				+ "}\n"
				
				+ "pre{"
				+ "margin: 0;\n"
				+ "}\n");
		out.print("</style>");
		out.print("<body>");
		out.print("<div class=\"gugudan\">");
		for (int i = 2; i <= 9; i++) {
			out.print(gugudan(i));
		}
		out.print("</div>");
		out.print("<hr>");
		
		out.print("<div id=\"gugudan2\">");
		for(int gop = 0; gop <=9; gop++) {
			for(int dan = 2; dan <= 9; dan++) {
				if(gop == 0) {
					out.print(String.format("<div class=\"dan\">%d단</div>", dan));
				} else {
					out.print(String.format("<div>%d x %d=%d</div>", dan, gop, dan*gop));
				}
			}
		}
		
		out.print("</body>");
			
		
		
	}
	
	String gugudan(int dan) {
		
		String result = "<div id=\"dan" + dan + "\"><pre>" + dan + " 단\n\n";
		for(int i = 1; i <= 9; i++) {
			result += String.format("%d x %d = %2d\n", dan, i, dan*i);
		}

		return result += "</pre></div>";
	}

}
