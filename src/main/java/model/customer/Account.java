package model.customer;

public class Account {
	private int ID;
	private String userName;
	private String password;
	private int isAdmin;
	
	public int getID() {
		return ID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Account(int iD, String userName, String password, int isAdmin) {
		super();
		ID = iD;
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	public Account(String userName, String password, int isAdmin) {
		super();
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	public Account(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
}