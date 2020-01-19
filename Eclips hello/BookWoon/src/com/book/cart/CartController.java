package com.book.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.book.alam.NewBookDAO;
import com.book.alam.NewBookPOJO;

@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public CartController() {
		super();
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ISBN13 = request.getParameter("isbn13").trim();
		String action = request.getParameter("action");
		
		System.out.println("cart controller");
		
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email");
		
		if (email == null) {
			request.setAttribute("msg", "please login to buy this product");
			request.getRequestDispatcher("U-Login.jsp").forward(request, response);
		}	
		
		if (action.equalsIgnoreCase("addtocart")) {
			NewBookDAO dao = new NewBookDAO();
			CartPOJO cp = new CartPOJO();
			
			List<NewBookPOJO> list = dao.getNewBookDetailsByISBN13(ISBN13);
			for (NewBookPOJO nbp : list) {
				cp.setISBN13(ISBN13);
				cp.setEMAIL(email);
				cp.setTITLE(nbp.getTITLE());
				cp.setPRICE(nbp.getPRICE());
				cp.setIMAGEAPIPATH(nbp.getIMAGEAPIPATH());
			}
			int i = CartDAO.insertBuyItem(cp,ISBN13);
			if (i > 0) {
				request.setAttribute("msg", "Product Added to The Cart Please Procced For Chekout");
				request.getRequestDispatcher("index-book-details.jsp").forward(request, response);
			} else {
				System.out.println("nothing inserted cart to the dbs");
			}
		}
		if (action.equalsIgnoreCase("delete")) {
			String isbn13 = request.getParameter("isbn13");
			CartDAO.deleteItemFromCartByISBN13(isbn13);
			request.getRequestDispatcher("C-Cart.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("cart controller");
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if (action.equals("ajax")) {
			int price = Integer.parseInt(request.getParameter("price"));
			int qty = Integer.parseInt(request.getParameter("qty"));
			out.print(price * qty);
		}
	}
}
