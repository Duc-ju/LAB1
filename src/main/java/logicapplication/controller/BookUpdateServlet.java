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
 * Servlet implementation class BookUpdateServlet
 */
@WebServlet("/update-book")
public class BookUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUpdateServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = new BookDAO().getBookByID(id);
		request.setAttribute("book", book);
		List<Category> categories = new CategoryDAO().getCategories();
		request.setAttribute("direction", "bookmanagement");
		request.setAttribute("numberOfItems", new CartDAO().getCartByCustomer(customer).getNumberOfItems());
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("BookForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		if(customer == null||customer.getAccount().getIsAdmin()==0) {
			response.sendRedirect(request.getContextPath()+"/home");
			return;
		}
		try {
			int ID = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String image = request.getParameter("image");
			String author = request.getParameter("author");
			String description = request.getParameter("description");
			float price = Float.parseFloat(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int category_ID = Integer.parseInt(request.getParameter("category"));
			BookDAO bookDAO = new BookDAO();
			bookDAO.updateBook(new Book(ID,
					title,
					image,
					author,
					price,
					description,
					quantity,
					new Category(category_ID)));
			request.setAttribute("notice", "You have updated the book successfully");
			CategoryDAO categoryDAO = new CategoryDAO();
			List<Category> categories = categoryDAO.getCategories();
			request.setAttribute("direction", "bookmanagement");
			request.setAttribute("categories", categories);
			request.setAttribute("numberOfItems", new CartDAO().getCartByCustomer(customer).getNumberOfItems());
			request.getRequestDispatcher("BookForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("notice", "Failed to update, please retry");
			CategoryDAO categoryDAO = new CategoryDAO();
			List<Category> listCategories = categoryDAO.getCategories();
			request.setAttribute("direction", "bookmanagement");
			request.setAttribute("categories", listCategories);
			request.setAttribute("numberOfItems", new CartDAO().getCartByCustomer(customer).getNumberOfItems());
			request.getRequestDispatcher("BookForm.jsp").forward(request, response);
		}
	}

}
