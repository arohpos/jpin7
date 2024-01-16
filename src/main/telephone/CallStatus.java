package main.telephone;

public interface CallStatus {
	public void connect(PhoneCall phonecall, CallDirection callDirection, String callerNumber);
	public void disconnect(PhoneCall phonecall);
}
