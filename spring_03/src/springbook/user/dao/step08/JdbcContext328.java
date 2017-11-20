package springbook.user.dao.step08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import springbook.user.dao.step03.StatementStrategy;

/*
 * jdbcContextWithStatementStrategy()는 다른 DAO에서도 사용 가능하다
 * 그러니 jdbcContextWithStatementStrategy를 UserDao 클래스 밖으로 독립시켜서 
 * 모든 Dao가 사용할 수 있도록 하자.
 */
public class JdbcContext328 {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = dataSource.getConnection();
			ps = stmt.makePreparedStatement(c);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			;
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
			;
		}

	}

	public void executeSql(final String query) throws SQLException {
		workWithStatementStrategy(new StatementStrategy() {
			@Override
			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
				// TODO Auto-generated method stub
				return c.prepareStatement(query);
			}
		});
	}

}
