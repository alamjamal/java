
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import java.sql.*;
import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RegForm extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String email = req.getParameter("email");
        String pwd1 = req.getParameter("password");
        String pwd2 = req.getParameter("password_confirmation");

        out.print(fname + "    ");
        out.print(lname + "    ");
        out.print(email + "   ");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alam", "alam", "manuu");
            String s = "insert into student values(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(s);
            
            st.setString(1, fname);
            st.setString(2, lname);
            st.setString(3, email);
            st.setString(4, pwd1);
            st.setString(5, pwd2);
            int i = st.executeUpdate();
            if (i != 0) {
                out.print("<h1>successfull </h1>");
            } else {
                out.print("<h1> unsuccesfull</h1>");
            }

        } catch (ClassNotFoundException | SQLException e) {
            out.print("<h1>" + e.getMessage() + "</h1>");
        }

    }

}
