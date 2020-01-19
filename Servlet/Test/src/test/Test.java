/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;
import static test.DBUtil.con;

public class Test {

    /**
     *
     */
    public  Test(){
        con=DBUtil.getConnection();
    
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String args[]) throws Exception {
        
        
        

        try {
            
            int roll_no, id;

            Scanner sc = new Scanner(System.in);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.println("1. insert \n 2. view all data \n 3. update \n 4. delete \n 5.search ");

                int userchoice = sc.nextInt();
                

                switch (userchoice) {
                    case 1:
                        String insert = "insert into studn values(?,?)";
                        PreparedStatement ps = con.prepareStatement(insert);
                        System.out.println("enter roll_no:");
                        roll_no = sc.nextInt();
                        System.out.println("enter name:");
                        String name = sc.next();
                     
                        
                        ps.setInt(1, roll_no);
                        ps.setString(2, name);
                        int i = ps.executeUpdate();
                        System.out.println(i + " records affected");
                        break;
                    case 2:
                        PreparedStatement stmt = con.prepareStatement("select * from student");
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + " " + rs.getString(2));
                        }

                        break;

                    case 3:
                        PreparedStatement stmt1 = con.prepareStatement("update login set  roll_no=? , name=? where id=?");
                        System.out.println("enter id no of that whice you want to update ");
                        id = sc.nextInt();

                        System.out.println("enter roll ");
                        roll_no = sc.nextInt();
                        stmt1.setInt(1, roll_no);
                        System.out.println("enter name ");
                        name = br.readLine();
                        stmt1.setString(2, name);

                        stmt1.setInt(3, id);

                        int j = stmt1.executeUpdate();
                        System.out.println(j + " records updated");
                        break;
                    case 4:
                        PreparedStatement stmt2 = con.prepareStatement("delete from login where id=?");
                        System.out.println("enter id no of that whice you want to delete ");
                        id = sc.nextInt();
                        stmt2.setInt(1, id);

                        int k = stmt2.executeUpdate();
                        System.out.println(k + " records deleted");

                        break;
                    case 5:
                        PreparedStatement stmt3 = con.prepareStatement("select * from login where id=?");

                        System.out.println("enter id no of that whice you want search ");
                        id = sc.nextInt();
                        stmt3.setInt(1, id);
                        ResultSet rs3 = stmt3.executeQuery();
                        while (rs3.next()) {

                            System.out.println(rs3.getInt(2) + " " + rs3.getString(3));
                        }
                        rs3.close();
                        break;

                    default:
                        System.out.println("enter correct choice");
                        break;

                }

                System.out.println("Do you want to continue: y/n");
                String s = sc.next();
                if (s.startsWith("n")) {
                    break;
                }
            } while (true);
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
