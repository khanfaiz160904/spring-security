package com.secured.service;

import com.secured.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	ArrayList<User> user = new ArrayList<>();

	public UserService() {
		user.add(new User("faiz", "faiz@gmail.com", "faiz@123"));
		user.add(new User("ayan", "ayan@gmail.com", "ayan@123"));
	}

	public boolean add(User use) {
		return user.add(use);
	}

	public User getUserByName(String name) throws Exception {
		for (User user : user) {
			if (user.getName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		throw new Exception();
	}

	public List<User> getAll() {
		return user;
	}

	public void deleteAll() {
		user.clear();
	}
}
