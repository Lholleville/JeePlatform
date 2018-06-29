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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Loic
 */
@Entity
@Table(name = "devicetype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devicetype.findAll", query = "SELECT d FROM Devicetype d")
    , @NamedQuery(name = "Devicetype.findById", query = "SELECT d FROM Devicetype d WHERE d.id = :id")
    , @NamedQuery(name = "Devicetype.findByDevicetype", query = "SELECT d FROM Devicetype d WHERE d.devicetype = :devicetype")})
public class Devicetype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "devicetype")
    private String devicetype;

    public Devicetype() {
    }
    
    public Devicetype(Integer id, String deviceType) {
        this.id = id;
        this.devicetype = deviceType;
    }

    public Devicetype(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
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
        if (!(object instanceof Devicetype)) {
            return false;
        }
        Devicetype other = (Devicetype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Devicetype[ id=" + id + " ]";
    }
    
}
