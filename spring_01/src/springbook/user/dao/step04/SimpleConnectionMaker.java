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
 * ��������
 * UserDao16������ SimpleConnectionMaker���� � ��ȭ�� �Ͼ���� ���� ���� 
 * ���� SimpleConnectionMaker�� �ִ� makeNewConnection()�� �� ���̴�.
 */
