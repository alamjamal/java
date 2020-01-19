package com.sl.google;

import com.google.gson.Gson;
import com.sl.dao.UserDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/oauth2callback")
public class OAuth2Callback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String className = "com.sl.OAuth2Callback";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			String code = request.getParameter("code");
			String urlParameters = "code=" + code + "&client_id=" + Setup.CLIENT_ID + "&client_secret="
					+ Setup.CLIENT_SECRET + "&redirect_uri=" + Setup.REDIRECT_URL + "&grant_type=authorization_code";
			URL url = new URL("https://accounts.google.com/o/oauth2/token");
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line1 = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				line1 = line1 + line;
			}
			String s = GsonUtility.getJsonElementString("access_token", line1);
			
			url = new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + s);
			conn = url.openConnection();
			line1 = "";
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				line1 = line1 + line;
			}
			GooglePojo gp = (GooglePojo) new Gson().fromJson(line1, GooglePojo.class);
			request.getSession().setAttribute("gp", gp);
			request.getSession().setAttribute("userName", gp.getName());
			request.getSession().setAttribute("email", gp.getEmail());
			gp.setId(gp.getId());
			gp.setName(gp.getName());
			gp.setEmail(gp.getEmail());
			try {
				System.out.println("in try block");
				int j = UserDAO.googleCheckEmail(gp);
				if (j == 0) {
					//if email not there then insert data
					int i = UserDAO.googleRegister(gp);
				
					if (i != 0) {
						System.out.println("data inserted");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				}else{
					request.getSession().setAttribute("gp", gp);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} catch (Exception e) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
				e.printStackTrace();
			}
			
			System.out.println("oauth done");
			writer.close();
			reader.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ProtocolException e) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			e.printStackTrace();
		} catch (IOException e) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
