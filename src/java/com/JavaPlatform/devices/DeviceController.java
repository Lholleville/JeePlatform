/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JavaPlatform.devices;

import com.bdd.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Loic
 */
@Path("/devices")
public class DeviceController {
    private Database db;
    private Connection con;
    
    public DeviceController() throws ClassNotFoundException, SQLException
    {
        this.db = new Database();
        this.con = db.getConnection();
    }
    
    @GET
    @Path("/show")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<DeviceModel> getDataDeviceInJSON() throws SQLException
    {
        ArrayList<DeviceModel> Dmm = new ArrayList<>();
        Statement st = this.con.createStatement();
        String query = "SELECT * FROM devices";
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next())
        {
            DeviceModel Dm = new DeviceModel();
            Dm.setId(rs.getInt("id"));
            Dm.setMACAdress(rs.getString("MACAdress"));
            
            Dmm.add(Dm);
        }
        return Dmm;
    }
    
}
