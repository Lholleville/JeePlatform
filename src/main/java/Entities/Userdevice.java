/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Loic
 */
@Entity
@Table(name = "userdevice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userdevice.findAll", query = "SELECT u FROM Userdevice u")
    , @NamedQuery(name = "Userdevice.findById", query = "SELECT u FROM Userdevice u WHERE u.id = :id")
    , @NamedQuery(name = "Userdevice.findByUserId", query = "SELECT u FROM Userdevice u WHERE u.userId = :userId")
    , @NamedQuery(name = "Userdevice.findByDeviceId", query = "SELECT u FROM Userdevice u WHERE u.deviceId = :deviceId")})
public class Userdevice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "deviceId")
    private Integer deviceId;

    public Userdevice() {
    }
    
    public Userdevice(Integer id, Integer userId, Integer deviceId) {
        this.id = id;
        this.userId = userId;
        this.deviceId = deviceId;
    }

    public Userdevice(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userdevice)) {
            return false;
        }
        Userdevice other = (Userdevice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Userdevice[ id=" + id + " ]";
    }
    
}
