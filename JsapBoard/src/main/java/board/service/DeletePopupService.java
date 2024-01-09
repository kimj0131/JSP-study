package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class DeletePopupService implements Service {

	private static DeletePopupService instance = new DeletePopupService();

	BoardDAO dao = new BoardDAO();

	public static DeletePopupService getInstance() {
		return instance;
	}

	private DeletePopupService() {
	}

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {

//		try {
//			int board_id = Integer.parseInt(request.getParameter("board_id"));
//
//			BoardDTO detail = dao.get(board_id);
//
//			if (detail != null) {
//				request.setAttribute("detail", detail);
//				return "/WEB-INF/views/boards/deletePopup.jsp";
//			} else {
//				return "redirect::/";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "redirect::/";
//		}
		return "/WEB-INF/views/boards/deletePopup.jsp";

	}

}
