package springbook.user.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.jdbc.SQLError;

import springbook.user.dao.UserDao;
import springbook.user.dao.UserDaoJDBC;
import springbook.user.domain.Level;
import springbook.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링의 테스트 컨텍스트 프레임워크의 JUnit 확장기능 지정
@ContextConfiguration(locations="/text-applicationContext.xml")
public class UserDaoTest{
	@Autowired
	private ApplicationContext context;
	private User user1;
	private User user2;
	private User user3;
	@Autowired 
	DataSource dataSource;
	@Autowired
	UserDao dao;
	@Before
	public void setUp() {
		this.dao = this.context.getBean("userDao", UserDaoJDBC.class);
		
		user1 = new User("gyumee", "박상철", "springno1", Level.BASIC, 1, 0);
		user2 = new User("leegw700", "이길원", "springno2", Level.SILVER, 55, 10);
		user3 = new User("bumjin", "박범진", "springno3", Level.GOLD, 100, 40);
	}
	
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
		System.out.println("hh"+user1.getId());
		System.out.println("hwwh"+userget1.toString());
		checkSameUser(userget1, user1);
		
		User userget2 = dao.get(user2.getId());
		checkSameUser(userget2, user2);
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
	
	@Test
	public void deleteTest() throws SQLException{
		dao.deleteAll();
		
		dao.add(user1);
		dao.add(user2);
		dao.add(user3);
	}

	@Test(expected=DataAccessException.class)
//	@Test
	public void duplicateKey(){
		dao.deleteAll();
		
		dao.add(user1);
		dao.add(user1);
	}
	
	@Test
	public void sqlExceptionTranslate(){
		dao.deleteAll();
		
		try{
			dao.add(user1);
			dao.add(user2);
		}
		catch(DuplicateKeyException ex){
			SQLException sqlEx = (SQLException)ex.getRootCause();
			//코드를 이용한 SQLException의 전환
			SQLExceptionTranslator set = new SQLErrorCodeSQLExceptionTranslator(this.dataSource);
			//에러 메세지를 사용할 때 사용하는 정보이므로 null을 넣어도 된다. 
			assertThat(set.translate(null, null, sqlEx), is(DuplicateKeyException.class));
		}
	}
	private void checkSameUser(User user1, User user2){
		assertThat(user1.getId(), is(user2.getId()));
		assertThat(user1.getName(), is(user2.getName()));
		assertThat(user1.getPassword(), is(user2.getPassword()));
		assertThat(user1.getLevel(), is(user2.getLevel()));
		assertThat(user1.getLogin(), is(user2.getLogin()));
		assertThat(user1.getRecommend(), is(user2.getRecommend()));
		
	}
}
