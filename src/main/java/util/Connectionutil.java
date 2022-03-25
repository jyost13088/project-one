package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionutil {
    public static Connection getConnection(){
        Connection conn = null;
        String url = "jdbc:postgresql://jyfsjdb.co1pygtburjj.us-east-1.rds.amazonaws.com/ERS";
        String username = "postgres";
        String password = "p4ssw0rd";
        try{
            conn = DriverManager.getConnection(url,username,password);
        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return conn;
    }
}
