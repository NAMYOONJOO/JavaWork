package practice.cardcompany;

//import com.lec.java.static03.Test;

public class Company {
	
	private int cardNumber = 10000;
	private Company() {
	}

	private static Company instance = null;

	public static Company getInstance() {
		if (instance == null) {
			instance = new Company();
		}
		return instance;
	}
	
	public Card createCard() {
		cardNumber++;
		Card user = new Card(cardNumber);
		return user;
	}

} // end class
