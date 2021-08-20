package com.book.cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sl.db.DBConn;

public class CartDAO {

	public static int insertBuyItem(CartPOJO cp, String isbn13) {
		int i=0;
		Connection con=null;
		PreparedStatement ps=null;
		try{
			con=DBConn.getConnection();
			ps=con.prepareStatement("insert into book_new_cart (ISBN13,EMAIL,TITLE,IMAGEAPIPATH,PRICE)values(?,?,?,?,?)");
			
			ps.setString(1,isbn13);
			ps.setString(2,cp.getEMAIL() );
			ps.setString(3,cp.getTITLE() );
			ps.setString(4,cp.getIMAGEAPIPATH() );
			ps.setInt(5,cp.getPRICE());
			//ps.setInt(7,cp.getQty());
			i=ps.executeUpdate();
			con.close();
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return i;
	}

	public List<CartPOJO> getCartInfoByEmail(String email) {
		List<CartPOJO> cartbyemail = new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			con=DBConn.getConnection();
			ps=con.prepareStatement("select * from book_new_cart where email=? ");
			ps.setString(1, email);
			
			rs=ps.executeQuery();
			while(rs.next()){
				CartPOJO cp = new CartPOJO();
				cp.setISBN13(rs.getString("ISBN13"));
				cp.setTITLE(rs.getString("TITLE"));
				
				cp.setIMAGEAPIPATH(rs.getString("IMAGEAPIPATH"));
				cp.setPRICE(rs.getInt("PRICE"));
				cp.setQty(rs.getInt("QTY"));
				cartbyemail.add(cp);
				
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return cartbyemail;
	}

	public static void deleteItemFromCartByISBN13(String isbn13) {
		Connection con = null;
		try {
			con = DBConn.getConnection();
			String sql = "delete from book_new_cart where ISBN13=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, isbn13);
			ps.executeUpdate();
			System.out.println("deleted");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
