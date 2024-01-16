package main.telephone;

public class Finished implements CallStatus{

	@Override
	public void connect(PhoneCall phonecall, CallDirection callDirection, String callerNumber) {
		return;
		
	}

	@Override
	public void disconnect(PhoneCall phonecall) {
		return;
	}
}
