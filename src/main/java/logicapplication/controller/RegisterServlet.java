package logicapplication.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logicapplication.customerdao.AccountDAO;
import logicapplication.customerdao.CustomerDAO;
import logicapplication.order.CartDAO;
import model.customer.Account;
import model.customer.Customer;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/register");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("re_pass");
		if(!pass.equals(repass)) {
			request.setAttribute("errorMessage", "Password and re-pass are different");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			return;
		}
		AccountDAO accountDAO= new AccountDAO();
		if(accountDAO.checkAccountByName(name)) {
			request.setAttribute("errorMessage", "The user name is used");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			return;
		}
		else {  
			accountDAO.addAccount(new Account(name, pass));
			CustomerDAO customerDAO = new CustomerDAO();
			customerDAO.addCustomer(new Customer(nickname,
					accountDAO.getAccount(new Account(name, pass)), null));
			Customer customer = new CustomerDAO().getCustomer
					(new AccountDAO().getAccount(new Account(name, pass)));
			new CartDAO().createCartByCustomerID(customer.getID());
			HttpSession session = request.getSession();
			session.setAttribute("customer",customer);
			response.sendRedirect(request.getContextPath()+"/home");
		}
	}

}
