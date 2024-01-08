package board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardListService implements Service{
	
	private static BoardListService instance = new BoardListService();
	
	public static BoardListService getInstance() {
		return instance;
	}
	
	private BoardListService() {
	}
	
	BoardDAO dao = new BoardDAO();
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		
		List<BoardDTO> boards = dao.getList();
		
		request.setAttribute("boards", boards);
		
		return "/WEB-INF/views/boards/index.jsp";
	}

}
