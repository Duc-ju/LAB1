package model.customer;

import java.util.List;

public class Customer {

	private int ID;
	private String nickname;
	private Account account;
	private List<Address> addressList;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	public Customer(int iD, String nickname, Account account, List<Address> addressList) {
		super();
		ID = iD;
		this.nickname = nickname;
		this.account = account;
		this.addressList = addressList;
	}
	public Customer(String nickname, Account account, List<Address> addressList) {
		super();
		this.nickname = nickname;
		this.account = account;
		this.addressList = addressList;
	}
	
}