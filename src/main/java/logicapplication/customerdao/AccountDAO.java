package logicapplication.customerdao;


import model.customer.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logicapplication.dao.*;

public class AccountDAO extends DAO {

	/**
	 * 
	 * @param account
	 */
	public boolean checkAccount(Account account) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM account\r\n"
							+ "WHERE UserName = ?\r\n"
							+ "AND PassWord = ?");
			preparedStatement.setString(1, account.getUserName());
			preparedStatement.setString(2, account.getPassword());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 
	 * @param account
	 */
	public boolean checkAccountByName(String name) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM account\r\n"
							+ "WHERE UserName = ?");
			preparedStatement.setString(1, name);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 
	 * @param account
	 */
	public Account getAccount(Account account) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM account\r\n"
							+ "WHERE UserName = ?\r\n"
							+ "AND PassWord = ?");
			preparedStatement.setString(1, account.getUserName());
			preparedStatement.setString(2, account.getPassword());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				return new Account(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void addAccount(Account account) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("INSERT INTO account (UserName,Password,IsAdmin)\r\n"
							+ "VALUES (?,?,?)");
			preparedStatement.setString(1, account.getUserName());
			preparedStatement.setString(2, account.getPassword());
			preparedStatement.setInt(3, 0);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}