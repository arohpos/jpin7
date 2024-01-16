package main.telephone;

public class Connecting implements CallStatus{

	@Override
	public void connect(PhoneCall phonecall, CallDirection callDirection, String callerNumber) {
		return;
	}

	@Override
	public void disconnect(PhoneCall phonecall) {
		phonecall.changeState(new Finished());
		phonecall.recordEndHistory();
	}
	
	
}
