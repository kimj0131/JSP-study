package chap08.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap08.dao.EmployeeDao;


@WebServlet("/empSearch")
public class AppServlet extends HttpServlet{
	
	EmployeeDao employeeDao = new EmployeeDao();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		String department_name = req.getParameter("department_name");
		
		if (!first_name.equals("")) {
		 	req.setAttribute("employees", employeeDao.searchForType("first_name", first_name)); 
		 	
		 	req.getRequestDispatcher("/search.jsp").forward(req, resp);
		} else if (!last_name.equals("")) {
			req.setAttribute("employees", employeeDao.searchForType("last_name", last_name)); 
		 	
		 	req.getRequestDispatcher("/search.jsp").forward(req, resp);
		} else if (!department_name.equals("")) {
			req.setAttribute("employees", employeeDao.searchForDepartName(department_name));

			req.getRequestDispatcher("/search.jsp").forward(req, resp);
		}	
		System.out.println("검색한 속성");
		System.out.println("first_name : " + first_name);
		System.out.println("last_name : " + last_name);
		System.out.println("department_name : " + department_name);
		
	}
	
}
