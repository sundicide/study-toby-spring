package springbook.user.dao.step09;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.user.dao.step01.UserDao;
import springbook.user.dao.step04.UserDao0207;
import springbook.user.dao.step06.UserDao0214;
import springbook.user.domain.User;

@DirtiesContext //테스트 메소드에서 애플리케이션 컨텍스트의 구성이나 상태를 변겨한다는 것을 테스트 컨텍스트 프레임워크에 알려준다. 
@RunWith(SpringJUnit4ClassRunner.class) // 스프링의 테스트 컨텍스트 프레임워크의 JUnit 확장기능 지정
@ContextConfiguration(locations="/springbook/user/dao/step06/applicationContextStep06.xml")
public class UserDaoTest0220 {
	@Autowired //테스트 오브젝트가 만들어지고 나면 스프링 테스트 컨텍스트에 의해 자동적으로 값이 주입된다.
	private ApplicationContext context;
	private UserDao0214 dao;
	private User user1;
	private User user2;
	private User user3;
	
	
	//@Test 메소드가 실행되기 전에 먼저 실행돼야 하는 메소드를 정의한다. 
	@Before
	public void setUp() {
		//테스트에서 UserDao가 사용할 DataSource 오브젝트를 직접 생성한다
		//SingleConnectionDataSource는 테스트용에 적합하다. DB 커넥션을 하나만 만들어두고 계속 사용하기 때문이다. 
		DataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost/testdb","root","root",true);

		this.dao = this.context.getBean("userDao", UserDao0214.class);
		
		dao.setDataSource(dataSource);
		
		user1 = new User("gyumee", "박상철", "springno1");
		user2 = new User("leegw700", "이길원", "springno2");
		user3 = new User("bumjin", "박범진", "springno3");
	}
	
	
	//테스트 중에 발상할 것으로 기대하는 예외 클래스를 지정한다.
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
