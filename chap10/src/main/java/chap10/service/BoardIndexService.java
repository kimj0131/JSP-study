package chap10.service;

import javax.servlet.http.HttpServletRequest;

import chap10.dao.BoardDao;

public class BoardIndexService implements Service {

	private static BoardIndexService instance = new BoardIndexService();
	
	private BoardDao boardDao = new BoardDao();
 
	public static BoardIndexService getInstance() {
		return instance;
	}

	private BoardIndexService() {
	}

	@Override
	public String service(HttpServletRequest request) {
		request.setAttribute("boardTitleList", boardDao.getBoardTitleList());
		return "/homework.jsp";
	}
}
