package chap08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap08.dto.EmployeeDto;

public class EmployeeDao {

	public List<EmployeeDto> searchForType(String searchType, String name) {
		String sql = "SELECT * FROM employees WHERE " + searchType + " = ?";

		List<EmployeeDto> list = new ArrayList<>();

		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(
						new EmployeeDto(rs.getInt("employee_id"), rs.getString("first_name"), rs.getString("last_name"),
								rs.getDouble("salary"), rs.getDouble("commission_pct"), rs.getDate("hire_date"),
								rs.getString("job_id"), rs.getInt("manager_id"), rs.getInt("department_id")));
			}
			System.out.println(sql);
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	public Object searchForDepartName(String department_name) {

		String sql = "select * from employees e, departments d "
				+ "where e.department_id = d.department_id "
				+ "and department_name = ?";

		List<EmployeeDto> list = new ArrayList<>();

		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, department_name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(
						new EmployeeDto(rs.getInt("employee_id"), rs.getString("first_name"), rs.getString("last_name"),
								rs.getDouble("salary"), rs.getDouble("commission_pct"), rs.getDate("hire_date"),
								rs.getString("job_id"), rs.getInt("manager_id"), rs.getInt("department_id")));
			}
			System.out.println(sql);
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

}
