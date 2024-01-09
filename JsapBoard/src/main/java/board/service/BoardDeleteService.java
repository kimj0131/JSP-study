package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardDeleteService implements Service {

	private static BoardDeleteService instance = new BoardDeleteService();

	BoardDAO dao = new BoardDAO();

	public static BoardDeleteService getInstance() {
		return instance;
	}

	private BoardDeleteService() {
	}

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {

		try {
			int board_id = Integer.parseInt(request.getParameter("board_id"));
			String board_password = request.getParameter("board_password");

//			System.out.println(board_id);
//			System.out.println(board_password);

			// 풀어본 코드
//			int result = dao.delete(board_id);
//
//			if (result < 1) {
//				throw new Exception("게시글 삭제 도중 에러 발생");
//			}

			BoardDTO ori = dao.get(board_id);

			if (ori.getBoard_password().equals(board_password)) {
				if (dao.delete(board_id) < 1) {
					throw new Exception("삭제가 올바르게 진행되지 않았습니다!");
				}
			} else {
				throw new Exception("지우려는 글의 비밀번호와 일치하지 않습니다.");
			}

			return "redirect::/list";
		} catch (Exception e) {
			e.printStackTrace();
//			return "redirect::/detail?board_id=" + board_id;
			return "/WEB-INF/views/boards/deleteFail.jsp";
		}

	}

}
