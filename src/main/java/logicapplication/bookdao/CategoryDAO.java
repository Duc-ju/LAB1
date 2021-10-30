package logicapplication.bookdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logicapplication.dao.DAO;
import model.book.Book;
import model.book.Category;

public class CategoryDAO extends DAO{
	
	public Category getCategoryByID(int id) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM Category"
							+ " WHERE ID = ?");
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				return(new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Category> getCategories(){
		List<Category> categories = new ArrayList<Category>();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM Category");
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				categories.add(new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}
}
