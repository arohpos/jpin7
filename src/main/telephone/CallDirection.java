package main.telephone;

public enum CallDirection {
	IN("電話を受けました"),
	OUT("電話をかけました");
	
	
	private String message;
	
	private CallDirection(String message) {
		this.message = message;
	}
	
	public void showMessage() {
		System.out.println(this.message);
	}
	
	
	
}
