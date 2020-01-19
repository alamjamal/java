package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private static Connection con = null;

	public static Connection getConnection() {
		if (con != null)
			return con;
		else {
			try {

				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost/alam";
				String user = "root";
				String password = "";
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
			}
			return con;
		}

	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}