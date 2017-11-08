package springbook.user.dao.step08;

import springbook.user.dao.step05.ConnectionMaker;

public class AccountDao {
	private ConnectionMaker connectionMaker;
	
	public AccountDao(ConnectionMaker connectionMaker){
		this.connectionMaker = connectionMaker;
	}
}
