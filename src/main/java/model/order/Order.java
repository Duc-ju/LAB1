package model.order;

import java.sql.Date;

public class Order {

	private int ID;
	private float totalPrice;
	private Date orderTime;
	private Cart cart;
	private Payment payment;
	private Shipment shipment;
	public int getID() {
		return ID;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Shipment getShipment() {
		return shipment;
	}
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	public Order(int iD, float totalPrice, Date orderTime, Cart cart, Payment payment, Shipment shipment) {
		super();
		ID = iD;
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.cart = cart;
		this.payment = payment;
		this.shipment = shipment;
	}
	public Order(float totalPrice, Date orderTime, Cart cart, Payment payment, Shipment shipment) {
		super();
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.cart = cart;
		this.payment = payment;
		this.shipment = shipment;
	}
	public Order(Date orderTime, Cart cart, Payment payment, Shipment shipment) {
		super();
		this.orderTime = orderTime;
		this.cart = cart;
		this.payment = payment;
		this.shipment = shipment;
	}
	
}