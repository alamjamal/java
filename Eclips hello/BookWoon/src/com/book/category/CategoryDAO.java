package com.book.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sl.db.DBConn;

public class CategoryDAO {
	public static int addCategory(CategoryPOJO cp) {
		int i = 0;
		try {
			Connection con = null;
			con = DBConn.getConnection();
			PreparedStatement ps = null;
			ps = con.prepareStatement("insert into category(category_name) values(?)");
			ps.setString(1, cp.getCategory_name());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static CategoryPOJO editCategory(int id) {
		CategoryPOJO cp = null;
		try {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			con = DBConn.getConnection();
			ps = con.prepareStatement("select * from category where category_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				cp = new CategoryPOJO();
				cp.setCategory_name(rs.getString("category_name"));
				cp.setCategory_id(rs.getInt("category_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cp;
	}
	
	public static void deleteCategory(int id) {
		Connection con = null;
		try {
			con = DBConn.getConnection();
			String sql = "delete from category where category_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int updateCategory(CategoryPOJO cp) {
		int i = 0;
		System.out.println("in i");
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getConnection();
			ps = con.prepareStatement("update category set category_name=? where category_id=? ");
			ps.setString(1, cp.getCategory_name());
			ps.setInt(2, cp.getCategory_id());
			int j = ps.executeUpdate();
			if (j != 0) {
				i++;
				System.out.println("in j");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static int getCategoryByCatName(String cat_name) {
		int id = 0;
		try {
			System.out.println("in selection");
			Connection con = DBConn.getConnection();
			PreparedStatement ps = null;
			ps = con.prepareStatement("select category_id from category where category_name=?");
			ps.setString(1, cat_name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("category_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("out selection");
		return id;
	}
	
	public static List<CategoryPOJO> getRecords(int start, int total) {
		List<CategoryPOJO> list = new ArrayList<CategoryPOJO>();
		try {
			Connection con = DBConn.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from category limit " + (start - 1) + "," + total);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryPOJO e = new CategoryPOJO();
				e.setCategory_id(rs.getInt(1));
				e.setCategory_name(rs.getString(2));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public List<CategoryPOJO> getAllCategory() {
		List<CategoryPOJO> allcat = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBConn.getConnection();
			ps = con.prepareStatement("select * from category");
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryPOJO cp = new CategoryPOJO();
				cp.setCategory_id(rs.getInt("category_id"));
				cp.setCategory_name(rs.getString("category_name"));
				allcat.add(cp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allcat;
	}
}
