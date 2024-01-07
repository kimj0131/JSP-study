package chap10.service;

import javax.servlet.http.HttpServletRequest;

import chap10.dao.BoardDao;

public class BoardUpdateFormService implements Service{
	
	private static BoardUpdateFormService instance = new BoardUpdateFormService();
	
	private BoardDao boardDao = new BoardDao();
	
	public static BoardUpdateFormService getInstance() {
		return instance;
	}
	
	private BoardUpdateFormService() {
		
	}
	
	@Override
	public String service(HttpServletRequest request) {
		String updateIdxStr = request.getParameter("update_idx");
		String checkPwd = request.getParameter("update_chk_pwd");
		
		if (updateIdxStr != null && checkPwd != null) {
			int updateIdx = Integer.parseInt(updateIdxStr);
			
			if (boardDao.checkPassward(updateIdx, checkPwd)) {
				request.setAttribute("board", boardDao.getBoardDetailWihtoutReplace(updateIdx));
				return "/boardUpdateForm.jsp";
			} else {
				return "redirect::" + request.getContextPath() + "/board/pwdErr";
			}
		}
		return "redirect::" + request.getContextPath() + "/board/pwdErr";
	}
}
