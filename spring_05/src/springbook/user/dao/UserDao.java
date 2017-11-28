package springbook.user.dao;

import java.util.*;

import springbook.user.domain.User;

public interface UserDao{
	void add(User user);
	User get(String id);
	List<User> getAll();
	void deleteAll();
	int getCount();
}
