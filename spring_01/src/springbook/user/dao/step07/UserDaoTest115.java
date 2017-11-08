package springbook.user.dao.step07;
import java.sql.SQLException;

import springbook.user.dao.step05.ConnectionMaker;
import springbook.user.dao.step05.DConnectionMaker;
import springbook.user.dao.step06.UserDao111;
import springbook.user.domain.User;

public class UserDaoTest115 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao111 dao = new DaoFactory().userDao();
		
		User user = new User();
		user.setId("whiteship");
		user.setName("��⼱");;
		user.setPassword("married");
		
		dao.add(user);
		
		System.out.println(user.getId() + "��� ����");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " ��ȸ ����");

	}

}
