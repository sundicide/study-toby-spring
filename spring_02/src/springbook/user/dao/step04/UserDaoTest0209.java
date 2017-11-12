package springbook.user.dao.step04;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.user.dao.step01.UserDao;
import springbook.user.domain.User;

public class UserDaoTest0209 {

	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException{
		ApplicationContext context = new GenericXmlApplicationContext("springbook/user/dao/step04/applicationContextStep04.xml");
		
		UserDao0207 dao = context.getBean("userDao", UserDao0207.class);
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		User user = new User();
		user.setId("gyumee");
		user.setName("นฺป๓รถ");
		user.setPassword("springno1");
		
		dao.add(user);
		assertThat(dao.getCount(), is(1));
		
		User user2 = dao.get(user.getId());
		
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user2.getPassword()));
	}
}
