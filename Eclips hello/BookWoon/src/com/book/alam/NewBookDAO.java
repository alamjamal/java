package com.book.alam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sl.db.DBConn;

public class NewBookDAO {

	public static int insertBookDetails(NewBookPOJO np) {
		int i=0;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			System.out.println("in new book insert");
			con=DBConn.getConnection();
			ps=con.prepareStatement("insert into book_new(TITLE, AUTHOR, PUBLISHER, PUBLISHEDDATE, CATEGORY, ISBN, ISBN13, IMAGEAPIPATH, DESCRIPTION, PAGECOUNT, PRICE) values(?,?,?,?,?,?,?,?,?,?,?)");
			//ps.setInt(1, np.getNBOOKID());
			ps.setString(1, np.getTITLE());
			ps.setString(2, np.getAUTHOR());
			ps.setString(3, np.getPUBLISHER());
			ps.setString(4, np.getPUBLISHEDDATE());
			ps.setString(5, np.getCATEGORY());
			ps.setString(6, np.getISBN());
			ps.setString(7, np.getISBN13());
			ps.setString(8, np.getIMAGEAPIPATH());
			ps.setString(9, np.getDESCRIPTION());
			ps.setInt(10,np.getPAGECOUNT());
			ps.setInt(11,np.getPRICE());
			i = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("out new book insert");
		return i;
	}

