package springbook.user.dao.step06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.user.dao.step03.StatementStrategy;
import springbook.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링의 테스트 컨텍스트 프레임워크의 JUnit 확장기능 지정
@ContextConfiguration(locations="/springbook/user/dao/step06/text-applicationContext.xml")
public class UserDao322{
	private User user1;
	private User user2;
	private User user3;
	private DataSource dataSource;
	
	@Autowired
	private JdbcContext jdbcContext;
	
	@Before
	public void setUp() {
		user1 = new User("gyumee", "박상철", "springno1");
		user2 = new User("leegw700", "이길원", "springno2");
		user3 = new User("bumjin", "박범진", "springno3");
	}
	//간략하게 만든 deleteAll
	@Test
	public void deleteAll() throws SQLException {
		jdbcContext.workWithStatementStrategy(
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
		add(user1);
		add(user2);
		add(user3);
	}
	
	//Addstatement를 익명 클래스로 변환
	public void add(User user) throws SQLException{
		System.out.println(jdbcContext);
		jdbcContext.workWithStatementStrategy(
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
