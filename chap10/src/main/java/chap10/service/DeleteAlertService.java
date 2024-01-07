package chap10.service;

import javax.servlet.http.HttpServletRequest;

public class DeleteAlertService implements Service{
	
	private static DeleteAlertService instance = new DeleteAlertService();
	
	public static DeleteAlertService getInstance() {
		return instance;
	}
	
	private DeleteAlertService() {
		
	}

	@Override
	public String service(HttpServletRequest request) {
		request.setAttribute("deleted", true);
		return "/";
	}
}
