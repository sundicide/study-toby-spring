package springbook.user.dao.step01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.jdbc.MysqlErrorNumbers;

import springbook.user.domain.User;

public class UserDao{
	private User user1;
	private User user2;
	private User user3;
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
		this.dataSource = dataSource;
	}
	
	//간략하게 만든 deleteAll
	public void deleteAll() throws SQLException {
		//1번 방식
		this.jdbcTemplate.update(
				new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						// TODO Auto-generated method stub
						return con.prepareStatement("delete from usres");
					}
				}
			);
		//2번 방식
		//this.jdbcTemplate.update("delete from users");
	}
	
	
	public void add(User user) throws DuplicateUserIdException{
		try{
			Connection c = null;
			PreparedStatement ps = null;
			DataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost/testdb","root","root",true);
			c = dataSource.getConnection();
			//기타 등등
		}catch(SQLException e){
			if(e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY)
				throw new DuplicateUserIdException(e);
			else
				throw new RuntimeException(e);
		}
	}
	
	/*
	public int getCount(){
		return this.jdbcTemplate.queryForInt(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				return con.prepareStatement("select count(*) from users");
			}
		}, new ResultSetExtractor<Integer>() {
			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				rs.next();
				return rs.getInt(1);
			}
		});
	}
	*/
}
