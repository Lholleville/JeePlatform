/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JavaPlatform.devices;

import com.JavaPlatform.users.UserModel;

/**
 *
 * @author Loic
 */
public class DeviceModel {
    
    private String MACAdress;
    private int id;
    private int type;
    private UserModel user;
    private int users_id;

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(int users_id) {
        this.user = user;
    }

    public String getMACAdress() {
        return MACAdress;
    }

    public void setMACAdress(String MACAdress) {
        this.MACAdress = MACAdress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
