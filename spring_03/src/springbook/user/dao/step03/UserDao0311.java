package springbook.user.dao.step03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public abstract class UserDao0311{
	private DataSource dataSource;
	
	public void jdbcContextWithStatementStrategy(StatementStrategy stat) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		
		try{
			c=dataSource.getConnection();
			
			ps = stat.makePreparedStatement(c);
			
			ps.executeQuery();
		} catch(SQLException e){
			throw e;
		} finally {
			if(ps!=null){try{ps.close();} catch(SQLException e) {} }
			if(c!=null){try{c.close();} catch(SQLException e) {} }
		}
	}
	
	public void deleteAll() throws SQLException {
		StatementStrategy st = new DeleteAllStatement();
		jdbcContextWithStatementStrategy(st);
	}
}
