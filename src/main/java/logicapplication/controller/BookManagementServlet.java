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

/**
 * Servlet implementation class BookManagementServlet
 */
@WebServlet("/bookmanagement")
public class BookManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		if(customer == null||customer.getAccount().getIsAdmin()==0) {
			response.sendRedirect(request.getContextPath()+"/home");
			return;
		}
		request.setAttribute("numberOfItems", new CartDAO().getCartByCustomer(customer).getNumberOfItems());
		List<Book> books = new BookDAO().getBooks();
		List<Category> categories = new CategoryDAO().getCategories();
		request.setAttribute("direction", "bookmanagement");
		request.setAttribute("books",books );
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("BookManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
