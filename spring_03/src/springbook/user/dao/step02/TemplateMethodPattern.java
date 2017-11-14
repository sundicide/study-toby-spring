package springbook.user.dao.step02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public abstract class TemplateMethodPattern{
	private DataSource dataSource;
	abstract protected PreparedStatement makeStatement(Connection c) throws SQLException; 
	
	
	public void deleteAll() throws SQLException{
		Connection c = null;
		PreparedStatement ps = null;
		
		try{
			c = dataSource.getConnection();
			ps = makeStatement(c);
		}catch (SQLException e){
			throw e;
		}finally{//예외가 발생했을 때나 안했을 때나 모두 실행된다
			if( ps!= null){
				try{
					ps.close();
				} catch(SQLException e){
					//ps.close() 메소드에서도 SQLException이 발생할 수 있기 때문에 이를 잡아줘야 한다
					//그렇지 않으면 Connection을 close()하지 못하고 메소드를 빠져나갈 수 있다. 
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
					//close()는 만들어진 순서 역순이다.
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
