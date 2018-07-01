/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entities.Devicetype;
import Entities.User;
import bdd.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author Loic
 */
public class DeviceModel {
    private Integer id;
    
    private String name;
    private Integer deviceType;
    private String unit;
    private Integer status;
    private Integer user_id;

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

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
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
    
    public String getUser(int id) throws ClassNotFoundException, SQLException{
       try{
            Database db = new Database();
            String query = "SELECT * FROM user WHERE id = ?";
                    
            PreparedStatement preparedStmt = db.getConnection().prepareStatement(query);
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
                
                return user.getUsername();
            }
            preparedStmt.clearParameters();
            
        }catch(Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
       return null;
    }

    public String getDeviceTypeObject(int id) throws ClassNotFoundException, SQLException{
       try{
            Database db = new Database();
            String query = "SELECT * FROM devicetype WHERE id = ?";
                    
            PreparedStatement preparedStmt = db.getConnection().prepareStatement(query);
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
}
