package logicapplication.controller;

import model.customer.Customer;
import model.order.*;
import java.io.IOException;
import java.util.Calendar;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicapplication.bookdao.BookDAO;
import logicapplication.bookdao.BookItemDAO;
import logicapplication.customerdao.AddressDAO;
import logicapplication.order.CartDAO;
import logicapplication.order.OrderDAO;
import logicapplication.order.PaymentDAO;
import logicapplication.order.ShipmentDAO;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		if(customer == null) {
			response.sendRedirect("Login.jsp");
			return;
		}
		int cartID = Integer.parseInt(request.getParameter("cartID"));
		int paymentID = Integer.parseInt(request.getParameter("paymentID"));
		int addressID = Integer.parseInt(request.getParameter("addressID"));
		new ShipmentDAO().addShipment(addressID);
		int shipmentID = new ShipmentDAO().getLastShipmentID();
		new BookItemDAO().setFinalPriceOfBookItem(new CartDAO().getCartByCustomer(customer));
		new BookDAO().updateAvaiableQuantityAfterOrdered(new CartDAO().getCartByCustomer(customer));
		new OrderDAO().addOrder(cartID, paymentID, shipmentID);
		new CartDAO().updateCartToOrdered(cartID);
		new CartDAO().createCartByCustomerID(customer.getID());
		response.sendRedirect(request.getContextPath()+"/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
