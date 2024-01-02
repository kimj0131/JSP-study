package chap07.servlet;
	
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap07.dto.EmployeeDTO;
import chap07.dto.FruitDTO;
import chap07.util.UriParser;

public class ApplicationServlet extends HttpServlet{
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String cmd = UriParser.getCmd(req);
		
		if (cmd.equals("/")) {
			req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
		} else if (cmd.equals("/dbtest/emplist")) {
			
			// DB에서 값을 꺼낸 후
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try ( 
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
				ResultSet rs = pstmt.executeQuery();
			){
				// dto : 읽기/쓰기 가능
				// vo : 읽기 전용
				List<EmployeeDTO> employees = new ArrayList<>();
				
				while (rs.next()) {
					employees.add(new EmployeeDTO(
							rs.getInt("employee_id"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getDouble("salary"),
							rs.getDouble("commission_pct"),
							rs.getDate("hire_date"),
							rs.getString("job_id"),
							rs.getInt("manager_id"),
							rs.getInt("department_id")
							));
				}
				
				// 처리 후 어트리뷰트에 데이터 적재
				req.setAttribute("employees", employees);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// 포워딩
			req.getRequestDispatcher("/WEB-INF/views/dbtest/list.jsp").forward(req, resp);
			
		} else if (cmd.equals("/dbtest/fruitList")) {
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try ( 
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM fruits");
				ResultSet rs = pstmt.executeQuery();
			){
				// dto : 읽기/쓰기 가능
				// vo : 읽기 전용
				List<FruitDTO> fruits = new ArrayList<>();
				
				while (rs.next()) {
					fruits.add(new FruitDTO(
							rs.getString("fruit_name"),
							rs.getInt("fruit_price"),
							rs.getString("fruit_grade")							
							));
				}
				
				// 처리 후 어트리뷰트에 데이터 적재
				req.setAttribute("fruits", fruits);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			req.getRequestDispatcher("/WEB-INF/views/dbtest/fruitList.jsp").forward(req, resp);
		} else if (cmd.equals("/dbtest/fruitAdd")) {
			req.getRequestDispatcher("/WEB-INF/views/dbtest/fruitAdd.jsp").forward(req, resp);
		} else if (cmd.equals("/addFruitDB")) {
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String fruitName = req.getParameter("fruit-name");
			String fruitPriceStr = req.getParameter("fruit-price");
			String fruitGrade = req.getParameter("fruit-grade");
			
			if (fruitName == null || fruitPriceStr == null || fruitGrade == null ||
					fruitName == "" || fruitPriceStr == "" || fruitGrade == "") {
				throw new ServletException("파라미터 값에 문제가 있습니다.");
			} 
			
			int fruitPrice = Integer.parseInt(fruitPriceStr);
			
			String sql = String.format("insert into fruits values ('%s', %d, '%s')", fruitName, fruitPrice, fruitGrade);
			
			
			try ( 
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			resp.sendRedirect(req.getContextPath() + "/dbtest/fruitAdd");
		} else if (cmd.equals("/dbtest/fruitDel")) {
			req.getRequestDispatcher("/WEB-INF/views/dbtest/fruitDel.jsp").forward(req, resp);
		} else if (cmd.equals("/delFruitDB")) {
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String fruitName = req.getParameter("fruit-name");
			
			String sql = String.format("DELETE FROM fruits WHERE fruit_name = '%s'", fruitName);
			

			try ( 
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			resp.sendRedirect(req.getContextPath() + "/dbtest/fruitDel");
		} else if (cmd.equals("/dbtest/fruitUpdate")) {
			req.getRequestDispatcher("/WEB-INF/views/dbtest/fruitUpdate.jsp").forward(req, resp);
		}
	}

}
