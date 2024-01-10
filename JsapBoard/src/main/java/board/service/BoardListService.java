package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dao.ReplyDAO;
import board.dto.BoardDTO;

public class BoardListService implements Service{
	
	private static BoardListService instance = new BoardListService();
	
	public static BoardListService getInstance() {
		return instance;
	}
	
	private BoardListService() {
	}
	
	BoardDAO boardDAO = new BoardDAO();
	ReplyDAO replyDAO = new ReplyDAO();
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		
		List<BoardDTO> boards = boardDAO.getList();
		Map<Integer, Integer> replySizes = new HashMap<>();
		
		for (BoardDTO board : boards) {
			int board_id = board.getBoard_id();
			
			int replySize = replyDAO.getBoardReplies(board_id).size();
			
			replySizes.put(board_id, replySize);
		}

		request.setAttribute("boards", boards);
		request.setAttribute("replySizes", replySizes);
		
		return "/WEB-INF/views/boards/index.jsp";
	}

}
