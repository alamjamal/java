package com.book.old;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/OldBookController")
public class OldBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public OldBookController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("B-Sell-Old-Book.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publish_date = request.getParameter("publish_date");
		String publisher = request.getParameter("publisher");
		String category = request.getParameter("category");
		String isbn = request.getParameter("isbn");
		String isbn13 = request.getParameter("isbn13");
		String imageapipath = request.getParameter("imageapipath");
		String cob = request.getParameter("cob");
		String th = request.getParameter("th");
		String nib = request.getParameter("nib");
		String pin = request.getParameter("pin");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		int price = Integer.parseInt(request.getParameter("price"));
		String mobile = request.getParameter("mobile");
		String agree = request.getParameter("agree");
	//	int price = 10;
		OldBookPOJO pojo = new OldBookPOJO();
		pojo.setTITLE(title);
		pojo.setAUTHOR(author);
		pojo.setPUBLISHEDDATE(publish_date);
		pojo.setPUBLISHER(publisher);
		pojo.setCATEGORY(category);
		pojo.setISBN(isbn);
		pojo.setISBN13(isbn13);
		pojo.setIMAGEAPIPATH(imageapipath);
		pojo.setBOOKCONDITION(cob);
		pojo.setTEXTHIGHLIGHT(th);
		pojo.setNOTESINBOOK(nib);
		pojo.setPIN(pin);
		pojo.setADDRESS(address);
		pojo.setCITY(city);
		pojo.setSTATE(state);
		pojo.setCOUNTRY(country);
		pojo.setPRICE(price);
		pojo.setMOBILE(mobile);
		pojo.setAGREE(agree);
		try {
			System.out.println("before inserted");
			String email = (String)request.getSession().getAttribute("email");
			if (email==null) {
				request.getSession().setAttribute("pojo",pojo);
				request.setAttribute("msg", "please Login to Contineu");
				request.getRequestDispatcher("U-Login.jsp").include(request, response);
			}
			else{
				int i  = OldBookDAO.insertBookDetails(pojo);
				if(i>0){
			request.getRequestDispatcher("B-Buy-Old-Book.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
