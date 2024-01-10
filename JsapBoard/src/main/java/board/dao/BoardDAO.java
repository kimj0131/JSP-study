package board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardDTO;

public class BoardDAO {
	
	public int write(BoardDTO dto) {
		String sql = "INSERT INTO myboard(board_id, board_title, "
				+ "board_content, board_password, board_writer) "
				+ "VALUES(myboard_id_seq.nextval,?,?,?,?)";
		
		try (
			DBSession session = DBConnector.getSession();
			PreparedStatement pstmt = session.preparedStatement(sql);
		) {
			pstmt.setString(1, dto.getBoard_title());
			pstmt.setString(2, dto.getBoard_content());
			pstmt.setString(3, dto.getBoard_password());
			pstmt.setString(4, dto.getBoard_writer());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	public List<BoardDTO> getList() {
		String sql = "SELECT board_id, board_title, board_writer, view_count, write_date "
				+ "FROM myboard ORDER BY board_id DESC";
		
		List<BoardDTO> list = new ArrayList<>();
		
		try (
			DBSession session = DBConnector.getSession();
			PreparedStatement pstmt = session.preparedStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setBoard_id(rs.getInt("board_id"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setView_count(rs.getInt("view_count"));
				dto.setWrite_date(rs.getDate("write_date"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	public BoardDTO get(int board_id) {
		String sql = "SELECT * FROM myboard WHERE board_id = ?";
		
		BoardDTO detail = new BoardDTO();
		
		try (
			DBSession session = DBConnector.getSession();
			PreparedStatement pstmt = session.preparedStatement(sql);
		){
			pstmt.setInt(1, board_id);
			
			try (ResultSet rs = pstmt.executeQuery()) {
				rs.next();
				detail.setBoard_id(rs.getInt("board_id"));
				detail.setBoard_title(rs.getString("board_title"));
				detail.setBoard_content(rs.getString("board_content"));
				detail.setBoard_writer(rs.getString("board_writer"));
				detail.setView_count(rs.getInt("view_count"));
				detail.setWrite_date(rs.getDate("write_date"));
				detail.setBoard_password(rs.getString("board_password"));
			} 
			return detail;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int plusView(int pk) {
		String sql = "UPDATE myboard SET view_count = view_count + 1 WHERE board_id = ?";
		
		try (
			DBSession session = DBConnector.getSession();
			PreparedStatement pstmt = session.preparedStatement(sql);
		){
			pstmt.setInt(1, pk);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}

	public int modify(BoardDTO dto) {
		String sql = "UPDATE myboard SET board_title=?, board_content=? "
				+ "WHERE board_id=?";
		
		try (
			DBSession session = DBConnector.getSession();
			PreparedStatement pstmt = session.preparedStatement(sql)
		){
			pstmt.setString(1, dto.getBoard_title());
			pstmt.setString(2, dto.getBoard_content());
			pstmt.setInt(3, dto.getBoard_id());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int delete(int pk) {
		String sql = "DELETE FROM myboard WHERE board_id=?";
		
		try (
			DBSession session = DBConnector.getSession();
			PreparedStatement pstmt = session.preparedStatement(sql);
		){
			pstmt.setInt(1, pk);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
}
