package springbook.user.dao.step03;

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
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.jdbc.SQLError;

import springbook.user.dao.step01.UserDao;
import springbook.user.dao.step02.UserDao420;
import springbook.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class) // �������� �׽�Ʈ ���ؽ�Ʈ �����ӿ�ũ�� JUnit Ȯ���� ����
@ContextConfiguration(locations="/springbook/user/dao/step02/text-applicationContext.xml")
public class UserDaoTest423{
	@Autowired
	private ApplicationContext context;
	private User user1;
	private User user2;
	private User user3;
	@Autowired DataSource dataSource;
	@Autowired UserDao420 dao;
	
	@Before
	public void setUp() {
//		this.dao = this.context.getBean("userDao", UserDaoJDBC.class);
		
		user1 = new User("gyumee", "�ڻ�ö", "springno1");
		user2 = new User("leegw700", "�̱��", "springno2");
		user3 = new User("bumjin", "�ڹ���", "springno3");
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
			//�ڵ带 �̿��� SQLException�� ��ȯ
			SQLExceptionTranslator set = new SQLErrorCodeSQLExceptionTranslator(this.dataSource);
			//���� �޼����� ����� �� ����ϴ� �����̹Ƿ� null�� �־ �ȴ�. 
			assertThat(set.translate(null, null, sqlEx), is(DuplicateKeyException.class));
		}
	}
}
