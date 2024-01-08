package board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import oracle.net.aso.f;

public class BoardDetailService implements Service{
	
	private static BoardDetailService instance = new BoardDetailService();
	
	public static BoardDetailService getInstance() {
		return instance;
	}
	
	private BoardDetailService() {
	}
	
	BoardDAO dao = new BoardDAO();
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		boolean plused = false;
		
		Cookie[] cookies = request.getCookies();
		
		// 글 번호와 같은 이름을 지닌 쿠키가 존재하는지 여부를 체크(해당 쿠키가 존재하면 글 조회수를 증가시킨 적이 있다는 뜻)
		if (cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("" + board_id)) {
					plused = true;
				}
			}
		}
		
		// 글 번호와 같은 이름의 쿠키가 조회된적이 없다면 조회수를 증가시키고 쿠키를 등록
		if (!plused) {
			int row = dao.plusView(board_id);
			response.addCookie(new Cookie("" + board_id, "1"));
			
			if (row < 1) {
				return "/WEB-INF/views/boards/detailNotFound.jsp";
			}
		}
		
		BoardDTO detail = dao.get(board_id);
		
		if (detail != null) {
			request.setAttribute("detail", detail);
			return "/WEB-INF/views/boards/detail.jsp";
		} else {
			return "/WEB-INF/views/boards/detailNotFound.jsp";
		}
	}
}
