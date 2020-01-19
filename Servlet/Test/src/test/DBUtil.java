/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.*;
import static test.DBUtil.con;


public class DBUtil {

    
		public static Connection con;
   
		public static Connection getConnection(){
                    
			
			try{
				
				 Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alam","alam","manuu");
				
				
			}catch(SQLException | ClassNotFoundException e){}
                    return con;
			
			
			
		}



    public static void closeConnection(Connection ccn) throws SQLException {
        ccn.close();
        
    }

	

		
}
     