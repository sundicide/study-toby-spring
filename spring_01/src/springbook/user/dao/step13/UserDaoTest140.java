package springbook.user.dao.step13;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoTest140 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//대체로 Generic이 무난하다
//		ApplicationContext context = new GenericXmlApplicationContext("springbook/user/dao/step13/applicationContext.xml");
//		ApplicationContext context = new GenericXmlApplicationContext("applicationContext2.xml");
		//클래스패스의 경로정보를 클래스에서 가져온다. 
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", UserDao133.class);
		
		UserDao133 userDao = context.getBean("userDao",UserDao133.class);
		System.out.println(userDao.get("whiteship"));

	}

}
