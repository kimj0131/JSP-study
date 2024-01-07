package chap10.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap10.service.BoardDeleteFormService;
import chap10.service.BoardDetailService;
import chap10.service.BoardIndexService;
import chap10.service.BoardUpdateFormService;
import chap10.service.BoardUpdateService;
import chap10.service.BoardWriteFormService;
import chap10.service.BoardWriteService;
import chap10.service.DeleteAlertService;
import chap10.service.FilterIndexService;
import chap10.service.PwdCheckErrorService;
import chap10.service.Service;
import chap10.service.UpdateAlertService;
import chap10.service.WriteErrorService;

public class ApplicationServlet extends HttpServlet{
	
	static Map<String, Service> uriMapping = new HashMap<>();
	
	static String REDIRECT_PREFIX = "redirect::"; 
	static int REDIRECT_PREFIX_LEN = REDIRECT_PREFIX.length();
	
	@Override
	public void init() throws ServletException {
		uriMapping.put("GET:/filter", FilterIndexService.getInstance());
		
		uriMapping.put("GET:/board/writeErr", WriteErrorService.getInstance());
		uriMapping.put("GET:/board/pwdErr", PwdCheckErrorService.getInstance());
		
		uriMapping.put("GET:/board/updated", UpdateAlertService.getInstance());
		uriMapping.put("GET:/board/deleted", DeleteAlertService.getInstance());
		
		uriMapping.put("GET:/", BoardIndexService.getInstance());
		uriMapping.put("GET:/board/detail", BoardDetailService.getInstance());
		uriMapping.put("GET:/board/writeform", BoardWriteFormService.getInstance());
		uriMapping.put("POST:/board/write", BoardWriteService.getInstance());
		uriMapping.put("POST:/board/updateForm", BoardUpdateFormService.getInstance());
		uriMapping.put("POST:/board/update", BoardUpdateService.getInstance());
		uriMapping.put("POST:/board/deleteForm", BoardDeleteFormService.getInstance());
		
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
