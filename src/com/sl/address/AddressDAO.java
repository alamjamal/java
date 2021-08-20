package com.sl.address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sl.db.*;



public class AddressDAO {
	
	
	public AddressDAO() throws Exception{
		
	}
	public static int updateAddress(AddressPOJO ap) {
		int i=0;
		Connection con=null;
		PreparedStatement ps=null;
		System.out.println("DAO Method");
		try{
			con=DBConn.getConnection();
			ps = con.prepareStatement("replace into demo_user_address values(?,?,?,?,?,?) ");
			ps.setInt(1,ap.getPin());
			ps.setString(2,ap.getCity());
			ps.setString(3,ap.getAddress());
			ps.setString(4,ap.getState());
			ps.setString(5,ap.getCountry());
			ps.setString(6,ap.getEmail());
			
			int j = ps.executeUpdate();
			if(j!=0){
				System.out.println("i incriment");
				i++;
			}
			
			DBConn.close(con, ps);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return i;
	}
	public static AddressPOJO getAddressByEmail(String email) {
		AddressPOJO ap= new AddressPOJO();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		System.out.println("in getaddress");
		try{
			con=DBConn.getConnection();
			ps=con.prepareStatement("select * from demo_user_address where email=?");
			ps.setString(1, email);
			rs=ps.executeQuery();
			while (rs.next()) {
				ap.setPin(rs.getInt("pin"));
				ap.setAddress(rs.getString("address"));
				ap.setCity(rs.getString("city"));
				ap.setState(rs.getString("state"));
				ap.setCountry(rs.getString("country"));
				System.out.println("find address");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ap;
	}


}
