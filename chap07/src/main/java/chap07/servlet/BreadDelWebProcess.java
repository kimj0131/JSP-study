package chap07.servlet;

import javax.servlet.http.HttpServletRequest;

import chap07.dao.BreadDao;
import chap07.dto.BreadDTO;
import chap07.webprocess.WebProcess;

public class BreadDelWebProcess implements WebProcess {
	
	BreadDao breadDao = new BreadDao();

	@Override
	public String process(HttpServletRequest request) {
		String bread_name = request.getParameter("bread_name");
		
		// Integer result = breadDao.delete(new BreadDTO(bread_name, null));
		Integer result = breadDao.delete(bread_name);
		
		if (result == null) {
			return "redirect::" + request.getContextPath() + "/";
		} else if (result > 0){
			return "redirect::" + request.getContextPath() + "/dbtest/bread/list";
		} else {
			return "redirect::" + request.getContextPath() + "/";
		}
	}

}
