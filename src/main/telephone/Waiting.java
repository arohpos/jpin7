package main.telephone;

public class Waiting implements CallStatus{
	
	@Override
	public void connect(PhoneCall phonecall, CallDirection callDirection, String callerNumber) {
		phonecall.changeState(new Connecting());
		phonecall.recordStartHistory();
		System.out.println(callDirection + ", " + callerNumber);
	}

	@Override
	public void disconnect(PhoneCall phonecall) {
		return;
	}

}
