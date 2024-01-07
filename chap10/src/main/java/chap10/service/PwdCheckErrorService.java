package chap10.service;

import javax.servlet.http.HttpServletRequest;

public class PwdCheckErrorService implements Service {
	
	private static PwdCheckErrorService instance = new PwdCheckErrorService();
	
	public static PwdCheckErrorService getInstance() {
		return instance;
	}

	private PwdCheckErrorService() {
	}
	
	@Override
	public String service(HttpServletRequest request) {
		request.setAttribute("pwdErr", true);
		return "/";
	}

}
