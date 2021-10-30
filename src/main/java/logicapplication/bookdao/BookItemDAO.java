package logicapplication.bookdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logicapplication.dao.DAO;
import logicapplication.order.CartDAO;
import model.book.Book;
import model.book.BookItem;
import model.order.Cart;

public class BookItemDAO extends DAO{

	public BookItemDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<BookItem> getBookItemsByCartID(int id){
		List<BookItem> list = new ArrayList<BookItem>();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM bookitem\r\n"
							+ "WHERE CartID = ?\r\n");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Book book = new BookDAO().getBookByID(rs.getInt(4));
				list.add(new BookItem(rs.getInt(1),
						book.getPrice(),
						rs.getInt(3),
						rs.getInt(3)*book.getPrice(),
						book));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public BookItem getBookItemByID(int id) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM bookitem\r\n"
							+ "WHERE ID = ?\r\n");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Book book = new BookDAO().getBookByID(rs.getInt(4));
				return new BookItem(rs.getInt(1),
						book.getPrice(),
						rs.getInt(3),
						rs.getInt(3)*book.getPrice(),
						book);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void addBookItemToCart(BookItem bookItem, int id) {
		try {
			//check duplicate
			PreparedStatement preparedStatement1 = connection.
					prepareStatement("SELECT * FROM bookitem\r\n"
							+ "WHERE BookID = ?\r\n"
							+ "AND CartID = ?");
			
			preparedStatement1.setInt(1, bookItem.getBook().getID());
			preparedStatement1.setInt(2, id);
			System.out.println(preparedStatement1);
			ResultSet rs = preparedStatement1.executeQuery();
			if(rs.next()) {
				Book book = new BookDAO().getBookByID(rs.getInt(4));
				BookItem bookItem1 = new BookItem(rs.getInt(1),
						book.getPrice(),
						rs.getInt(3),
						rs.getInt(3)*book.getPrice(),
						book);
				PreparedStatement preparedStatement2 = connection.
						prepareStatement("UPDATE bookitem\r\n"
								+ "SET Quantity = ?\r\n"
								+ "WHERE BookID = ?\r\n"
								+ "AND CartID = ?");
				preparedStatement2.setInt(1, bookItem1.getQuantity()+bookItem.getQuantity());
				preparedStatement2.setInt(2, bookItem.getBook().getID());
				preparedStatement2.setInt(3, id);
				preparedStatement2.executeUpdate();
				System.out.println(preparedStatement2);
				return;
			}
			//add if not duplicate
			PreparedStatement preparedStatement = connection.
					prepareStatement("INSERT INTO bookitem(CurrentPrice, Quantity, BookID, CartID)\r\n"
							+ "VALUES (?,?,?,?)");
			preparedStatement.setFloat(1, bookItem.getBook().getPrice());
			preparedStatement.setInt(2, bookItem.getQuantity());
			preparedStatement.setInt(3, bookItem.getBook().getID());
			preparedStatement.setInt(4, id);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteBookItem(int id) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("DELETE FROM bookitem WHERE ID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setFinalPriceOfBookItem(Cart cart) {
		List<BookItem> bookItems = cart.getBookItemList();
		for(BookItem bookItem : bookItems) {
			try {
				PreparedStatement preparedStatement = connection.
						prepareStatement("UPDATE bookitem\r\n"
								+ "SET currentPrice = ?\r\n"
								+ "WHERE ID = ?");
				preparedStatement.setFloat(1, bookItem.getBook().getPrice());
				preparedStatement.setInt(2, bookItem.getID());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void increaseBookItem(int id) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("UPDATE bookitem\r\n"
							+ "SET Quantity = Quantity+1\r\n"
							+ "WHERE ID = ?");
			preparedStatement.setFloat(1,id);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void decreaseBookItem(int id) {
		try {
			BookItem bookItem = new BookItemDAO().getBookItemByID(id);
			if(bookItem.getQuantity()==1) {
				new BookItemDAO().deleteBookItem(id);
				return;
			}	
			PreparedStatement preparedStatement = connection.
					prepareStatement("UPDATE bookitem\r\n"
							+ "SET Quantity = Quantity-1\r\n"
							+ "WHERE ID = ?\r\n"
							+ "AND Quantity >1");
			preparedStatement.setFloat(1,id);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
