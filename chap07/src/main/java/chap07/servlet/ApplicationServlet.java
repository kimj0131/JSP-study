package chap07.servlet;
	
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap07.dto.EmployeeDTO;
import chap07.dto.FruitDTO;
import chap07.util.UriParser;
import chap07.webprocess.BreadAddFormWebProcess;
import chap07.webprocess.BreadAddWebProcess;
import chap07.webprocess.BreadDelFormWebProcess;
import chap07.webprocess.BreadListWebProcess;
import chap07.webprocess.BreadUpdateFormWebProcess;
import chap07.webprocess.BreadUpdateWebProcess;
import chap07.webprocess.DBTestWebProcess;
import chap07.webprocess.IndexWebProcess;
import chap07.webprocess.WebProcess;

public class ApplicationServlet extends HttpServlet{
	
	static Map<String, WebProcess> uriMapping = new HashMap<>();
	
	static {
		
		// (1) 전달받은 URI(cmd)에 따라 알맞은 처리를 꺼내줄 수 있는 맵을 생성해두면 if문을 안 쓸 수 있다 (커맨드 패턴)
		uriMapping.put("GET::/", new IndexWebProcess());
		uriMapping.put("GET::/dbtest/emplist", new DBTestWebProcess());
		uriMapping.put("GET::/dbtest/bread/list", new BreadListWebProcess());
		// 같은 주소의 처리방식을 다르게 하는 법
		uriMapping.put("GET::/dbtest/bread/add", new BreadAddFormWebProcess());
		uriMapping.put("POST::/dbtest/bread/add", new BreadAddWebProcess());
		
		uriMapping.put("GET::/dbtest/bread/del", new BreadDelFormWebProcess());
		uriMapping.put("POST::/dbtest/bread/del", new BreadDelWebProcess());
		
		uriMapping.put("GET::/dbtest/bread/update", new BreadUpdateFormWebProcess());
		uriMapping.put("POST::/dbtest/bread/update", new BreadUpdateWebProcess());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String cmd = UriParser.getCmd(req);
		
		// 1. 내가 전달받은 uri를 문자열 형태로 전달받는다
		// 2. 해당 uri에 알맞은 처리를 한다(DB작업 등..)
		// 3. 내가 다음으로 가야할 뷰 페이지로 포워드 하거나 리다이렉트 한다
		// 위 세가지를 인터페이스로 구현?
		
		String nextPage = uriMapping.get(cmd).process(req);
		
		if(nextPage.startsWith("redirect::")){
			// redirect로 시작하는 경우 페이지를 리다이렉트 한다
			resp.sendRedirect(nextPage.substring("redirect::".length()));
		} else {
			req.getRequestDispatcher(nextPage).forward(req, resp);
		}
		
		// if문을 사용할때의 문제점 - 끝도 없이 늘어나기 때문에 소스코드가 길어지고 유지보수가 힘들다
		// 결론 : 엄청나게 늘어날 수 있는 if문은 제거해야 한다 -> 인터페이스와 Map을 활용 
		
		
		
//		if (cmd.equals("/")) {
//			req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
//		} else if (cmd.equals("/dbtest/emplist")) {
//			
//			// DB에서 값을 꺼낸 후
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			
//			try ( 
//				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
//				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
//				ResultSet rs = pstmt.executeQuery();
//			){
//				// dto : 읽기/쓰기 가능
//				// vo : 읽기 전용
//				List<EmployeeDTO> employees = new ArrayList<>();
//				
//				while (rs.next()) {
//					employees.add(new EmployeeDTO(
//							rs.getInt("employee_id"),
//							rs.getString("first_name"),
//							rs.getString("last_name"),
//							rs.getDouble("salary"),
//							rs.getDouble("commission_pct"),
//							rs.getDate("hire_date"),
//							rs.getString("job_id"),
//							rs.getInt("manager_id"),
//							rs.getInt("department_id")
//							));
//				}
//				
//				// 처리 후 어트리뷰트에 데이터 적재
//				req.setAttribute("employees", employees);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//			// 포워딩
//			req.getRequestDispatcher("/WEB-INF/views/dbtest/list.jsp").forward(req, resp);
//			
//		} 
		// 같이작성해보기
//		else if (cmd.equals("/dbtest/bread/list")){
//			
//			req.getRequestDispatcher("/WEB-INF/views/bread/list.jsp").forward(req, resp);
//		}
		
		
		
		// 연습문제
		//else 
//			if (cmd.equals("/dbtest/fruitList")) {
//			
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			
//			try ( 
//				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
//				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM fruits");
//				ResultSet rs = pstmt.executeQuery();
//			){
//				// dto : 읽기/쓰기 가능
//				// vo : 읽기 전용
//				List<FruitDTO> fruits = new ArrayList<>();
//				
//				while (rs.next()) {
//					fruits.add(new FruitDTO(
//							rs.getString("fruit_name"),
//							rs.getInt("fruit_price"),
//							rs.getString("fruit_grade")							
//							));
//				}
//				
//				// 처리 후 어트리뷰트에 데이터 적재
//				req.setAttribute("fruits", fruits);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//			req.getRequestDispatcher("/WEB-INF/views/dbtest/fruitList.jsp").forward(req, resp);
//		} else if (cmd.equals("/dbtest/fruitAdd")) {
//			req.getRequestDispatcher("/WEB-INF/views/dbtest/fruitAdd.jsp").forward(req, resp);
//		} else if (cmd.equals("/addFruitDB")) {
//			
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			
//			String fruitName = req.getParameter("fruit-name");
//			String fruitPriceStr = req.getParameter("fruit-price");
//			String fruitGrade = req.getParameter("fruit-grade");
//			
//			if (fruitName == null || fruitPriceStr == null || fruitGrade == null ||
//					fruitName == "" || fruitPriceStr == "" || fruitGrade == "") {
//				throw new ServletException("파라미터 값에 문제가 있습니다.");
//			} 
//			
//			int fruitPrice = Integer.parseInt(fruitPriceStr);
//			
//			String sql = String.format("insert into fruits values ('%s', %d, '%s')", fruitName, fruitPrice, fruitGrade);
//			
//			
//			try ( 
//				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//			){
//				pstmt.executeUpdate();
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//			resp.sendRedirect(req.getContextPath() + "/dbtest/fruitAdd");
//		} else if (cmd.equals("/dbtest/fruitDel")) {
//			req.getRequestDispatcher("/WEB-INF/views/dbtest/fruitDel.jsp").forward(req, resp);
//		} else if (cmd.equals("/delFruitDB")) {
//			
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			String fruitName = req.getParameter("fruit-name");
//			
//			String sql = String.format("DELETE FROM fruits WHERE fruit_name = '%s'", fruitName);
//			
//
//			try ( 
//				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//			){
//				pstmt.executeUpdate();
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//			resp.sendRedirect(req.getContextPath() + "/dbtest/fruitDel");
//		} else if (cmd.equals("/dbtest/fruitUpdate")) {
//			req.getRequestDispatcher("/WEB-INF/views/dbtest/fruitUpdate.jsp").forward(req, resp);
//		}
		
		
	}

}
