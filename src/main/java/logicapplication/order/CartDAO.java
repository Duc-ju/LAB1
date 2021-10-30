package logicapplication.order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import logicapplication.bookdao.BookItemDAO;
import logicapplication.dao.DAO;
import model.book.BookItem;
import model.customer.Customer;
import model.order.Cart;

public class CartDAO extends DAO{

	public CartDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart getCartByCustomer(Customer customer) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT cart.* FROM cart,customer\r\n"
							+ "WHERE cart.CustomerID = customer.ID\r\n"
							+ "AND cart.IsOrdered = '0'\r\n"
							+ "AND customer.ID = ?");
			preparedStatement.setInt(1, customer.getID());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				List<BookItem> bookItems = new BookItemDAO().getBookItemsByCartID(rs.getInt(1));
				float booksCost = 0;
				int numberOfItems = 0;
				for(BookItem bookItem : bookItems) {
					booksCost+=bookItem.getBookItemCost();
					numberOfItems += bookItem.getQuantity();
				}
				return new Cart(rs.getInt(1),
						booksCost,
						bookItems,
						numberOfItems,
						0,
						customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void createCartByCustomerID(int id) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("INSERT INTO cart(IsOrdered, CustomerID)\r\n"
							+ "VALUES (0,?)");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateCartToOrdered(int id) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("UPDATE cart\r\n"
							+ "SET IsOrdered=1\r\n"
							+ "WHERE ID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
