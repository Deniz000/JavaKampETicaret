package business.concretes;


import java.util.ArrayList;
import java.util.regex.Pattern;


import Entities.concretes.User;
import business.abstracts.UserCheckService;

public class UserCheckManager implements UserCheckService{
	
	ArrayList<String> listOfEmaiList = new ArrayList<>();
	@Override
	public boolean checkFirstName(User user) {
		if (user.getFirstName().isEmpty()) {
			System.out.println("�sim Alan� Bo� B�rak�lamaz!");
			return false;
		}
		else if (user.getFirstName().length() < 3) {
				System.out.println("�sim 2 karakterden daha k���k olamaz.");
				return false;
			}
		else {
			return true;
		}
	}

	@Override
	public boolean checkLastName(User user) {
		if (user.getLastName().isEmpty()) {
			System.out.println("Soyisim alan� bo� b�rak�lamaz!");
			return false;
		}
		else if (user.getLastName().length() < 3) {
			System.out.println("Soyisim alan� 2 karakterden az olamaz!");
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkEmail(User user) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		
		if(user.getEmail().isEmpty()) {
			System.out.println("Email alan� bo� b�rak�lamaz.");
			return false;
		}
		else if (pattern.matcher(user.getEmail()).find() == false) {
			System.out.println("Girilen email adresi formata uygun de�il. �rnek: ornek@ornek.com");
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkPassword(User user) {
		if (user.getPassword().isEmpty()) {
			System.out.println("Soyisim alan� bo� b�rak�lamaz.");
			return false;
		} else if (user.getPassword().length() < 6) {
				System.out.println("Parola 6 karakterden daha k���k olamaz.");
				return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean uniqueEmail(User user) {
		if (listOfEmaiList.contains(user.getEmail())) {
			System.out.println("Bu mail adresi kullan�mda");
			return false;
		}
		else {
			listOfEmaiList.add(user.getEmail());
			return true;
		}
	}

	@Override
	public boolean isValid(User user) {
		if (checkFirstName(user) && checkLastName(user) && checkEmail(user) && checkPassword(user)
				&& uniqueEmail(user) == true) {
			return true;
		}
		return false;
	}

}
