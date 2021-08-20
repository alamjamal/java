package com.sl.address;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/add")
public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       public AddressController() {
		super();
		

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("get method");
			String action = request.getParameter("action");
			if (action == null) {
				request.getRequestDispatcher("U-Profile.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("U-Profile.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			

		//1. get value from html page
		int pin = Integer.parseInt(request.getParameter("pin"));
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String email = request.getParameter("email");
		
		//2.set all values to the model class
		AddressPOJO ap = new AddressPOJO();
		ap.setEmail(email);
		ap.setPin(pin);
		ap.setAddress(address);
		ap.setCity(city);
		ap.setCountry(country);
		ap.setState(state);
		ap.setCountry(country);
		
		//3. call dao method to perform sql opration
		int i = AddressDAO.updateAddress(ap);
				if(i!=0){
					request.getSession().setAttribute("ap", ap);
					request.getRequestDispatcher("U-Profile.jsp").forward(request, response);
				}
		
				else{
					request.getRequestDispatcher("U-Profile.jsp").forward(request, response);

					System.out.println("not upadted address");
				}
		}catch(Exception e){
			request.getRequestDispatcher("U-Profile.jsp").forward(request, response);

			e.printStackTrace();
		}
	}

}
