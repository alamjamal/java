package com.book.category;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/admin/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryPOJO cp;
	public CategoryController() {
		super();
		cp = new CategoryPOJO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String cat_name = request.getParameter("cat_name");
		int id = Integer.parseInt(request.getParameter("id"));
		if (action == null) {
			request.getRequestDispatcher("manage_catagory.jsp").forward(request, response);
		}
		if (!("".equals(id)) && action.equalsIgnoreCase("info")) {
	//	 id=CategoryDAO.getCategoryByCatName(cat_name);
			System.out.println("in info");			
			cp.setCategory_name(cat_name);
			cp.setCategory_id(id);
			cp = CategoryDAO.editCategory(id);
			request.setAttribute("cp", cp);
			request.getRequestDispatcher("manage_catagory.jsp").forward(request, response);
			System.out.println("catagory edited");
		}
		if (!("".equals(id)) && action.equalsIgnoreCase("delete")) {
			System.out.println("in delete");
			cp.setCategory_name(cat_name);
			cp.setCategory_id(id);
			CategoryDAO.deleteCategory(id);
			request.getRequestDispatcher("manage_catagory.jsp").forward(request, response);
			System.out.println("catagory deleted");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cat_name = request.getParameter("cat_name");		
		String hiddenForm = request.getParameter("form");
		// may be add require id
		if (cat_name != null && hiddenForm.equalsIgnoreCase("form_add")) {
			cp.setCategory_name(cat_name);			
			int i = CategoryDAO.addCategory(cp);
			if (i != 0) {
				// request.getRequestDispatcher("manage_catagory.jsp").forward(request,
				// response);
				response.sendRedirect("manage_catagory.jsp");
				System.out.println("category added");
			}
		}
		 if (cat_name != null && hiddenForm.equalsIgnoreCase("form_update")) {
			cp.setCategory_name(cat_name);			
			cp.setCategory_id(cp.getCategory_id());
			System.out.println("in update ");
			int i = CategoryDAO.updateCategory(cp);
			if (i != 0) {
				// request.getRequestDispatcher("manage_catagory.jsp").forward(request,
				// response);
				response.sendRedirect("manage_catagory.jsp");
				System.out.println("category updated");
			}
		}
	}
}
