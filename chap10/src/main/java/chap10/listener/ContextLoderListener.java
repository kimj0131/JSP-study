package chap10.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// ServletContextListener : 컨텍스트 내부 내용에 변화가 있어 리로드할 때 호출되는 이벤트 리스너
// web.xml에 등록해야 한다
public class ContextLoderListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ContextLoderListener : 컨텍스트 내부에 수정된 사항이 있었습니다...");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ContextLoderListener : 컨텍스트가 파괴되었습니다...");
	}
}
