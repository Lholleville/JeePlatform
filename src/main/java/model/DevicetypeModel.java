/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bdd.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Loic
 */
public class DevicetypeModel {
    
    private Integer id;
    
    private String devicetype;
    
    private Database database;
    private Connection con;
    
    public DevicetypeModel() throws ClassNotFoundException, SQLException {
        this.database = new Database();
        this.con = this.database.getConnection();
    }
    
    public DevicetypeModel(Integer id, String deviceType) {
        this.id = id;
        this.devicetype = deviceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }
    
    public List<DevicetypeModel> findAll() throws SQLException, ClassNotFoundException{
        Statement st = this.con.createStatement();
        String query = "SELECT * FROM devicetype";
        ResultSet rs = st.executeQuery(query);
        List<DevicetypeModel> ldtm = new ArrayList<>();
        while(rs.next()){
            DevicetypeModel dtm = new DevicetypeModel();
            dtm.setId(rs.getInt("id"));
            dtm.setDevicetype(rs.getString("devicetype"));
            ldtm.add(dtm);
        }
        return ldtm;
    }
    
    
}
