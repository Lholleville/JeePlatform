/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entities.Devicetype;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Loic
 */
@Stateless
public class DevicetypeFacade extends AbstractFacade<Devicetype> {

    @PersistenceContext(unitName = "com.mycompany_JavaplatformLinux_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DevicetypeFacade() {
        super(Devicetype.class);
    }
    
}
