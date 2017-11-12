package springbook.user.dao.step15;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.user.dao.step14.UserDao142;

public class UserDaoTest148 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("springbook/user/dao/step15/applicationContext145.xml");
		UserDao142 userDao = context.getBean("userDao", UserDao142.class);
		System.out.println(userDao.get("whiteship"));
	}

}
