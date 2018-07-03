/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entities.Device;
import bdd.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Loic
 */
@Stateless
@Path("entities.device")
public class DeviceFacadeREST extends AbstractFacade<Device> {
    
    
    @PersistenceContext(unitName = "com.mycompany_JavaplatformLinux_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public DeviceFacadeREST() {
        super(Device.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Device entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Device entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Device find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Device> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("user/{id_user}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Device> findDeviceByUserId(@PathParam("id_user") Integer id_user) throws ClassNotFoundException, SQLException {
        Database bdd = new Database();
        Connection con = bdd.getConnection();
        List<Device> ld = new ArrayList<>();
        Statement st = con.createStatement();
        String query = "SELECT * FROM device WHERE user_id = '"+ id_user +"'";
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            Device device = new Device();
            device.setId(rs.getInt("id"));
            device.setName(rs.getString("name"));
            device.setStatus(rs.getInt("status"));
            device.setDeviceType(rs.getInt("devicetype"));
            device.setUser_id(rs.getInt("user_id"));
            ld.add(device);
        }
        
        return ld;
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Device> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
