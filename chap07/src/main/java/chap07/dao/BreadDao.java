package chap07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap07.dto.BreadDTO;

public class BreadDao {
	
	public List<BreadDTO> getAll() {
		String sql = "SELECT * FROM bread";
		List<BreadDTO> list = new ArrayList<>();
		
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) {
				list.add(new BreadDTO(rs.getString("bread_name"), rs.getInt("bread_price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Integer insert(BreadDTO breadDTO) {
		// 나중에 테이블이 수정되는것에 대비해 컬럼명을 다 쓰는것이 바람직하다
		String sql = "INSERT INTO bread(bread_name, bread_price) VALUES (?,?)";
		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, breadDTO.getBread_name());
			pstmt.setInt(2, breadDTO.getBread_price());
			
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer delete(String bread_name) {
		String sql = "DELETE FROM bread WHERE bread_name = ?";
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setString(1, bread_name);
				
				return pstmt.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}

	public Integer update(BreadDTO breadDTO, String find_name) {
		String sql = "UPDATE bread SET bread_name = ?, bread_price = ? WHERE bread_name = ?";

		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setString(1, breadDTO.getBread_name());
				pstmt.setInt(2, breadDTO.getBread_price());
				
				pstmt.setString(3, find_name);
				
				return pstmt.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}
}
