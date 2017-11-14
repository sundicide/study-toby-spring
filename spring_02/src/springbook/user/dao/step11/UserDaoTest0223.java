package springbook.user.dao.step11;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import springbook.user.dao.step06.UserDao0214;
import springbook.user.domain.User;

/**
 * ���ø����̼� ���ؽ�Ʈ�� ������� �ʴ� ��� 
 * �ڵ�� �� �ܼ������� �����ϱ� ��������.
 * ������ �Ź� UserDao0214�� ��������ٴ� ������ �ִ�. 
 */
public class UserDaoTest0223 {
	private UserDao0214 dao;
	private User user1;
	private User user2;
	private User user3;
	
	
	@Before
	public void setUp() {
		dao = new UserDao0214();
		DataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost/testdb","root","root",true);
		dao.setDataSource(dataSource);
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