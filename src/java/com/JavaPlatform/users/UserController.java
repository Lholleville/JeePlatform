/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JavaPlatform.users;

import com.bdd.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    private JPAdatabase jpa;
    
    public UserController() throws ClassNotFoundException, SQLException
    {
        this.db = new Database();
        this.con = db.getConnection();
        this.jpa = new JPAdatabase();
        
    }
    
    @GET
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public User CreateUser(){
        this.jpa.em.getTransaction().begin();
        User user = new User("Antoine Evray","antoine.evray@viacesi.fr","cesi123");
        this.jpa.em.persist(user);
        this.jpa.em.getTransaction().commit();
        this.jpa.close();
        return user;
    }
    
    @GET
    @Path("/show/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getDataUsersInJSON(@PathParam("id") int id) throws SQLException
    {                
        Statement st = this.con.createStatement();
        String query = "SELECT * FROM users WHERE id = " + id;
        ResultSet rs = st.executeQuery(query);
        User Um = new User();

        while(rs.next())
        {
            Um.setId(rs.getLong("id"));
            Um.setName(rs.getString("name"));
            Um.setEmail(rs.getString("email"));
            Um.setPassword(rs.getString("password"));
        }
        return Um;
    }
    
    @GET
    @Path("/show")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getDataUserInJSON() throws SQLException
    {
        
        ArrayList<User> Umm = new ArrayList();
        TypedQuery<User> query = (TypedQuery<User>) this.jpa.em.createNativeQuery("SELECT * FROM users", User.class);
        List<User> results = query.getResultList();
        for (User u : results){
            Umm.add(u);
        }
        return Umm;

        
        /*Statement st = this.con.createStatement();
        String query = "SELECT * FROM users";
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next())
        {
            User Um = new User();
            Um.setId(rs.getInt("id"));
            Um.setName(rs.getString("name"));
            Um.setEmail(rs.getString("email"));
            Um.setPassword(rs.getString("password"));
            Umm.add(Um);
        }
        */
    }
}