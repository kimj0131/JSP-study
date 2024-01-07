package chap10.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SQLInjectionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String name = request.getParameter("userName");
		
		// 위험한 SQL 문자열이 있는지 검사를 한다... --, ;
		// if (name.contains())
		
		// 글 내용중 자바스크립트 소스가 포함되어있는지 검사한다.. (XSS 공격 대비)
		System.out.println("포함된 데이터들을 검사하는 중입니다...");
		
		chain.doFilter(request, response);
	}

}
