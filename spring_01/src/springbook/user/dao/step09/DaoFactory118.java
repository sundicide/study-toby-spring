package springbook.user.dao.step09;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springbook.user.dao.step05.ConnectionMaker;
import springbook.user.dao.step05.DConnectionMaker;
import springbook.user.dao.step06.UserDao111;

@Configuration	//애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시
public class DaoFactory118 {
	@Bean	//오브젝트 생성을 담당하는 IoC용 메소드라는 표시
	public UserDao111 userDao(){
		return new UserDao111(connectionMaker());
	}

	@Bean
	public ConnectionMaker connectionMaker(){
		return new DConnectionMaker();
	}
}