	public List<NewBookPOJO> getAllBookInfo() {
		List<NewBookPOJO> allbookinfo = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			con = DBConn.getConnection();
			ps=con.prepareStatement("select NBOOKID,TITLE,ISBN,AUTHOR,IMAGEAPIPATH,PRICE from book_new ORDER BY NBOOKID DESC");
			rs=ps.executeQuery();
			while(rs.next()){
				NewBookPOJO np= new NewBookPOJO();
				np.setNBOOKID(rs.getInt("NBOOKID"));
				np.setTITLE(rs.getString("TITLE"));
				np.setISBN(rs.getString("ISBN"));
				np.setAUTHOR(rs.getString("AUTHOR"));
				np.setIMAGEAPIPATH(rs.getString("IMAGEAPIPATH"));
				np.setPRICE(rs.getInt("PRICE"));
				
				allbookinfo.add(np);
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
		return allbookinfo;
	}

	public static NewBookPOJO bookInfoForEdit(int id) {
		NewBookPOJO np = new NewBookPOJO();
		Connection con=null;
		PreparedStatement ps = null;
		try {
			con=DBConn.getConnection();
			ps=con.prepareStatement("select * from book_new where NBOOKID=?");
			//System.out.println(np.getNBOOKID());
			//value 0 bcs it is not reciving object but int var so zero
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				np.setTITLE(rs.getString("TITLE"));
				np.setAUTHOR(rs.getString("AUTHOR"));
				np.setPUBLISHER(rs.getString("PUBLISHER"));
				np.setPUBLISHEDDATE(rs.getString("PUBLISHEDDATE"));
				np.setCATEGORY(rs.getString("CATEGORY"));
				np.setISBN(rs.getString("ISBN"));
				np.setISBN13(rs.getString("ISBN13"));
				np.setIMAGEAPIPATH(rs.getString("IMAGEAPIPATH"));
				np.setDESCRIPTION(rs.getString("DESCRIPTION"));
				np.setPAGECOUNT(rs.getInt("PAGECOUNT"));
				np.setPRICE(rs.getInt("PRICE"));
				np.setNBOOKID(rs.getInt("NBOOKID"));
				
				
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return np;
	}

	public static int updateBook(NewBookPOJO np, int id) {
		int i=0;
		Connection con=null;
		PreparedStatement ps = null;
		System.out.println("in update");
		try {
			con=DBConn.getConnection();
			ps=con.prepareStatement("update  book_new set TITLE=?, AUTHOR=?, PUBLISHER=?, PUBLISHEDDATE=?, CATEGORY=?, ISBN=?, ISBN13=?, IMAGEAPIPATH=?,DESCRIPTION=?,  PAGECOUNT=?, PRICE=? where NBOOKID=?");
			
			ps.setString(1,np.getTITLE());
			ps.setString(2, np.getAUTHOR());
			ps.setString(3, np.getPUBLISHER());
			ps.setString(4,np.getPUBLISHEDDATE());
			ps.setString(5,np.getCATEGORY());
			ps.setString(6,np.getISBN() );
			ps.setString(7, np.getISBN13());
			ps.setString(8,np.getIMAGEAPIPATH());
			ps.setString(9,np.getDESCRIPTION());
			ps.setInt(10, np.getPAGECOUNT());
			ps.setInt(11,np.getPRICE());			
			ps.setInt(12,id);
			
			i = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		System.out.println("updated");
		return i;
	}

	public static void deleteBookByid(int id) {
		Connection con=null;
		PreparedStatement ps = null;
		try {
			con=DBConn.getConnection();
			ps=con.prepareStatement("delete from book_new where NBOOKID=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	public List<NewBookPOJO> getAllNewBook() {
		List<NewBookPOJO> allbook = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			System.out.println("in allbook");
			con = DBConn.getConnection();
			ps=con.prepareStatement("select NBOOKID,CATEGORY,TITLE,AUTHOR,IMAGEAPIPATH,PRICE from book_new ORDER BY NBOOKID DESC LIMIT 20");
			rs=ps.executeQuery();
			while(rs.next()){
				NewBookPOJO nbp= new NewBookPOJO();
				nbp.setNBOOKID(rs.getInt("NBOOKID"));
				nbp.setCATEGORY(rs.getString("CATEGORY"));
				nbp.setTITLE(rs.getString("TITLE"));
				nbp.setAUTHOR(rs.getString("AUTHOR"));
				nbp.setIMAGEAPIPATH(rs.getString("IMAGEAPIPATH"));
				nbp.setPRICE(rs.getInt("PRICE"));			
				allbook.add(nbp);
				System.out.println("out allbook");
				
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
		
		return allbook;
	}
	
	public List<NewBookPOJO> getNewBookByCategory(String category) {
		List<NewBookPOJO> allbook = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			System.out.println("in allbook");
			con = DBConn.getConnection();
			ps=con.prepareStatement("select NBOOKID,TITLE,AUTHOR,IMAGEAPIPATH,PRICE from book_new  WHERE CATEGORY LIKE ?");
			ps.setString(1, "%" + category + "%");
			rs=ps.executeQuery();
			while(rs.next()){
				NewBookPOJO nbp= new NewBookPOJO();
				nbp.setNBOOKID(rs.getInt("NBOOKID"));
				nbp.setTITLE(rs.getString("TITLE"));
				nbp.setAUTHOR(rs.getString("AUTHOR"));
				nbp.setIMAGEAPIPATH(rs.getString("IMAGEAPIPATH"));
				nbp.setPRICE(rs.getInt("PRICE"));
				
				allbook.add(nbp);
				System.out.println("out allbook");
				
			}
			con.close();	
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
		
		return allbook;
	}

	public List<NewBookPOJO> getNewBookByBookid(int bookid) {
		List<NewBookPOJO> allbook = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		System.out.println("in book id");
		try{
			System.out.println("in allbook");
			con = DBConn.getConnection();
			ps=con.prepareStatement("select * from book_new  WHERE NBOOKID=?");
			ps.setInt(1, bookid);
			rs=ps.executeQuery();
			while(rs.next()){
				NewBookPOJO nbp= new NewBookPOJO();
				nbp.setNBOOKID(rs.getInt("NBOOKID"));
				nbp.setTITLE(rs.getString("TITLE"));
				nbp.setAUTHOR(rs.getString("AUTHOR"));
				nbp.setPUBLISHEDDATE(rs.getString("PUBLISHEDDATE"));
				nbp.setPUBLISHER(rs.getString("PUBLISHER"));
				nbp.setCATEGORY(rs.getString("CATEGORY"));
				nbp.setISBN(rs.getString("ISBN"));
				nbp.setISBN13(rs.getString("ISBN13"));
				nbp.setIMAGEAPIPATH(rs.getString("IMAGEAPIPATH"));
				nbp.setDESCRIPTION(rs.getString("DESCRIPTION"));
				nbp.setPAGECOUNT(rs.getInt("PAGECOUNT"));
				nbp.setPRICE(rs.getInt("PRICE"));
				allbook.add(nbp);
				System.out.println("out book id");
			}
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
	
		return allbook;
	}

	public List<NewBookPOJO> getNewBookDetailsByISBN13(String iSBN13) {
		List<NewBookPOJO> allbook = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		System.out.println("in book id");
		try{
			System.out.println("in allbook");
			con = DBConn.getConnection();
			ps=con.prepareStatement("select * from book_new  WHERE iSBN13=?");
			ps.setString(1, iSBN13);
			rs=ps.executeQuery();
			while(rs.next()){
				NewBookPOJO obp= new NewBookPOJO();
				obp.setNBOOKID(rs.getInt("NBOOKID"));
				obp.setTITLE(rs.getString("TITLE"));
				obp.setAUTHOR(rs.getString("AUTHOR"));
				obp.setPUBLISHEDDATE(rs.getString("PUBLISHEDDATE"));
				obp.setPUBLISHER(rs.getString("PUBLISHER"));
				obp.setCATEGORY(rs.getString("CATEGORY"));
				obp.setISBN(rs.getString("ISBN"));
				obp.setISBN(rs.getString("ISBN13"));
				obp.setIMAGEAPIPATH(rs.getString("IMAGEAPIPATH"));		
				obp.setPRICE(rs.getInt("PRICE"));	
				allbook.add(obp);
				System.out.println("out book id");
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
	
		return allbook;
		
	}
	
	
	
	
}
