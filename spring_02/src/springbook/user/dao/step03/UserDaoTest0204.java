package springbook.user.dao.step03;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.user.dao.step01.UserDao;
import springbook.user.domain.User;

public class UserDaoTest0204 {

	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("user");
		user.setName("백기선");
		user.setPassword("marries");
		
//		dao.add(user);
		
		System.out.println(user.getId() + "등록 성공");

		User user2 = dao.get(user.getId());
		
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user2.getPassword()));
	}
}
