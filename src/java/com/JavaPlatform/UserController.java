/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JavaPlatform;

import com.bdd.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Loic
 */

@Path("/users")
public class UserController {
        
    
    private Database db;
    private Connection con;
    
    public UserController() throws ClassNotFoundException, SQLException
    {
        this.db = new Database();
        this.con = db.getConnection();
    }
    
    @GET
    @Path("/show/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserModel getDataUsersInJSON(@PathParam("id") int id) throws SQLException
    {                
        Statement st = this.con.createStatement();
        String query = "SELECT * FROM users WHERE id = " + id;
        ResultSet rs = st.executeQuery(query);
        UserModel Um = new UserModel();

        while(rs.next())
        {
            Um.setId(rs.getInt("id"));
            Um.setName(rs.getString("name"));
            Um.setEmail(rs.getString("email"));
            Um.setPassword(rs.getString("password"));
        }
        return Um;
    }
    
    @GET
    @Path("/show")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<UserModel> getDataUserInJSON() throws SQLException
    {
        ArrayList<UserModel> Umm = new ArrayList<>();
        Statement st = this.con.createStatement();
        String query = "SELECT * FROM users";
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next())
        {
            UserModel Um = new UserModel();
            Um.setId(rs.getInt("id"));
            Um.setName(rs.getString("name"));
            Um.setEmail(rs.getString("email"));
            Um.setPassword(rs.getString("password"));
            Umm.add(Um);
        }
        return Umm;
    }
}