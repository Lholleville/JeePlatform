/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdd;

import javax.persistence.*;

/**
 *
 * @author Loic
 */
public class JPAdatabase {
    
    private EntityManagerFactory emf;
    public EntityManager em;
    
    public JPAdatabase(){
        this.emf = Persistence.createEntityManagerFactory("JavaPlatformPU");
        this.em = emf.createEntityManager();
    }
    
    public void close(){
        this.em.close();
        this.emf.close();
    }
}
