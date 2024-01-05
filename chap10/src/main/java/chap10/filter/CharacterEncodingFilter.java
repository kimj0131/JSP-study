package chap10.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{
	
	String charset;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	 	this.charset = filterConfig.getInitParameter("encodingType");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(charset);
		
		System.out.println("요청을 " + charset + "으로 해석하도록 설정했습니다");
		
		chain.doFilter(request, response);
	}
}
