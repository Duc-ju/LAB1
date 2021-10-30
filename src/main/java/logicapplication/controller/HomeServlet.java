package logicapplication.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import logicapplication.bookdao.BookDAO;
import logicapplication.bookdao.CategoryDAO;
import logicapplication.order.CartDAO;
import model.book.Book;
import model.book.Category;
import model.customer.Customer;

@WebServlet(urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		if(customer == null) {
			req.setAttribute("hiddenCart", 1);
		}
		else {
			req.setAttribute("numberOfItems", new CartDAO().getCartByCustomer(customer).getNumberOfItems());
		}
		List<Book> books = new BookDAO().getBooks();
		List<Category> categories = new CategoryDAO().getCategories();
		req.setAttribute("direction", "home");
		req.setAttribute("books",books );
		req.setAttribute("categories", categories);
		
		req.getRequestDispatcher("Home.jsp").forward(req, resp);
	}
}
