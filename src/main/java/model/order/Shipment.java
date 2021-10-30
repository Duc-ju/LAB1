package model.order;

import model.customer.*;

public class Shipment {

	private int ID;
	private float fee;
	private Address address;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Shipment(int iD, float fee, Address address) {
		super();
		ID = iD;
		this.fee = fee;
		this.address = address;
	}
}