package logicapplication.bookdao;

import model.book.*;
import model.order.Cart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSOutput;

import logicapplication.dao.*;

public class BookDAO extends DAO {
	
	public BookDAO() {
		super();
	}

	public List<Book> getBooks() {
		List<Book> list = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM Book");
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				list.add(new Book(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getFloat(5),
						rs.getString(6),
						rs.getInt(7),
						new CategoryDAO().getCategoryByID(rs.getInt(8))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 
	 * @param book
	 * @throws SQLException 
	 */
	public void addBook(Book book) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(
				"INSERT INTO book (Title, author, image, description, price, AvaiableQuantity, CategoryID)\r\n"
						+ "VALUES (?,?,?,?,?,?,?)");
		preparedStatement.setString(1, book.getTitle());
		preparedStatement.setString(2, book.getAuthor());
		preparedStatement.setString(3, book.getImage());
		preparedStatement.setString(4, book.getDescription());
		preparedStatement.setFloat(5, book.getPrice());
		preparedStatement.setInt(6, book.getAvaiableQuantity());
		preparedStatement.setInt(7, book.getCategory().getID());
		System.out.println(preparedStatement);
		preparedStatement.executeUpdate();
	}

	/**
	 * 
	 * @param name
	 */
	public List<Book> getBooksByName(String name) {
		List<Book> list = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM book\r\n"
							+ "WHERE Title LIKE ?");
			preparedStatement.setString(1, "%"+name+"%");
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				list.add(new Book(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getFloat(5),
						rs.getString(6),
						rs.getInt(7),
						new CategoryDAO().getCategoryByID(rs.getInt(8))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 
	 * @param id
	 */
	public List<Book> getBooksByCategoryID(int id) {
		List<Book> list = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM Book"
							+ " WHERE CategoryID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				list.add(new Book(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getFloat(5),
						rs.getString(6),
						rs.getInt(7),
						new CategoryDAO().getCategoryByID(rs.getInt(8))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 
	 * @param book
	 * @throws SQLException 
	 */
	public void updateBook(Book book) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE book\r\n"
				+ "SET Title = ?, Author = ?, Image=?, Description = ?, price = ?, AvaiableQuantity=?, CategoryID=?  \r\n"
				+ "WHERE ID = ?");
		preparedStatement.setString(1, book.getTitle());
		preparedStatement.setString(2, book.getAuthor());
		preparedStatement.setString(3, book.getImage());
		preparedStatement.setString(4, book.getDescription());
		preparedStatement.setFloat(5, book.getPrice());
		preparedStatement.setInt(6, book.getAvaiableQuantity());
		preparedStatement.setInt(7, book.getCategory().getID());
		preparedStatement.setInt(8, book.getID());
		System.out.println(preparedStatement);
		preparedStatement.executeUpdate();
	}

	/**
	 * 
	 * @param id
	 */
	public void hiddenBook(int id) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("UPDATE book\r\n"
							+ "SET AvaiableQuantity = 0\r\n"
							+ "WHERE ID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void hiddenAllOfBooks() {
		// TODO - implement BookDAO.deleteAllOfBooks
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Book getBookByID(int id) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM book\r\n"
							+ "WHERE ID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				return new Book(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getFloat(5),
						rs.getString(6),
						rs.getInt(7),
						new CategoryDAO().getCategoryByID(rs.getInt(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void updateAvaiableQuantityAfterOrdered(Cart cart) {
		List<BookItem> bookItems = cart.getBookItemList();
		for(BookItem bookItem : bookItems) {
			try {
				PreparedStatement preparedStatement = connection.
						prepareStatement("UPDATE book\r\n"
								+ "SET AvaiableQuantity = ?\r\n"
								+ "WHERE ID =?");
				preparedStatement.setInt(1, bookItem.getBook()
						.getAvaiableQuantity()-bookItem.getQuantity());
				preparedStatement.setInt(2, bookItem.getBook().getID());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}