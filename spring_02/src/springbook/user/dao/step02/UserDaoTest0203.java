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
		user.setName("백기선");
		user.setPassword("marries");
		
//		dao.add(user);
		
		System.out.println(user.getId() + "등록 성공");

		User user2 = dao.get(user.getId());
		if(!user.getName().equals(user2.getName())) {
			System.out.println("테스트 실패 (name)");
		}
		else if(!user.getPassword().equals(user2.getPassword())) {
			System.out.println("테스트 실패 (password)");
		}
		else {
			System.out.println("조회 테스트 성공");
		}
	}

}
