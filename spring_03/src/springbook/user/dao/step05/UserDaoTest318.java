package springbook.user.dao.step05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import springbook.user.dao.step03.StatementStrategy;
import springbook.user.domain.User;


public class UserDaoTest318{
	private User user1;
	private User user2;
	private User user3;
	private DataSource dataSource;
	
	@Before
	public void setUp() {
		this.dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost/testdb","root","root",true);
		user1 = new User("gyumee", "박상철", "springno1");
		user2 = new User("leegw700", "이길원", "springno2");
		user3 = new User("bumjin", "박범진", "springno3");
	}
	public void jdbcContextWithStatementStrategy(StatementStrategy stat) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		
		try{
			c=dataSource.getConnection();
			
			ps = stat.makePreparedStatement(c);
			
			ps.executeUpdate();
			
		} catch(SQLException e){
			throw e;
		} finally {
			if(ps!=null){try{ps.close();} catch(SQLException e) {} }
			if(c!=null){try{c.close();} catch(SQLException e) {} }
		}
	}
	//간략하게 만든 deleteAll
	@Test
	public void deleteAll() throws SQLException {
		jdbcContextWithStatementStrategy(
				new StatementStrategy() {
					@Override
					public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
						return c.prepareStatement("delete from users");
					}
				}
		);
	}
	
	@Test
	public void addTest() throws SQLException{
//		add(user1);
	}
	
	//Addstatement를 익명 클래스로 변환
	public void add(User user) throws SQLException{
		jdbcContextWithStatementStrategy(
			new StatementStrategy() {
				@Override
				public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
					PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
					ps.setString(1,  user.getId());
					ps.setString(2, user.getName());
					ps.setString(3, user.getPassword());
					
					return ps;
				}
			}
		);
	}
}
