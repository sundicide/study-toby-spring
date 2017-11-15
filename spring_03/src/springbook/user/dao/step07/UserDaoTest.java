package springbook.user.dao.step07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.user.dao.step01.UserDao;
import springbook.user.dao.step03.StatementStrategy;
import springbook.user.dao.step06.JdbcContext;
import springbook.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class) // �������� �׽�Ʈ ���ؽ�Ʈ �����ӿ�ũ�� JUnit Ȯ���� ����
@ContextConfiguration(locations="/springbook/user/dao/step07/text-applicationContext.xml")
public class UserDaoTest{
	@Autowired
	private ApplicationContext context;
	private User user1;
	private User user2;
	private User user3;
	private DataSource dataSource;
	private UserDao325 userDao;
	
	@Before
	public void setUp() {
		this.userDao = this.context.getBean("userDao", UserDao325.class);
		
		user1 = new User("gyumee", "�ڻ�ö", "springno1");
		user2 = new User("leegw700", "�̱��", "springno2");
		user3 = new User("bumjin", "�ڹ���", "springno3");
	}
	
	@Test
	public void deleteTest() throws SQLException{
		userDao.deleteAll();
		
		userDao.add(user1);
		userDao.add(user2);
		userDao.add(user3);
	}
}
