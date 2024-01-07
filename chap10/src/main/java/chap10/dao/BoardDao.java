package chap10.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap10.dto.BoardDto;
import chap10.util.EncryptSHA256;

public class BoardDao {

	// 비밀번호 맞는지 체크하는 메서드
	public boolean checkPassward(int idx, String inputPwd) {
		String sql = "select write_passward as chk_pwd from boards where boards.board_idx = ?";

		EncryptSHA256 encryptSHA256 = new EncryptSHA256();

		try (
				Connection conn = DBConnector.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, idx);
			ResultSet rs = pstmt.executeQuery();

			String pwd = encryptSHA256.encrypt(inputPwd);

			if (rs.next()) {
				if (pwd.equals(rs.getString("chk_pwd"))) {
					return true;
				}
			}
			rs.close();
		} catch (SQLException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return false;
	}

	// DB에서 다음 게시글 번호를 가져오는 메서드
	public int getNextIndex() {
		String sql = "SELECT MAX(board_idx) AS max_idx FROM boards";
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			if (rs.next()) {
				int nextIndex = rs.getInt("max_idx") + 1;
				return nextIndex;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	// DB에서 게시글 목록을 받아오는 메서드
	public List<BoardDto> getBoardTitleList() {
		String sql = "SELECT board_idx, write_name, board_title FROM boards";
		List<BoardDto> list = new ArrayList<>();

		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) {
				list.add(new BoardDto(rs.getInt("board_idx"), rs.getString("board_title"), rs.getString("write_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 게시글 번호를 사용해 DB에서 게시글을 가져오는 메서드
	public BoardDto getBoardDetail(int board_idx) {
		String sql = "SELECT * FROM boards WHERE board_idx = ?";
		BoardDto boardDto = null;
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, board_idx);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardDto = new BoardDto(
						rs.getInt("board_idx"), rs.getString("board_title"),
						// replace로 줄바꿈을 정상적으로 출력하도록 변경
						rs.getString("board_content").replace("\r\n", "<br>"),
						rs.getString("write_name"), rs.getString("write_passward"));
				return boardDto;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardDto;
	}
	// 수정을 위해 replace없이 받아오는 메서드
	public BoardDto getBoardDetailWihtoutReplace(int board_idx) {
		String sql = "SELECT * FROM boards WHERE board_idx = ?";
		BoardDto boardDto = null;
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, board_idx);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardDto = new BoardDto(
						rs.getInt("board_idx"), rs.getString("board_title"),
						rs.getString("board_content"),
						rs.getString("write_name"), rs.getString("write_passward"));
				return boardDto;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardDto;
	}
	
	// 파라미터값을 전달받아 DB에서 INSERT쿼리를 하는 메서드
	public Integer insert(BoardDto boardDto) {
		String sql = "INSERT INTO boards("
				+ "board_idx, board_title, board_content, write_name, write_passward) "
				+ "VALUES (board_idx_seq.nextval,?,?,?,?)";
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
//			pstmt.setInt(1, boardDto.getBoard_idx());
			pstmt.setString(1, boardDto.getBoard_title());
			pstmt.setString(2, boardDto.getBoard_content());
			pstmt.setString(3, boardDto.getWrite_name());
			pstmt.setString(4, boardDto.getWrite_passward());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// UPDATE 쿼리 메서드
	public Integer update(int board_index, String board_content) {
		String sql = "update boards set board_content = ? where board_idx = ?";
		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setString(1, board_content);
			pstmt.setInt(2, board_index);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// DELETE 쿼리 메서드
	public Integer delete(int board_idx) {
		String sql = "DELETE from boards where board_idx = ?";
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, board_idx);
			
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
