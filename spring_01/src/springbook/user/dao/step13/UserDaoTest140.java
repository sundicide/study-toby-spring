package springbook.user.dao.step13;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoTest140 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//��ü�� Generic�� �����ϴ�
//		ApplicationContext context = new GenericXmlApplicationContext("springbook/user/dao/step13/applicationContext.xml");
//		ApplicationContext context = new GenericXmlApplicationContext("applicationContext2.xml");
		//Ŭ�����н��� ��������� Ŭ�������� �����´�. 
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", UserDao133.class);
		
		UserDao133 userDao = context.getBean("userDao",UserDao133.class);
		System.out.println(userDao.get("whiteship"));

	}

}
