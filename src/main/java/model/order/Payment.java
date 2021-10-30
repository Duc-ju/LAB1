package model.order;

public class Payment {

	private int ID;
	private String method;
	public int getID() {
		return ID;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Payment(int iD, String method) {
		super();
		ID = iD;
		this.method = method;
	}

}