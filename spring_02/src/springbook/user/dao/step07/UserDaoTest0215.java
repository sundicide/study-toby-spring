package springbook.user.dao.step07;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import springbook.user.dao.step01.UserDao;
import springbook.user.dao.step04.UserDao0207;
import springbook.user.dao.step06.UserDao0214;
import springbook.user.domain.User;

public class UserDaoTest0215 {
	private UserDao0214 dao;
	private User user1;
	private User user2;
	private User user3;
	
	
	//@Test �޼ҵ尡 ����Ǳ� ���� ���� ����ž� �ϴ� �޼ҵ带 �����Ѵ�. 
	@Before
	public void setUp() {
		ApplicationContext context = new GenericXmlApplicationContext("springbook/user/dao/step06/applicationContextStep06.xml");
		this.dao = context.getBean("userDao", UserDao0214.class);
		
		user1 = new User("gyumee", "�ڻ�ö", "springno1");
		user2 = new User("leegw700", "�̱��", "springno2");
		user3 = new User("bumjin", "�ڹ���", "springno3");
	}
	
	
	//�׽�Ʈ �߿� �߻��� ������ ����ϴ� ���� Ŭ������ �����Ѵ�.
	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException, ClassNotFoundException{
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.get("unknown_id");
	}
	
	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException{
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		dao.add(user2);
		assertThat(dao.getCount(), is(2));
		
		User userget1 = dao.get(user1.getId());
		assertThat(userget1.getName(), is(user1.getName()));
		assertThat(userget1.getPassword(), is(user1.getPassword()));
		
		User userget2 = dao.get(user2.getId());
		assertThat(userget2.getName(), is(user2.getName()));
		assertThat(userget2.getPassword(), is(user2.getPassword()));
	}
	
	@Test
	public void count() throws SQLException, ClassNotFoundException{		
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		assertThat(dao.getCount(), is(1));

		dao.add(user2);
		assertThat(dao.getCount(), is(2));
		
		dao.add(user3);
		assertThat(dao.getCount(), is(3));
		
	}
}