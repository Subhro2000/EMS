/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Subhro Ghosh
 */
public class ConnectionToDatabase
{
    private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver" ;
    private final String DB_NAME = "ems" ;
    private final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME ;
    
    private String username;
    private String password;
    
    public Connection con;

    public ConnectionToDatabase(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public ConnectionToDatabase()
    {
        this("root" , "Sghosh@0708");
    }
    
    public Connection startConnection() throws SQLException
    {
        try
        {
            Class.forName(DRIVER_NAME);
            con = DriverManager.getConnection(URL, username, password);
//            System.out.println("Connected Successfully.......");
            
        } catch (ClassNotFoundException ex)
        {
//            Logger.getLogger(AdminLoginFrom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
    
    public void closeConnection()
    {
        try
        {
            con.close(); 
//            System.out.println("Connection Closed");
        } catch (SQLException ex)
        {
//            Logger.getLogger(ConnectToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
