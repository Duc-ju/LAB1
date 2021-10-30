package logicapplication.customerdao;

import model.customer.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logicapplication.dao.*;

public class AddressDAO extends DAO {

	/**
	 * 
	 * @param id
	 */
	public List<Address> getAddressesByCustomerID(int id) {
		List<Address> list = new ArrayList<Address>();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT adress.* from adress,customer\r\n"
							+ "WHERE customer.ID = adress.CustomerID\r\n"
							+ "AND adress.CustomerID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				list.add(new Address(rs.getInt(1),
						rs.getString(3),
						rs.getString(2),
						rs.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param customer
	 * @param address
	 */
	public void addAdress(Customer customer, Address address) {
		// TODO - implement AddressDAO.addAdress
		throw new UnsupportedOperationException();
	}

}