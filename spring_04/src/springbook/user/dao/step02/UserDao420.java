package springbook.user.dao.step02;

import java.util.*;

import springbook.user.domain.User;

public interface UserDao420{
	void add(User user);
	User get(String id);
	List<User> getAll();
	void deleteAll();
	int getCount();
}
