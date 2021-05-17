package Database;

import SmartDevice.AdditionalTools;
import SmartDevice.INetwork;
import SmartDevice.UserAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQLServer implements INetwork {

    public UserAccount verifyUser(int userId, int password) {
    	UserAccount userAccount =null;
        System.out.println("User database is verifying the user...");
        AdditionalTools.interrupt(2000);
        System.out.println("Connecting to database (postgresql database management system) and verifying the user...");
        AdditionalTools.interrupt(2000);

        //veritabani.baglan(hesapNumarasi, sifre);

        try
        {
        	
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SmartDevice",
                    "postgres", "1234");
            if (conn != null)
                System.out.println("Connected to database!");
            else
                System.out.println("Database connection failed!");


            String sql= "SELECT *  FROM \"UserAccount\" WHERE \"userId\"="+ userId+" AND password="+ password;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //***** Bağlantı sonlandırma *****
            conn.close();

            int userNo;

            while(rs.next())
            {
            	userNo  = rs.getInt("userId");

            	userAccount = new UserAccount(userNo, password);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userAccount;

    }


}
