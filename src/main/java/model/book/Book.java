package model.book;

public class Book {

	private int ID;
	private String title;
	private String image;
	private String author;
	private float price;
	private String description;
	private int avaiableQuantity;
	private Category category;
	public int getID() {
		return ID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAvaiableQuantity() {
		return avaiableQuantity;
	}
	public void setAvaiableQuantity(int avaiableQuantity) {
		this.avaiableQuantity = avaiableQuantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Book(int iD, String title, String image, String author, float price, String description,
			int avaiableQuantity, Category category) {
		super();
		ID = iD;
		this.title = title;
		this.image = image;
		this.author = author;
		this.price = price;
		this.description = description;
		this.avaiableQuantity = avaiableQuantity;
		this.category = category;
	}
	public Book(String title, String image, String author, float price, String description, int avaiableQuantity,
			Category category) {
		super();
		this.title = title;
		this.image = image;
		this.author = author;
		this.price = price;
		this.description = description;
		this.avaiableQuantity = avaiableQuantity;
		this.category = category;
	}
	
}