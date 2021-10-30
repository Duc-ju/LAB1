package logicapplication.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logicapplication.dao.DAO;

public class ShipmentDAO extends DAO{

	public ShipmentDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void addShipment(int addressID) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("INSERT INTO shipment(Fee,AdressID)\r\n"
							+ "VALUES(2,?)");
			preparedStatement.setInt(1, addressID);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getLastShipmentID() {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT max(shipment.ID)\r\n"
							+ "FROM shipment");
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
