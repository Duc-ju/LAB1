package logicapplication.order;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import logicapplication.dao.DAO;
import model.order.Order;

public class OrderDAO extends DAO{

	public OrderDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void addOrder(int cartID, int paymentID, int shipmentID) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("INSERT INTO `order`(OrderTime, ShipmentID, PaymentID, CartID)\r\n"
							+ "VALUES(CURRENT_DATE(),?,?,?)");
			preparedStatement.setInt(1, shipmentID);
			preparedStatement.setInt(2, paymentID);
			preparedStatement.setInt(3, cartID);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
