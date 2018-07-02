/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entities.Devicetype;
import Entities.User;
import bdd.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Size;

/**
 *
 * @author Loic
 */
public class DeviceModel {
    private Integer id;
    
    private String name;
    private int deviceType;
    private String unit;
    private Integer status;
    private Integer user_id;
    private Database database;
    private Connection con;
    
    public DeviceModel() throws ClassNotFoundException, SQLException{
        this.database = new Database();
        this.con = this.database.getConnection();
    }
    
    public void getDeviceById(int id) throws SQLException, ClassNotFoundException{
       
        String query = "SELECT * FROM device WHERE id = " + id;   
        /*PreparedStatement preparedStmt = this.con.prepareStatement(query);
        preparedStmt.setInt(1, id);*/
        Statement st = this.con.createStatement();
        
        ResultSet rs = st.executeQuery(query);
        //ResultSet rs = preparedStmt.executeQuery(query);
        
        while(rs.next()){
           this.setId(rs.getInt("id"));
           this.setName(rs.getString("name"));
           this.setStatus(rs.getInt("status"));
           this.setUnit(rs.getString("unit"));
           this.setUser_id(rs.getInt("user_id"));
           this.setDeviceType(rs.getInt("devicetype"));  
        }       
        
        //preparedStmt.clearParameters();
                
    }
        
    
    
    public DeviceModel(String name, String unit, Integer status, Integer user_id, int deviceType){
       
        this.name = name;
        this.status = status;
        this.unit = unit;
        this.user_id = user_id;
        this.deviceType = deviceType;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

  

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    
    
    public List<DeviceModel> findAll() throws SQLException, ClassNotFoundException{
        Statement st = this.con.createStatement();
        String query = "SELECT * FROM device";
        ResultSet rs = st.executeQuery(query);
        List<DeviceModel> Dm = new ArrayList<DeviceModel>();
        while(rs.next()){
            DeviceModel d = new DeviceModel();
            d.setId(rs.getInt("id"));
            d.setName(rs.getString("name"));
            d.setStatus(rs.getInt("status"));
            d.setUnit(rs.getString("unit"));
            d.setUser_id(rs.getInt("user_id"));
            d.setDeviceType(rs.getInt("deviceType"));
            Dm.add(d);
        }
        return Dm;
    }
    
   public String getUser(int id) throws ClassNotFoundException, SQLException{
       try{
            
            String query = "SELECT * FROM user WHERE id = ?";
                    
            PreparedStatement preparedStmt = this.con.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setMail(rs.getString("mail"));
                user.setRole(rs.getInt("role"));
                user.setMobileToken(rs.getString("mobileToken"));
                user.setPass(rs.getString("pass"));
                preparedStmt.clearParameters();
                return user.getUsername();   
            }
           
        }catch(Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
       return null;
    }

    public String getDeviceTypeObject(int id) throws ClassNotFoundException, SQLException{
       try{
            
            String query = "SELECT * FROM devicetype WHERE id = ?";
                    
            PreparedStatement preparedStmt = this.con.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            
            while(rs.next()){
                Devicetype device = new Devicetype();
                device.setId(rs.getInt("id"));
                device.setDevicetype(rs.getString("devicetype"));
                
                return device.getDevicetype();
            }
            preparedStmt.clearParameters();
            
        }catch(Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
       return null;
    }
    
    public void createDevice(String name, String unit, Integer status, Integer user_id, int devicetype) throws SQLException{
        
        DeviceModel dm = new DeviceModel(name, unit, status ,user_id, devicetype);
        
        
        String query = "INSERT INTO device (name, unit, status, user_id, devicetype) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStmt = this.con.prepareStatement(query);    
        preparedStmt.setString(1, dm.getName());
        preparedStmt.setString(2, dm.getUnit());
        preparedStmt.setInt(3, status);
        preparedStmt.setInt(4, user_id);
        preparedStmt.setInt(5, devicetype);
        preparedStmt.execute();
    }
    
    public void updateDevice(HttpServletRequest request) throws SQLException{
                
        String query = "UPDATE device SET name = ?, unit = ?, status = ?, user_id = ?, devicetype = ? WHERE id = ?";
        int status = Integer.parseInt(request.getParameter("status"));
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int devicetype = Integer.parseInt(request.getParameter("devicetype"));
        int id = Integer.parseInt(request.getParameter("id"));
        PreparedStatement preparedStmt = this.con.prepareStatement(query);    
        preparedStmt.setString(1, request.getParameter("name"));
        preparedStmt.setString(2, request.getParameter("unit"));
        preparedStmt.setInt(3, status);
        preparedStmt.setInt(4, user_id);
        preparedStmt.setInt(5, devicetype);
        preparedStmt.setInt(6, id);
        preparedStmt.execute();
    }
}
