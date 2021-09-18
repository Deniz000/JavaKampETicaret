package business.concretes;

import java.util.ArrayList;
import java.util.List;

import business.abstracts.VerificationService;

public class MailVerificationManager implements VerificationService{

	UserCheckManager checkManager;
	List<String> verificatedEmails = new ArrayList<>();
	@Override
	public void sendToVerifyMail(String email) {
		System.out.println(email + " kullan�c�ya do�rulama maili g�nderildi.");
	}

	@Override
	public void verifyMail(String email) {
		verificatedEmails.add(email);
		System.out.println(email + " do�ruland�.");		
	}

	@Override
	public boolean checkVerifyAccount(String email) {
		if (verificatedEmails.contains(email)) {
			return true;
		}
		return false;
	}

}
