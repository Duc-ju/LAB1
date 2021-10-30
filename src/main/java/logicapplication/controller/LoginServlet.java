package logicapplication.controller;

import java.io.IOException;
import java.security.cert.CertStoreSpi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logicapplication.customerdao.AccountDAO;
import logicapplication.customerdao.CustomerDAO;
import model.customer.Account;
import model.customer.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("customer")==null) {
			response.sendRedirect("Login.jsp");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("your_name");
		String password = request.getParameter("your_pass");
		if(new AccountDAO().checkAccount(new Account(userName, password))) {
			Customer customer = new CustomerDAO().getCustomer
					(new AccountDAO().getAccount(new Account(userName, password)));
			HttpSession session = request.getSession();
			session.setAttribute("customer",customer);
			response.sendRedirect(request.getContextPath()+"/home");
		}
		else {
			request.setAttribute("errorLogin", 1);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
