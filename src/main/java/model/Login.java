/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Entities.User;
import bdd.Database;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Loic
 */


public class Login {


    
public User verifyLogin(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String message = "";
        
        password = this.hashPassword(password);

        
        try{
            Database db = new Database();
            String query = "SELECT * FROM user WHERE mail = ? AND pass = ?";
                    
            PreparedStatement preparedStmt = db.getConnection().prepareStatement(query);
            preparedStmt.setString(1, email);
            preparedStmt.setString(2, password);
            ResultSet rs = preparedStmt.executeQuery();
            
            
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setMail(rs.getString("mail"));
                user.setRole(rs.getInt("role"));
                user.setMobileToken(rs.getString("mobileToken"));
                user.setPass(rs.getString("pass"));
                
                return user;
            }
            preparedStmt.clearParameters();
            
        }catch(Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        
         
       return null;
       
    }
       
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void register(String name, String email, String password) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        
        password = this.hashPassword(password);
        
        
        User user = new User();
        user.setUsername(name);
        user.setMail(email);
        user.setPass(password);
        user.setRole(2);
        user.setMobileToken("");
        
        System.out.println("Username : " + user.getUsername());
        
        try{
            Database db = new Database();
            String query = "INSERT INTO user (username, pass, mail, mobileToken, role) VALUES (?,?,?,?,?)";
                
            PreparedStatement preparedStmt = db.getConnection().prepareStatement(query);
            preparedStmt.setString(1, user.getUsername());
            preparedStmt.setString(2, user.getPass());
            preparedStmt.setString(3, user.getMail());
            preparedStmt.setString(4, user.getMobileToken());
            preparedStmt.setInt(5, user.getRole());
            preparedStmt.execute();
        }catch(Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        
        

    }
    
    private String hashPassword(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
        password = sb.toString();
        return password;
    }
    
}
