package model.order;

import java.util.List;

import model.book.*;
import model.customer.*;

public class Cart {

	private int ID;
	private float booksCost;
	private List<BookItem> bookItemList;
	private int numberOfItems;
	private int isOrdered;
	private Customer customer;
	public int getID() {
		return ID;
	}
	public float getBooksCost() {
		return booksCost;
	}
	public void setBooksCost(float booksCost) {
		this.booksCost = booksCost;
	}
	public List<BookItem> getBookItemList() {
		return bookItemList;
	}
	public void setBookItemList(List<BookItem> bookItemList) {
		this.bookItemList = bookItemList;
	}
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	public int getIsOrdered() {
		return isOrdered;
	}
	public void setIsOrdered(int isOrdered) {
		this.isOrdered = isOrdered;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Cart(int iD, float booksCost, List<BookItem> bookItemList, int numberOfItems, int isOrdered,
			Customer customer) {
		super();
		ID = iD;
		this.booksCost = booksCost;
		this.bookItemList = bookItemList;
		this.numberOfItems = numberOfItems;
		this.isOrdered = isOrdered;
		this.customer = customer;
	}
	public Cart(float booksCost, List<BookItem> bookItemList, int numberOfItems, int isOrdered, Customer customer) {
		super();
		this.booksCost = booksCost;
		this.bookItemList = bookItemList;
		this.numberOfItems = numberOfItems;
		this.isOrdered = isOrdered;
		this.customer = customer;
	}


}