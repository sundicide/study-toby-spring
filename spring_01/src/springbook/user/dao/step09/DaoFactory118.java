package springbook.user.dao.step09;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springbook.user.dao.step05.ConnectionMaker;
import springbook.user.dao.step05.DConnectionMaker;
import springbook.user.dao.step06.UserDao111;

@Configuration	//���ø����̼� ���ؽ�Ʈ �Ǵ� �� ���丮�� ����� ����������� ǥ��
public class DaoFactory118 {
	@Bean	//������Ʈ ������ ����ϴ� IoC�� �޼ҵ��� ǥ��
	public UserDao111 userDao(){
		return new UserDao111(connectionMaker());
	}

	@Bean
	public ConnectionMaker connectionMaker(){
		return new DConnectionMaker();
	}
}
