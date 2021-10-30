package model.book;

public class Category {

	private int ID;
	private String categoryName;
	public int getID() {
		return ID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Category(int iD, String categoryName) {
		super();
		ID = iD;
		this.categoryName = categoryName;
	}
	public Category(int iD) {
		super();
		ID = iD;
	}
	
}