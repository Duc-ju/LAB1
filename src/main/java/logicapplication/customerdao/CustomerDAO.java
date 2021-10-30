package logicapplication.customerdao;

import model.customer.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logicapplication.dao.*;

public class CustomerDAO extends DAO {

	/**
	 * 
	 * @param account
	 */
	public Customer getCustomer(Account account) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT customer.* FROM customer, account\r\n"
							+ "WHERE customer.AccountID = account.ID\r\n"
							+ "AND account.ID = ?");
			preparedStatement.setInt(1, account.getID());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				return new Customer(rs.getInt(1),
						rs.getString(2),
						account,
						new AddressDAO().getAddressesByCustomerID(rs.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("INSERT INTO customer (NickName,AccountID)\r\n"
							+ "VALUES (?,?)");
			preparedStatement.setString(1, customer.getNickname());
			Account account = new AccountDAO().getAccount(customer.getAccount());
			preparedStatement.setInt(2,account.getID());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}