package springbook.user.dao.step05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import springbook.user.domain.User;

public class UserDao110 {
	//�������̽��� ���� ������Ʈ�� �����ϹǷ� ��ü���� Ŭ���� ������ �� �ʿ䰡 ����
	private ConnectionMaker connectionMaker;
	
	//��! �׷��� ���⿡�� Ŭ���� �̸��� ������!!
	public UserDao110(){
		connectionMaker = new DConnectionMaker();
	}
	public void add(User user) throws ClassNotFoundException, SQLException{
		//�������̽��� ���ǵ� �޼ҵ带 ����ϹǷ� Ŭ������ �ٲ�ٰ� �ص� �޼ҵ� �̸��� ����� ������ ����.
		Connection c = connectionMaker.makeConnection();
		
		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException{
		Connection c = connectionMaker.makeConnection();
		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "root","wlqkRKwl12#");
		return c;
	}
}