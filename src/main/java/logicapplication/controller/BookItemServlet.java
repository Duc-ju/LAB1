package logicapplication.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicapplication.bookdao.BookItemDAO;

/**
 * Servlet implementation class BookItemServlet
 */
@WebServlet("/bookitemcontrol")
public class BookItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("customer")==null) {
			response.sendRedirect("Login.jsp");
			return;
		}
		String action = request.getParameter("action");
		int bookItemID = Integer.parseInt(request.getParameter("id"));
		switch (action) {
		case "increase":
			new BookItemDAO().increaseBookItem(bookItemID);
			response.sendRedirect(request.getContextPath()+"/cart");
			break;
		default:
			new BookItemDAO().decreaseBookItem(bookItemID);
			response.sendRedirect(request.getContextPath()+"/cart");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
