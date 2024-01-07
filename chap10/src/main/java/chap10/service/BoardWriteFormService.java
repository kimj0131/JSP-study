package chap10.service;

import javax.servlet.http.HttpServletRequest;

import chap10.dao.BoardDao;

public class BoardWriteFormService implements Service {
	
	private static BoardWriteFormService instance = new BoardWriteFormService();
	
	BoardDao boardDao = new BoardDao();
	
	public static BoardWriteFormService getInstance() {
		return instance;
	}
	
	private BoardWriteFormService() {
	}

	@Override
	public String service(HttpServletRequest request) {
		int nextBoard_idx = boardDao.getNextIndex();
		if (nextBoard_idx != -1) {
			request.setAttribute("nextBoard_idx", nextBoard_idx);
			return "/boardWriteForm.jsp";
		} else {
			System.out.println(nextBoard_idx);
			return "/homework.jsp";
		}
		
	}

}
