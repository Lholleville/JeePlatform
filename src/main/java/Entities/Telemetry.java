/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Loic
 */
@Entity
@Table(name = "telemetry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telemetry.findAll", query = "SELECT t FROM Telemetry t")
    , @NamedQuery(name = "Telemetry.findById", query = "SELECT t FROM Telemetry t WHERE t.id = :id")
    , @NamedQuery(name = "Telemetry.findByDeviceId", query = "SELECT t FROM Telemetry t WHERE t.deviceId = :deviceId")
    , @NamedQuery(name = "Telemetry.findByMetricValue", query = "SELECT t FROM Telemetry t WHERE t.metricValue = :metricValue")
    , @NamedQuery(name = "Telemetry.findByMetricDate", query = "SELECT t FROM Telemetry t WHERE t.metricDate = :metricDate")
    , @NamedQuery(name = "Telemetry.findByMetricName", query = "SELECT t FROM Telemetry t WHERE t.metricName = :metricName")})
public class Telemetry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "DeviceId")
    private Integer deviceId;
    @Size(max = 50)
    @Column(name = "metricValue")
    private String metricValue;
    @Column(name = "metricDate")
    @Temporal(TemporalType.DATE)
    private Date metricDate;
    @Size(max = 100)
    @Column(name = "metricName")
    private String metricName;

    public Telemetry() {
    }
    
    public Telemetry(Integer id, Integer deviceId, String metricValue, Date metricDate, String metricName) {
        this.id = id;
        this.deviceId = deviceId;
        this.metricValue = metricValue;
        this.metricDate = metricDate;
        this.metricName = metricName;
        
    }
    public Telemetry(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getMetricValue() {
        return metricValue;
    }

    public void setMetricValue(String metricValue) {
        this.metricValue = metricValue;
    }

    public Date getMetricDate() {
        return metricDate;
    }

    public void setMetricDate(Date metricDate) {
        this.metricDate = metricDate;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
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
        if (!(object instanceof Telemetry)) {
            return false;
        }
        Telemetry other = (Telemetry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Telemetry[ id=" + id + " ]";
    }
    
}
