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
			System.out.print(user.getFirstName() + " kullan�c�s� ba�ar�yla sisteme eklendi.\n");
			mailVerificationService.sendToVerifyMail(user.getEmail());
			userDao.add(user);
		}
	}

	@Override
	public void logIn(User user) {
		mailVerificationService.verifyMail(user.getEmail());

		if (userDao.getEmail(user.getEmail()) && userDao.getPassword(user.getPassword())
				&& mailVerificationService.checkVerifyAccount(user.getEmail()) == true) {
			System.out.println("Kullan�c� giri�i ba�ar�yla yap�ld�.");
		} 
		else if (mailVerificationService.checkVerifyAccount(user.getEmail()) == false) {
			System.out.println("Kullan�c� bilgileri do�ru. Fakat mail adresi do�rulanmad��� i�in giri� yap�lam�yor.");
		} 
		else {
			System.out.println("Kullan�c� bilgileri yanl��, l�tfen kontrol ediniz.");
		}		
	}


}
