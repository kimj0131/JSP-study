package chap10.service;

import javax.servlet.http.HttpServletRequest;

import chap10.dao.BoardDao;

public class BoardDeleteFormService implements Service{
	
	private static BoardDeleteFormService instance = new BoardDeleteFormService();
	
	private BoardDao boardDao = new BoardDao();
	
	public static BoardDeleteFormService getInstance() {
		return instance;
	}

	private BoardDeleteFormService() {
		
	}
	
	@Override
	public String service(HttpServletRequest request) {
		String deleteIdxStr = request.getParameter("del_idx");
		String checkPwd = request.getParameter("del_chk_pwd");
		
		if (deleteIdxStr != null && checkPwd != null) {
			int deleteIdx = Integer.parseInt(deleteIdxStr);
			
			if (boardDao.checkPassward(deleteIdx, checkPwd)) {
				Integer result = boardDao.delete(deleteIdx);
				if (result == null) {
					return "redirect::" + request.getContextPath() + "/board/writeErr";
				} else if (result > 0){
					return "redirect::" + request.getContextPath() + "/board/deleted";
				} else {
					return "redirect::" + request.getContextPath() + "/board/writeErr";
				}
			} else {
				return "redirect::" + request.getContextPath() + "/board/pwdErr";
			}
		}
		return "redirect::" + request.getContextPath() + "/board/pwdErr";
	}

}
