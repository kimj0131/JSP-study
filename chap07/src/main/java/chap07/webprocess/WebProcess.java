package chap07.webprocess;

import javax.servlet.http.HttpServletRequest;

public interface WebProcess {
	
	String process(HttpServletRequest request);
	
}
