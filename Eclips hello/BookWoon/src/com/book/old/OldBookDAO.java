package com.book.old;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.sl.db.DBConn;

public class OldBookDAO {

	public static int insertBookDetails(OldBookPOJO pojo) {
	int i=0;
	Connection con=null;
	PreparedStatement ps=null;	
	System.out.println("in inserted");
	try {
		con=DBConn.getConnection();
		ps=con.prepareStatement("insert into book_old (BOOKID,TITLE,AUTHOR,PUBLISHEDDATE,PUBLISHER,CATEGORY,ISBN,ISBN13,IMAGEAPIPATH,BOOKCONDITION,TEXTHIGHLIGHT,NOTESINBOOK,PIN,ADDRESS,CITY,STATE,COUNTRY,PRICE,MOBILE,AGREE) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		ps.setInt(1, pojo.getBOOKID());
		ps.setString(2,pojo.getTITLE());
		ps.setString(3,pojo.getAUTHOR());
		ps.setString(4,pojo.getPUBLISHEDDATE());
		ps.setString(5,pojo.getPUBLISHER());
		ps.setString(6,pojo.getCATEGORY());
		ps.setString(7,pojo.getISBN());
		ps.setString(8,pojo.getISBN13());
		ps.setString(9,pojo.getIMAGEAPIPATH());
		ps.setString(10,pojo.getBOOKCONDITION());
		ps.setString(11,pojo.getTEXTHIGHLIGHT());
		ps.setString(12,pojo.getNOTESINBOOK());
		ps.setString(13,pojo.getPIN());
		ps.setString(14,pojo.getADDRESS());
		ps.setString(15,pojo.getCITY());
		ps.setString(16,pojo.getSTATE());
		ps.setString(17,pojo.getCOUNTRY());
		ps.setInt(18, pojo.getPRICE());
		ps.setString(19,pojo.getMOBILE());
		ps.setString(20,pojo.getAGREE());
		i=ps.executeUpdate();
		con.close();
		System.out.println("out inserted");
	} catch (Exception e) {
		e.printStackTrace();
		
	}
		return i;
		
	}

	public List<OldBookPOJO> getAllOldBook() {
		List<OldBookPOJO> allbook = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			System.out.println("in allbook");
			con = DBConn.getConnection();
			ps=con.prepareStatement("select BOOKID,CATEGORY,TITLE,AUTHOR,IMAGEAPIPATH,PRICE from book_old ORDER BY BOOKID DESC LIMIT 8");
			rs=ps.executeQuery();
			while(rs.next()){
				OldBookPOJO obp= new OldBookPOJO();
				obp.setBOOKID(rs.getInt("BOOKID"));
				obp.setCATEGORY(rs.getString("CATEGORY"));
				obp.setTITLE(rs.getString("TITLE"));
				obp.setAUTHOR(rs.getString("AUTHOR"));
				obp.setIMAGEAPIPATH(rs.getString("IMAGEAPIPATH"));
				obp.setPRICE(rs.getInt("PRICE"));
				
				allbook.add(obp);
				System.out.println("out allbook");
				
			}
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
		
		return allbook;
	}

	public List<OldBookPOJO> getOldBookByCategory(String category) {
		List<OldBookPOJO> allbook = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			System.out.println("in allbook");
			con = DBConn.getConnection();
			ps=con.prepareStatement("select BOOKID,TITLE,AUTHOR,IMAGEAPIPATH,PRICE from book_old  WHERE CATEGORY LIKE ?");
			ps.setString(1, "%" + category + "%");
			rs=ps.executeQuery();
			while(rs.next()){
				OldBookPOJO obp= new OldBookPOJO();
				obp.setBOOKID(rs.getInt("BOOKID"));
				obp.setTITLE(rs.getString("TITLE"));
				obp.setAUTHOR(rs.getString("AUTHOR"));
				obp.setIMAGEAPIPATH(rs.getString("IMAGEAPIPATH"));
				obp.setPRICE(rs.getInt("PRICE"));
				
				allbook.add(obp);
				System.out.println("out allbook");
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
		
		return allbook;
	}

	
	public List<OldBookPOJO> getOldBookByBookid(int bookid) {
		List<OldBookPOJO> allbook = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		System.out.println("in book id");
		try{
			System.out.println("in allbook");
			con = DBConn.getConnection();
			ps=con.prepareStatement("select * from book_old  WHERE BOOKID=?");
			ps.setInt(1, bookid);
			rs=ps.executeQuery();
			while(rs.next()){
				OldBookPOJO obp= new OldBookPOJO();
				obp.setBOOKID(rs.getInt("BOOKID"));
				obp.setTITLE(rs.getString("TITLE"));
				obp.setAUTHOR(rs.getString("AUTHOR"));
				obp.setPUBLISHEDDATE(rs.getString("PUBLISHEDDATE"));
				obp.setPUBLISHER(rs.getString("PUBLISHER"));
				obp.setCATEGORY(rs.getString("CATEGORY"));
				obp.setISBN(rs.getString("ISBN"));
				obp.setISBN13(rs.getString("ISBN13"));
				obp.setIMAGEAPIPATH(rs.getString("IMAGEAPIPATH"));
				obp.setBOOKCONDITION(rs.getString("BOOKCONDITION"));
				obp.setTEXTHIGHLIGHT(rs.getString("TEXTHIGHLIGHT"));
				obp.setNOTESINBOOK(rs.getString("NOTESINBOOK"));
				obp.setPIN(rs.getString("PIN"));
				obp.setADDRESS(rs.getString("ADDRESS"));
				obp.setCITY(rs.getString("CITY"));
				obp.setSTATE(rs.getString("STATE"));
				obp.setCOUNTRY(rs.getString("COUNTRY"));
				obp.setPRICE(rs.getInt("PRICE"));
				obp.setMOBILE(rs.getString("MOBILE"));
				obp.setAGREE(rs.getString("AGREE"));
							
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
