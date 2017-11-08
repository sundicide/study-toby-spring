package springbook.user.dao.step03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import springbook.user.dao.step01.UserDao;
import springbook.user.domain.User;

public abstract class UserDao15 {
	public void add(User user) throws ClassNotFoundException, SQLException{
		Connection c = getConnection();
		
		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException{
		Connection c = getConnection();
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
	
	public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
	
	public class NUserDao extends UserDao{
		public Connection getConnection() throws ClassNotFoundException, SQLException{
			//N荤 DB connection 积己 内靛
			return null;
		}
	}
	public class DUserDao extends UserDao{
		public Connection getConnection() throws ClassNotFoundException, SQLException{
			//D荤 DB connection 积己 内靛
			return null;
		}
	}
	
	
//	private Connection getConnection() throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "root","wlqkRKwl12#");
//		return c;
//	}
}
