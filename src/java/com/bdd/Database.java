/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Loic
 */
public class Database {
    
    private Connection con;
    private String username;
    private String password;
    public Database() throws ClassNotFoundException, SQLException{
        this.con = null;
        this.username = "cesi";
        this.password = "cesi123";
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        this.con = DriverManager.getConnection("jdbc:derby://localhost:1527/JavaPlatformDB", username, password);
    }
    
    public Connection getConnection(){
        return this.con;
    }
    
}
