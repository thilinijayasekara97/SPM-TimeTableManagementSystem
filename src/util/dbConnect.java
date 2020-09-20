/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Thili
 */
public class dbConnect {
    
    private Connection con;
    private static dbConnect dbc;
    
    private dbConnect() 
    {
        try {
            //Class.forName("com.derby.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb" , "login" , "login");
            System.out.println("Connection Established !");
   
        } catch (SQLException ex) {
            Logger.getLogger(dbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static dbConnect getDatabaseConnection(){
        
        if(dbc == null ){
            dbc = new dbConnect();
        }
        return dbc;
    }
    
    public Connection getConnection(){
        return con;
    }
    
}
