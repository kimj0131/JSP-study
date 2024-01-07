package chap10.service;

import javax.servlet.http.HttpServletRequest;

import chap10.dao.BoardDao;

public class BoardUpdateService implements Service{
	
	private static BoardUpdateService instance = new BoardUpdateService();
	
	private BoardDao boardDao = new BoardDao();
	
	public static BoardUpdateService getInstance() {
		return instance;
	}
	private BoardUpdateService() {
		
	}
	
	@Override
	public String service(HttpServletRequest request) {
		String board_idxStr = request.getParameter("board_idx");
		String board_content = request.getParameter("board_content");
		
		Integer board_idx = Integer.parseInt(board_idxStr);
		
		Integer result = boardDao.update(board_idx, board_content);
		
		if (result == null) {
			return "redirect::" + request.getContextPath() + "/board/writeErr";
		} else if (result > 0){
			return "redirect::" + request.getContextPath() + "/board/updated";
		} else {
			return "redirect::" + request.getContextPath() + "/board/writeErr";
		}
		
	}

}
