package springbook.user.dao.step12;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.dao.step06.UserDao111;
import springbook.user.dao.step11.CountingConnectionMaker;

public class UserDaoConnectionCountingTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(CountingDaoFactory134.class);
		UserDao133  dao = context.getBean("userDao", UserDao133.class);

		//DAO 사용 코드
		dao.get("whiteship");
		dao.get("whiteship");
		dao.get("whiteship");
		////
		
		
		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println("Connection counter: " + ccm.getCount());
	}
}
