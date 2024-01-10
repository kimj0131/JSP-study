package board.dao;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DBConnector {

	private static Set<DBSession> sessions = new HashSet<>();

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			sessions.add(new DBSession());
		}
	}

	public static DBSession getSession() throws SQLException {
		while (true) {
			for (DBSession session : sessions) {
				if (!session.using) {
					// 해당 DB세션을 사용중으로 변경
					session.using = true;
					return session;
				}
			}
			// 10개 모두 사용중이면 최대치를 늘려준다...?
		}
	}
}
