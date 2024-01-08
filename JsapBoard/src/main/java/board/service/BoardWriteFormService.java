package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteFormService implements Service{
	
	private static BoardWriteFormService instance = new BoardWriteFormService();
	
	public static BoardWriteFormService getInstance() {
		return instance;
	}
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/views/boards/writeForm.jsp";
	}

}
