package springbook.user.dao.step03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public abstract class UserDao0310{
	private DataSource dataSource;
	abstract protected PreparedStatement makeStatement(Connection c) throws SQLException; 
	
	
	public void deleteAll() throws SQLException{
		Connection c = null;
		PreparedStatement ps = null;
		
		try{
			c = dataSource.getConnection();
			
			//�и��ؾ��� ���ɻ� 
			StatementStrategy strategy = new DeleteAllStatement();
			ps = strategy.makePreparedStatement(c);
		}catch (SQLException e){
			throw e;
		}finally{
			if( ps!= null){
				try{
					ps.close();
				} catch(SQLException e){
					//ps.close() �޼ҵ忡���� SQLException�� �߻��� �� �ֱ� ������ �̸� ������ �Ѵ�
					//�׷��� ������ Connection�� close()���� ���ϰ� �޼ҵ带 �������� �� �ִ�. 
				}
			}if (c!=null){
				try{
					c.close();
				}catch(SQLException e){
					
				}
			}
		}
	}
	public int getCount() throws SQLException{
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			c = dataSource.getConnection();
			
			ps = c.prepareStatement("select count(*) from users");
			
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e){
			throw e;
		}finally {
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException e){ 
					//close()�� ������� ���� �����̴�.
				}
			}
			if(ps!=null){
				try{
					ps.close();
				}catch(SQLException e){ }
			}
			if(c!= null){
				try{
					c.close();
				}catch(SQLException e){ }
			}
		}
	}
	
}
