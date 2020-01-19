package dao.user;

import dbutil.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.user.ModelUser;

public class DaoUser {

 

   
    private final Connection con;

    public DaoUser() {
        con = ConnectionProvider.getConnection();
    }
 
   public  void register(ModelUser model) {
       
       try{
           String sql = "insert into user(iduser,name, email, mobile, pass1, pass2) values(?,?,?,?,?)";
           
           
           PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, model.getId());
            ps.setString(2, model.getName());
            ps.setString(3, model.getEmail());
            ps.setString(4, model.getMobile());
            ps.setString(5, model.getPass1());
            ps.setString(6, model.getPass2());
           
            ps.executeUpdate();

       }catch(SQLException e){
           System.out.println(e);}
  }
}
