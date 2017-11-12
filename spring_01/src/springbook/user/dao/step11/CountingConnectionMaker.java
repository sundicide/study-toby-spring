//p122 1-30
package springbook.user.dao.step11;

import java.sql.Connection;
import java.sql.SQLException;

import springbook.user.dao.step05.ConnectionMaker;

public class CountingConnectionMaker implements ConnectionMaker{
	int counter = 0;
	private ConnectionMaker realConnectionMaker;

	
	public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
		this.realConnectionMaker = realConnectionMaker;
	}
	
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException{
		this.counter++;
		return realConnectionMaker.makeConnection();
	}
	
	public int getCount(){
		return this.counter;
	}

}
