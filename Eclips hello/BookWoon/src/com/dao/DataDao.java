package com.dao;
import com.sl.db.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DataDao {
	private Connection connection;

	public DataDao() throws Exception {
		connection = DBConn.getConnection();
	}

	public ArrayList<String> getFrameWork(String frameWork) {
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("alamjamal");
		PreparedStatement ps = null;
		String data;
		try {
			ps = connection
					.prepareStatement("select name from google_user where  name LIKE ?");
			ps.setString(1, frameWork + "%");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getString("name");
			
				list.add(data);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
