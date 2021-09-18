package business.abstracts;

import Entities.concretes.User;

public interface UserService {
	void signIn(User user);
	void logIn(User user);
	
}
