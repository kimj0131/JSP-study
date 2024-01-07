package chap10.service;

import javax.servlet.http.HttpServletRequest;

import chap10.dao.BoardDao;

public class BoardDetailService implements Service{

	private static BoardDetailService instance = new BoardDetailService();
	
	private BoardDao boardDao = new BoardDao();
	
	public static BoardDetailService getInstance() {
		return instance;
	}
	
	private BoardDetailService() {
	}
	
	@Override
	public String service(HttpServletRequest request) {
		String board_idxStr = request.getParameter("board_idx");
		
		if (board_idxStr != null) {
			int board_idx = Integer.parseInt(board_idxStr);
			request.setAttribute("boardIdx", board_idx);
			request.setAttribute("boardDetail", boardDao.getBoardDetail(board_idx));
		} 
		return "/boardDetail.jsp";
	}
}
