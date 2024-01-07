package chap10.service;

import javax.servlet.http.HttpServletRequest;

public class WriteErrorService implements Service {
	
	private static WriteErrorService instance = new WriteErrorService();
	
	public static WriteErrorService getInstance() {
		return instance;
	}

	private WriteErrorService() {
	}
	
	@Override
	public String service(HttpServletRequest request) {
		request.setAttribute("writeErr", true);
		return "/";
	}

}
