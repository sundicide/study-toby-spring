package springbook.user.dao.step03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import springbook.user.domain.User;


public class UserDaoTest0311{
	private User user1;
	private User user2;
	private User user3;
	private DataSource dataSource;
	
	@Before
	public void setUp() {
//		dao = new UserDao0214();
		this.dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost/testdb","root","root",true);
//		dao.setDataSource(dataSource);
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
	@Test
	public void deleteAll() throws SQLException {
		StatementStrategy st = new DeleteAllStatement();
		jdbcContextWithStatementStrategy(st);
	}
	
	@Test
	public void add() throws SQLException{
		StatementStrategy st = new AddStatement(user1);
		StatementStrategy st2 = new AddStatement(user2);
		StatementStrategy st3 = new AddStatement(user3);
		jdbcContextWithStatementStrategy(st);
		jdbcContextWithStatementStrategy(st2);
		jdbcContextWithStatementStrategy(st3);
	}
}
