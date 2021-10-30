package model.customer;

public class Address {

	private int ID;
	private String phoneNumber;
	private String fullName;
	private String fullAddress;
	public int getID() {
		return ID;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public Address(int iD, String phoneNumber, String fullName, String fullAddress) {
		super();
		ID = iD;
		this.phoneNumber = phoneNumber;
		this.fullName = fullName;
		this.fullAddress = fullAddress;
	}
	
}
