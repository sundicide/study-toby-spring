package springbook.user.dao.step08;

import springbook.user.dao.step05.ConnectionMaker;
import springbook.user.dao.step05.DConnectionMaker;
import springbook.user.dao.step06.UserDao111;

public class DaoFactory117 {
	public UserDao111 userDao(){
		return new UserDao111(connectionMaker());
	}
	public AccountDao accountDao(){
		return new AccountDao(connectionMaker());
	}
	
	public ConnectionMaker connectionMaker(){
		return new DConnectionMaker();
	}
}
