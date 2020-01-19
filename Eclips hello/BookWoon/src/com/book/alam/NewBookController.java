package com.book.alam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/NewBookController")
public class NewBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NewBookPOJO np;
	
	public NewBookController() {
		super();
		np = new NewBookPOJO();
		//POJO always put here if we want to use it as a request.setAttribute
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		if (action == null) {
			request.getRequestDispatcher("manage_product.jsp").forward(request, response);
		}
		if (!("".equals(id)) && action.equalsIgnoreCase("info")) {
			// id=CategoryDAO.getCategoryByCatName(cat_name);
			System.out.println("");
			np.setNBOOKID(id);
			np = NewBookDAO.bookInfoForEdit(id);
			request.setAttribute("np", np);
			request.setAttribute("id", id);
			System.out.println(np.getNBOOKID());
			request.getRequestDispatcher("manage_product.jsp").forward(request, response);
			System.out.println("new book info finished");
		}
		if (!("".equals(id)) && action.equalsIgnoreCase("delete")) {
			
			np.setNBOOKID(id);
			NewBookDAO.deleteBookByid(id);
			request.setAttribute("np", np);
			
		
			request.getRequestDispatcher("manage_product.jsp").forward(request, response);
			System.out.println("new book info finished");
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String TITLE = request.getParameter("title");
		String AUTHOR = request.getParameter("author");
		String PUBLISHER = request.getParameter("publisher");
		String PUBLISHEDDATE = request.getParameter("published_date");
		String CATEGORY = request.getParameter("category");
		String ISBN = request.getParameter("isbn");
		String ISBN13 = request.getParameter("isbn13");
		String IMAGEAPIPATH = request.getParameter("imageapipath");
		String DESCRIPTION = request.getParameter("description");
		int PAGECOUNT = Integer.parseInt(request.getParameter("pagecount"));
		int PRICE = Integer.parseInt(request.getParameter("price"));

		np.setTITLE(TITLE);
		np.setAUTHOR(AUTHOR);
		np.setPUBLISHER(PUBLISHER);
		np.setPUBLISHEDDATE(PUBLISHEDDATE);
		np.setCATEGORY(CATEGORY);
		np.setISBN(ISBN);
		np.setISBN13(ISBN13);
		np.setIMAGEAPIPATH(IMAGEAPIPATH);
		np.setDESCRIPTION(DESCRIPTION);
		np.setPAGECOUNT(PAGECOUNT);
		np.setPRICE(PRICE);
		String hiddenForm = request.getParameter("myform");
		if (hiddenForm.equals("myaddform")) {
			
			int i = NewBookDAO.insertBookDetails(np);
			if (i > 0) {
				System.out.println("inserted");
				// request.getRequestDispatcher("add_product.jsp").forward(request,
				// response);
				// deu to again same value inserted after reloading the page dont use this
				response.sendRedirect("add_product.jsp");
				request.setAttribute("msg", "book inserted successfully");
			}
		} else if (hiddenForm.equals("myeditform")) {
			int i = NewBookDAO.updateBook(np, np.getNBOOKID());
			if (i > 0) {
				System.out.println("updated from servlet ");
				response.sendRedirect("manage_product.jsp");
			}
		}
	}
}
