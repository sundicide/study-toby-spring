package springbook.user.dao.step07;

import springbook.user.dao.step05.ConnectionMaker;
import springbook.user.dao.step05.DConnectionMaker;
import springbook.user.dao.step06.UserDao111;

public class DaoFactory {
	public UserDao111 userDao(){
		ConnectionMaker connectionMaker = new DConnectionMaker();
		UserDao111 userDao = new UserDao111(connectionMaker);
		return userDao;
	}
}

/**
 * 제어의 역전 / IoC
 */
