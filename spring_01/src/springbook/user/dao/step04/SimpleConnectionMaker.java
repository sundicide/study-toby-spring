package springbook.user.dao.step04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "root","wlqkRKwl12#");
		return c;
	}
}
/**
 * 전략패턴
 * UserDao16에서는 SimpleConnectionMaker에서 어떤 변화가 일어나던지 관심 없다 
 * 단지 SimpleConnectionMaker에 있는 makeNewConnection()만 쓸 뿐이다.
 */
