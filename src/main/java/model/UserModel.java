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
import javax.persistence.Column;
import javax.validation.constraints.Size;

/**
 *
 * @author Loic
 */
public class UserModel {
    
    private Integer id;
    
    private String username;
   
    private String pass;
   
    private String mobileToken;
    
    private Integer role;
    
    private String mail;
    
    private Database database;
    
    private Connection con;
    
    public UserModel() throws ClassNotFoundException, SQLException {
        this.database = new Database();
        this.con = this.database.getConnection();
    }

    public UserModel(Integer id, String username, String pass, String mobileToken, Integer role, String mail ) throws ClassNotFoundException, SQLException {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.mobileToken = mobileToken;
        this.role = role;
        this.mail = mail;
        this.database = new Database();
        this.con = this.database.getConnection();
    }
    
 
    public List<UserModel> findAll() throws SQLException, ClassNotFoundException{
        System.out.println("passe dans usermodel.findall()");
        Statement st = this.con.createStatement();
        String query = "SELECT * FROM user";
        ResultSet rs = st.executeQuery(query);
        List<UserModel> ldtm = new ArrayList<>();
        while(rs.next()){
            UserModel dtm = new UserModel();
            dtm.setId(rs.getInt("id"));
            dtm.setUsername(rs.getString("username"));
            dtm.setMail(rs.getString("mail"));
            dtm.setRole(rs.getInt("role"));
            dtm.setMobileToken(rs.getString("mobileToken"));
            dtm.setPass(rs.getString("pass"));
            System.out.println(dtm.getUsername());
            ldtm.add(dtm);
        }
        System.out.println(ldtm);
        return ldtm;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMobileToken() {
        return mobileToken;
    }

    public void setMobileToken(String mobileToken) {
        this.mobileToken = mobileToken;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
}
