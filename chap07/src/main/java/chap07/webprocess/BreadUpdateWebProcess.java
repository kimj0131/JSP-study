package chap07.webprocess;

import javax.servlet.http.HttpServletRequest;

import chap07.dao.BreadDao;
import chap07.dto.BreadDTO;

public class BreadUpdateWebProcess implements WebProcess {

	BreadDao breadDao = new BreadDao();
	
	@Override
	public String process(HttpServletRequest request) {
		String find_bread_name = request.getParameter("find_bread_name");
		
		String bread_name = request.getParameter("bread_name");
		Integer bread_price = Integer.parseInt(request.getParameter("bread_price"));
		
		Integer result = breadDao.update(new BreadDTO(bread_name, bread_price), find_bread_name);
		
		if (result == null) {
			return "redirect::" + request.getContextPath() + "/";
		} else if (result > 0){
			return "redirect::" + request.getContextPath() + "/dbtest/bread/list";
		} else {
			return "redirect::" + request.getContextPath() + "/";
		}
	}

}
