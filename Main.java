import Entities.concretes.User;
import business.concretes.MailVerificationManager;
import business.concretes.UserCheckManager;
import business.concretes.UserManager;
import dataAccess.concretes.UserActionsDao;

public class Main {

	public static void main(String[] args) {
		User user0 = new User();
		user0.setId(0);
		user0.setFirstName("Deniz");
		user0.setLastName("Özdemir");
		user0.setEmail("guldeniz010203@gmail.com");
		user0.setPassword("123123");
		
		User user1 = new User();
		user1.setId(1);
		user1.setFirstName("Deniz");
		user1.setLastName("Özdemir");
		user1.setEmail("guldeniz010203@gmail.com");
		user1.setPassword("123123");
		
		User user2 = new User();
		user2.setId(1);
		user2.setFirstName("Deniz");
		user2.setLastName("Özdemir");
		user2.setEmail("ftmorhan@gmail.com");
		user2.setPassword("1595275");
		
		UserManager manager = new UserManager(new UserCheckManager(), new MailVerificationManager(), new UserActionsDao());
		
		manager.signIn(user0);
		manager.signIn(user2);
	}

}
