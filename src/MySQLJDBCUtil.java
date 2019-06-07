

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sedanur
 */
public class MySQLJDBCUtil {
    Connection conn=null;
    public static Connection ConnectDB(){
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/otel","root","0000");
                return conn;
            }
            catch(Exception e){ 
          return null;
       }
    }
}
