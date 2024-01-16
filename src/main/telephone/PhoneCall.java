package main.telephone;

import java.time.LocalDateTime;

/**
 * 通話が開始されるとインスタンスが生成される
 */
public class PhoneCall {
	//private boolean isConnected;			//通話状態
	private LocalDateTime starTime;			//開始時刻
	private LocalDateTime endTime;			//終了時刻
	private CallDirection callDirection;	//発着区分
	private String callerNumber;			//相手の電話番号

	private CallStatus callStatus;			//

	
	public PhoneCall() {
		this.callStatus = new Waiting();
	}
	
	public void connect(CallDirection callDirection, String callerNumber) {
		callStatus.connect(this, callDirection, callerNumber);
	}
	
	public void disconnect() {
		callStatus.disconnect(this);
	}
	
	public void changeState(CallStatus callStatus) {
		this.callStatus = callStatus;
	};
	
	public void recordStartHistory() {
		this.starTime = LocalDateTime.now();
		this.callDirection = callDirection;
		this.callerNumber = callerNumber;
	}
	
	public void recordEndHistory() {
		this.endTime = LocalDateTime.now();
	}
	
//	public boolean canConnect() {
//		if(this.callStatus == CallStatus.WAITING) {			
//			return true;
//		}else {
//			return false;
//		}
//	}

	@Override
	public String toString() {
		return this.callStatus + " : " +  this.callerNumber + "\r\n"
				+ this.starTime + " - "  + this.endTime;
		
	}
}
