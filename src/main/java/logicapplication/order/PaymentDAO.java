package logicapplication.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logicapplication.dao.DAO;
import model.customer.Address;
import model.order.Payment;

public class PaymentDAO extends DAO{

	public PaymentDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Payment> getPayments() {
		List<Payment> list = new ArrayList<Payment>();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM payment");
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				list.add(new Payment(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
