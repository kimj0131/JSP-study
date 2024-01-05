package chap10.service;

import javax.servlet.http.HttpServletRequest;

public class FilterIndexService implements Service {

	private static FilterIndexService instance = new FilterIndexService();
	
	// 싱글톤 디자인 패턴 
	// - 이 클래스의 인스턴스가 프로그램에서 단 하나밖에 생성되지 않도록 하는 패턴
	public static FilterIndexService getInstance() {
		return instance;
	}
	
	// 외부에서 이 클래스의 인스턴스를 무단으로 생성하는 것을 방지한다
	private FilterIndexService() {
	}

	@Override
	public String service(HttpServletRequest request) {
		return "/WEB-INF/views/filter/index.jsp";
	}
}
