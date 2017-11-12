package springbook.user.dao.step02;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.user.dao.step01.UserDao;
import springbook.user.domain.User;

public class UserDaoTest0203 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("user");
		user.setName("��⼱");
		user.setPassword("marries");
		
//		dao.add(user);
		
		System.out.println(user.getId() + "��� ����");

		User user2 = dao.get(user.getId());
		if(!user.getName().equals(user2.getName())) {
			System.out.println("�׽�Ʈ ���� (name)");
		}
		else if(!user.getPassword().equals(user2.getPassword())) {
			System.out.println("�׽�Ʈ ���� (password)");
		}
		else {
			System.out.println("��ȸ �׽�Ʈ ����");
		}
	}

}
