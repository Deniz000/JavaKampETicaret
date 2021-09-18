package business.abstracts;

import Entities.concretes.User;

public interface UserCheckService {
	boolean checkFirstName(User user);
	boolean checkLastName(User user);
	boolean checkEmail(User user);
	boolean checkPassword(User user);
	boolean uniqueEmail(User user);
	boolean isValid(User user);
}
