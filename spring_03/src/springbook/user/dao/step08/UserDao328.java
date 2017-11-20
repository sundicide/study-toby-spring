package springbook.user.dao.step08;

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
import springbook.user.dao.step06.JdbcContext;
import springbook.user.domain.User;

public class UserDao328{
	private User user1;
	private User user2;
	private User user3;
	private DataSource dataSource;
	
	private JdbcContext328 jdbcContext;

	//수정자 메소드이면서 JdbcContext에 대한 생성, DI 작업을 동시에 수행한다.
	public void setDataSource(DataSource dataSource){
		this.jdbcContext = new JdbcContext328();
		
		this.jdbcContext.setDataSource(dataSource);
	}
	
	//간략하게 만든 deleteAll
	public void deleteAll() throws SQLException {
		this.jdbcContext.executeSql("delete from users");
	}
	
	
	//Addstatement를 익명 클래스로 변환
	public void add(User user) throws SQLException{
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
