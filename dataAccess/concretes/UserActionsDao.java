package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import Entities.concretes.User;
import dataAccess.abstracts.UserDao;


public class UserActionsDao implements UserDao{
	List<User> users = new ArrayList<>();


	@Override
	public boolean getEmail(String email) {
		for(User user : users) {
			if (user.getEmail() == email) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getPassword(String password) {
		for(User user : users) {
			if(user.getPassword() == password) return true;
		}
		return false;
	}

	@Override
	public List<User> getAll() {
		for(User user : users) {
			System.out.println(user.getEmail());
		}
		return null;
	}

	@Override
	public void add(User user) {
		users.add(user);
	}

	@Override
	public void update(User user) {
	}

	@Override
	public void delete(User user) {
		users.remove(user);
	}

}
