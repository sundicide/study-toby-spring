package springbook.user.dao.step14;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import springbook.user.dao.step05.ConnectionMaker;
import springbook.user.dao.step05.DConnectionMaker;
import springbook.user.dao.step06.UserDao111;

@Configuration	//���ø����̼� ���ؽ�Ʈ �Ǵ� �� ���丮�� ����� ����������� ǥ��
public class DaoFactory143 {
	@Bean	//������Ʈ ������ ����ϴ� IoC�� �޼ҵ��� ǥ��
	public UserDao142 userDao(){
		UserDao142 userDao = new UserDao142();
		userDao.setDataSource(dataSource());
		return userDao;
	}
	
	@Bean
	public DataSource dataSource(){
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost/springbook");
		dataSource.setUsername("root");
		dataSource.setPassword("wlqkRKwl12#");
		
		return dataSource;
	}
}
