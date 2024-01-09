package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardModifyFormService implements Service{

	private static BoardModifyFormService instance = new BoardModifyFormService();
	
	BoardDAO dao = new BoardDAO();
	
	public static BoardModifyFormService getInstance() {
		return instance;
	}
	
	private BoardModifyFormService() {
	}
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		// 더욱 안전하게 동작하게 하는 법 >> try catch 사용
		try {
			int board_id = Integer.parseInt(request.getParameter("board_id"));
			
			BoardDTO oldData = dao.get(board_id);
			
			if (oldData != null) {
				request.setAttribute("oldData", oldData);
				return "/WEB-INF/views/boards/modifyForm.jsp";
			} else {
				return "redirect::/";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect::/";
		}
	}
}
