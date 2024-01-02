package chap07.util;

import javax.servlet.http.HttpServletRequest;

public class UriParser {
	
	public static String getCmd(HttpServletRequest request) {
		return request.getRequestURI().substring(request.getContextPath().length());
	}

}
