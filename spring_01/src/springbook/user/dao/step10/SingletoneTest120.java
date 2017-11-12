package springbook.user.dao.step10;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.dao.step06.UserDao111;
import springbook.user.dao.step09.DaoFactory118;
import springbook.user.domain.User;

public class SingletoneTest120 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		usingFactory();
		usingApplicationContext();
	}
	public static void usingFactory(){
		DaoFactory118 factory = new DaoFactory118();
		UserDao111 dao1 = factory.userDao();
		UserDao111 dao2 = factory.userDao();
		
		System.out.println(dao1);
		System.out.println(dao2);
	}
	public static void usingApplicationContext(){
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory118.class);
		
		UserDao111 dao3 = context.getBean("userDao", UserDao111.class);
		UserDao111 dao4 = context.getBean("userDao", UserDao111.class);
		
		System.out.println(dao3);
		System.out.println(dao4);
	}

}
