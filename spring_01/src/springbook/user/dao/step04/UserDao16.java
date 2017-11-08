package springbook.user.dao.step04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.dao.step01.UserDao;
import springbook.user.domain.User;

public abstract class UserDao16 {
	private SimpleConnectionMaker simpleConnectionMaker;
	
	public UserDao16(){
		simpleConnectionMaker = new SimpleConnectionMaker();
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException{
		Connection c = simpleConnectionMaker.makeNewConnection();
		
		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException{
		Connection c = simpleConnectionMaker.makeNewConnection();
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
			//N�� DB connection ���� �ڵ�
			return null;
		}
	}
	public class DUserDao extends UserDao{
		public Connection getConnection() throws ClassNotFoundException, SQLException{
			//D�� DB connection ���� �ڵ�
			return null;
		}
	}
	
	

}
