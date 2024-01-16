package main.telephone;

public class Main {

	public static void main(String[] args) {
		Telephone telephone = new Telephone("myPhoneNumber");
		telephone.call("YourPhoneNumber");
		telephone.disconnect();
		telephone.answer("test2");
		telephone.disconnect();
		telephone.displayHistory();
	}
}
