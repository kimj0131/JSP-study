package chap10.service;

import javax.servlet.http.HttpServletRequest;

public class UpdateAlertService implements Service {
	private static UpdateAlertService instance = new UpdateAlertService();
	
	public static UpdateAlertService getInstance() {
		return instance;
	}
	
	private UpdateAlertService() {
		
	}

	@Override
	public String service(HttpServletRequest request) {
		request.setAttribute("updated", true);
		return "/";
	}
}
