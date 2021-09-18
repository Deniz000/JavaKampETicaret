package business.concretes;

import Entities.concretes.User;
import business.abstracts.UserService;
import business.abstracts.VerificationService;
import dataAccess.abstracts.UserDao;

public class UserManager implements UserService{
	UserCheckManager checkManager;
	VerificationService mailVerificationService;
	UserDao userDao;
	
	public UserManager(UserCheckManager checkManager, VerificationService mailVerificationService, UserDao userDao) {
		super();
		this.checkManager = checkManager;
		this.mailVerificationService = mailVerificationService;
		this.userDao = userDao;
	}

	@Override
	public void signIn(User user) {
		if (checkManager.isValid(user) == true) {
			System.out.print(user.getFirstName() + " kullanýcýsý baþarýyla sisteme eklendi.\n");
			mailVerificationService.sendToVerifyMail(user.getEmail());
			userDao.add(user);
		}
	}

	@Override
	public void logIn(User user) {
		mailVerificationService.verifyMail(user.getEmail());

		if (userDao.getEmail(user.getEmail()) && userDao.getPassword(user.getPassword())
				&& mailVerificationService.checkVerifyAccount(user.getEmail()) == true) {
			System.out.println("Kullanýcý giriþi baþarýyla yapýldý.");
		} 
		else if (mailVerificationService.checkVerifyAccount(user.getEmail()) == false) {
			System.out.println("Kullanýcý bilgileri doðru. Fakat mail adresi doðrulanmadýðý için giriþ yapýlamýyor.");
		} 
		else {
			System.out.println("Kullanýcý bilgileri yanlýþ, lütfen kontrol ediniz.");
		}		
	}


}
