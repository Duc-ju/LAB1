package model.book;

public class BookItem {

	private int ID;
	private float currentPrice;
	private int quantity;
	private float bookItemCost;
	private Book book;
	public int getID() {
		return ID;
	}
	public float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getBookItemCost() {
		return bookItemCost;
	}
	public void setBookItemCost(float bookItemCost) {
		this.bookItemCost = bookItemCost;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookItem(int iD, float currentPrice, int quantity, float bookItemCost, Book book) {
		super();
		ID = iD;
		this.currentPrice = currentPrice;
		this.quantity = quantity;
		this.bookItemCost = bookItemCost;
		this.book = book;
	}
	public BookItem(float currentPrice, int quantity, Book book) {
		super();
		this.currentPrice = currentPrice;
		this.quantity = quantity;
		this.book = book;
	}
	
}