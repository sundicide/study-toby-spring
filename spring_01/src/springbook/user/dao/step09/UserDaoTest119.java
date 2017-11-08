package springbook.user.dao.step09;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.dao.step06.UserDao111;
import springbook.user.domain.User;

public class UserDaoTest119 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory118.class);
		UserDao111 dao = context.getBean("userDao", UserDao111.class);
		
		User user = new User();
		user.setId("whiteship");
		user.setName("백기선");;
		user.setPassword("married");
		
		dao.add(user);
		
		System.out.println(user.getId() + "등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " 조회 성공");

	}

}
