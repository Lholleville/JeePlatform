/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entities.Telemetry;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Loic
 */
@Stateless
public class TelemetryFacade extends AbstractFacade<Telemetry> {

    @PersistenceContext(unitName = "com.mycompany_JavaplatformLinux_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelemetryFacade() {
        super(Telemetry.class);
    }
    
}
