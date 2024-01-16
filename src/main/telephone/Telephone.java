package main.telephone;

import java.util.ArrayList;
import java.util.List;

public class Telephone {
	private final String ownNumber;			//自分の電話番号
	private PhoneCall currentPhoneCall;		//現在の通話
	
	private List<PhoneCall> phoneCallList;
	
	public Telephone(String ownNumber) {
		this.ownNumber = ownNumber;
		this.currentPhoneCall = new PhoneCall();
		this.phoneCallList = new ArrayList<PhoneCall>();
	}

	public void call(String number) {
		this.currentPhoneCall.connect(CallDirection.OUT, number);
	}
	
	public void answer(String number) {
		this.currentPhoneCall.connect(CallDirection.IN, number);
	}
	
	public void disconnect() {
		this.currentPhoneCall.disconnect();
		this.phoneCallList.add(currentPhoneCall);
		currentPhoneCall = new PhoneCall();
	}
	
	public void displayHistory() {
		for(PhoneCall phoneCall : this.phoneCallList) {
			System.out.println(phoneCall);
		}
	}

}
