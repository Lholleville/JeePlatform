/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.controller;


import bdd.*;
import com.api.model.Devices;
import com.api.model.User;
import com.bdd.JPAdatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    @Path("/{id}/devices")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Devices> getDataDevicesByUserID(@PathParam("id") int id){
        ArrayList<Devices> Dmm = new ArrayList();
        TypedQuery<Devices> query = (TypedQuery<Devices>) this.jpa.em.createNativeQuery("SELECT * FROM devices WHERE users_id = " + id, Devices.class);
        List<Devices> results = query.getResultList();
        for (Devices d : results){
            Dmm.add(d);
        }
        this.jpa.close();
        return Dmm;
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
    @Path("/{id}")
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
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getDataUserInJSON() throws SQLException
    {
        
        ArrayList<User> Umm = new ArrayList();
        TypedQuery<User> query = (TypedQuery<User>) this.jpa.em.createNativeQuery("SELECT * FROM users", User.class);
        List<User> results = query.getResultList();
        for (User u : results){
            Umm.add(u);
        }
        this.jpa.close();

        return Umm;
    }
}