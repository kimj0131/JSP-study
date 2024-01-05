package chap10.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap10.service.FilterIndexService;
import chap10.service.Service;

public class ApplicationServlet extends HttpServlet{
	
	static Map<String, Service> uriMapping = new HashMap<>();
	
	static String REDIRECT_PREFIX = "redirect::"; 
	static int REDIRECT_PREFIX_LEN = REDIRECT_PREFIX.length();
	
	@Override
	public void init() throws ServletException {
		uriMapping.put("GET:/filter", FilterIndexService.getInstance());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getMethod() + ":" + req.getRequestURI().substring(req.getContextPath().length());
		
		String nexteView = uriMapping.get(cmd).service(req);
		
		if (nexteView.startsWith(REDIRECT_PREFIX)) {
			resp.sendRedirect(nexteView.substring(REDIRECT_PREFIX_LEN));
		} else {
			req.getRequestDispatcher(nexteView).forward(req, resp);
		}
	}
}
