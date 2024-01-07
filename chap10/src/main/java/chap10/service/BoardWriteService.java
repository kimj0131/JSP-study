package chap10.service;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import chap10.dao.BoardDao;
import chap10.dto.BoardDto;
import chap10.util.EncryptSHA256;

public class BoardWriteService implements Service {
	
	private static BoardWriteService instance = new BoardWriteService();
	
	BoardDao boardDao = new BoardDao();
	
	EncryptSHA256 encryptSHA256 = new EncryptSHA256();
	
	public static BoardWriteService getInstance() {
		return instance;
	}
	
	private BoardWriteService() {
	}

	@Override
	public String service(HttpServletRequest request) {
		String board_idxStr = request.getParameter("board_idx");
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		String write_name = request.getParameter("write_name");
		String write_pass = request.getParameter("write_passward");
		
		System.out.println(board_content);
		
		Integer board_idx = Integer.parseInt(board_idxStr);
		
		try {
			String write_passward = encryptSHA256.encrypt(write_pass);
			
			Integer result = boardDao.insert(new BoardDto(
					board_idx, board_title, board_content,
					write_name, write_passward));
//			System.out.println("write result : " + result);
			
			if (result == null) {
				return "redirect::" + request.getContextPath() + "/board/writeErr";
			} else if (result > 0){
				return "redirect::" + request.getContextPath() + "/";
			} else {
				return "redirect::" + request.getContextPath() + "/board/writeErr";
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "redirect::" + request.getContextPath() + "/board/writeErr";
		
	}

}
