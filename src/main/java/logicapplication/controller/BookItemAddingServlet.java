package logicapplication.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicapplication.bookdao.BookDAO;
import logicapplication.bookdao.BookItemDAO;
import logicapplication.order.CartDAO;
import model.book.Book;
import model.book.BookItem;
import model.customer.Customer;
import model.order.Cart;

/**
 * Servlet implementation class BookAddingServlet
 */
@WebServlet("/bookadding")
public class BookItemAddingServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookItemAddingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.context = config.getServletContext();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		if(customer == null) {
//			response.sendRedirect("Login.jsp");
			context.getRequestDispatcher("Login.jsp").forward(request, response);
		}	
		int id = Integer.parseInt(request.getParameter("id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Cart cart = new CartDAO().getCartByCustomer(customer);
		Book book = new BookDAO().getBookByID(id);
		new BookItemDAO().addBookItemToCart(new BookItem(book.getPrice(), quantity, book), cart.getID());
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("Them thanh cong");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
